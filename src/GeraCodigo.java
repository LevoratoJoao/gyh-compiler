import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class GeraCodigo {
    private TabelaSimbolos tabela;
    // representação dos comandos
    private ArrayList<Comando> comandos = new ArrayList<>();

    public GeraCodigo() {

    }

    public ArrayList<Comando> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<Comando> comandos) {
        this.comandos = comandos;
    }

    public TabelaSimbolos getTabela() {
        return tabela;
    }

    public void setTabela(TabelaSimbolos tabela) {
        this.tabela = tabela;
    }

    public void geradorCodigo() {
        StringBuilder str = new StringBuilder();
        str.append("#include <stdlib.h>\n#include <stdio.h>\n#include <string.h>\n#include <stdbool.h>\n\n");
        str.append("int main() {\n");
        for (Simbolo simbolo : tabela.getAll()) {
            if (simbolo.tipo.equals("float")) {
                str.append("\tfloat "+ simbolo.nome + ";\n");
            } else {
                str.append("\tint "+ simbolo.nome + ";\n");
            }
        }
        str.append("\n");
        for (Comando cmd : comandos) {
            str.append(cmd.geradorComandos());
        }
        str.append("\treturn 0; \n}");
        // Aberura do arquivo
        try {
            FileWriter file = new FileWriter("output/programa.c");
            file.write(str.toString());
            //FileWriter file = new FileWriter(new File("programa.c"));
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
