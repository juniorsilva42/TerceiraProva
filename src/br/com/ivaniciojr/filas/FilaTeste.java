package br.com.ivaniciojr.filas;

public class FilaTeste {

    public static void main(String[] args) {

        Fila fila = new Fila();

        fila.enfileira("Elemento A");
        fila.enfileira("Elemento B");
        fila.enfileira("Elemento C");
        fila.enfileira("Elemento D");
        fila.enfileira("Elemento E");
        fila.enfileira("Elemento F");
        fila.enfileira("Elemento G");
        fila.enfileira("Elemento H");
        fila.enfileira("Elemento I");
        fila.enfileira("Elemento J");

        for (int i = 0; i < 10; i++) {
            System.out.println(fila.toString());
            fila.desenfileira();
        }
    }
}
