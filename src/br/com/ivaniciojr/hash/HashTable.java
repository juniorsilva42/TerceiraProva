package br.com.ivaniciojr.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HashTable {

    /*
    *
    * Aloca 2 estruturas para povoar nossa tabela hash
    * */
    private List<List<String>> table = new ArrayList<List<String>>();
    private int size = 0;

    // Define um valor maximo para criar as listas na tabela
    private final int MAX = 100;

    /*
    *
    * Método construtor
    * Adiciona 100 listas na tabela
    *
    * */
    public HashTable() {
        for (int i = 0; i < MAX; i++) {
            LinkedList<String> lista = new LinkedList<>();
            table.add(lista);
        }
    }

    /*
     *
     * Procedimento para adicionar um elemento em uma lista específica na tabela
     * @arguments String elemento
     * @return void
     *
     * */
    public void adiciona(String elemento) {
        if (!this.existeElemento(elemento)) {

            this.verificaPeso();
            int indice = this.obtemIndiceElemento(elemento);

            List<String> lista = this.table.get(indice);
            lista.add(elemento);
            this.size++;
        }
    }

    /*
     *
     * Procedimento para remover um elemento da lista
     * @arguments String elemento
     * @return void
     *
     * */
    public void remove (String elemento) {
        if (this.existeElemento(elemento)) {

            this.verificaPeso();
            int indice = this.obtemIndiceElemento(elemento);

            List<String> lista = this.table.get(indice);
            lista.remove(elemento);

            this.size--;
        }
    }

    /*
     *
     * Método obter todos os elementos da tabela
     * @arguments null
     * @return List<String>
     *
     * */
    public List<String> obtemTodosElementos () {
        List<String> elementos = new ArrayList<>();
        int tamanhoTabela = this.table.size();

        for (int i = 0; i < tamanhoTabela; i++)
            elementos.addAll(this.table.get(i));

        return elementos;
    }

    /*
     *
     * Procedimento obter todos os elementos da tabela
     * @arguments Boolean obtemSemLista
     * @return Boolean
     *
     * */
    public void obtemTodosElementos (Boolean obtemSemLista) {
        List<String> elementos = new ArrayList<>();
        int tamanhoTabela = this.table.size();

        for (int i = 0; i < tamanhoTabela; i++)
            elementos.addAll(this.table.get(i));

        // Aloca 3 variáveis auxiliares para tratar e classificar os dados mediante à matrícula do aluno
        String anoIngresso, curso, sequencia;

        for (int i = 0; i < elementos.size(); i++) {
            // No vetor do arranjo da string, classifica as informações pelo método substring
            // do indice 0 ao 4, temos o ano. do 4 ao 6, o curso, do 6 ao 10, a sequencia.
            anoIngresso = elementos.get(i).substring(0, 4);
            curso = elementos.get(i).substring(4, 6);
            sequencia = elementos.get(i).substring(6, 10);

            System.out.println("Aluno " + (i+1)+": ");
            System.out.println("Ano de ingresso: " + anoIngresso);
            System.out.println("Curso: " + curso);
            System.out.println("Sequência: " + sequencia);

            System.out.print("\n");
        }
    }

    /*
     *
     * Método para verificar se existe um elemento na tabela. (Uma das grandes sacadas de uma tabela hash é não ter colisão entre elementos iguais e/ou pseudo-iguais)
     * @arguments String elemento
     * @return Boolean
     *
     * */
    public boolean existeElemento (String elemento) {
        int indice = this.obtemIndiceElemento(elemento);
        List<String> lista = this.table.get(indice);

        return lista.contains(elemento);
    }

    /*
     *
     * Método para gerar e obter uma key para cada elemento da tabela e, posteriormente, exitar colisões entre itens iguais.
     * @arguments String elemento
     * @return int
     *
     * */
    private int obtemCodigoTabela (String elemento) {
        int code = 1;
        int qtdCaracteres = elemento.length();

        for (int i = 0; i < qtdCaracteres; i++)
            code = 31 * code + elemento.charAt(i);

        return code;
    }

    /*
     *
     * Método para obter e fortalecer o método para gerar uma key para cada elemento da tabela
     * @arguments String elemento
     * @return int
     *
     * */
    public int obtemIndiceElemento (String elemento) {
        int code = this.obtemCodigoTabela(elemento);
        code = Math.abs(code);

        return code % this.table.size();
    }

    /*
     *
     * Procedimento redimensionar a tabela
     * @arguments int novaCapacidade
     * @return void
     *
     * */
    public void redimensionaTabela (int novaCapacidade) {

        List<String> elementos = this.obtemTodosElementos();
        this.table.clear();

        for (int i = 0; i < novaCapacidade; i++)
            this.table.add(new LinkedList<>());

        for (String elemento: elementos)
            this.adiciona(elemento);
    }

    /*
     *
     * Procedimento para gerar um peso para cada lista da tabela. Sendo o peso a razão entre o tamanho da tabela e o numero de listas da mesma
     * @arguments null
     * @return void
     * @references Caelum - Estrutura de dados com Java
     *
     * */
    public void verificaPeso () {

        int capacidade = this.table.size();
        double peso = (double) this.size / capacidade;

        if (peso > 0.75)
            this.redimensionaTabela(capacidade * 2);
        else if (peso < 0.25)
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
    }
}
