package br.com.ivaniciojr.filas;

import java.lang.reflect.Array;
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
        return this.fila.remove(0);
    }

    public void furaFila (Object valor, int posicao) {

        if (!this.estaCheia()) {
            this.fila.add(posicao+1, this.fila.get(posicao));
            fila.remove(posicao);
            this.fila.add(posicao, valor);
        }
    }

    public boolean estaVazia () {
        return this.fila.size() == 0;
    }

    public boolean estaCheia () {
        return this.fila.size() == 100;
    }

    public String toString () {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < fila.size(); i++)
            s.append(this.fila.get(i)+"\n");

        return s.toString();
    }
}
