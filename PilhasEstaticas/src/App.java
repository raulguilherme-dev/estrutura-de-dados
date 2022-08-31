public class App {

    public static void main(String[] args) {
        //criando a pilha
        Pilha pilha = new Pilha(5);

        pilha.push(3);
        pilha.push(5);
        pilha.push(7);
        pilha.push(3);
        pilha.push(4);
        pilha.removeNumero(3);
    }

}