package estruturadados.modelo;

public class Fila {

    private int inicio;

    private int fim;

    private final int tamanho;

    private int quantidadeElementos;

    private final int fila[];

    public Fila() {

        this.inicio = this.fim = -1;
        this.tamanho = 100;
        this.fila = new int[this.tamanho];
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
            this.fila[this.fim] = e;
            this.quantidadeElementos++;
        }
        System.out.println("Fila após inserção:");
        this.mostrar();
    }

    public void remover() {

        if (!this.verificaVazia()) {
            this.inicio++;
            this.quantidadeElementos--;
        }
        System.out.println("Fila após remoção:");
        this.mostrar();
    }

    private void mostrar() {

        final StringBuilder elementos = new StringBuilder();
        for (int i = this.inicio; i <= this.fim; i++) {
            elementos.append("Elemento ");
            elementos.append(i);
            elementos.append(" = ");
            elementos.append(this.fila[i] + "\n");
        }
        System.out.println(elementos);
    }
}
