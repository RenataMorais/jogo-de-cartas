package paciencia;

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
        n = (int) (Math.random() * 5);
        novaCarta.setNaipe(n);
        v = (int) (Math.random() * 14);
        novaCarta.setValor(v);

        return novaCarta;
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
