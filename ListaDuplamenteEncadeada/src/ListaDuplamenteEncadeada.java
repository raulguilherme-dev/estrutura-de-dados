import java.util.ArrayList;;

public class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;
    private int totalDeElementos;

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private No pegaNo (int posicao) {
        if(!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posição Inálida!");
        }
        No atual = this.inicio;
        for(int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public void adicionaNoInicio(Object elemento) {
        if(this.totalDeElementos == 0) {
            No novo = new No(elemento);
            this.inicio = novo;
            this.fim = novo;
        }
        else {
            No novo = new No(elemento, this.inicio);
            this.inicio.setAnterior(novo);
            this.inicio = novo;
        }
        this.totalDeElementos++;
    }

    public void adicionaNoFinal(Object elemento) {
        if(this.totalDeElementos == 0) {
            this.adicionaNoInicio(elemento);
        }
        else {
            No novo = new No(elemento);
            this.fim.setProximo(novo);
            novo.setAnterior(this.fim);
            this.fim = novo;
            this.totalDeElementos++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if(this.posicaoValida(posicao)) {
            if(posicao == 0) {
                this.adicionaNoInicio(elemento);
            }else {
                No anterior = this.pegaNo(posicao-1);
                No proximo = anterior.getProximo();
                No novo = new No(elemento, proximo);
                anterior.setProximo(novo);
                proximo.setAnterior(novo);
                novo.setAnterior(anterior);

                this.totalDeElementos++;

            }
        }else if(posicao == this.totalDeElementos){
            this.adicionaNoFinal(elemento);
        }else{
            System.out.println("Posição inválida!");
        }
    }

    public void removeDoInicio() {
        if(this.totalDeElementos > 1) {
            No novoInicio = this.inicio.getProximo();
            novoInicio.setAnterior(null);
            this.inicio = novoInicio;
        }else {
            this.fim = null;
            this.inicio = null;
        }
        this.totalDeElementos--;
    }

    public void removeDoFinal() {
        if(this.totalDeElementos > 1) {
            No NovoFim = this.fim.getAnterior();
            NovoFim.setProximo(null);
            this.fim = this.fim.getAnterior();
            this.totalDeElementos--;
        }
        else {
            this.removeDoInicio();
        }
    }

    public void remove(int posicao) {
        if(this.posicaoValida(posicao)) {
            if(posicao == 0) {
                this.removeDoInicio();
            }else if(posicao == this.totalDeElementos-1) {
                this.removeDoFinal();
            }else {
                No no = this.pegaNo(posicao);
                No anterior = no.getAnterior();
                No proximo = no.getProximo();
                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
                this.totalDeElementos--;
            }
        }else{
            System.out.println("Posição inválida!");
        }
    }


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

        System.out.println("Início: "+this.inicio.getElemento());
        System.out.println("Fim: "+this.fim.getElemento());
        return builder.toString();
    }

    public static ListaDuplamenteEncadeada copiaLista(ListaDuplamenteEncadeada l) {
        ListaDuplamenteEncadeada novaLista = new ListaDuplamenteEncadeada();
        No atual = l.getInicio();
        do {
            novaLista.adicionaNoInicio(atual.getElemento());
            l.removeDoInicio();
            atual = atual.getProximo();
        } while (atual != null);
        return novaLista;
    }

    public void embaralhaLista() {
        ListaDuplamenteEncadeada listaAuxiliar = copiaLista(this);
        No atual = this.getInicio();
        for (int i=0; i<listaAuxiliar.getTotalDeElementos(); i++) {

            atual = atual.getProximo();
        }
    }

    //PROVA 02

    // Questão 1

    public void encontraNesimo(int n) {
        int pos = 0;
        ListaDuplamenteEncadeada copia = copiaLista(this);
        int maior = (int) copia.getInicio().getElemento();
        No atual = copia.getInicio();
        int contador = 0;
        for (int c=0; c<n; c++) {
            atual = copia.getInicio();
            maior = (int) copia.getInicio().getElemento();
            contador =0;
            for (int i = 0; i < copia.getTotalDeElementos(); i++) {
                if ((int) atual.getElemento() > maior) {
                    maior = (int) atual.getElemento();
                    pos = contador;
                }
                atual = atual.getProximo();
                contador++;
            }
            copia.remove(pos);
        }
        System.out.println(maior);

    }


    // Questão 2
    public void divideLista(int n) {
        ListaDuplamenteEncadeada listas = new ListaDuplamenteEncadeada();
        int valores_por_lista = this.getTotalDeElementos() / n;
        No atual = this.getInicio();
        for (int i = 0; i < n; i++) {
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
            for (int c=0; c < valores_por_lista; c++) {
                lista.adicionaNoFinal(atual.getElemento());
                atual = atual.getProximo();
            }
            listas.adicionaNoFinal(lista);
        }
        System.out.println(listas);
    }

    //Apenas para testes
    public String listaAoContrario() {
        if(this.totalDeElementos==0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No atual = this.getFim();
        for(int i=0; i<this.totalDeElementos-1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getAnterior();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
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


}