import java.util.ArrayList;

public class ComandoRepeticao extends Comando {
    private String condicao;
    private ArrayList<Comando> listWhile;

    @Override
    public StringBuilder geradorComandos() {
        StringBuilder str = new StringBuilder("\twhile (" + condicao + ") {\n");
        for (Comando cmd : listWhile) {
            str.append("\t"+ cmd.geradorComandos());
        }
        str.append("\t}\n");
        return str;
    }

    public String getCondicao() {
        return condicao;
    }
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
    public ArrayList<Comando> getListWhile() {
        return listWhile;
    }
    public void setListWhile(ArrayList<Comando> listWhile) {
        this.listWhile = listWhile;
    }
    @Override
    public String toString() {
        return "ComandoRepeticao [condicao=" + condicao + ", listWhile=" + listWhile + "]";
    }


}
