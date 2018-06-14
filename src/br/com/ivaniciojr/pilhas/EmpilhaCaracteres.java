package br.com.ivaniciojr.pilhas;

import java.util.Scanner;
import java.util.Stack;

public class EmpilhaCaracteres {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Stack<Character> pilhaCaracteres = new Stack<>();
        Stack<Character> pilhaNumeros = new Stack<>();

        String entrada;

        System.out.println("Digite um arranjo de letras e/ou números: ");
        entrada = in.nextLine();

        if (!entrada.isEmpty()) {

            char[] arranjoCaracteres = String.valueOf(entrada).toCharArray();

            for (char caractere: arranjoCaracteres) {
                if (caractere != ' ') {
                    if (verificaCaractere(caractere)) {
                        // numero
                        System.out.println("LETRA: " + caractere);
                    } else {
                        // letra
                        System.out.println("NUMERO: " + caractere);
                    }
                }
            }

        } else System.out.println("ERRO! Digite algum arranjo de letras e/ou números.");

    }

    public static boolean verificaCaractere (char c) {

        return !Character.isDigit(c);
    }
}
