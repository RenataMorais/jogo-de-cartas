/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas.estrutura;

/** Classe que define um identificador para cada conjunto de cartas e o modo de jogo que implica na forma como algumas cartas podem ser manipuladas
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel
 * @version 1.0a
 */
public class Pilhas {

    private int id;                 // Rever...
    private int gameMode;           // Modo de jogo: 1 para vira uma carta e 3 para vira 3 cartas

    /** Identificador da Pilha
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param int id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Define qual o modo de jogo
     *
     * @return int                      Valor correspondente ao modo de jogo
     */
    public int getGameMode() {
        return gameMode;
    }

    /** O modo de jogo indica quantas cartas do descarte serão viradas
     *
     * @param int gameMode
     */
    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }
}
