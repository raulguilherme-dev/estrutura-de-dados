public class App {

    public static void main(String[] arcs) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        agenda.criar_agenda();
        System.out.println(agenda.listaContatos());
        agenda.insereContato("Raul", "15161651", "nslns@gmail.com", "01/07/2012");
        agenda.insereContato("Ana", "15161651", "nslns@gmail.com", "01/07/2012");
        agenda.insereContato("Vitor", "15161651", "nslns@gmail.com", "01/07/2012");
        agenda.insereContato("joão", "14454574", "dsmsd@gmail.com", "09/10/1999");
        System.out.println(agenda.getTotalDeElementos());
        System.out.println(agenda.listaContatos());
        System.out.println(agenda.buscaContato("Vitor"));
    }
}
