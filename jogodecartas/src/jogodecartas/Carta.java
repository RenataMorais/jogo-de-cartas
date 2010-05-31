package jogodecartas;

/**
 * 
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel
 * @version 1.0b
 */
public class Carta {

    public enum Valor {

        DOIS, TRES, QUATRO, CINCO, SEIS,
        SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI, AS
    }

    public enum Naipe {

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
        return valor + " of " + naipe;
    }

    /** Alterna o valor do atributo virada de uma carta
     *
     * @param Carta x                       Recebe como atributo um objeto do tipo carta
     */
    public void vira(Carta carta) {
        carta.setVirada();
    }

    /** Retorna 0 para naipes pares e um valor diferente de zero para números ímpares
     *
     * @return int                          Valor correspondente ao Naipe: 0 se naipe par, !=0 se ímpar
     */
    public int naipeColor() {
        return naipe.valor % 2;
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
