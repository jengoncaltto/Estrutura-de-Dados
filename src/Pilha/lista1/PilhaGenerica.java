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

    public void pilhaSequencia(int inicial, int fim){
      /*
        EXERCÍCIO 8.
            receber o numero inicial e o numero final da sequencia
            iniciar dois "for" para criar os subarrays
            concatena e adiciona cada subarray em uma pilhaSUbArray
            verifica onde existem os dois unicos pares e se o segundo é maior que o primeiro
            onde a string for os pares adiciona na pilhaUnicosPares
     */
        PilhaGenerica<String> pilhaSUBArray = new PilhaGenerica<>(this.n);
        PilhaGenerica<String> auxSUBArray = new PilhaGenerica<>(this.n);

        for (int i = inicial; i <= fim; i++){
            String numeros = new String();
            int index = i;
            for (int j = i; j <= fim; j++){
                numeros = numeros.concat(Integer.toString(j));
                pilhaSUBArray.push(numeros);
            }
        }
        while (!pilhaSUBArray.vazia()){   // while para inverter, ordenar e apresentar no formato correto(crescente) dos subarrays
            String s = pilhaSUBArray.pop();
            auxSUBArray.push(s);
        }

        System.out.println("Sua sequencia de Sub Arrays: ");
        while(!auxSUBArray.vazia()){
            String s = auxSUBArray.pop();
            System.out.println(s);
            pilhaSUBArray.push(s);
        }

        while (!pilhaSUBArray.vazia()){  // while para inverter, ordenar e apresentar no formato corretor dos numeros pares unicos
            String s = pilhaSUBArray.pop();
            auxSUBArray.push(s);
        }
        System.out.println("---------------------------");

        while(!auxSUBArray.vazia()){
            String s = auxSUBArray.pop();
            if(s.length() == 2 && (s.charAt(1) > s.charAt(0))){
                System.out.printf("\nPar unico: (%c, %c)", s.charAt(1), s.charAt(0));
            }
        }
    }
}