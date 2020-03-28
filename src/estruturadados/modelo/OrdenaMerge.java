package estruturadados.modelo;

public class OrdenaMerge {

    // Divide a matriz maior (M[inicio...fim]) em duas
    // Matriz a esquerda A[inicio...meio], matriz a direita B[meio+1...fim]
    public void merge(final int array[], final int inicio, final int meio, final int fim) {

        // Encontra os limites das duas matrizes
        final int n1 = (meio - inicio) + 1;
        final int n2 = fim - meio;

        /* Cria as duas matrizes */
        final int L[] = new int[n1];
        final int R[] = new int[n2];

        /* Copia os dados para as matrizes */
        for (int i = 0; i < n1; ++i) {
            L[i] = array[inicio + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[meio + 1 + j];
        }

        /* Mescla as matrizes temposrarias */

        // Indice inicial para as duas matrizes
        int i = 0, j = 0;

        // Indice inicial para a matriz maior
        int k = inicio;
        while ((i < n1) && (j < n2)) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copia os elementos restantes da matriz a esquerda se houver */
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        /* Copia os elementos restantes da matriz a direita se houver */
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Ordena a matriz maior usando o metodo merge()
    public void ordenar(final int array[], final int inicio, final int fim) {

        if (inicio < fim) {
            // Encontra o ponto medio
            final int pontomedio = (inicio + fim) / 2;

            // Ordena as duas matrizes
            this.ordenar(array, inicio, pontomedio);
            this.ordenar(array, pontomedio + 1, fim);

            // Une as matrizes
            this.merge(array, inicio, pontomedio, fim);
        }
    }

    public void imprimir(final int arr[]) {

        final int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
