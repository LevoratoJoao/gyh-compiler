// João Vitor Levorato de Souza - 2419890
// Arthur Henrique de Oliveira Petroli - 2408732
// Link do video - https://youtu.be/LWLG-V5Xzto

import java.io.IOException;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

public class main {
	public static void main(String[] args) {
		try {
			CharStream cs = CharStreams.fromFileName("tests/programa1.gyh");
			GyhRepaginadoLanguageLexer lexer = new GyhRepaginadoLanguageLexer(cs);
			CommonTokenStream token = new CommonTokenStream(lexer);
			GyhRepaginadoLanguageParser parser = new GyhRepaginadoLanguageParser(token);
			ErroListener erroListener = new ErroListener(parser.getTabelaSimbolo());

			parser.addParseListener(erroListener);

			parser.programa();

			/* Print dos tokens caso seja necessario
			 *
			 Token t;

			 while ( (t=lexer.nextToken()).getType() != Token.EOF ) {
				System.out.println("<"+ lexer.VOCABULARY.getSymbolicName(t.getType()) + ", " + t.getText() + ">");
				}
			*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
