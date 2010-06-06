package jogodecartas;

/**
 * Uma carta é o elemento básico de um jogo de cartas. Essa classe implementa
 * as cartas de um jogo definindo naipes e valores a partir das definições
 * originais do jogo.
 *
 * @author João Carlos Nunes Bittencourt
 * @version 2.0b
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
     * @param carta                        Recebe como atributo um objeto do tipo carta
     */
    public void vira(Carta carta) {
        carta.setVirada();
    }

    /** Retorna 0 para naipes pares e um peso diferente de zero para números ímpares
     *
     * @return int                          Valor correspondente ao Naipe: 0 se naipe vermelho, 1 se preto
     */
    public int naipeColor() {
        return naipe.valor % 2;
    }

    /**
     * Identifica o valor correspondente de uma carta qualquer.
     *
     * @return               valor da carta
     */
    public int cartaValor() {
        return valor.peso;
    }

    /**
     * Retorna se uma carta está virada ou não
     *
     * @return               <code>true</code>a  carta está virada
     *                       <code>false</code> caso contrário
     */
    public boolean isVirada() {
        return virada;
    }

    /**
     * Vira uma carta
     */
    public void setVirada() {
        this.virada = !virada;
    }
}
