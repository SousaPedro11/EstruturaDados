package estruturadados.modelo;

import java.util.Arrays;

public class OrdenaRadix {

    // Obter valor maximo
    static int getMax(final int array[], final int n) {

        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Faz a contagem da matriz de acordo com o digito mais significativo
    static void countSort(final int array[], final int n, final int exp) {

        final int saida[] = new int[n];
        int i;
        final int count[] = new int[10];
        Arrays.fill(count, 0);

        // Armazena a contagem de ocorrencias em count[]
        for (i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constroi a matriz de saida
        for (i = n - 1; i >= 0; i--) {
            saida[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++) {
            array[i] = saida[i];
        }
    }

    // Funcao que ordena usando RadixSort
    static void radixsort(final int arr[], final int n) {

        // Encontra o maior numero
        final int m = OrdenaRadix.getMax(arr, n);

        for (int exp = 1; (m / exp) > 0; exp *= 10) {
            OrdenaRadix.countSort(arr, n, exp);
        }
    }

    public void imprimir(final int arr[], final int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
