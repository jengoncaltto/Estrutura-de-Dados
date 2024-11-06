package Complexidade.lista3.pilha;

import Pilha.lista1.Pilha;
import Pilha.lista1.PilhaGenerica;

import java.util.Vector;

public class PilhaComplex<T> extends PilhaGenerica<T> {

    public PilhaComplex(int tamanho) {
        super(tamanho);
    }

    public PilhaComplex<Integer> preencherPilhaNumeros(){
        return geraNumeros(1);
    }

    private PilhaComplex<Integer> geraNumeros(Integer i){  // Complexidade 0(n)
        if(!this.cheia()){
            this.push((T) i);
            return geraNumeros(i+1);
        }
        return (PilhaComplex<Integer>) this;
    }

    public int retornaPares(){
        return verificaPares(0);
    }
    
    private int verificaPares(int i){ //Complexidade 0(n)
        if(!this.vazia()){
            int n = (int)this.pop();
            if(n%2==0) {
                return verificaPares(i+1);
            }else{
                return verificaPares(i);
            }
        }
        return i;
    }
}
