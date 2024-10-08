package Pilha.lista1;
public class Pilha
{
    private int n; /* Tamanho da pilha */
    private char vetor[]; /*Vetor que armazena a pilha */
    private int topo;      /*Indica a posicao do topo da pilha */

    public Pilha()
    {
        n = 10;
        vetor = new char[n];
        topo = -1;
    }

    public Pilha(int tamanho)
    {
        n = tamanho;
        vetor = new char[tamanho];
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

    public char pop()
    {
        char c = '\0';

        if (!this.vazia())
        {
            c = vetor[topo];

            //Decrementando o topo, o elemento  "removido"
            topo--;
        }
        else
        {
            //Impressao para fins didaticos
            System.out.println("Lista1.Pilha vazia: pop nao funcionou.");
        }

        return c;
    }

    public boolean push(char elemento)
    {
        if (!this.cheia())
        {
            vetor[++topo] = elemento;
            return true;
        }
        else
        {
            //Impressao para fins didaticos
            System.out.println("Lista1.Pilha cheia: push nao funcionou.\n");
            return false;
        }
    }

    public char retornaTopo()
    {
        char elemento = '\0';

        if(!this.vazia())
        {
            elemento = vetor[topo];
        }
        else
        {
            System.out.println("Lista1.Pilha vazia.");
        }

        return elemento;
    }

    public int getTopo(){
        return this.topo;
    }

    public Pilha transformaEmPilha(String s)
    {
        int j = 0;
        while(j < s.length()) {
            this.push(s.charAt(j));
            j++;
        }
        return this;
    }

    public void apresentaPilha(){
        Pilha pilhaAux = new Pilha(this.n);
        char c = '\0';
        while(!this.vazia()){
            c = this.pop();
            pilhaAux.push(c);
            System.out.print(c);
        }
        while (!pilhaAux.vazia()){
            c = pilhaAux.pop();
            this.push(c);
        }
    }

    public boolean verificaCadeiaXcY()
    {
		/*
		EXERCÍCIO 1.
			Recebe pilha de chars
			separa a primeira parte em uma pilha para inversão
			compara tamanho e se a pilha original é igual pilha invertida
			retorna true
		*/
        char c = '\0';
        Pilha pilhaInversao = new Pilha();
        while(c != 'C')
        {
            c = this.pop();
            if(c != 'C')
                pilhaInversao.push(c);
        }

        while(!pilhaInversao.vazia() && !this.vazia())
        {
            if((!pilhaInversao.vazia() && this.vazia()) || (pilhaInversao.vazia() && !this.vazia()))
            {
                return false;
            }
            if(pilhaInversao.pop() != this.pop())
            {
                return false;
            }
        }
        return true;
    }

    public boolean verificaCadeiaAdB()
    {
		/*
		EXERCÍCIO 2.
			receber a pilha
			adicionar ate o ponto D, em uma pilha D caracteres
			chamar o método verificaCadeiaAdB
			se true, return true
		*/
        while(!this.vazia()) {
            char c = '\0';
            Pilha pilhaACB = new Pilha();
            while (c != 'D' && !this.vazia())
            {
                c = this.pop();
                if (c != 'D')
                    pilhaACB.push(c);
            }
            if (!pilhaACB.verificaCadeiaXcY())
            {
                return false;
            }
        }
        return true;
    }

    public char[] arrayPilhas(Pilha p2)
    {
        /*
		EXERCÍCIO 3.
			receber a segunda pilha
			criar o vetor
			determinar o tamanho do array de acordo com o tamanho das pilhas
			adicionar a primeira pilha no vetor
			adicionar a segunda pilha no vetor
			retornar o vetor
		*/
        char c = '\0';
        int t1 = this.getTopo() + 1;
        int t2 = p2.getTopo() + 1;
        char vetorP[] = new char[t1+t2];
        while(!this.vazia()){
            for (int i = 0; i < t1 + 1; i++){
                if(!this.vazia()) {
                    c = this.pop();
                    vetorP[i] = c;
                }else continue;
            }
        }
        while(!p2.vazia()){
            for (int i = t1; i < t1+t2; i++){
                if(!p2.vazia()) {
                    c = p2.pop();
                    vetorP[i] = c;
                }else continue;
            }
        }
        return vetorP;
    }

    public void balanceado(String s){
	/* 
 		EXERCÍCIO 5.
	            receber a String
	            verificar aonde existem pontuações
	            separar as pontuações em uma pilha
	            verificar se pilha pontuacao não está vazia, vazia == balanceado, não-vazia == outras verificacoes
	        */
        Pilha pilhaString = new Pilha(s.length());
        Pilha pontuacao = new Pilha(s.length());
        Pilha pilhaAux = new Pilha(s.length());
        pilhaString.transformaEmPilha(s);

        while(!pilhaString.vazia()){
            char c = pilhaString.pop();
            if(c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')'){ // se eh pontuacao add na pilha pontuacao
                pontuacao.push(c);
            }
        }
        boolean b = true;
        if(!pontuacao.vazia()) // se pilha pontuacao nao esta vazia == verificacoes dessas pontuacoes, se pilha pontuacao vazia == balanceado
        {
            int tamPilhaPontuacao = pontuacao.getTopo() + 1;

            if (tamPilhaPontuacao % 2 == 0) // se a pilha pontuacao tem tamanho impar, existe pontuacao sobrando, ou seja, ñ balanceado
            {
                while (!pontuacao.vazia())
                {
                    char c = pontuacao.pop();
                    if (c == '{' || c == '[' || c == '(') { // verifica se eh de abertura, add na pilha auxiliar e proximo elemento pilha pontuacao
                        pilhaAux.push(c);
                        continue;
                    }

                    if (pilhaAux.vazia()) { // se pilhaAux vazia, existe fechamento, mas nao existe abertura da pontuacao, quebra loop e "retorna falso"(nao balanceado)
                        b = false;
                        break;
                    }

                    char aux = pilhaAux.pop();
                    if (c == '}') {
                        if (aux != '{') {
                            b = false;
                            break;
                        }
                    }
                    if (c == ']') {
                        if (aux != '[') {
                            b = false;
                            break;
                        }
                    }
                    if (c == ')') {
                        if (aux != '(') {
                            b = false;
                            break;
                        }
                    }

                }
            } else b = false;
        }

        if(!pilhaAux.vazia()){
            b = false;
        }

        if(b){
            System.out.println("balanceado");
        }else{
            System.out.println("não balanceado");
        }
    }

    public Pilha palavraInvertida(String s){
	    /* 
     		EXERCICIO 6.
	     		recebe string e transforma em pilha
	       		pop na this e add na aux2 enqunato não encontrar espaço em branco
		 	    quando for espaço em branco dar pop em aux2 e add na aux1 para inversao
	   		    adiciona o espaco que apareceu na this para o aux1 e voltar ao passo de pop na this e add na aux2
	     		por fim pop da aux1 para this para inversao 
	    */
        int j = s.length() -1;
        while(j > -1) {
            this.push(s.charAt(j));
            j--;
        }

        Pilha aux1 = new Pilha(s.length());
        Pilha aux2 = new Pilha(s.length());
        char c = '\0';
        char aux = '\0';
        while(!aux1.cheia()){
            c = this.pop();
            if(c != ' '){
                aux2.push(c);
                if(!this.vazia()){
                    continue;
                }
            }
            if (c == ' ' || this.vazia()) {
                while (!aux2.vazia()){
                    aux = aux2.pop();
                    aux1.push(aux);
                }
                if(!aux1.cheia()) {
                    aux1.push(c);
                }
            }
        }
        while(!aux1.vazia()){
            c = aux1.pop();
            this.push(c);
        }
        this.apresentaPilha();
        return this;
    }
}
