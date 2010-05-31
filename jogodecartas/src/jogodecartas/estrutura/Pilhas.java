package jogodecartas.estrutura;

import jogodecartas.Baralho;
import jogodecartas.Carta;
import jogodecartas.core.Controller;

/** Classe que define um identificador para cada conjunto de cartas e o modo de jogo que implica na forma como algumas cartas podem ser manipuladas
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel
 * @version 1.0a
 */
public class Pilhas {

    private int gameMode;           // Modo de jogo: 1 para vira uma carta e 3 para vira 3 cartas
    Controller controle = new Controller();

    public void moveEstoqueFileira(Fileira fileiras, int id, Carta carta) {
        if (controle.validaFileiraDestino(carta, id)) {
            fileiras.getFileiras().get(id).push(carta);
        }
    }

    public void moveEstoqueFundacoes(Fundacao fundacoes, int id, Carta carta) {
        if (controle.validaFundacaoDestino(carta, id)) {
            fundacoes.getFundacoes().get(id).push(carta);
        }
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
