package estruturadados.arvores;

import estruturadados.modelo.ObjetoBase;

public class RBTree extends ObjetoBase<RBTree> {

    private NoRBTree raiz;

    private static NoRBTree sentinela = new NoRBTree(0, false);

    private int cont;

    public RBTree() {

        this.raiz = RBTree.sentinela;
    }

    public RBTree(final int key) {

        this.raiz = new NoRBTree(key, false);
    }

    private void rotacaoEsquerda(final NoRBTree noInicial) {

        final NoRBTree noDireita = noInicial.getDireita();
        noInicial.setDireita(noDireita.getEsquerda());
        if (noDireita.getEsquerda() != RBTree.sentinela) {
            noDireita.getEsquerda().setPai(noInicial);
        }
        noDireita.setPai(noInicial.getPai());
        if (noInicial.getPai() == RBTree.sentinela) {
            this.raiz = noDireita;
        } else if (noInicial == noInicial.getPai().getEsquerda()) {
            noInicial.getPai().setEsquerda(noDireita);
        } else {
            noInicial.getPai().setDireita(noDireita);
        }
        noDireita.setEsquerda(noInicial);
        noInicial.setPai(noDireita);
    }

    private void rotacaoDireita(final NoRBTree noInicial) {

        final NoRBTree noEsquerda = noInicial.getEsquerda();
        noInicial.setEsquerda(noEsquerda.getDireita());
        if (noEsquerda.getDireita() != RBTree.sentinela) {
            noEsquerda.getDireita().setPai(noInicial);
        }
        noEsquerda.setPai(noInicial.getPai());
        if (noInicial.getPai() == RBTree.sentinela) {
            this.raiz = noEsquerda;
        } else if (noInicial == noInicial.getPai().getEsquerda()) {
            noInicial.getPai().setEsquerda(noEsquerda);
        } else {
            noInicial.getPai().setDireita(noEsquerda);
        }
        noEsquerda.setDireita(noInicial);
        noInicial.setPai(noEsquerda);

    }

    private NoRBTree busca(final int key) {

        return this.raiz.busca(key);
    }

    public void insere(final int key) {

        if (this.raiz == RBTree.sentinela) {
            this.raiz = new NoRBTree(key, false);
        } else {
            final NoRBTree found = this.busca(key);
            if (key < found.getKey()) {
                found.setEsquerda(new NoRBTree(key, true));
                found.getEsquerda().setPai(found);
                this.fixaadicao(found.getEsquerda());
            } else if (key > found.getKey()) {
                found.setDireita(new NoRBTree(key, true));
                found.getDireita().setPai(found);
                this.fixaadicao(found.getDireita());
            }
        }
    }

    private void fixaadicao(NoRBTree noPai) {

        NoRBTree noTio;
        while (noPai.getPai().isRed()) {
            if (noPai.getPai() == noPai.getPai().getPai().getEsquerda()) {
                noTio = noPai.getPai().getPai().getDireita();
                if (noTio.isRed()) {
                    noPai.getPai().setRed(false);
                    noTio.setRed(false);
                    noPai.getPai().getPai().setRed(true);
                    noPai = noPai.getPai().getPai();
                } else {
                    if (noPai == noPai.getPai().getDireita()) {
                        noPai = noPai.getPai();
                        this.rotacaoEsquerda(noPai);
                    }

                    noPai.getPai().setRed(false);
                    noPai.getPai().getPai().setRed(true);
                    this.rotacaoDireita(noPai.getPai().getPai());
                }
            } else {
                noTio = noPai.getPai().getPai().getEsquerda();
                if (noTio.isRed()) {
                    noTio.setRed(false);
                    noPai.getPai().setRed(false);
                    noPai.getPai().getPai().setRed(true);
                    noPai = noPai.getPai().getPai();
                } else {
                    if (noPai == noPai.getPai().getEsquerda()) {
                        noPai = noPai.getPai();
                        this.rotacaoDireita(noPai);
                    }

                    noPai.getPai().setRed(false);
                    noPai.getPai().getPai().setRed(true);
                    this.rotacaoEsquerda(noPai.getPai().getPai());
                }
            }
        }
        this.raiz.setRed(false);
    }

    private void troca(final NoRBTree no1, final NoRBTree no2) {

        if (no1.getPai() == RBTree.sentinela) {
            this.raiz = no2;
        } else if (no1 == no1.getPai().getEsquerda()) {
            no1.getPai().setEsquerda(no2);
        } else {
            no1.getPai().setDireita(no2);
        }
        no2.setPai(no1.getPai());
    }

    public void remove(final int key) {

        final NoRBTree z = this.busca(key);
        // Após utilizar o método encontra(), z será o nodo a ser excluído, caso ele exista, ou o com valor mais próximo de n
        // Caso não exista nodo com o valor n, o primeiro if do método já será quebrado e então não fará mais nada
        NoRBTree x, y = z;
        boolean cordey = y.isRed();

        if (z.getKey() == key) {
            if (z.getEsquerda() == RBTree.sentinela) {
                x = z.getDireita();
                this.troca(z, z.getDireita());
            } else if (z.getDireita() == RBTree.sentinela) {
                x = z.getEsquerda();
                this.troca(z, z.getEsquerda());
            } else {
                y = z.sucessor();
                cordey = y.isRed();
                x = y.getDireita();

                if (y.getPai() == z) {
                    x.setPai(y);
                } else {
                    this.troca(y, y.getDireita());
                    y.setDireita(z.getDireita());
                    y.getDireita().setPai(y);
                }
                this.troca(z, y);
                y.setEsquerda(z.getEsquerda());
                y.getEsquerda().setPai(y);
                y.setRed(z.isRed());
            }

            if (!cordey) {
                this.fixaremocao(x);
            }
        }
    }

    private void fixaremocao(NoRBTree key) {

        NoRBTree x;

        while ((key != this.raiz) && !key.isRed()) {
            if (key == key.getPai().getEsquerda()) {
                x = key.getPai().getDireita();

                if (x.isRed()) { // caso 1
                    x.setRed(false);
                    key.getPai().setRed(true);
                    this.rotacaoEsquerda(key.getPai());
                    x = key.getPai().getDireita();
                }
                if (!x.getEsquerda().isRed() && !x.getDireita().isRed()) { // caso 2
                    x.setRed(true);
                    key = key.getPai();
                } else {
                    if (!x.getDireita().isRed()) { // caso 3
                        x.getEsquerda().setRed(false);
                        x.setRed(true);
                        this.rotacaoDireita(x);
                        x = key.getPai().getDireita();
                    }
                    // caso 4
                    x.setRed(key.getPai().isRed());
                    key.getPai().setRed(false);
                    x.getDireita().setRed(false);
                    this.rotacaoEsquerda(key.getPai());
                    key = this.raiz;
                }
            } else {
                x = key.getPai().getEsquerda();

                if (x.isRed()) { // caso 1
                    x.setRed(false);
                    key.getPai().setRed(true);
                    this.rotacaoDireita(key.getPai());
                    x = key.getPai().getEsquerda();
                }
                if (!x.getEsquerda().isRed() && !x.getDireita().isRed()) { // caso 2
                    x.setRed(true);
                    key = key.getPai();
                } else {
                    if (!x.getEsquerda().isRed()) { // caso 3
                        x.getDireita().setRed(false);
                        x.setRed(true);
                        this.rotacaoEsquerda(x);
                        x = key.getPai().getEsquerda();
                    }
                    // caso 4
                    x.setRed(key.getPai().isRed());
                    key.getPai().setRed(false);
                    x.getEsquerda().setRed(false);
                    this.rotacaoDireita(key.getPai());
                    key = this.raiz;
                }
            }
        }
        key.setRed(false);
    }

    public void ordenar() {

        this.raiz.ordenar();
    }

    public NoRBTree minimo() {

        return this.raiz.menor();
    }

    public NoRBTree maximo() {

        return this.raiz.maior();
    }

    public static NoRBTree getSentinela() {

        return RBTree.sentinela;
    }

    public static void setSentinela(final NoRBTree sentinela) {

        RBTree.sentinela = sentinela;
    }
}
