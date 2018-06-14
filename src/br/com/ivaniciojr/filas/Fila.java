package br.com.ivaniciojr.filas;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Object> fila = new ArrayList<Object>(100);
    private int capacidade = 100;

    public void enfileira (Object elemento) {
        this.fila.add(elemento);
    }

    public Object desenfileira () {
        return this.fila.remove(0);
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
