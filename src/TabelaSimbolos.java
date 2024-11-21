import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.management.QueryExp;

public class TabelaSimbolos {
    HashMap<String, Simbolo> tabela;

    public TabelaSimbolos() {
        this.tabela = new HashMap<String, Simbolo>();
    }

    public HashMap<String, Simbolo> getTabela() {
        return tabela;
    }

    public void setTabela(Simbolo simbolo) {
        this.tabela.put(simbolo.getNome(), simbolo);
    }

    public Simbolo getSimbolo(String simbolo) {
        return this.tabela.get(simbolo);
    }

    @Override
    public String toString() {
        return "TabelaSimbolos [getTabela()=" + this.getTabela() + "]";
    }

    public boolean exists(String nome) {
        return this.tabela.get(nome) != null;
    }

    public Queue<Simbolo> getAll() {
        Queue<Simbolo> queue = new LinkedList<Simbolo>();
        for (Simbolo simbolo : tabela.values()) {
            queue.add(simbolo);
        }
        return queue;
    }
}
