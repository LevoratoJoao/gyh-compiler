public class ComandoSaida extends Comando {
    private String variavel;
    private String tipo;

    @Override
    public StringBuilder geradorComandos() {
        StringBuilder str = new StringBuilder();
        // printf("tipo\n", variavel);
        switch (this.tipo) {
            case "integer":
                str.append("\tprintf(\"%d\\n\", "+ variavel+ ");\n");
                break;
            case "float":
                str.append("\tprintf(\"%f\\n\", "+ variavel+ ");\n");
                break;
            default:
                str.append("\tprintf("+ variavel+");\n");
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
        return "ComandoSaida [variavel=" + variavel + ", tipo=" + tipo + "]";
    }
}
