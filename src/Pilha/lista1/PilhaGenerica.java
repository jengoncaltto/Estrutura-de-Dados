package Pilha.lista1;

import java.util.Vector;

public class PilhaGenerica<T>
{
    private int n;
    private Vector<T> vetor;
    private int topo;

    public PilhaGenerica(int tamanho)
    {
        n = tamanho;
        vetor = new Vector<T>(tamanho);
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

    public T pop()
    {
        T elemento;

        if (!this.vazia())
        {
            elemento = vetor.get(topo--);
            return elemento;
        }
        else
        {
            //Impressao para fins didaticos
            System.out.println("Lista1.Pilha vazia: pop nao funcionou.");
            return null;
        }
    }

    public boolean push(T elemento)
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

    public boolean retornaTopo(T elemento)
    {
        if(!this.vazia()){
            elemento = vetor.get(topo);
            return true;
        }
        else
            return false;
    }

    public void removerObjeto(T elemento){
         /*
        EXERCÍCIO 4.
            receber o objeto
            criar pilha auxiliar
            procurar e adicionar na pilha auxiliar
            identificar e achar
            retornar objetos da pilha auxiliar para a pilha principal
            retornar que o objeto foi removido
        */
        T aux;
        T elementoEncontrado = null;
        if(!this.vazia()){
            PilhaGenerica<T> pilhaAux = new PilhaGenerica<>(5);
            while(!this.vazia()){
                aux = this.pop();
                if(aux != elemento){
                    pilhaAux.push(aux);
                }else {
                    elementoEncontrado = aux;
                }
            }
            while(!pilhaAux.vazia()){
                aux = pilhaAux.pop();
                this.push(aux);
            }
        }
        if(!elementoEncontrado.equals(elemento)){
            System.out.println("O elemento não foi encontrado.");
        }else{
            System.out.println("Elemento " + elementoEncontrado + " removido!");
        }

        while(!this.vazia()){
            System.out.print(this.pop() + " ");
        }
    }
}