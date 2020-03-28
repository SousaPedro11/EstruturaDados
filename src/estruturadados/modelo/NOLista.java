package estruturadados.modelo;

public class NOLista {

    private int valor;

    private NOLista prox;

    public NOLista(final int valor) {

        this.valor = valor;
        this.prox = null;
    }

    public int getValor() {

        return this.valor;
    }

    public void setValor(final int valor) {

        this.valor = valor;
    }

    public NOLista getProx() {

        return this.prox;
    }

    public void setProx(final NOLista prox) {

        this.prox = prox;
    }

}
