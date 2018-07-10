package estruturadados.arvores;

import estruturadados.modelo.ObjetoBase;

public class RBTree extends ObjetoBase<RBTree> {

    private final NoRBTree raiz;

    private static NoRBTree sentinela = new NoRBTree(0, false);

    private int cont;

    public RBTree() {

        this.raiz = RBTree.sentinela;
    }

    public RBTree(final int key) {

        this.raiz = new NoRBTree(key, false);
    }

    public static NoRBTree getSentinela() {

        return RBTree.sentinela;
    }

    public static void setSentinela(final NoRBTree sentinela) {

        RBTree.sentinela = sentinela;
    }
}
