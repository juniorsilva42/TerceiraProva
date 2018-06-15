package br.com.ivaniciojr.hash;

import java.util.List;

public class HashTableTest {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        hashTable.adiciona("2017043003");
        hashTable.adiciona("2018032009");
        hashTable.adiciona("2016062010");
        hashTable.adiciona("2019032020");

        // Obtem todos os elementos. Valor true para obter sem a lista.
        // Preferível assim, melhor para abstrair a classse sem sujar o código de testes e engessar o uso do retorno
        hashTable.obtemTodosElementos(true);
    }
}
