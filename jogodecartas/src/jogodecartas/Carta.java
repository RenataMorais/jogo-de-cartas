/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogodecartas;

/**
 * 
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel
 * @version 1.0b
 */
public class Carta {
    private int valor;
    private int naipe;
    private boolean virada; // Virada ou não

    /** Alterna o valor do atributo virada de uma carta
     *
     * @param Carta x       Recebe como atributo um objeto do tipo carta
     */
    public void vira(Carta carta) {
        if (carta.isVirada() == false) {
            carta.setVirada(true);
        } else {
            carta.setVirada(false);
        }
    }
    /** Retorna 0 para naipes pares e um valor diferente de zero para números ímpares
     *
     * @param Carta carta
     * @return int                          Valor correspondente ao Naipe: 0 se naipe par, !=0 se
     */
    public int naipe() {
        return naipe % 2;
    }
    /**
    *
    * @return int naipe
    */
    public int getNaipe() {
        return naipe;
    }
    /**
     *
     * @param int naipe
     */
    public void setNaipe(int naipe) {
        this.naipe = naipe;
    }
    /**
     *
     * @return int valor
     */
    public int getValor() {
        return valor;
    }
    /**
     *
     * @param int valor                     Recebe um valor inteiro correspondente ao índice da carta
     */
    public void setValor(int valor) {
        this.valor = valor;
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
    public void setVirada(boolean virada) {
        this.virada = virada;
    }

}
