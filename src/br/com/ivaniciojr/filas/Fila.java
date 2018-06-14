package br.com.ivaniciojr.filas;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Object> fila;
    private int capacidade = 100;

    /*
     *
     * Aloca a ArrayList com uma capacidade predefinida de 100 elementos
     *
     * */
    public Fila () {
        fila = new ArrayList<Object>(capacidade);
    }

    /*
     *
     * Procedimento para enfileirar um item na fila, adiciona o elemento no fim da ArrayList
     *
     * */
    public void enfileira (Object elemento) {
        this.fila.add(elemento);
    }

    /*
     *
     * Procedimento para desenfileira um item da fila, removendo sempre o elemento cabeça
     *
     * */
    public Object desenfileira () {
        // Verifica se a fila não está vazia, o contrário disso não faz sentido tentar remover
        if (!this.estaVazia()) {
            return this.fila.remove(0);
        } else {
            throw new IllegalArgumentException("Não há elementos na Fila!");
        }
    }

    /*
     *
     * Procedimento para furar a fila, ou seja, inserir um elemento na lista numa dada posição.
     *
     * */
    public void furaFila (Object valor, int posicao) {

        // Se a fila não estiver cheia, ou seja, não ultrapassar os 100 elementos
        if (!this.estaCheia()) {
            // Verifica se existe a posição
            if (verificaPosicao(posicao)) {
                /*
                *
                * Adiciono o elemento corrente na posição informada no argumento da função na próxima posição,
                * em seguida, deleto o mesmo, e adiciona naquela posição o novo elemento.
                *
                * */
                this.fila.add(posicao+1, this.fila.get(posicao));
                fila.remove(posicao);
                this.fila.add(posicao, valor);
            } else {
                throw new IllegalArgumentException("Posição inválida!");
            }
        }
    }

    /*
     *
     * Método para verificar se a fila está vazia
     *
     * */
    public boolean estaVazia () {
        return this.fila.size() == 0;
    }

    /*
     *
     * Método para verificar se a fila está cheia
     *
     * */
    public boolean estaCheia () {
        return this.fila.size() == capacidade;
    }

    /*
     *
     * Método para verificar a existência de uma dada posição
     *
     * */
    public boolean verificaPosicao (int posicao) {
        if (!(posicao >= 0 && posicao < this.fila.size())) {
            return false;
        }
        return true;
    }

    /*
     *
     * Método para montar os elementos da fila numa String
     *
     * */
    @Override
    public String toString () {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < fila.size(); i++)
            s.append(this.fila.get(i)+"\n");

        return s.toString();
    }
}
