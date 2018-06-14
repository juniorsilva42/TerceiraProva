package br.com.ivaniciojr.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {

    private List<List<String>> table = new ArrayList<List<String>>();
    private int size = 0;

    private final int MAX = 50;

    public HashTable() {
        for (int i = 0; i < MAX; i++) {
            LinkedList<String> lista = new LinkedList<>();
            table.add(lista);
        }
    }

    public void adiciona(String elemento) {
        if (!this.existeElemento(elemento)) {

            this.verificaPeso();
            int indice = this.obtemIndiceElemento(elemento);

            List<String> lista = this.table.get(indice);
            lista.add(elemento);
            this.size++;
        }
    }

    public void remove (String elemento) {
        if (this.existeElemento(elemento)) {

            this.verificaPeso();
            int indice = this.obtemIndiceElemento(elemento);

            List<String> lista = this.table.get(indice);
            lista.remove(elemento);

            this.size--;
        }
    }

    public List<String> obtemTodosElementos () {
        List<String> elementos = new ArrayList<>();
        int tamanhoTabela = this.table.size();

        for (int i = 0; i < tamanhoTabela; i++)
            elementos.addAll(this.table.get(i));


        return elementos;
    }

    public boolean existeElemento (String elemento) {
        int indice = this.obtemIndiceElemento(elemento);
        List<String> lista = this.table.get(indice);

        return lista.contains(elemento);
    }

    private int obtemCodigoTabela (String elemento) {
        int code = 1;
        int qtdCaracteres = elemento.length();

        for (int i = 0; i < qtdCaracteres; i++)
            code = 31 * code + elemento.charAt(i);

        return code;
    }

    public int obtemIndiceElemento (String elemento) {
        int code = this.obtemCodigoTabela(elemento);
        code = Math.abs(code);

        return code % this.table.size();
    }

    public void redimensionaTabela (int novaCapacidade) {

        List<String> elementos = this.obtemTodosElementos();
        this.table.clear();

        for (int i = 0; i < novaCapacidade; i++)
            this.table.add(new LinkedList<>());

        for (String elemento: elementos)
            this.adiciona(elemento);
    }

    public void verificaPeso () {

        int capacidade = this.table.size();
        double peso = (double) this.size / capacidade;

        if (peso > 0.75)
            this.redimensionaTabela(capacidade * 2);
        else if (peso < 0.25)
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
    }
}
