public class No {
    private No proximo;
    private Object elemento;

    public No(Object elemento) {
        this.elemento = elemento;
    }
    public No(Object elemento, No proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proixmo) {
        this.proximo = proixmo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
