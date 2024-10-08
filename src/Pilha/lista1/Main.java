package Pilha.lista1;
public class Main {
    public static void main(String args[])
    {
        /*
        EXERCÍCIO 1 E 2.
        String s = "BACABDBBCBBDABCBA";
		Pilha pilhaChar = new Pilha(s.length());
		pilhaChar.transformaEmPilha(s);
		System.out.println(pilhaChar.verificaCadeiaAdB());
		*/

        /*
        EXERCÍCIO 3.
        String x = "RSRSRS";
        String y = "OPOPOP";
        Pilha p1 = new Pilha(x.length());
        Pilha p2 = new Pilha(y.length());
        p2.transformaEmPilha(x);
        p1.transformaEmPilha(y);
        System.out.println(p2.arrayPilhas(p1));
        */

       /* EXERCÍCIO 4.
        PilhaGenerica<String> pilha= new PilhaGenerica<>(5);
        pilha.push("BA");
        pilha.push("BE");
        pilha.push("BI");
        pilha.push("BO");
        pilha.push("BU");
        pilha.removerObjeto("BE");
        */

        /*  EXERCÍCIO 5.

        String s = "{ab[cd]efg}";
        Pilha pilhaS = new Pilha(s.length());
        pilhaS.balanceado(s);
        */

        /*  EXERCÍCIO 6.
        String s = "a maçã está podre";
        Pilha pilhaInvertida = new Pilha(s.length());
        pilhaInvertida.palavraInvertida(s);
        */

        /* EXERCICIO 8.
        int indiceInicial = 1;
        int indiceFinal = 5;
        int tampilhaSequencia = ((indiceFinal*(indiceFinal+1)))/2;
        PilhaGenerica<String> pilhaSequencia = new PilhaGenerica<>(tampilhaSequencia);
        pilhaSequencia.pilhaSequencia(indiceInicial, indiceFinal);
        */
    }
}