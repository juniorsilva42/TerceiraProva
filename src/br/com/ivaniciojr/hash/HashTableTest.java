package br.com.ivaniciojr.hash;

import java.util.List;

public class HashTableTest {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        hashTable.adiciona("2017043003");
        hashTable.adiciona("2018032009");
        hashTable.adiciona("2016062010");

        List<String> elementos = hashTable.obtemTodosElementos();

        String anoIngresso, curso, sequencia;

        for (int i = 0; i < elementos.size(); i++) {

            anoIngresso = elementos.get(i).substring(0, 4);
            curso = elementos.get(i).substring(4, 6);
            sequencia = elementos.get(i).substring(6, 10);

            System.out.println("Aluno " + (i+1)+": ");
            System.out.println("Ano de ingresso: " + anoIngresso);
            System.out.println("Curso: " + curso);
            System.out.println("Sequência: " + sequencia);

            System.out.print("\n");
        }
    }
}
