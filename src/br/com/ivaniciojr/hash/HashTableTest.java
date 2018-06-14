package br.com.ivaniciojr.hash;

import java.util.List;

public class HashTableTest {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        hashTable.adiciona("2017043003");
        hashTable.adiciona("2018032009");
        hashTable.adiciona("2016062010");
        hashTable.adiciona("2019032020");

        hashTable.obtemTodosElementos(true);
    }
}
