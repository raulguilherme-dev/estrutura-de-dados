import java.util.Arrays;

public class Pilha {
    private int elementos[];
    private int topo;

    public Pilha(int capacidade) {
        this.topo=-1;
        this.elementos = new int[capacidade];
    }

    //INSERE
    public boolean push(int elemento) {
        if(this.topo < this.elementos.length-1) {
            this.topo++;
            this.elementos[topo] = elemento;
            return true;
        }
        return false;
    }

    //VERIFICA SE ESTÁ VAZIA
    public boolean isEmpty() {
        return topo<0;
    }

    //TAMANHO
    public int size() {
        if(this.isEmpty()) return 0;
        return this.topo+1;
    }

    //REMOVE TOPO
    public Object pop() {
        if (this.isEmpty()) return null;
        return this.elementos[this.topo--];
    }

    public Object top() {
        if (this.isEmpty()) return null;
        return this.elementos[this.topo];
    }

    @Override
    public String toString() {
        return "Pilha{" +
                "elementos=" + Arrays.toString(elementos) +
                '}';
    }

    // Prova 3

    public void removeNumero(int numero) {
        Pilha elementosRemovidos = new Pilha(topo);

        for (int i = 0; i < topo; i++) {
            if (numero != elementos[i]) {
                elementosRemovidos.push(elementos[i]);
            }
            this.pop();
        }

        for (int i = 0; i < elementosRemovidos.topo; i++) {
            this.push(elementosRemovidos.elementos[i]);
        }
        System.out.println(elementosRemovidos);
        System.out.println(this);
    }


}