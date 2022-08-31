public class App {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        pilha.push(100);
        pilha.push(300);
        pilha.push(500);
        pilha.push(200);
        pilha.push(600);
        System.out.println(pilha);
        pilha.removeNumero(200);
        System.out.println(pilha);

    }

}