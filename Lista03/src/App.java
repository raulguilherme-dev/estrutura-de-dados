import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] arcs) {
        // Questão 1
        Scanner entrada = new Scanner(System.in);
        LinkedList funcionarios = new LinkedList();
        for (int i=0; i < 5; i++) {
            System.out.print("Informe o funcionario: ");
            String funcionario = entrada.next();
            funcionarios.addLast(funcionario);
        }
        System.out.println(funcionarios);
        entrada.close();

        // Questão 2
        System.out.print("Eduardo está presente na lista? ");
        System.out.println(funcionarios.contains("Eduardo"));

        // Questão 3
        System.out.println("Indice 1: " +funcionarios.get(1));

        // Questão 4
        funcionarios.addFirst("Gerson");
        funcionarios.removeLast();

        // Questão 5
        System.out.println("Primeiro elemento: " + funcionarios.getFirst());
        System.out.println("Ultimo elemento: " + funcionarios.getLast());

        // Questão 6
        funcionarios.remove(3);
        System.out.println(funcionarios);
    }

}
