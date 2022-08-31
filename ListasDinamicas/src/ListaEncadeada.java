public class ListaEncadeada {
    private No inicio;
    private No fim;
    private int totalDeElementos;

    public void adicionaNoInicio(Object elemento) {
        No novo = new No(elemento, this.inicio);
        this.inicio = novo;
        if(this.totalDeElementos==0) {
            this.fim = novo;
        }
        this.totalDeElementos++;
    }

    public void adicionaNoFinal(Object elemento) {
        if(this.totalDeElementos==0) {
            this.adicionaNoInicio(elemento);
        }else {
            No novo = new No(elemento);
            this.fim.setProximo(novo);
            this.fim = novo;
            this.totalDeElementos++;
        }
    }

	/*@Override
	public String toString() {
		return "ListaEncadeada [inicio=" + inicio.getElemento() + ", fim=" + fim.getElemento() + ", totalDeElementos=" + totalDeElementos + "]";
	}*/

    @Override
    public String toString() {
        if(this.totalDeElementos==0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No atual = this.inicio;
        for(int i=0; i<this.totalDeElementos-1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }
    private No pegaNo (int posicao) {

        if(!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição Inválida!");
        }
        No atual = this.inicio;
        for(int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public void adiciona(int posicao, Object elemento) {
        if(posicao==0) {
            this.adicionaNoInicio(elemento);
        }else if(posicao==this.totalDeElementos-1) {
            this.adicionaNoFinal(elemento);
        }else{
            No anterior = this.pegaNo(posicao-1);
            No novo = new No(elemento, anterior.getProximo());
            anterior.setProximo(novo);
            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaNo(posicao).getElemento();
    }

    public void removeDoInicio() {
        this.inicio = this.inicio.getProximo();
        this.totalDeElementos--;

        if(this.totalDeElementos==0) {
            this.fim = null;
        }
    }

    public void removeDoFinal() {
        if(this.totalDeElementos==0) {
            System.out.println("Lista vazia! Impossível remover!");
        }else if(this.totalDeElementos==1){
            this.removeDoInicio();
        }else {
            No anterior = this.pegaNo(this.totalDeElementos-2);
            anterior.setProximo(null);
            this.fim = anterior;
            this.totalDeElementos--;
        }
    }

    public boolean remove(int posicao) {
        if (this.posicaoValida(posicao)) {
            return false;
        } else {
            if (posicao==0) {
                this.removeDoInicio();
                return true;
            } else if (posicao==this.totalDeElementos-1) {
                this.removeDoFinal();
                return true;
            } else {
                No anterior = this.pegaNo(posicao-1);
                No atual = anterior.getProximo();
                anterior.setProximo(atual.getProximo());
                this.totalDeElementos--;
            }
        }
        return true;
    }

    public boolean contem(Object elemento) {
        No atual = this.inicio;
        for (int i=0; i<this.totalDeElementos; i++) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    public int tamanho() {
        return this.totalDeElementos;
    }

    //Questão 1
    public boolean verificaOrdem() {
        if (totalDeElementos == 0 || totalDeElementos == 1) {
            if (totalDeElementos == 0) {
                System.out.println("Lista vazia");
            } else {
                System.out.println("Apenas um elemento na lista");
            }
        } else {
            No atual = this.inicio;
            for (int i = 0; i < totalDeElementos - 1; i++) {
                if ((int) atual.getProximo().getElemento() > (int) atual.getElemento()) {
                    atual = atual.getProximo();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //Questão 2
    public static boolean verificaListas(ListaEncadeada l1, ListaEncadeada l2) {
        if (l1.getTotalDeElementos() != l2.getTotalDeElementos()) {
            return false;
        } else {
            No l1_atual = l1.getInicio();
            No l2_atual = l2.getInicio();
            for (int i=0; i< l1.getTotalDeElementos(); i++) {
                if (l1_atual.getElemento().equals(l2_atual.getElemento())) {
                    l1_atual = l1_atual.getProximo();
                    l2_atual = l2_atual.getProximo();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //Questão 3
    public static void tranfereValores(Object v[]) {
        ListaEncadeada novaLista = new ListaEncadeada();
        for (int i=0; i < v.length; i++) {
            novaLista.adicionaNoFinal(v[i]);
        }
        System.out.println(novaLista);
    }



    //Questão 4
    public static ListaEncadeada copiaLista(ListaEncadeada l) {
        ListaEncadeada novaLista = new ListaEncadeada();
        No atual = l.getInicio();
        do {
            novaLista.adicionaNoInicio(atual.getElemento());
            l.removeDoInicio();
            atual = atual.getProximo();
        } while (atual != null);
        return novaLista;
    }

    //Quetão 5
    public static void removeAteX(ListaEncadeada l, int x) {
        No atual = l.getInicio();
        for (int i=0; i < l.getTotalDeElementos(); i++) {
            if ((int) atual.getElemento() == x) {
                break;
            }
            else {
                l.removeDoInicio();
                atual = l.getInicio();
            }
        }
    }

    /*public void ordenaLista(ListaEncadeada l) {
        ListaEncadeada k = new ListaEncadeada();
        int maior = 0;
        No atual = l.getInicio();
        for (int i=0; i<l.getTotalDeElementos(); i++) {
            if ((int) atual.getElemento() > maior) {
                maior = (int) atual.getElemento();
                l.remove();
            }
            k.adicionaNoFinal(maior);
            atual = atual.getProximo();
        }
    }*/

    // Lista 2

    // Questão 1
    public void moveMenor() {
        No menor = this.getInicio();
        No atual = this.getInicio();
        for (int i=0; i < this.getTotalDeElementos(); i++) {
            if ((int) atual.getElemento() < (int) menor.getElemento() ) {
                menor = atual;
            }
            atual = atual.getProximo();
        }
        No inicio = this.getInicio();
        this.setInicio(menor);
        menor.setProximo(inicio);
    }

    //Questão 2
    public void removeRepetidos() {
        No atual1 = this.getInicio();
        int removidos = 0;
        ListaEncadeada removiveis = new ListaEncadeada();
        for (int i=0; i<this.getTotalDeElementos()-removidos; i++) {
            No atual2 = atual1.getProximo();
            for (int j=i+1; j<this.getTotalDeElementos(); j++) {
                if (atual1.getElemento().equals(atual2.getElemento())) {
                    removiveis.adicionaNoInicio(j);
                }
                atual2 = atual2.getProximo();
            }
            atual1 = atual1.getProximo();
        }
        System.out.println(removiveis);
        
        No atualRemoviveis = removiveis.getInicio();
        for (int i=0; i<removiveis.getTotalDeElementos(); i++) {
            this.remove((int) atualRemoviveis.getElemento() - i);
            atualRemoviveis = atualRemoviveis.getProximo();
        }
    }

    //Questão 3
    public void trocaValores(Object x, Object y) {
        No atual = this.getInicio();
        No anteriorx = null;
        No posx = null;
        No anteriory = null;
        No posy = null;
        if (this.contem(x) && this.contem(y)) {
            for (int i = 0; i < this.getTotalDeElementos(); i++) {

                if (atual.getElemento().equals(x)) {
                    anteriorx = this.pegaNo(i - 1);
                    posx = atual;
                }

                if (atual.getElemento().equals(y)) {
                    anteriory = this.pegaNo(i - 1);
                    posy = atual;
                }

                atual = atual.getProximo();
            }
        } else {
            System.out.println("Um ou mais elementos não foram encontrados na lista");
            return;
        }
        posy.setProximo(posx.getProximo());
        anteriorx.setProximo(posy);
        posx.setProximo(posy.getProximo());
        anteriory.setProximo(posx);
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public int getTotalDeElementos() {
        return totalDeElementos;
    }

    public void setTotalDeElementos(int totalDeElementos) {
        this.totalDeElementos = totalDeElementos;
    }

}
