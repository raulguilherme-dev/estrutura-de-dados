public class Pilha {
    private No topo;
    private int tamanho;

    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void push(int elemento) {
        No novo = new No(elemento, this.topo);
        this.topo = novo;
        this.tamanho++;
    }

    public boolean isEmpty() {
        return this.topo==null;
    }

    public int size() {
        return this.tamanho;
    }

    public Object top() {
        return this.topo.getElemento();
    }

    public Object pop() {
        if(this.isEmpty()) return null;

        Object elementoTopo = this.topo.getElemento();
        this.topo = this.topo.getProximo();
        this.tamanho--;
        return elementoTopo;
    }

    @Override
    public String toString() {
        if(this.isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No atual = this.topo;
        for(int i=0; i<this.tamanho-1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento());
        builder.append("]");

        return builder.toString();
    }

    public void removeNumero(int numero) {
        Pilha elementosRemovidos = new Pilha();

        No atual1 = topo;
        int t = this.tamanho;
        for (int i = 0; i < t; i++) {
            if (numero != atual1.getElemento()) {
                elementosRemovidos.push(atual1.getElemento());
            }
            this.pop();
            atual1 = atual1.getProximo();
        }

        No atual3 = elementosRemovidos.topo;

        for (int i = 0; i < elementosRemovidos.tamanho; i++) {
            this.push(atual3.getElemento());
            atual3 = atual3.getProximo();
        }
    }

}