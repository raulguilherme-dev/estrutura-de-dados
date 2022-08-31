public class Arvore {
    public No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void inserir(int elemento) {
        if (this.isEmpty()) {
            No novo = new No(elemento);
            this.raiz = novo;
        } else {
            No atual = this.raiz;
            while (atual != null) {
                if (elemento < atual.getElemento()) {
                    if (atual.getEsq() == null) {
                        No novo = new No(elemento);
                        atual.setEsq(novo);
                        novo.setPai(atual);
                        return;
                    }
                    atual = atual.getEsq();
                } else {
                    if (atual.getDir() == null) {
                        No novo = new No(elemento);
                        atual.setDir(novo);
                        novo.setPai(atual);
                        return;
                    } else {
                        atual = atual.getDir();
                    }
                }
            }
        }
    }

    public void inserirRec(int elemento) {
        if (this.isEmpty()) {
            No novo = new No(elemento);
            this.raiz = novo;
        } else {
            inserirRec(this.raiz, elemento);
        }
    }

    private void inserirRec(No atual, int elemento) {
        if (elemento < atual.getElemento()) {
            if (atual.getEsq() == null) {
                No novo = new No(elemento);
                atual.setEsq(novo);
                novo.setPai(atual);
                return;
            }
            inserirRec(atual.getEsq(), elemento);
        } else {
            if (atual.getDir() == null) {
                No novo = new No(elemento);
                atual.setDir(novo);
                novo.setPai(atual);
                return;
            }
            inserirRec(atual.getDir(), elemento);
        }
    }

    public No busca(int elemento) {
        No atual = this.raiz;
        while (atual != null) {
            if (atual.getElemento() == elemento) {
                return atual;
            } else if (elemento < atual.getElemento()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }
        return null;
    }

    public No minimo() {
        if (this.isEmpty()) return null;

        No atual = this.raiz;
        while (atual.getEsq() != null) {
            atual = atual.getEsq();
        }
        return atual;
    }

    public No maximo() {
        if (this.isEmpty()) return null;

        No atual = this.raiz;
        while (atual.getDir() != null) {
            atual = atual.getDir();
        }
        return atual;

    }

    public void preOrdem() {
        preOrdem(this.raiz);
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.println(no.getElemento());
            preOrdem(no.getEsq());
            preOrdem(no.getDir());
        }
    }

    //Lista

    // Questão 1

    public int quantidadeNos() {
        return quantidadeNos(raiz);
    }

    private int quantidadeNos(No no) {
        if (no == null) return 0;
        return 1 + quantidadeNos(no.getEsq()) + quantidadeNos(no.getDir());
    }

    // Questão 2

    public int numeroFolhas(){
        return numeroFolhas(raiz);
    }

    private int numeroFolhas(No no) {
        if (no == null) return 0;

        else if (no.getEsq() == null && no.getDir() == null) {
            return 1;
        } else {
            return numeroFolhas(no.getEsq()) + numeroFolhas(no.getDir());
        }
    }

    // Questão 3

    public void isEqual(Arvore b) {

        No atual_a = this.raiz;
        No atual_b = b.raiz;
        boolean resposta = isEqual(atual_a, atual_b);
        System.out.println(resposta);
    }

    private boolean isEqual(No atual_a, No atual_b) {
        if (atual_a == null && atual_b == null) {
            return true;
        }

        if (atual_a != null && atual_b != null) {
            return (atual_a.getElemento() == atual_b.getElemento() &&
                    isEqual(atual_a.getEsq(), atual_b.getEsq()) &&
                    isEqual(atual_a.getDir(), atual_b.getDir())
                    );
        }
        return  false;
    }


}