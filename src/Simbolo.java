public class Simbolo {
    String nome;
    String tipo;
    String valor;
    int quantidadeUsada;
    boolean warning = false;

    public Simbolo(String nome, String tipo, String valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.quantidadeUsada = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getQuantidadeUsada() {
        return quantidadeUsada;
    }

    public void setQuantidadeUsada(int quantidadeUsada) {
        this.quantidadeUsada++;
    }

    public boolean isWarning() {
        return warning;
    }

    public void setWarning(boolean warning) {
        this.warning = warning;
    }

    @Override
    public String toString() {
        return "Simbolo [getNome()=" + this.getNome() + ", getTipo()=" + this.getTipo() + ", getValor()=" + this.getValor() + "]";
    }
}
