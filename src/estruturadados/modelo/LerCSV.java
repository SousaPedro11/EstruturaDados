package estruturadados.modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import estruturadados.util.Reflexao;

/**
 * Classe de leitura do arquivo csv presente na pasta raiz do projeto
 *
 * @author Pedro
 *
 */
public class LerCSV extends ObjetoBase<LerCSV> {

    private final List<Jogador> jogadores = new ArrayList<>();

    int i = 0;

    /**
     * Método de leitura do csv e criação dos objetos jogador
     *
     * @author Pedro
     */
    public void lerJogadores() {

        final long tempoInicial = System.currentTimeMillis();

        try (final BufferedReader leitor = new BufferedReader(new InputStreamReader(
                        new FileInputStream("base_futebol.csv"),
                        "UTF-8"))) {

            // ler cabecalho
            leitor.readLine();
            String linha = null;
            while ((linha = leitor.readLine()) != null) {

                this.i++;
                // cria objeto a cada passada do loop
                final Jogador jogador = new Jogador();

                // incrementa contador

                // inicializa posicao da coluna
                int posicao = 0;

                // separa linha em colunas delimitadas por virgula
                final String[] campos = linha.split(",", -1);

                // Associa campos aos atributos do objeto jogador
                for (final Field field : jogador.getClass().getDeclaredFields()) {
                    final String coluna = campos[posicao++];
                    field.setAccessible(true);
                    if (int.class.isAssignableFrom(field.getType()) && (!coluna.isEmpty())) {
                        field.set(jogador, Integer.parseInt(coluna));
                    } else if (Date.class.isAssignableFrom(field.getType())) {
                        field.set(jogador, Reflexao.toDate((coluna)));
                    } else if (int.class.isAssignableFrom(field.getType()) && (coluna.isEmpty())) {
                        field.set(jogador, Random.class.newInstance().nextInt((99 - 60) + 1) + 60);
                    } else {
                        field.set(jogador, coluna);
                    }
                }

                this.jogadores.add(jogador);
            }
        } catch (final Exception e) {
            System.out.println(this.i);
            e.printStackTrace();
        }

        // System.out.println(this.jogadores.size());
        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execução da leitura: %.3f ms%n", (float) (tempoFinal - tempoInicial));
    }

    /**
     * Método que ordena por ID usando Bubblesort
     *
     * @author Pedro
     */
    public void ordenaPorID(final boolean print) {

        final long tempoInicial = System.currentTimeMillis();

        List<Jogador> objeto = new ArrayList<>();
        objeto = this.jogadores;

        int maior_i = 0;

        for (int i = 0; i < this.jogadores.size(); i++) {
            for (int j = 0; j < (this.jogadores.size() - i - 1); j++) {
                if (this.jogadores.get(j).getId() > this.jogadores.get(j + 1).getId()) {
                    final Jogador temp = objeto.get(j);
                    objeto.set(j, objeto.get(j + 1));
                    objeto.set(j + 1, temp);
                }
            }
            maior_i = i;
        }

        if (print) {
            System.out.println("\nOrdenação por ID");
            objeto.stream().forEach(f -> {
                System.out.println("ID: " + f.getId() + "   Nome: " + f.getPrimeironome().concat(" ").concat(f.getApelido()));
            });
            System.out.println("Número de elementos: " + objeto.size());
        }
        // System.out.println(objeto.size());
        // System.out.println("Jogador com maior ID: " + objeto.get(maior_i));
        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execução da ordenação por ID: %.3f ms%n", (float) (tempoFinal - tempoInicial));

    }

    /**
     * Método que ordena por Peso usando Bubblesort
     *
     * @author Pedro
     */
    public void ordenaPorPeso(final boolean print) {

        final long tempoInicial = System.currentTimeMillis();

        List<Jogador> objeto = new ArrayList<>();
        objeto = this.jogadores;

        int maior_i = 0;

        for (int i = 0; i < this.jogadores.size(); i++) {
            for (int j = 0; j < (this.jogadores.size() - i - 1); j++) {
                if (this.jogadores.get(j).getPeso() > this.jogadores.get(j + 1).getPeso()) {
                    final Jogador temp = objeto.get(j);
                    objeto.set(j, objeto.get(j + 1));
                    objeto.set(j + 1, temp);
                }
            }
            maior_i = i;
        }

        if (print) {
            System.out.println("\nOrdenação por Peso");
            objeto.stream().forEach(f -> {
                System.out.println("Peso: " + f.getPeso() + "   Nome: " + f.getPrimeironome().concat(" ").concat(f.getApelido()));
            });
            System.out.println("Número de elementos: " + objeto.size());
        }
        // System.out.println(objeto.size());
        // System.out.println("Jogador com maior ID: " + objeto.get(maior_i));
        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execução da ordenação por Peso: %.3f ms%n", (float) (tempoFinal - tempoInicial));
    }

    /**
     * Método que ordena por Altura usando Bubblesort
     *
     * @author Pedro
     */
    public void ordenaPorAltura(final boolean print) {

        final long tempoInicial = System.currentTimeMillis();

        List<Jogador> objeto = new ArrayList<>();
        objeto = this.jogadores;

        int maior_i = 0;

        for (int i = 0; i < this.jogadores.size(); i++) {
            for (int j = 0; j < (this.jogadores.size() - i - 1); j++) {
                if (this.jogadores.get(j).getAltura() > this.jogadores.get(j + 1).getAltura()) {
                    final Jogador temp = objeto.get(j);
                    objeto.set(j, objeto.get(j + 1));
                    objeto.set(j + 1, temp);
                }
            }
            maior_i = i;
        }

        if (print) {
            System.out.println("\nOrdenação por Altura");
            objeto.stream().forEach(f -> {
                System.out.println("Altura: " + f.getAltura() + "   Nome: " + f.getPrimeironome().concat(" ").concat(f.getApelido()));
            });
            System.out.println("Número de elementos: " + objeto.size());
        }
        // System.out.println(objeto.size());
        // System.out.println("Jogador com maior ID: " + objeto.get(maior_i));
        final long tempoFinal = System.currentTimeMillis();
        System.out.printf("Tempo de execução da ordenação por Altura: %.3f ms%n", (float) (tempoFinal - tempoInicial));

    }

}
