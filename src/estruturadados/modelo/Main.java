package estruturadados.modelo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

import estruturadados.arvores.AVLTree;
import estruturadados.util.Reflexao;

public class Main {

    @SuppressWarnings("unused")
    public static void main(final String[] args) {

        final OrdenaSelecao selection = new OrdenaSelecao();
        final OrdenaQuick quick = new OrdenaQuick();
        final OrdenaMerge merge = new OrdenaMerge();
        final OrdenaHeap heap = new OrdenaHeap();
        final OrdenaRadix radix = new OrdenaRadix();

        final Jogador jogador1 = new Jogador(37348, "Canarinho", "Pistola", Reflexao.toDate("2018-06-15"), 180, 82);
        /*
         * 1 - Leitura e ordena��o do CSV Para utilizar basta descomentar e executar um
         * metodo por vez (inclusive no m�todo no final)
         */
        /* Ordena��o da lista */
        // Main.leituraCSV();

        /* Inser��o e remo��o na lista */
        // final LerCSV leitura = new LerCSV();
        // leitura.lerJogadores();
        // System.out.println("\nINSERIR NA LISTA");
        // leitura.adicionarJogador(jogador1, false);
        // System.out.println("\nREMOVER DA LISTA");
        // leitura.removerJogador(1188, false);

        // 2 - Implementar AVL e RB (inser��o, busca e ordem simetrica)
        /*
         * final AVL avl = new AVL();
         * final int min = 1;
         * final int max = 10;
         * System.out.printf("Inserir valores %d para %d\n", min, max);
         * for (int i = min; i < max; i++) {
         * avl.insert(i);
         * // System.out.println("Imprime balanceado:");
         * avl.printBalance();
         * }
         */

        // AVLTree avl = new AVLTree();
        // final int n = 10;
        // System.out.println("AVL");
        //
        // avl = Main.popularAvl(avl, n);
        // final ArrayList<NoAVLTree> ordem = avl.ordenar();
        // System.out.println("AVL Sort");
        // System.out.println(ordem);

        /* 3 - Implementar ordena��o */
        /* SelectionSort */
        // System.out.println("SelectionSort");
        // Main.implementarOrdenacao(selection);

        /* QuickSort */
        // System.out.println("QuickSort");
        // Main.implementarOrdenacao(quick);

        /* MergeSort */
        // System.out.println("MergeSort");
        // Main.implementarOrdenacao(merge);

        /* HeapSort */
        // System.out.println("HeapSort");
        // Main.implementarOrdenacao(heap);

        /* Ordena��o em tempo Linear */
        // System.out.println("RadixSort");
        // Main.implementarOrdenacao(radix);

        /* 4 - Implementar Lista, Pilha e Fila */

        // Main.implementaLista();

        // Main.implementaPilha();

        // Main.implementarFila();

    }

    private static final int tam = 1000000;

    private static int[] arrayG = Main.arrayRandomico();

    /**
     * M�todo que implementa a leitura e ordena��o do CSV
     */
    @SuppressWarnings("unused")
    private static void leituraCSV() {

        final LerCSV leitura = new LerCSV();
        leitura.lerJogadores();
        leitura.ordenaPorID(false);
        leitura.ordenaPorPeso(false);
        leitura.ordenaPorAltura(false);
    }

    /**
     * M�todo que implementa Lista Encadeada
     */
    @SuppressWarnings("unused")
    private static void implementaLista() {

        final long tempoInicial = System.currentTimeMillis();
        final Lista lista = new Lista();
        System.out.println("INSER��O NA LISTA");
        lista.adicionarNoFim(5);
        lista.adicionarNoFim(48);
        lista.adicionarNoInicio(55);
        lista.adicionarNoFim(4);
        lista.adicionarNoInicio(3);
        System.out.println("REMO��O");
        lista.remover(48);
        lista.remover(4);
        lista.remover(3);
        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execu��o da Lista: %.3f ms%n", (float) (tempoFinal - tempoInicial));
    }

    /**
     * M�todo que implementa Pilha
     */
    @SuppressWarnings("unused")
    private static void implementaPilha() {

        final long tempoInicial = System.currentTimeMillis();
        final Pilha pilha = new Pilha();
        System.out.println("INSER��O NA PILHA");
        pilha.adicionar(Main.randomico());
        pilha.adicionar(Main.randomico());
        pilha.adicionar(Main.randomico());
        pilha.adicionar(Main.randomico());
        pilha.adicionar(Main.randomico());

        System.out.println("REMO��O");
        pilha.remover();

        pilha.remover();
        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execu��o da Pilha: %.3f ms%n", (float) (tempoFinal - tempoInicial));
    }

    /**
     * M�todo que implementa Fila
     */
    @SuppressWarnings("unused")
    private static void implementarFila() {

        final long tempoInicial = System.currentTimeMillis();
        final Fila fila = new Fila();
        System.out.println("INSER��O NA FILA");
        fila.adicionar(Main.randomico());
        fila.adicionar(Main.randomico());
        fila.adicionar(Main.randomico());
        fila.adicionar(Main.randomico());
        fila.adicionar(Main.randomico());
        System.out.println("REMO��O");
        fila.remover();
        fila.remover();
        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execu��o da Fila: %.3f ms%n", (float) (tempoFinal - tempoInicial));
    }

    @SuppressWarnings({ "unused" })
    private static <T> void implementarOrdenacao(final T objeto) {

        final long tempoInicial = System.currentTimeMillis();
        final int[] array = Main.arrayG.clone();
        try {
            Method ordenar;
            if (OrdenaQuick.class.isAssignableFrom(objeto.getClass()) || OrdenaMerge.class.isAssignableFrom(objeto.getClass())) {
                ordenar = objeto.getClass().getMethod("ordenar", int[].class, int.class, int.class);
            } else if (OrdenaRadix.class.isAssignableFrom(objeto.getClass())) {
                ordenar = objeto.getClass().getMethod("ordenar", int[].class, int.class);
            } else {
                ordenar = objeto.getClass().getMethod("ordenar", int[].class);
            }
            ordenar.setAccessible(true);
            Method imprimir;
            if (OrdenaRadix.class.isAssignableFrom(objeto.getClass())) {
                imprimir = objeto.getClass().getMethod("imprimir", int[].class, int.class);
            } else {
                imprimir = objeto.getClass().getMethod("imprimir", int[].class);
            }
            imprimir.setAccessible(true);

            // System.out.println("Entrada");
            // Main.printOrdem(objeto, array, imprimir);

            if (OrdenaQuick.class.isAssignableFrom(objeto.getClass()) || OrdenaMerge.class.isAssignableFrom(objeto.getClass())) {
                ordenar.invoke(objeto, array, 0, Main.tam - 1);
            } else if (OrdenaRadix.class.isAssignableFrom(objeto.getClass())) {
                ordenar.invoke(objeto, array, Main.tam);
            } else {
                ordenar.invoke(objeto, array);
            }
            // System.out.println("Sa�da");
            // Main.printOrdem(objeto, array, imprimir);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execu��o: %.3f ms%n", (float) (tempoFinal - tempoInicial));
        System.out.println();
    }

    @SuppressWarnings("unused")
    private static <T> void printOrdem(final T objeto, final int[] array, final Method imprimir)
                    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        if (OrdenaRadix.class.isAssignableFrom(objeto.getClass())) {
            imprimir.invoke(objeto, array, Main.tam);
        } else {
            imprimir.invoke(objeto, array);
        }
        System.out.println();
    }

    private static AVLTree popularAvl(final AVLTree avl, final int n) {

        final ArrayList<Integer> listKey = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final int key = Main.randomico();
            listKey.add(key);
            avl.inserir(key);
        }
        System.out.println(listKey);
        return avl;
    }

    /**
     * M�todo para randomizar valores
     *
     * @return int
     */
    @SuppressWarnings("unused")
    private static int randomico() {

        final Random rand = new Random();
        final int max = 99;
        final int min = 0;
        return rand.nextInt(((max - min) + 1) + min);
    }

    /**
     * M�todo que cria uma matriz com n�meros aleat�rios
     *
     * @return int[]
     */
    @SuppressWarnings("unused")
    private static int[] arrayRandomico() {

        final int array[] = new int[Main.tam];

        final Random rand = new Random();
        final int max = 99;
        final int min = 0;
        rand.nextInt(((max - min) + 1) + min);
        for (int i = 0; i < Main.tam; i++) {
            array[i] = rand.nextInt(((max - min) + 1) + min);
        }
        return array;
    }
}