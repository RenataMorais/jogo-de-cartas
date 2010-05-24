package paciencia;

import java.util.Stack;

/**
 * @projeto Jogo de Cartas
 * @disciplina Padrões e Frameworks
 * @autor João Carlos Nunes Bittencourt
 */
public class Carta {

    private int valor;
    private int naipe;
    private boolean status; // Virada ou não

    public void viraCarta(Carta x) {
        if (x.isStatus() == true) {
            x.setStatus(false);
        }
    }

    public Carta geraCarta(){
        Carta novaCarta = new Carta();
        int v = 0;
        int n = 0;
        
        novaCarta.setStatus(false);
        n = (int) (Math.random() * 4+1);
        novaCarta.setNaipe(n);
        v = (int) (Math.random() * 13+1);
        novaCarta.setValor(v);

        return novaCarta;
    }

    public boolean procuraCarta(Stack<Carta> pilha, Carta c1) {
        boolean achou = false;

        for (int j = 0; j < pilha.size() - 1; j++) {
            if ((pilha.elementAt(j).getNaipe() == c1.getNaipe()) && (pilha.elementAt(j).getValor() == c1.getValor())) {
                //System.out.println("Achei!");
                achou = true;
                break;
            } else {
                //System.out.println("Não Achei!!!");
                achou = false;
            }
        }
        return achou;
    }
    
    public void setNaipe(int naipe) {
        this.naipe = naipe;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNaipe() {
        return naipe;
    }

    public boolean isStatus() {
        return status;
    }

    public int getValor() {
        return valor;
    }
}
