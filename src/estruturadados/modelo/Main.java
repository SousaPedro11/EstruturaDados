package estruturadados.modelo;

import java.util.Random;

public class Main {

	public static void main(final String[] args) {

		/*
		 * 1 - Leitura e ordena��o do CSV Para utilizar basta descomentar e executar um
		 * metodo por vez (inclusive no m�todo no final)
		 */
		// Main.leituraCSV();

		// 2 - Implementar AVL e RB (inser��o, busca e ordem simetrica)

		/* 3 - Implementar ordena��o */
		/* SelectionSort */
		Main.implementaSelectionSort();

		/* QuickSort */
		Main.implementaQuick();

		/* MergeSort */
		Main.implementaMerge();

		/* HeapSort */
		Main.implementaHeap();

		/* Ordena��o em tempo Linear */
		Main.implementaRadix();

		/* 4 - Implementar Lista, Pilha e Fila */

		// Main.implementaLista();

		// Main.implementaPilha();

		// Main.implementarFila();

	}

	private static final int tam = 1000;
	private static int[] arrayG = arrayRandomico();

	/**
	 * M�todo que implementa a leitura e ordena��o do CSV
	 */
	@SuppressWarnings("unused")
	private static void leituraCSV() {

		final LerCSV leitura = new LerCSV();
		leitura.lerJogadores();
		// leitura.ordenaPorID(false);
		leitura.ordenaPorAltura(false);
		leitura.ordenaPorPeso(false);
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

	/**
	 * M�todo que implementa SelectionSort
	 */
	@SuppressWarnings("unused")
	private static void implementaSelectionSort() {

		final long tempoInicial = System.currentTimeMillis();
		int[] array = arrayG.clone();

		final OrdenaSelecao selecao = new OrdenaSelecao();
		System.out.println("\nSELECTIONSORT");
//		System.out.println("Entrada: ");
//		selecao.imprimir(array);
//		System.out.println();
		selecao.ordenar(array);

//		System.out.println();
//		System.out.println("Ordenada: ");
//		selecao.imprimir(array);
		final long tempoFinal = System.currentTimeMillis();
		System.out.printf("\nTempo de execu��o da SelectionSort: %.3f ms%n", (float) (tempoFinal - tempoInicial));
	}

	@SuppressWarnings("unused")
	private static void implementaQuick() {

		final long tempoInicial = System.currentTimeMillis();
		int[]array = arrayG.clone();
		final OrdenaQuick quick = new OrdenaQuick();
		System.out.println("\nQUICKSORT");
//		System.out.println("Entrada:");
//		quick.imprimir(array);

		quick.sort(array, 0, Main.tam - 1);

//		System.out.println("Ordenado:");
//		quick.imprimir(array);
		final long tempoFinal = System.currentTimeMillis();
		System.out.printf("Tempo de execu��o da QuickSort: %.3f ms%n", (float) (tempoFinal - tempoInicial));
	}

	@SuppressWarnings("unused")
	private static void implementaMerge() {

		final long tempoInicial = System.currentTimeMillis();
		int[]array = arrayG.clone();
		final OrdenaMerge merge = new OrdenaMerge();
		System.out.println("\nMERGESORT");
//		System.out.println("Entrada");
//		 merge.imprimir(array);

		merge.sort(array, 0, Main.tam - 1);

//		System.out.println("\nOrdenado");
//		 merge.imprimir(array);
		System.out.println();
		final long tempoFinal = System.currentTimeMillis();
		System.out.printf("Tempo de execu��o da MergeSort: %.3f ms%n", (float) (tempoFinal - tempoInicial));
	}

	@SuppressWarnings("unused")
	private static void implementaHeap() {

		final long tempoInicial = System.currentTimeMillis();
		int[]array = arrayG.clone();

		final OrdenaHeap heap = new OrdenaHeap();
		System.out.println("\nHEAPSORT");
//		System.out.println("Entrada");
//		 heap.imprimir(array);

		heap.sort(array);

//		System.out.println("\nOrdenado");
//		 heap.imprimir(array);
		System.out.println();
		final long tempoFinal = System.currentTimeMillis();
		System.out.printf("Tempo de execu��o da HeapSort: %.3f ms%n", (float) (tempoFinal - tempoInicial));
	}

	@SuppressWarnings("unused")
	private static void implementaRadix() {

		final long tempoInicial = System.currentTimeMillis();
		int[]array = arrayG.clone();

		final OrdenaRadix radix = new OrdenaRadix();
		System.out.println("\nRADIXSORT");
//		System.out.println("Entrada");
//		 radix.imprimir(array, Main.tam);

		OrdenaRadix.radixsort(array, Main.tam);

//		System.out.println("\nOrdenado");
//		 radix.imprimir(array, Main.tam);
		final long tempoFinal = System.currentTimeMillis();
		System.out.printf("\nTempo de execu��o da RadixSort: %.3f ms%n", (float) (tempoFinal - tempoInicial));
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