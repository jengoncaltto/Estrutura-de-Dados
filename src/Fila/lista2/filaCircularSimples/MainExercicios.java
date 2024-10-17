package Fila.lista2.filaCircularSimples;
import Pilha.lista1.Pilha;
public class MainExercicios {
    public static void main(String[] args) {
        /*
            EXERCICIO 1
        SistemaOperacional op = new SistemaOperacional("Linux");
        op.inserirProcesso(20231210);
        op.inserirProcesso(20231211);
        op.imprimeListaProcessos();
        op.retiraMaiorTempoNaFila();
        op.imprimeListaProcessos();*/

        /*
            EXERCICIO 2
        Fila f1 = new Fila(5);
        Fila f2 = new Fila(5);
        Fila fila = new Fila(f1.tamanho + f2.tamanho);
        f1.insere(0);
        f1.insere(0);
        f1.insere(0);
        f2.insere(1);
        f2.insere(1);
        f2.insere(1);
        fila.combinaFilas(f1,f2); */

        /*
            EXERCICIO 3
            FILA DE PILHAS*/

        Pilha p1 = new Pilha(2); p1.push('a'); p1.push('b');
        Pilha p2 = new Pilha(2); p2.push('j'); p2.push('k');
        Pilha p3 = new Pilha(2); p3.push('x'); p3.push('y');

        FilaPilhas filaPilhas = new FilaPilhas(5);
        filaPilhas.insere(p1);
        filaPilhas.insere(p2);
        filaPilhas.insere(p3);
        filaPilhas.imprime();

                 /*PILHA DE FILAS*/

        Fila f1 = new Fila(2); f1.insere(1);   f1.insere(2);
        Fila f2 = new Fila(2); f2.insere(7); f2.insere(8);

        PilhaFilas pf = new PilhaFilas(2);
        pf.push(f1);
        pf.push(f2);
        pf.apresentaPilha();


            /* FILA DE FILAS */

        Fila f3 = new Fila(2); f3.insere(1); f3.insere(2);
        Fila f4 = new Fila(2); f4.insere(1); f4.insere(1);

        FilaFilas ff = new FilaFilas(2);
        ff.insere(f3);
        ff.insere(f4);
        ff.imprime();


        /*
         EXERCICIO 4.
        Fila fila = new Fila(5);
        fila.insere(1);
        fila.insere(2);
        fila.insere(3);
        fila.insere(4);

        FilaDupla filaDupla = Fila.FilaCirularPDupla(fila, fila.getTamanho());
        filaDupla.imprime();
        */


    }
}
