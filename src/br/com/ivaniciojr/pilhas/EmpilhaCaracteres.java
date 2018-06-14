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
                    if (verificaCaractere(caractere))
                        // É um número
                        pilhaCaracteres.push(caractere);
                    else
                        // Caso contrário, é uma letra
                        pilhaNumeros.push(caractere);

                }
            }

        } else System.out.println("ERRO! Digite algum arranjo de letras e/ou números.");

        /*
        *
        * Desempilha a pilha de caracteres
        *
        * */
        desempilha(pilhaCaracteres);

        /*
         *
         * Desempilha a pilha de números
         *
         * */
        desempilha(pilhaNumeros);
    }

    public static boolean verificaCaractere (char c) {

        return !Character.isDigit(c);
    }

    public static void desempilha (Stack<Character> pilha) {

        int tamanhoPilha = pilha.size();
        char[] auxiliar = new char[tamanhoPilha];

        // Desempilha e coloca cada caractere da pilha em um vetor auxiliar
        for (int i = 0; i < tamanhoPilha; i++) {
            auxiliar[i] = pilha.pop();
        }

        // Faz um loop reverso e coloca todos os caracteres na sua devida ordem
        for (int i = tamanhoPilha-1; i >= 0 ; i--) {
            System.out.print(auxiliar[i]);
        }

        System.out.print("\n");
    }
}
