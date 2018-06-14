package br.com.ivaniciojr.filas;

public class FilaTeste {

    public static void main(String[] args) {

        Fila fila = new Fila();

        fila.enfileira("Elemento A");
        fila.enfileira("Elemento B");
        fila.enfileira("Elemento C");
        fila.enfileira("Elemento D");
        fila.enfileira("Elemento E");

        System.out.println(fila.toString());
    }
}
