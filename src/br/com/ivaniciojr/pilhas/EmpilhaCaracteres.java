package br.com.ivaniciojr.pilhas;

import java.util.Scanner;
import java.util.Stack;

public class EmpilhaCaracteres {

    private static Stack<Character> pilhaCaracteres = new Stack<>();
    private static Stack<Character> pilhaNumeros = new Stack<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String entrada;
        System.out.println("Digite um arranjo de letras e/ou números: ");
        entrada = in.nextLine();

        /*
         *
         * Classifica como letras e números, e empilha caracteres de um dado arranjo
         *
         * */
        empilha(entrada);

        /*
        *
        * Desempilha a pilha de caracteres
        * */
        desempilha(pilhaCaracteres);

        /*
         *
         * Desempilha a pilha de números
         * */
        desempilha(pilhaNumeros);
    }

    public static boolean verificaCaractere (char c) {

        return !Character.isDigit(c);
    }

    public static void empilha (String entrada) {

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
