package estruturadados.modelo;

public class OrdenaSelecao {

    public void ordenar(final int array[]) {

        final int tamanho = array.length;

        for (int i = 0; i < (tamanho - 1); i++) {
            // Encontra o elemento de menor valor
            int menor_i = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (array[j] < array[menor_i]) {
                    menor_i = j;
                }
            }

            // Coloca o menor elemento na posição mais a esquerda
            // final int aux = array[menor_i];
            // array[menor_i] = array[i];
            // array[i] = aux;
            if (array[i] != array[menor_i]) {
                final int aux = array[i];
                array[i] = array[menor_i];
                array[menor_i] = aux;
            }

            // System.out.printf("Passo %d: ", i + 1);
            // this.imprimir(array);
        }
    }

    // Prints the array
    public void imprimir(final int array[]) {

        final int tamanho = array.length;
        for (int i = 0; i < tamanho; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}
