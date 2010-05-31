package jogodecartas.core;

import jogodecartas.Carta;
import jogodecartas.core.paciencia.Config;
import jogodecartas.estrutura.Estoque;
import jogodecartas.estrutura.Fileira;
import jogodecartas.estrutura.Fundacao;

/** Classe de controle geral do framework, implementa os métodos principais dos jogos de cartas
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Controller {

    GlobalConfig config = new GlobalConfig();
    Fundacao fundacoes = new Fundacao(config.getFundacoes());
    Fileira fileiras = new Fileira(config.getFundacoes());

    /** Valida uma carta para ser inserida na fundação
     *
     * @param Carta carta                       Carta que será validada
     * @param int destino                       Idenficiador da fundação de destino
     * @return boolean                          (true) se a carta for válida, caso contrário (false)
     */
    public boolean validaFundacaoDestino(Carta carta, int destino) {
        // Verifico se a pilha está cheia e se o naipe da carta corresponde ao naipe da pilha
        if ((fundacoes.getFundacoes().get(destino).size() < 13) &&
                (fundacoes.getFundacoes().get(destino).peek().naipe() == carta.naipe())) {
            return true;
        } else {
            return false;
        }
    }

    /** Verifica se uma fileira é válida
     *
     * @param origem                                Carta do baralho que deseja validar
     * @param destino                               Identificador da fileira de destino
     * @return boolean                              (true) se a carta for válida, caso contrário (false)
     */
    public boolean validaFileiraDestino(Carta origem, int destino) {
        if (origem.naipeColor() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /** Método diz se o usuário completou as funcacoes
     *
     * @return boolean
     */
    public boolean completou() {
        for (int i = 0; i < fundacoes.getFundacoes().size(); i++) {
            if (fundacoes.getFundacoes().get(i).size() == 13) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public Fileira getFileiras() {
        return fileiras;
    }

    public Fundacao getFundacoes() {
        return fundacoes;
    }

}
