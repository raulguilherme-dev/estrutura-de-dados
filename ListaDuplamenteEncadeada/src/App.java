public class App {

    public static void main(String[] arcs) {

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        /*lista.adicionaNoInicio(5);
        lista.adicionaNoInicio(7);
        lista.adicionaNoInicio(6);
        lista.adicionaNoInicio(1);
        lista.adicionaNoFinal(2);
        lista.adicionaNoFinal(9);
        lista.adiciona(2, 8);
        System.out.println(lista);
        lista.removeDoInicio();
        lista.removeDoFinal();
        lista.remove(0);
        System.out.println(lista);
        System.out.println(lista.listaAoContrario());
         */

        lista.adicionaNoInicio(15);
        lista.adicionaNoInicio(47);
        lista.adicionaNoInicio(100);
        lista.adicionaNoInicio(4);
        lista.adicionaNoInicio(93);
        lista.adicionaNoInicio(66);
        lista.adicionaNoInicio(11);
        lista.adicionaNoInicio(38);
        lista.adicionaNoInicio(59);
        lista.adicionaNoInicio(40);
        lista.adicionaNoInicio(71);
        lista.adicionaNoInicio(22);
        System.out.println(lista);
        lista.encontraNesimo(1);
    }
}
