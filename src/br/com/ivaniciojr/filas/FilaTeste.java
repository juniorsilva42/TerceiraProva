package br.com.ivaniciojr.filas;

public class FilaTeste {

    public static void main(String[] args) {

        Fila fila = new Fila();

        // Adiciona 10 elementos para teste
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

        // Cria a primeira exibição
        System.out.println("======= Primeira exibição =======");
        System.out.println(fila.toString());

        // "Fura" a fila na posição 7, no mesmo lugar do Elemento H
        fila.furaFila("Furei a fila! :)", 7);

        // Cria a segunda exibição
        System.out.println("======= Segunda exibição - furando a fila =======");
        System.out.println(fila.toString());

        // Simula a desenfileiração até o elemento "Furei a fila" chegar na sua vez, e chegar no ultimo da fila.
        System.out.println("======= Começando a desempilhar =======");
        for (int i = 0; i < 11; i++) {
            System.out.println(fila.toString());
            fila.desenfileira();
        }
    }
}
