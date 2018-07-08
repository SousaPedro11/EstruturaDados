package estruturadados.modelo;

import java.util.Date;

import estruturadados.anotacao.AtribuirToString;

public class Jogador extends ObjetoBase<Jogador> {

    @AtribuirToString(prefixo = "ID: ", sufixo = "\n")
    private int id;

    @AtribuirToString(prefixo = "Primeiro Nome: ", sufixo = "\n")
    private String primeironome;

    @AtribuirToString(prefixo = "Apelido: ", sufixo = "\n")
    private String apelido;

    @AtribuirToString(prefixo = "Nascimento: ", sufixo = "\n")
    private Date nascimento;

    @AtribuirToString(prefixo = "Altura: ", sufixo = "\n")
    private int altura;

    @AtribuirToString(prefixo = "Peso: ", sufixo = "\n")
    private int peso;

    public int getId() {

        return this.id;
    }

    public void setId(final int id) {

        this.id = id;
    }

    public String getPrimeironome() {

        return this.primeironome;
    }

    public void setPrimeironome(final String primeironome) {

        this.primeironome = primeironome;
    }

    public String getApelido() {

        return this.apelido;
    }

    public void setApelido(final String apelido) {

        this.apelido = apelido;
    }

    public Date getNascimento() {

        return this.nascimento;
    }

    public void setNascimento(final Date nascimento) {

        this.nascimento = nascimento;
    }

    public int getAltura() {

        return this.altura;
    }

    public void setAltura(final int altura) {

        this.altura = altura;
    }

    public int getPeso() {

        return this.peso;
    }

    public void setPeso(final int peso) {

        this.peso = peso;
    }

}
