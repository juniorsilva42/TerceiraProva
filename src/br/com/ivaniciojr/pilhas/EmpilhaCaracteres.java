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

    /*
    *
    * Procedimento para empilhar uma dado arranjo e classificar cada caractere como sendo dígito ou número.
    *
    * @author Ivanicio Jr
    * @arguments String entrada
    * @return void
    *
    * */
    public static void empilha (String entrada) {

        // Caso a entrada seja diferente de vazia
        if (!entrada.isEmpty()) {

            // Quebra o arranjo dado pela entrada em um array de caracteres
            char[] arranjoCaracteres = String.valueOf(entrada).toCharArray();

            /*
            *
            * Percorre o array de caracteres classificando cada um como letra ou número
            *
            * */
            for (char caractere: arranjoCaracteres) {

                // Classifica cada caractere
                if (verificaCaractere(caractere))
                    // OPA! É um número
                    pilhaCaracteres.push(caractere);
                else
                    // OPA! É uma letra
                    pilhaNumeros.push(caractere);
            }

        } else System.out.println("ERRO! Digite algum arranjo de letras e/ou números.");
    }

    /*
     *
     * Procedimento para desempilhar uma dada uma pilha
     *
     * @author Ivanicio Jr
     * @arguments Stack<Character> pilha
     * @return void
     *
     * */
    public static void desempilha (Stack<Character> pilha) {

        // Armazena logo o tamanho da pilha na memória. Evita ter que calcular toda vez que o loop for executado
        int tamanhoPilha = pilha.size();
        char[] auxiliar = new char[tamanhoPilha];

        // Desempilha e coloca cada caractere da pilha em um vetor auxiliar
        for (int i = 0; i < tamanhoPilha; i++) {
            auxiliar[i] = pilha.pop();
        }

        // Faz um loop reverso e coloca todos os caracteres na sua devida ordem
        for (int i = tamanhoPilha - 1; i >= 0 ; i--) {
            System.out.print(auxiliar[i]);
        }

        System.out.print("\n");
    }

    /*
     *
     * Procedimento para classificar um dado caractere se é um dígito ou um número
     *
     * @author Ivanicio Jr
     * @arguments char c
     * @return boolean
     *
     * */
    public static boolean verificaCaractere (char c) {

        return !Character.isDigit(c);
    }
}
