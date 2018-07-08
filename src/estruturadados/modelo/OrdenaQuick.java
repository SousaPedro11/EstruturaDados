package estruturadados.modelo;

public class OrdenaQuick {

    public int particao(final int array[], final int inicial, final int fim) {

        final int pivot = array[fim];
        int i = (inicial - 1); // indice do menor elemento
        for (int j = inicial; j < fim; j++) {
            // Se o elemento for igual ou menor que o pivo
            if (array[j] <= pivot) {
                i++;

                // troca array[i] e array[j]
                final int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // this.imprimir(array);

        // troca array[i+1] and array[final] (ou pivot)
        final int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;
        return i + 1;
    }

    public void sort(final int array[], final int inicio, final int fim) {

        if (inicio < fim) {
            final int indiceparticao = this.particao(array, inicio, fim);

            // Ordena recursivamente os elementos antes e depois do particionamento
            this.sort(array, inicio, indiceparticao - 1);
            this.sort(array, indiceparticao + 1, fim);
        }
    }

    public void imprimir(final int arr[]) {

        final int tamanho = arr.length;
        for (int i = 0; i < tamanho; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
