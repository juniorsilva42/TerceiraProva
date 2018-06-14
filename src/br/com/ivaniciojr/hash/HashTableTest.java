package br.com.ivaniciojr.hash;

import java.util.List;

public class HashTableTest {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        hashTable.adiciona("2017043003");
        hashTable.adiciona("2018032009");

        List<String> elementos = hashTable.obtemTodosElementos();

        for (int i = 0; i < elementos.size(); i++) {

            System.out.println(elementos.get(i));
        }

        System.out.println("\n");
    }
}
