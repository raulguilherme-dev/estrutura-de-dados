public class App {

    public static void main(String[] arcs) {
        Fila f = new Fila(6);

        f.enqueue(1);
        f.enqueue(2);
        f.enqueue(3);
        f.enqueue(4);
        f.enqueue(5);
        f.dequeue();
        System.out.println(f.isEmpty());
        System.out.println(f.front());
        System.out.println(f);
    }
}
