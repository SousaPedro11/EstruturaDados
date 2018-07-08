package estruturadados.modelo;

public class OrdenaHeap {

    public void sort(final int array[]) {

        final int tamanho = array.length;

        // Constroi Heap (reorganiza array)
        for (int i = (tamanho / 2) - 1; i >= 0; i--) {
            this.heapify(array, tamanho, i);
        }

        // Extrai elementos um a um da heap
        for (int i = tamanho - 1; i >= 0; i--) {
            // move a raiz atual para o fim
            final int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // chama max heap na heap reduzida
            this.heapify(array, i, 0);
        }
    }

    // Obtem uma subarvore com raiz no no
    public void heapify(final int array[], final int tamanho, final int no) {

        int maior = no;  // inicializa o maior como raiz
        final int esquerda = (2 * no) + 1;
        final int direita = (2 * no) + 2;

        // Se o filho a esquerda for maior que a raiz
        if ((esquerda < tamanho) && (array[esquerda] > array[maior])) {
            maior = esquerda;
        }

        // Se o filho a direita for maior que a raiz
        if ((direita < tamanho) && (array[direita] > array[maior])) {
            maior = direita;
        }

        // Se o maior não for raiz
        if (maior != no) {
            final int swap = array[no];
            array[no] = array[maior];
            array[maior] = swap;

            // Empilha recursivamente a subarvore
            this.heapify(array, tamanho, maior);
        }

    }

    public void imprimir(final int array[]) {

        final int tamanho = array.length;
        for (int i = 0; i < tamanho; ++i) {
            System.out.print(array[i] + " ");
        }
    }

}
