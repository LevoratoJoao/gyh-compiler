grammar GyhRepaginadoLanguage;
@header{
	//importar libs
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private String _nomeVar;
	private String _tipoVar;
	private String _valorVar;
	private String _expressao = "";
	private String _condicao = "";
	private String _condicaoIf = "";
	private String _condicaoWhile = "";

	private ArrayList<ArrayList<Comando>> listIf = new ArrayList<>();
	private ArrayList<ArrayList<Comando>> listElse = new ArrayList<>();
	private ArrayList<ArrayList<Comando>> listWhile = new ArrayList<>();

	private GeraCodigo _codigo = new GeraCodigo();

	private Simbolo _simboloVar;

	private TabelaSimbolos _tabelaSimbolo=new TabelaSimbolos();

	private ArrayList<Comando> listCmd = new ArrayList<>();
	private Stack<ArrayList<Comando>> _stackComandos = new Stack<ArrayList<Comando>>();
	private Stack<String> _stackCondicoes = new Stack<String>();

	public TabelaSimbolos getTabelaSimbolo(){
		return _tabelaSimbolo;
	}
}

programa: IniDelim PCDec FimDelim listaDeclaracoes
		  IniDelim PCProg FimDelim listaComandos
		  {
			_codigo.setTabela(_tabelaSimbolo);
			_codigo.setComandos(_stackComandos.pop());
			_codigo.geradorCodigo();
		} EOF;

listaDeclaracoes: declaracao (listaDeclaracoes)?; // (declaracao)+;
/*
listaDeclaracoes returns [int qtdeCmd]: { $qtdeCmd = 0; }
		(declaracao { $qtdeCmd++; })+
		{ System.out.println("Quantidade de comandos: " + $qtdeCmd); }
		;
*/

declaracao: Var IniDelim VarTipo FimDelim;

expressaoAritmetica: termoAritmetico expressaoAritmeticaLinha; // (termoAritmetico)+;
expressaoAritmeticaLinha: ('+' {
							_expressao += " + ";
						} termoAritmetico expressaoAritmeticaLinha
						| '-' {
							_expressao += " - ";
						} termoAritmetico expressaoAritmetica)?;

termoAritmetico: fatorAritmetico termoAritmeticoLinha;
termoAritmeticoLinha: ('*' {
						_expressao += " * ";
					} fatorAritmetico termoAritmeticoLinha
					| '/' {
						_expressao += " / ";
					} fatorAritmetico termoAritmeticoLinha)?;

fatorAritmetico: NumInt {
					_expressao += _input.LT(-1).getText();
				}
				| NumReal {
					_expressao += _input.LT(-1).getText();
				}
				| varUse {
					_expressao += _input.LT(-1).getText();
				}
				| '(' {
					_expressao += "(";
				} expressaoAritmetica {
					_expressao += ")";
				} ')';

expressaoRelacional: termoRelacional expressaoRelacionalLinha; // (termoRelacional)+;
expressaoRelacionalLinha: (Opbooleano {
										switch(_input.LT(-1).getText()){
											case "and":
												_expressao += " && ";
												break;
											case "or":
												_expressao += " || ";
												break;
											default:
												break;
										}
									} termoRelacional expressaoRelacionalLinha)?;

termoRelacional: expressaoAritmetica {
					_condicao += _expressao;
					_expressao = "";
				} OpRel {
					if (_input.LT(-1).getText().equals("<>")) {
						_expressao += " != ";
					} else {
						_expressao += " "+_input.LT(-1).getText()+" ";
					}
				} expressaoAritmetica {
					_condicao += _expressao;
					_expressao = "";
				} | '(' {
					_condicao += "(";
				} expressaoRelacional {
					_condicao += ")";
				} ')';

listaComandos: {
					listCmd = new ArrayList<Comando>();
					_stackComandos.push(listCmd);
				} (comando)+;

comando: comandoAtribuicao | comandoEntrada | comandoSaida | comandoCondicao | subAlgoritmo | comandoRepeticao;

// Comando de print(): variavel ou string
comandoSaida: PCImprimir varUse {
								_nomeVar =_input.LT(-1).getText();

								ComandoSaida cmd = new ComandoSaida();
								cmd.setVariavel(_nomeVar);
								cmd.setTipo(_tabelaSimbolo.getSimbolo(_nomeVar).getTipo().toString());
								_stackComandos.peek().add(cmd);
							} | PCImprimir Cadeia { // String

								ComandoSaida cmd = new ComandoSaida();
								cmd.setVariavel(_input.LT(-1).getText());
								cmd.setTipo("string");
								_stackComandos.peek().add(cmd);
							};

// Comando de atribuicao a uma variavel: var = expressao
comandoAtribuicao: {
						_tabelaSimbolo.getSimbolo(_input.LT(1).getText()).setWarning(true);
					} varUse {
						_nomeVar = _input.LT(-1).getText();
					} Atrib expressaoAritmetica {

						ComandoAtribuicao cmd = new ComandoAtribuicao();
						cmd.setVariavel(_nomeVar);
						cmd.setAtribuicao(_expressao);
						_stackComandos.peek().add(cmd);
						_expressao="";
					};

// Comando de leitura de uma variavel: scanf("%tipo", &var);
comandoEntrada: PCLer varUse {
							_nomeVar = _input.LT(-1).getText();

							ComandoLeitura cmd = new ComandoLeitura();
							cmd.setVariavel(_nomeVar);
							cmd.setTipo(_tabelaSimbolo.getSimbolo(_nomeVar).getTipo().toString());
							_stackComandos.peek().add(cmd);
						};

// Comando de condicao: if(condicao) { comando } else { comando }
comandoCondicao: PCSe {
						_condicao = "";
						_expressao = "";
					} expressaoRelacional PCEntao {
						listCmd = new ArrayList<Comando>();
						_stackComandos.push(listCmd);
						_stackCondicoes.push(_condicao);
					} comando {
						listIf.add(_stackComandos.pop());
						//_condicaoIf = _stackCondicoes.pop();
					} (PCSenao {
						listCmd = new ArrayList<Comando>();
						_stackComandos.push(listCmd);
					} comando {
						listElse.add(_stackComandos.pop());
					})? {
						ComandoCondicao cmd = new ComandoCondicao();
						cmd.setCondicao(_stackCondicoes.pop());
						if (listIf.size() > 0)
							cmd.setListIf(listIf.remove(listIf.size()-1));
						if (listElse.size() > 0)
							cmd.setListElse(listElse.remove(listElse.size()-1));
						_stackComandos.peek().add(cmd);
					};

// Comando de repeticao: while(condicao) { comando }
comandoRepeticao: PCEnqto {
							_condicao = "";
							_expressao = "";
						} expressaoRelacional PCEntao {
							listCmd = new ArrayList<Comando>();
							_stackComandos.push(listCmd);
							_stackCondicoes.push(_condicao);
						} comando {
							listWhile.add(_stackComandos.pop());
							//_condicaoWhile = _stackCondicoes.pop();

							ComandoRepeticao cmd = new ComandoRepeticao();
							cmd.setCondicao(_stackCondicoes.pop());
							if (listWhile.size() > 0)
								cmd.setListWhile(listWhile.remove(listWhile.size()-1));
							_stackComandos.peek().add(cmd);
						};

// Sub-algoritmo: start { comando } end
subAlgoritmo: PCIni (comando)+ PCFim;

varUse: Var; // Uso de variavel

//==========

FimDelim: ']';
IniDelim: '[';
Atrib: '<<';
Opbooleano: OpBoolE | OpBoolOu;
OpBoolE: 'and';
OpBoolOu: 'or';
OpRel:  '=='| '>=' | '<=' | '>' | '<' | '<>';
PCProg: 'prog';
PCDec:  'dec';
VarTipo: PCInt | PCReal;
PCInt: 'integer';
PCReal: 'float';
PCLer: 'read';
PCImprimir: 'print';
PCSe: 'if';
PCSenao: 'else';
PCEntao: 'then';
PCEnqto: 'while';
PCIni: 'start';
PCFim: 'end';

Var: [A-Z] ( [0-9] | [a-z] | [A-Z] )*;

Cadeia:  '"' ( [0-9] | [a-z] | [A-Z] | OpRel | Atrib )* '"';

NumInt: [0-9]+;

NumReal: [0-9]+'.'[0-9]+;

WS: (' ' | '\n' | '\t')->skip; // espaco em branco

Comentario: '#' ~('\n')* ->skip;