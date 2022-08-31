import java.util.Arrays;

public class Fila {

    private int tamanho;
    private Object elementos[];

    public Fila(int capacidade) {
        this.tamanho = 0;
        this.elementos = new Object[capacidade];
    }

    public void enqueue(Object elemento) {
        this.elementos[tamanho++] = elemento;
    }

    public void dequeue() {
        if (!this.isEmpty()) {
            for(int i=0; i<tamanho-1;i++) {
                this.elementos[i] = this.elementos[i+1];
            }
            this.tamanho--;
        } else {
            System.out.println("Lista vazia");
        }
    }

    public boolean isEmpty() {
        if (this.tamanho < 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.tamanho;
    }

    public Object front() {
        if (!this.isEmpty()) {
            return this.elementos[0];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for(int i=0; i<this.tamanho-1;i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }
        if(this.tamanho>0) {
            s.append(this.elementos[this.tamanho-1]);
        }
        s.append("]");
        return s.toString();
    }
}