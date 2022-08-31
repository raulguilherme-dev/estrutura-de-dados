import java.util.ArrayList;
import java.util.Arrays;

public class AgendaTelefonica extends ListaEncadeada{

    private String[] alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split("");

    public void criar_agenda() {
        this.setTotalDeElementos(0);
    }

    public void insereContato(String nome, String telefone, String email, String dataAniversario) {
        AgendaTelefonica contato = new AgendaTelefonica();
        contato.adicionaNoFinal(nome);
        contato.adicionaNoFinal(telefone);
        contato.adicionaNoFinal(email);
        contato.adicionaNoFinal(dataAniversario);
        No novo = new No(contato, this.getInicio());
        if (this.getTotalDeElementos() == 0) {
            this.setInicio(novo);
            this.setFim(novo);
        } else {
            No ultimo = this.getFim();
            ultimo.setProximo(novo);
            this.setFim(novo);
        }
        this.setTotalDeElementos(this.getTotalDeElementos()+1);
    }

    public int buscaContato(String nome) {
        No atual = this.getInicio();
        No no_contato_atual = atual.getLista().getInicio();
        Object contato_atual;
        for (int i = 0; i < this.getTotalDeElementos(); i++) {
            contato_atual = no_contato_atual.getElemento();
            System.out.println(contato_atual);
            System.out.println(nome);
            if (contato_atual.equals(nome)) {
                System.out.println(atual.getLista());
                return i;
            }
            atual = atual.getProximo();
            no_contato_atual = no_contato_atual.getProximo();
        }
        return -1;
    }

    public void removeContato(String nome) {
        int contato_para_remover = buscaContato(nome);
        if (contato_para_remover == -1) {
            System.out.println("Contato não encontrado");
        } else {
            No atual = pegaNo(contato_para_remover);
            No anterior = pegaNo(contato_para_remover-1);
            anterior.setProximo(atual.getProximo());
        }
    }

    public void atualizaContato(String nome_atual, String novo_nome, String telefone, String email, String dataAniversario) {
        int posicao = buscaContato(nome_atual);
        if (posicao == -1) {
            System.out.println("Contato não encontrado");
            return;
        }
        AgendaTelefonica novo_contato = new AgendaTelefonica();
        novo_contato.adicionaNoFinal(novo_nome);
        novo_contato.adicionaNoFinal(telefone);
        novo_contato.adicionaNoFinal(email);
        novo_contato.adicionaNoFinal(dataAniversario);
        No novo = new No(novo_contato);
        No anterior = pegaNo(posicao-1);
        novo.setProximo(pegaNo(posicao).getProximo());
        anterior.setProximo(novo);
        
    }

    public void inverteDirecao() {
        No atual = this.getFim();
        int posicao = this.getTotalDeElementos()-1;
        this.setInicio(atual);
        while (atual != null) {
            posicao--;
            No proximo = pegaNo(posicao);
            atual.setProximo(proximo);
            atual = atual.getProximo();
        }
    }


    public String listaContatos() {
        if(this.getTotalDeElementos()==0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        No atual = this.getInicio();
        for(int i=0; i<this.getTotalDeElementos(); i++) {
            builder.append("[");
            if (atual.getLista() != null) {

                No atual_l = atual.getLista().getInicio();
                for (int j=0; j<atual.getLista().getTotalDeElementos()-1; j++) {
                    builder.append(atual_l.getElemento());
                    builder.append(", ");
                    atual_l = atual_l.getProximo();
                }
                builder.append(atual_l.getElemento());
                builder.append("]");
            }
            //builder.append(atual.getLista());
            builder.append(", ");
            atual = atual.getProximo();
        }
        builder.append("]");
        return builder.toString();
    }
}

