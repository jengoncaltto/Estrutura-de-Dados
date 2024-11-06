package Complexidade.lista3.pilha;

import Pilha.lista1.PilhaGenerica;

public class Main {
    public static void main(String[] args) {
        PilhaComplex<Integer> pilha = new PilhaComplex<>(10);
        pilha.preencherPilhaNumeros();
        System.out.println(pilha.retornaPares());
    }
}
