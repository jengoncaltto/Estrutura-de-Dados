package Fila.lista2.filaCircularSimples;

import Pilha.lista1.Pilha;

import java.util.Vector;

public class FilaFilas {
    protected int tamanho;	/* Tamanho do vetor */
    protected Vector<Fila> vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public FilaFilas(int tam)
    {
        tamanho = tam;
        vetor = new Vector<>(tamanho);
        ini = 0;
        n = 0;
    }

    public boolean vazia()
    {
        return (n == 0);
    }

    public boolean cheia()
    {
        return (n == tamanho);
    }
    public Fila remove()
    {
        Fila elemento = null;

        if (!this.vazia())
        {
            elemento = vetor.get(ini);
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    //Inserimos o elemento no final da fila
    public boolean insere(Fila elemento)
    {
        int fim;

        if ( !cheia() ) {
            fim = (ini + n) % tamanho;
            vetor.add(fim, elemento);
            n++;
            return true;
        }
        else
            return false;
    }

    public void imprime()
    {
        int i, j;

        if (vazia())
            System.out.println("Fila está vazia.");
        else
            for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
                System.out.println(j + " " + vetor.get(i));
    }

}
