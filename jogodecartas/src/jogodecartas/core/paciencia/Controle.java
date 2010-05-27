package jogodecartas.core.paciencia;

import java.util.ArrayList;
import jogodecartas.Carta;

/** Classe de controle do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class Controle {

    Config config = new Config();

    /** Cria as cartas do Baralho
     *
     * @return ArrayList<Carta> baralho                     Retorna uma coleção com as cartas do baralho
     */
    public ArrayList<Carta> criaBaralho() {
        ArrayList<Carta> baralho = new ArrayList<Carta>();

        for (int k = 0; k < config.getBaralhos(); k++) {
            for (int i = 1; i <= config.getNaipes(); i++) {
                for (int j = 1; j <= config.getCartas_naipes(); j++) {
                    Carta carta = new Carta();
                    carta.setNaipe(i);
                    carta.setValor(j);
                    carta.setVirada(false);
                    baralho.add(carta);
                }
            }
        }
        return baralho;
    }

}
