public class App {

    public static void main(String[] arcs) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionaNoFinal(10);
        lista.adicionaNoFinal(9);
        lista.adicionaNoFinal(8);
        lista.adicionaNoFinal(7);
        lista.adicionaNoFinal(6);
        lista.adicionaNoFinal(5);
        lista.adicionaNoFinal(4);
        lista.adicionaNoFinal(3);
        lista.adicionaNoFinal(2);
        lista.adicionaNoFinal(1);
        System.out.println(lista);
        lista.trocaValores(10, 1);
        System.out.println(lista);
        /*ListaEncadeada lista2 = new ListaEncadeada();
        lista2.copiaLista(lista);
        System.out.println();
        System.out.println(lista2);
        Object vetor[] = {10, 20, 30, 40, 50, 60, 70, 80};
        ListaEncadeada.tranfereValores(vetor);
        System.out.println(lista);
        System.out.println(lista.verificaOrdem());
        System.out.println(ListaEncadeada.verificaListas(lista, lista2));
        System.out.println(lista);
        System.out.println(lista2);
        ListaEncadeada listsa3 = new ListaEncadeada();
        listsa3.adicionaNoFinal(1);
        listsa3.adicionaNoFinal(2);
        listsa3.adicionaNoFinal(3);
        listsa3.adicionaNoFinal(4);
        listsa3.adicionaNoFinal(5);
        listsa3.adicionaNoFinal(6);
        listsa3.adicionaNoFinal(7);
        ListaEncadeada.removeAteX(listsa3, 5);
        System.out.println(listsa3);*/
    }
}
