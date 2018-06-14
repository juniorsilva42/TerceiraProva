package br.com.ivaniciojr.filas;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Object> fila;
    private int capacidade = 100;

    public Fila () {
        fila = new ArrayList<Object>(capacidade);
    }

    public void enfileira (Object elemento) {
        this.fila.add(elemento);
    }

    public Object desenfileira () {
        if (!this.estaVazia()) {
            return this.fila.remove(0);
        } else {
            throw new IllegalArgumentException("Não há elementos na Fila!");
        }
    }

    public void furaFila (Object valor, int posicao) {

        if (!this.estaCheia()) {
            if (verificaPosicao(posicao)) {
                this.fila.add(posicao+1, this.fila.get(posicao));
                fila.remove(posicao);
                this.fila.add(posicao, valor);
            } else {
                throw new IllegalArgumentException("Posição inválida!");
            }
        }
    }

    public boolean estaVazia () {
        return this.fila.size() == 0;
    }

    public boolean estaCheia () {
        return this.fila.size() == 100;
    }

    public boolean verificaPosicao (int posicao) {
        if (!(posicao >= 0 && posicao < this.fila.size())) {
            return false;
        }
        return true;
    }

    public String toString () {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < fila.size(); i++)
            s.append(this.fila.get(i)+"\n");

        return s.toString();
    }
}
