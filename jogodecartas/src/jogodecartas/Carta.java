package jogodecartas;

/**
 * 
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0b
 */
public class Carta {

    public enum Valor {

        DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6),
        SETE(7), OITO(8), NOVE(9), DEZ(10), VALETE(11), DAMA(12), REI(13), AS(1);
        private final int peso;

        Valor(int valor) {
            this.peso = valor;
        }
    }

    public enum Naipe {
        // Naipes par: vermelho; Naipes impares: preto;

        OUROS(1), PAUS(2), ESPADAS(3), COPAS(4);
        private final int valor;

        Naipe(int valor) {
            this.valor = valor;
        }
    }
    private final Valor valor;
    private final Naipe naipe;
    private boolean virada;

    public Carta(Valor valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public Valor valor() {
        return valor;
    }

    public Naipe naipe() {
        return naipe;
    }

    @Override
    public String toString() {
        //return "[" + valor + " de " + naipe + "]";
        return "[" + valor.peso + " de " + naipe + "]";
    }

    /** Alterna o peso do atributo virada de uma carta
     *
     * @param Carta x                       Recebe como atributo um objeto do tipo carta
     */
    public void vira(Carta carta) {
        carta.setVirada();
    }

    /** Retorna 0 para naipes pares e um peso diferente de zero para números ímpares
     *
     * @return int                          Valor correspondente ao Naipe: 0 se naipe par, !=0 se ímpar
     */
    public int naipeColor() {
        return naipe.valor % 2;
    }

    public int cartaValor() {
        return valor.peso;
    }

    /**
     *
     * @return booleand virada              Retorna se a carta está virada ou não
     */
    public boolean isVirada() {
        return virada;
    }

    /**
     *
     * @param boolean virada
     */
    public void setVirada() {
        this.virada = !virada;
    }
}
