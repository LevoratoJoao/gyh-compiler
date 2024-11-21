import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.Token;

public class ErroListener extends GyhRepaginadoLanguageBaseListener {
    private TabelaSimbolos _tabelaSimbolo = new TabelaSimbolos();
    private String _expressao = "";
    private String varName = "";
    private String varTipo = "";
    private int linha = 0;
    private int coluna = 0;

    public ErroListener(TabelaSimbolos tabelaSimbolo) {
        this._tabelaSimbolo = tabelaSimbolo;
    }

    public ErroListener() {
    }

    @Override
    public void exitDeclaracao(GyhRepaginadoLanguageParser.DeclaracaoContext ctx) {
        varName = ctx.Var().getText();
        varTipo = ctx.VarTipo().getText();
        if (_tabelaSimbolo.exists(varName)) {
            Token startToken = ctx.getStart();
            linha = startToken.getLine();
            coluna = startToken.getCharPositionInLine();
            throw new RuntimeException("Erro: { " +ctx.getText()+" } <linha " + linha + ", coluna " + coluna + ">: Variável <" + varName + ": "+ varTipo +"> já foi declarada.");
        } else {
            _tabelaSimbolo.setTabela(new Simbolo(varName, varTipo, null));
        }
    }

    @Override
    public void exitVarUse(GyhRepaginadoLanguageParser.VarUseContext ctx) {
        varName = ctx.Var().getText();
        if (!_tabelaSimbolo.exists(varName)) {
            Token startToken = ctx.getStart();
            linha = startToken.getLine();
            coluna = startToken.getCharPositionInLine();
            throw new RuntimeException("Erro: <linha " + linha + ", coluna " + coluna + ">: Variável { " + varName + " } não foi declarada.");
        } else {
            _tabelaSimbolo.getSimbolo(varName).setQuantidadeUsada(1);
            if (_tabelaSimbolo.getSimbolo(varName).getValor() == null && !_tabelaSimbolo.getSimbolo(varName).isWarning()) { // Verificar se a variavel foi inicializada
                Token startToken = ctx.getStart();
                linha = startToken.getLine();
                coluna = startToken.getCharPositionInLine();
                System.out.println("Aviso: <linha " + linha + ", coluna " + coluna + ">: Variável { " + varName + " } usada mas não foi inicializada.");
                _tabelaSimbolo.getSimbolo(varName).setWarning(true);
            }
        }
    }

    @Override
    public void exitComandoAtribuicao(GyhRepaginadoLanguageParser.ComandoAtribuicaoContext ctx) {
        _expressao = ctx.getText();
        String atriuicao = _expressao.substring(_expressao.indexOf("<")+2, _expressao.length()); // Pegar a atribuicao depois do <
        varName = _expressao.substring(0, _expressao.indexOf("<")); // Pegar o nome da variavel antes do <
        varTipo = _tabelaSimbolo.getSimbolo(varName).getTipo();

        // Token para pegar a linha e coluna
        Token startToken = ctx.getStart();
        linha = startToken.getLine();
        coluna = startToken.getCharPositionInLine();

        if (atriuicao.contains(".") && varTipo.equals("integer")) { // Verificar se a variavel é int e a atribuicao é float
            System.out.println("Aviso: { " +ctx.getText()+" } <linha " + linha + ", coluna " + coluna + ">: Variável <" + varName + ": "+ varTipo +"> não pode receber <float>.");
        } else if (!atriuicao.contains(".") && varTipo.equals("float")) { // Verificar se a variavel é float e a atribuicao é int
            System.out.println("Aviso: { " +ctx.getText()+" } <linha " + linha + ", coluna " + coluna + ">: Variável <" + varName + ": "+ varTipo +"> não pode receber <int>.");
        } else { // Extrair variaveis da atribuicao e verificar se o tipo é compativel
            Pattern pattern = Pattern.compile("\\b([A-Z])(\\S*?)\\b");
            Matcher matcher = pattern.matcher(atriuicao);
            while (matcher.find()) {
                String variavel = matcher.group();
                if (_tabelaSimbolo.exists(variavel) && !varTipo.equals(_tabelaSimbolo.getSimbolo(variavel).getTipo())) { // Verificar se o tipo da variavel é compativel
                    System.out.println("Aviso: { " +ctx.getText()+" } <linha " + linha + ", coluna " + coluna + ">: Variável <" + varName + ": "+ varTipo +"> não pode receber <" +variavel+": "+ _tabelaSimbolo.getSimbolo(variavel).getTipo() + ">");
                }
            }
        }
        //atriuicao = "";
    }

    @Override
    public void exitTermoAritmeticoLinha(GyhRepaginadoLanguageParser.TermoAritmeticoLinhaContext ctx) {
        String divisao = ctx.getText().substring(ctx.getText().lastIndexOf("/") + 1);
        if (divisao.equals("0") || divisao.equals("0.0"))  {
            Token startToken = ctx.getStart();
            linha = startToken.getLine();
            coluna = startToken.getCharPositionInLine();
            throw new RuntimeException("Erro: { " + ctx.getText() +" } <linha " + linha + ", coluna " + coluna + ">: Divisão por zero.");
        }
    }

    @Override
    public void exitPrograma(GyhRepaginadoLanguageParser.ProgramaContext ctx) {
        for (Simbolo simbolo : _tabelaSimbolo.getTabela().values()) {
            if (simbolo.getQuantidadeUsada() == 0) {
                System.out.println("Aviso: Variável <" + simbolo.getNome() + ": "+ simbolo.getTipo() +"> foi declarada mas não foi utilizada.");
            }
        }
        System.out.println("\nAnalise semantica finalizada, código gerado com sucesso!\n");
    }
}