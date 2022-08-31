import java.util.Scanner;

public class App {

    public static void main(String[] arcs) {
        Scanner entrada = new Scanner(System.in);
        Fila fila = new Fila();
        int escolha = 0;
        while (escolha != 4) {
            System.out.println("=========FILA DE CONTATOS========");
            System.out.println("Escolha uma opção:");
            System.out.println("[1] Inserir Contato");
            System.out.println("[2] Próximo Contato");
            System.out.println("[3] Imprimir Fila");
            System.out.println("[4] Sair");
            System.out.print("Escolha do usuário: ");
            escolha = entrada.nextInt();
            if (escolha == 1) {
                Fila contato = new Fila();
                String nome, telefone, email;
                System.out.print("Nome do contato: ");
                nome = entrada.next();
                System.out.print("Telefone do contato: ");
                telefone = entrada.next();
                System.out.print("Email do contato: ");
                email = entrada.next();
                contato.enqueue(nome);
                contato.enqueue(telefone);
                contato.enqueue(email);
                fila.enqueue(contato);
            } else if (escolha == 2) {
                System.out.println(fila.getInicio().getElemento());
                fila.dequeue();
            } else if (escolha == 3) {
                System.out.println(fila.imprimeFila());
            }
        }

    }
}
