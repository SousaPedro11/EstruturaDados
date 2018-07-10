package estruturadados.arvores;

import java.util.ArrayList;

import estruturadados.anotacao.AtribuirToString;

public class AVLTree {

    @AtribuirToString
    protected NoAVLTree raiz;

    public void inserir(final int key) {

        final NoAVLTree no = new NoAVLTree(key);
        this.inserirAVL(this.raiz, no);
    }

    private void inserirAVL(final NoAVLTree noCompara, final NoAVLTree noInsere) {

        if (noCompara == null) {
            this.raiz = noInsere;
        } else {
            if (noInsere.getKey() < noCompara.getKey()) {
                if (noCompara.getEsquerda() == null) {
                    noCompara.setEsquerda(noInsere);
                    noInsere.setPai(noCompara);
                    this.verificaBalanceamento(noCompara);
                } else {
                    this.inserirAVL(noCompara.getEsquerda(), noInsere);
                }
            } else if (noInsere.getKey() > noCompara.getKey()) {
                if (noCompara.getDireita() == null) {
                    noCompara.setDireita(noInsere);
                    noInsere.setPai(noCompara);
                    this.verificaBalanceamento(noCompara);
                } else {
                    this.inserirAVL(noCompara.getDireita(), noInsere);
                }
            }
        }
    }

    private int altura(final NoAVLTree noAtual) {

        if (noAtual == null) {
            return -1;
        }

        if ((noAtual.getEsquerda() == null) && (noAtual.getDireita() == null)) {
            return 0;
        } else if (noAtual.getEsquerda() == null) {
            return 1 + this.altura(noAtual.getDireita());
        } else if (noAtual.getDireita() == null) {
            return 1 + this.altura(noAtual.getEsquerda());
        } else {
            return 1 + Math.max(this.altura(noAtual.getEsquerda()), this.altura(noAtual.getDireita()));
        }

    }

    private NoAVLTree rotacaoDireita(final NoAVLTree noInicial) {

        final NoAVLTree noEsquerda = noInicial.getEsquerda();
        noEsquerda.setPai(noInicial.getPai());

        noInicial.setEsquerda(noEsquerda.getDireita());

        if (noInicial.getEsquerda() != null) {
            noInicial.getEsquerda().setPai(noInicial);
        }

        noEsquerda.setDireita(noInicial);
        noInicial.setPai(noEsquerda);

        if (noEsquerda.getPai() != null) {
            if (noEsquerda.getPai().getDireita() == noInicial) {
                noEsquerda.getPai().setDireita(noEsquerda);
            } else if (noEsquerda.getPai().getEsquerda() == noInicial) {
                noEsquerda.getPai().setEsquerda(noEsquerda);
            }
        }

        this.setBalanceamento(noInicial);
        this.setBalanceamento(noEsquerda);

        return noEsquerda;

    }

    private NoAVLTree rotacaoEsquerda(final NoAVLTree noInicial) {

        final NoAVLTree noDireita = noInicial.getDireita();
        noDireita.setPai(noInicial.getPai());

        noInicial.setDireita(noDireita.getEsquerda());

        if (noInicial.getDireita() != null) {
            noInicial.getDireita().setPai(noInicial);
        }

        noDireita.setEsquerda(noInicial);
        noInicial.setPai(noDireita);

        if (noDireita.getPai() != null) {
            if (noDireita.getPai().getDireita() == noInicial) {
                noDireita.getPai().setDireita(noDireita);
            } else if (noDireita.getPai().getEsquerda() == noInicial) {
                noDireita.getPai().setEsquerda(noDireita);
            }
        }

        this.setBalanceamento(noInicial);
        this.setBalanceamento(noDireita);

        return noDireita;

    }

    private NoAVLTree duplaRotacaoDireitaEsquerda(final NoAVLTree noInicial) {

        noInicial.setDireita(this.rotacaoDireita(noInicial.getDireita()));
        return this.rotacaoEsquerda(noInicial);

    }

    private NoAVLTree duplaRotacaoEsquerdaDireita(final NoAVLTree noInicial) {

        noInicial.setEsquerda(this.rotacaoEsquerda(noInicial.getEsquerda()));
        return this.rotacaoDireita(noInicial);

    }

    private NoAVLTree sucessor(NoAVLTree noAtual) {

        NoAVLTree sucessor = null;
        if (noAtual.getDireita() != null) {
            NoAVLTree noDireita = noAtual.getDireita();
            while (noDireita.getEsquerda() != null) {
                noDireita = noDireita.getEsquerda();
            }
            sucessor = noDireita;
        } else {
            NoAVLTree noPai = noAtual.getPai();
            while ((noPai != null) && (noAtual == noPai.getDireita())) {
                noAtual = noPai;
                noPai = noAtual.getPai();
            }
            sucessor = noPai;
        }
        return sucessor;
    }

    private void setBalanceamento(final NoAVLTree noAtual) {

        noAtual.setBalanceamento(this.altura(noAtual.getDireita()) - this.altura(noAtual.getEsquerda()));
    }

    private void verificaBalanceamento(NoAVLTree noAtual) {

        this.setBalanceamento(noAtual);

        final int balanceamento = noAtual.getBalanceamento();

        if (balanceamento == -2) {
            if (this.altura(noAtual.getEsquerda().getEsquerda()) >= this.altura(noAtual.getEsquerda().getDireita())) {
                noAtual = this.rotacaoDireita(noAtual);
            } else {
                noAtual = this.duplaRotacaoEsquerdaDireita(noAtual);
            }
        } else if (balanceamento == 2) {
            if (this.altura(noAtual.getDireita().getDireita()) >= this.altura(noAtual.getDireita().getEsquerda())) {
                noAtual = this.rotacaoEsquerda(noAtual);
            } else {
                noAtual = this.duplaRotacaoDireitaEsquerda(noAtual);
            }
        }

        if (noAtual.getPai() != null) {
            this.verificaBalanceamento(noAtual.getPai());
        } else {
            this.raiz = noAtual;
        }
    }

    private void removerNoEncontrado(NoAVLTree noRemover) {

        NoAVLTree noDireita;

        if ((noRemover.getEsquerda() == null) || (noRemover.getDireita() == null)) {
            if (noRemover.getPai() == null) {
                this.raiz = null;
                noRemover = null;
                return;
            }
            noDireita = noRemover;
        } else {
            noDireita = this.sucessor(noRemover);
            noRemover.setKey(noDireita.getKey());
        }

        NoAVLTree noPai;
        if (noDireita.getEsquerda() != null) {
            noPai = noDireita.getEsquerda();
        } else {
            noPai = noDireita.getDireita();
        }

        if (noPai != null) {
            noPai.setPai(noDireita.getPai());
        }

        if (noDireita.getPai() == null) {
            this.raiz = noPai;
        } else {
            if (noDireita == noDireita.getPai().getEsquerda()) {
                noDireita.getPai().setEsquerda(noPai);
            } else {
                noDireita.getPai().setDireita(noPai);
            }
            this.verificaBalanceamento(noDireita.getPai());
        }
        noDireita = null;
    }

    public void remover(final int key) {

        this.removerAVL(this.raiz, key);
    }

    private void removerAVL(final NoAVLTree noAtual, final int key) {

        if (noAtual == null) {
            return;
        } else {
            if (noAtual.getKey() > key) {
                this.removerAVL(noAtual.getEsquerda(), key);
            } else if (noAtual.getKey() < key) {
                this.removerAVL(noAtual.getDireita(), key);
            } else if (noAtual.getKey() == key) {
                this.removerNoEncontrado(noAtual);
            }
        }
    }

    public ArrayList<NoAVLTree> ordenar() {

        final ArrayList<NoAVLTree> lista = new ArrayList<>();
        this.ordenar(this.raiz, lista);
        return lista;
    }

    protected void ordenar(final NoAVLTree no, final ArrayList<NoAVLTree> lista) {

        if (no == null) {
            return;
        }
        this.ordenar(no.getEsquerda(), lista);
        lista.add(no);
        this.ordenar(no.getDireita(), lista);
    }
}
