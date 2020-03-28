package estruturadados.modelo;

public class Pilha {

    private int inicio;

    private int fim;

    private final int tamanho;

    private int quantidadeElementos;

    private final int pilha[];

    public Pilha() {

        this.inicio = this.fim = -1;
        this.tamanho = 100;
        this.pilha = new int[this.tamanho];
        this.quantidadeElementos = 0;
    }

    public boolean verificaVazia() {

        if (this.quantidadeElementos == 0) {
            return true;
        }
        return false;
    }

    public boolean verificaCheia() {

        if (this.quantidadeElementos == (this.tamanho - 1)) {
            return true;
        }
        return false;
    }

    public void adicionar(final int e) {

        if (!this.verificaCheia()) {
            if (this.inicio == -1) {
                this.inicio = 0;
            }
            this.fim++;
            this.pilha[this.fim] = e;
            this.quantidadeElementos++;
        }
        System.out.println("Pilha após inserção:");
        this.mostrar();
    }

    public void remover() {

        if (!this.verificaVazia()) {
            this.fim--;
            this.quantidadeElementos--;
        }
        System.out.println("Pilha após remoção do topo:");
        this.mostrar();
    }

    private void mostrar() {

        final StringBuilder elementos = new StringBuilder();
        for (int i = this.fim; i >= 0; i--) {
            elementos.append("Elemento ");
            elementos.append(i);
            elementos.append(" = ");
            elementos.append(this.pilha[i] + "\n");
        }
        System.out.println(elementos);
    }
}
