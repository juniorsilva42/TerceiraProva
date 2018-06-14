package br.com.ivaniciojr.filas;

import java.util.ArrayList;
import java.util.List;

public class Fila {

    private List<Object> fila;
    private int capacidade = 100;

    public void Fila () {
        fila = new ArrayList<Object>(capacidade);
    }

    public void enfileira (Object elemento) {
        this.fila.add(elemento);
    }

    public Object desenfileira () {
        return this.fila.remove(0);
    }

    public boolean estaVazia () {
        return this.fila.size() == 0;
    }

    public String toString () {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < fila.size(); i++) {
            s.append(fila.get(i));
        }

        return s.toString();
    }
}
