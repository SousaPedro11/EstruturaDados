package estruturadados.arvores;

import estruturadados.anotacao.AtribuirToString;
import estruturadados.modelo.ObjetoBase;

public class NoRBTree extends ObjetoBase<NoRBTree> {

    private NoRBTree esquerda;

    private NoRBTree direita;

    private NoRBTree pai;

    @AtribuirToString
    private int key;

    private boolean red;

    public NoRBTree(final int key, final boolean red) {

        this.key = key;
        this.red = red;
        this.pai = this.esquerda = this.direita = RBTree.getSentinela();
    }

    private NoRBTree busca(final int key) {

        NoRBTree no = null;
        if ((key < this.key) && (this.esquerda != RBTree.getSentinela())) {
            no = this.esquerda.busca(key);
        } else if ((key > this.key) && (this.direita != RBTree.getSentinela())) {
            no = this.direita.busca(key);
        } else {
            no = this;
        }
        return no;
    }

    private NoRBTree menor() {

        NoRBTree no = null;
        if (this.esquerda != RBTree.getSentinela()) {
            no = this.esquerda.menor();
        } else {
            no = this;
        }

        return no;
    }

    private NoRBTree maior() {

        NoRBTree no = null;
        if (this.direita != RBTree.getSentinela()) {
            no = this.direita.maior();
        } else {
            no = this;
        }
        return no;
    }

    private void ordenar() {

        if (this.esquerda != RBTree.getSentinela()) {
            this.esquerda.ordenar();
        }
        System.out.println(this.key + " ");
        if (this.direita != RBTree.getSentinela()) {
            this.direita.ordenar();
        }
    }

    private NoRBTree antecessor() {

        NoRBTree no = null;
        if (this.esquerda != RBTree.getSentinela()) {
            no = this.esquerda.maior();
        } else {
            no = this;
        }

        return no;
    }

    private NoRBTree sucessor() {

        NoRBTree no = null;
        if (this.direita != RBTree.getSentinela()) {
            no = this.direita.menor();
        } else {
            no = this;
        }

        return no;
    }

    public NoRBTree getEsquerda() {

        return this.esquerda;
    }

    public void setEsquerda(final NoRBTree esquerda) {

        this.esquerda = esquerda;
    }

    public NoRBTree getDireita() {

        return this.direita;
    }

    public void setDireita(final NoRBTree direita) {

        this.direita = direita;
    }

    public NoRBTree getPai() {

        return this.pai;
    }

    public void setPai(final NoRBTree pai) {

        this.pai = pai;
    }

    public int getKey() {

        return this.key;
    }

    public void setKey(final int key) {

        this.key = key;
    }

    public boolean isRed() {

        return this.red;
    }

    public void setRed(final boolean red) {

        this.red = red;
    }

}
