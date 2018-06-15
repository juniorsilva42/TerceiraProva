package br.com.ivaniciojr.hash;

import java.util.LinkedList;

public class Helpers {

    public static LinkedList<Integer> bubbleSort (LinkedList<Integer> v) {

        for (int i = v.size(); i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v.get(j - 1) > v.get(j)) {
                    int aux = v.get(j);
                    v.set(j, v.get(j - 1));
                    v.set(j - 1, aux);
                }
            }
        }
        return v;
    }
}
