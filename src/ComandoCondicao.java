import java.util.ArrayList;

public class ComandoCondicao extends Comando {
    private String condicao;
    private ArrayList<Comando> listIf = new ArrayList<Comando>();
    private ArrayList<Comando> listElse = new ArrayList<Comando>();

    @Override
    public StringBuilder geradorComandos() {
        StringBuilder str = new StringBuilder("\tif (" + condicao + ") {\n");

        for (Comando cmd : listIf) {
            str.append("\t"+ cmd.geradorComandos());
        }
        str.append("\t}\n");
        if (listElse.isEmpty() == false) {
            str.append("\telse {\n");
            for (Comando cmd : listElse) {
                str.append("\t"+ cmd.geradorComandos());
            }
            str.append("\t}\n");
        }
        return str;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public ArrayList<Comando> getListIf() {
        return listIf;
    }

    public void setListIf(ArrayList<Comando> listIf) {
        this.listIf = listIf;
    }

    public ArrayList<Comando> getListElse() {
        return listElse;
    }

    public void setListElse(ArrayList<Comando> listElse) {
        this.listElse = listElse;
    }

    @Override
    public String toString() {
        return "ComandoCondicao [condicao=" + condicao + ", listIf=" + listIf + ", listElse=" + listElse + "]";
    }


}
