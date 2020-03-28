package estruturadados.modelo;

public class Lista {

    NOLista primeiro, ultimo;

    int totalNos;

    public Lista() {

        this.primeiro = this.ultimo = null;
        this.totalNos = 0;
    }

    public int getTotalNos() {

        return this.totalNos;
    }

    public boolean verificaListaVazia() {

        if (this.getTotalNos() == 0) {
            return true;
        }
        return false;
    }

    public void adicionarNoInicio(final int valor) {

        final NOLista n = new NOLista(valor);
        if (this.verificaListaVazia()) {
            this.primeiro = this.ultimo = n;
        } else {
            n.setProx(this.primeiro);
            this.primeiro = n;
        }
        this.totalNos++;
        System.out.println("Lista após inserção no início:");
        this.mostrar();
    }

    public void adicionarNoFim(final int valor) {

        final NOLista n = new NOLista(valor);
        // caso não existam nós inseridos,
        // insere o primeiro nó (n) na lista
        if (this.verificaListaVazia()) {
            this.primeiro = this.ultimo = n;
        } else {
            this.ultimo.setProx(n);
            this.ultimo = n;
        }
        this.totalNos++;
        System.out.println("Lista após inserção no fim:");
        this.mostrar();
    }

    public void remover(final int valor) {

        final NOLista n = new NOLista(valor);
        NOLista noAtual;
        NOLista noAnterior;
        noAtual = noAnterior = this.primeiro;
        int contador = 1;

        if (this.verificaListaVazia() == false) {
            while ((contador <= this.getTotalNos()) &&
                            (noAtual.getValor() != n.getValor())) {
                noAnterior = noAtual;
                noAtual = noAtual.getProx();
                contador++;
            }

            if (noAtual.getValor() == n.getValor()) {
                if (this.getTotalNos() == 1) {
                    this.primeiro = this.ultimo = null;
                } else {
                    if (noAtual == this.primeiro) {
                        this.primeiro = noAtual.getProx();
                    } else {
                        noAnterior.setProx(noAtual.getProx());
                    }
                }
                this.totalNos--;
            }
        }
        System.out.println("Lista após remoção:");
        this.mostrar();
    }

    private void mostrar() {

        NOLista aux = this.primeiro;
        final StringBuilder elementos = new StringBuilder();
        int i = 1;
        if (this.verificaListaVazia() == false) {
            while (i <= this.getTotalNos()) {
                elementos.append("Elemento ");
                elementos.append(i);
                elementos.append(" = ");
                elementos.append(Integer.toString(aux.getValor()) + "\n");
                aux = aux.getProx();
                i++;
            }
        }
        System.out.println(elementos);
    }
}
