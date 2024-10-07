package Pilha.lista1;

public class MainPosFixada {
    public static void main(String[] args) {
        Posfixada pos = new Posfixada(100);
        pos.transformaInfixaEmPos();
        pos.avaliaExpressao();
        pos.imprimeResposta();
    }
}
