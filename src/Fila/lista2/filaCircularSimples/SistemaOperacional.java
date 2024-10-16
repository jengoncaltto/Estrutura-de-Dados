package Fila.lista2.filaCircularSimples;

public class SistemaOperacional {
    private String nome;
    private FilaGenerica<Processo> filaProcessos;
    private Processo processo;

    public SistemaOperacional(String nome) {
        this.nome = nome;
        this.filaProcessos = new FilaGenerica<>(2);
    }

    public boolean inserirProcesso(int id, String tempo){
        this.processo = new Processo(id, tempo);
        if(filaProcessos.cheia()){
            return false;
        }
        filaProcessos.insere(processo);
        return true;
    }

    public boolean retiraMaiorTempo(){
        if(filaProcessos.vazia()){
            return false;
        }
        filaProcessos.remove();
        return true;
    }

    public void imprimeListaProcessos(){
            filaProcessos.imprime();
    }
}
