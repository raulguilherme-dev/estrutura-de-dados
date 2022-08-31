public class No {
    private No proximo;
    private Object elemento;

    private ListaEncadeada lista;

    public ListaEncadeada getLista() {
        return lista;
    }

    public void setLista(ListaEncadeada contato) {
        this.lista = contato;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public No(Object elemento) {
        this.elemento = elemento;
    }
    public No(Object elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public No(ListaEncadeada lista) {
        this.lista = lista;
    }

    public No(ListaEncadeada lista, No proximo) {
        this.lista = lista;
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proixmo) {
        this.proximo = proixmo;
    }
}
