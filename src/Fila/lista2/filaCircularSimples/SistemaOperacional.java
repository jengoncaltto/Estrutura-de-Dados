package Fila.lista2.filaCircularSimples;

public class SistemaOperacional {
    private String nome;
    private FilaGenerica<Processo> filaProcessos;
    private Processo processo;

    public SistemaOperacional(String nome) {
        nome = nome;
        filaProcessos = new FilaGenerica<>(5);
    }

    public boolean inserirProcesso(int id){
        this.processo = new Processo(id);

        if(filaProcessos.cheia()){
            return false;
        }else {
            filaProcessos.insere(processo);
            return true;
        }
    }
    public boolean retiraMaiorTempoNaFila(){
        if(filaProcessos.vazia()){
            return false;
        }
        filaProcessos.remove();
        return true;
    }

    public void imprimeListaProcessos(){
        System.out.println("---------------------------");
        System.out.println("FILA DE PROCESSOS: ");
        filaProcessos.imprime();
    }
}
