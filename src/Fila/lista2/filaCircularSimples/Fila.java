package Fila.lista2.filaCircularSimples;

public class Fila
{
	/* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected int[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */
	
	public Fila(int tam)
	{
		tamanho = tam;
		vetor = new int[tamanho];
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
	
	//Retiramos o elemento do inicio da fila
	public int remove()
	{
		int elemento = Integer.MIN_VALUE;
		
		if (!this.vazia())
		{
			elemento = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(int elemento)
	{
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = elemento;
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
				System.out.println(j + " " + vetor[i]);
	}

	public void combinaFilas(Fila f1, Fila f2){
		/*
			EXERCICIO 2.
			receber as filas 1 e 2
			receber elemento da f1 e adicionar na this
			receber elemento da f2 e adicionar na this
			até as duas ficarem vazias
		*/
		int e;
		while(!f1.vazia() && !f2.vazia()){
			if(!f1.vazia() || !this.cheia()) {
				e = f1.remove();
				this.insere(e);
			}
			if(!f2.vazia() || !this.cheia()){
				e = f2.remove();
				this.insere(e);
			}
		}

		this.imprime();
	}

}