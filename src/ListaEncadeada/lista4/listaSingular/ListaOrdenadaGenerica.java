package ListaEncadeada.lista4.listaSingular;

public class ListaOrdenadaGenerica<T> extends Lista{
    protected Elo prim;
    protected class Elo
    {
        protected T dado;
        protected Elo prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(T elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo proxElem)
        {
            dado = elem;
            prox = proxElem;
        }
    }

    public void insere(T novo){
        Elo p, q;
        p = new Elo(novo);

        if(this.vazia()){
            prim = p;
        }else{
            for (q = prim; (q.prox != null); q = q.prox);
            q.prox = p;
        }
    }
}
