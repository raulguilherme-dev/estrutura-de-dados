public class App {

    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.inserir(10);
        arvore.inserir(2);
        arvore.inserir(80);
        arvore.inserir(3);
        arvore.inserir(11);
        arvore.inserir(18);
        //arvore.inserir(19);

        Arvore arvore2 = new Arvore();

        arvore2.inserir(10);
        arvore2.inserir(2);
        arvore2.inserir(80);
        arvore2.inserir(3);
        arvore2.inserir(11);
        arvore2.inserir(15);
        //arvore2.inserir(14);


        /*if(arvore.busca(3)!=null) {
            System.out.println("Elemento encontrado:"+arvore.busca(3).getElemento());
            System.out.println("Pai:"+arvore.busca(3).getPai().getElemento());
        }
        System.out.println("Máximo: "+arvore.maximo().getElemento());
        System.out.println("Mínimo: "+arvore.minimo().getElemento());*/

        arvore.isEqual(arvore2);
    }

}