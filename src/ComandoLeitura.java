public class ComandoLeitura extends Comando{
    private String variavel;
    private String tipo;

    @Override
    public StringBuilder geradorComandos() {
        StringBuilder str = new StringBuilder();
        switch (this.tipo) {
            case "integer":
                str.append("\tscanf(\"%d\", &"+ variavel+ ");\n");
                break;
            case "float":
                str.append("\tscanf(\"%f\", &"+ variavel+ ");\n");
                break;
            default:
                break;
        }
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

    @Override
    public String toString() {
        return "ComandoLeitura [variavel=" + variavel + ", tipo=" + tipo + "]";
    }
}
