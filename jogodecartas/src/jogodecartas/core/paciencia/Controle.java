package jogodecartas.core.paciencia;

import jogodecartas.estrutura.Estoque;

/** Classe de controle do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class Controle {

    Config config = new Config();
    Estoque estoque = new Estoque();

    /** Classe define o modo de jogo
     *
     * @param int modo                          Valor referente ao modo de jogo estabelecido
     */
    public void modoDeJogo(int modo) {
        estoque.setGameMode(modo);
    }

    public Estoque getEstoque() {
        return estoque;
    }

}
