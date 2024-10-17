package Fila.lista2.filaCircularSimples;

import Pilha.lista1.Pilha;
import Pilha.lista1.PilhaGenerica;

import java.util.Vector;

public class PilhaFilas {
    private int n; /* Tamanho da pilha */
    private Vector<Fila> vetor; /*Vetor que armazena a pilha */
    private int topo;      /*Indica a posicao do topo da pilha */

    public PilhaFilas()
    {
        n = 10;
        vetor = new Vector<>(n);
        topo = -1;
    }

    public PilhaFilas(int tamanho)
    {
        n = tamanho;
        vetor = new Vector<>(tamanho);
        topo = -1;
    }

    public boolean vazia()
    {
        return topo == -1 ? true : false;
    }

    public boolean cheia()
    {
        return topo == n - 1 ? true : false;
    }

    public Fila pop()
    {
        Fila f = null;

        if (!this.vazia())
        {
            f = vetor.get(topo);

            //Decrementando o topo, o elemento  "removido"
            topo--;
        }
        else
        {
            //Impressao para fins didaticos
            System.out.println("Lista1.Pilha vazia: pop nao funcionou.");
        }

        return f;
    }

    public boolean push(Fila elemento)
    {
        if (!this.cheia())
        {
            vetor.add(++topo, elemento);
            return true;
        }
        else
        {
            //Impressao para fins didaticos
            System.out.println("Lista1.Pilha cheia: push nao funcionou.\n");
            return false;
        }
    }
    public void apresentaPilha(){
        PilhaGenerica<Fila> pilhaAux = new PilhaGenerica<>(this.n);
        Fila f = null;
        while(!this.vazia()){
            f = this.pop();
            pilhaAux.push(f);
            System.out.print(f);
        }
        while (!pilhaAux.vazia()){
            f = pilhaAux.pop();
            this.push(f);
        }
    }

}
