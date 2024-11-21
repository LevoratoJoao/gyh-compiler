public class ComandoAtribuicao extends Comando {
    private String variavel;
    private String tipo;
    private String atribuicao;

    @Override
    public StringBuilder geradorComandos() {
        StringBuilder str = new StringBuilder();
        str.append("\t"+ variavel+ " = "+ atribuicao+ ";\n");

        return str;
    }

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAtribuicao() {
        return atribuicao;
    }

    public void setAtribuicao(String atribuicao) {
        this.atribuicao = atribuicao;
    }

    @Override
    public String toString() {
        return "ComandoAtribuicao [variavel=" + variavel + ", tipo=" + tipo + ", atribuicao=" + atribuicao + "]";
    }

}
