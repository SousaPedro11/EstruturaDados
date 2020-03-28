package estruturadados.arvores;

import estruturadados.anotacao.AtribuirToString;
import estruturadados.modelo.ObjetoBase;

public class NoAVLTree extends ObjetoBase<AVLTree> {

    private NoAVLTree esquerda;

    private NoAVLTree direita;

    private NoAVLTree pai;

    @AtribuirToString
    private int key;

    private int balanceamento;

    public NoAVLTree(final int key) {

        this.setEsquerda(this.setDireita(this.setPai(null)));
        this.setBalanceamento(0);
        this.setKey(key);
    }

    public NoAVLTree getEsquerda() {

        return this.esquerda;
    }

    public void setEsquerda(final NoAVLTree esquerda) {

        this.esquerda = esquerda;
    }

    public NoAVLTree getDireita() {

        return this.direita;
    }

    public NoAVLTree setDireita(final NoAVLTree direita) {

        return this.direita = direita;
    }

    public NoAVLTree getPai() {

        return this.pai;
    }

    public NoAVLTree setPai(final NoAVLTree pai) {

        return this.pai = pai;
    }

    public int getKey() {

        return this.key;
    }

    public void setKey(final int key) {

        this.key = key;
    }

    public int getBalanceamento() {

        return this.balanceamento;
    }

    public void setBalanceamento(final int balanceamento) {

        this.balanceamento = balanceamento;
    }

}
