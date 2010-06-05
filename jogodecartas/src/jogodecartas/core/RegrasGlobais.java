package jogodecartas.core;

import jogodecartas.Carta;
import jogodecartas.estrutura.Pilhas;

/**
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class RegrasGlobais extends ControladorGlobal {

    /** Valida uma carta para ser inserida na fundação
     *
     * @param Carta carta                       Carta que será validada
     * @param int destino                       Idenficiador da fundação de destino
     * @return boolean                          (true) se a carta for válida, caso contrário (false)
     */
    public boolean validaFundacaoDestino(Carta origem, Pilhas fundacao) {
        // Verifico se a fundação está vazia e libero apenas se a nova carta for um AS
        if (fundacao.isEmpty()) {
            return origem.valor().equals(Carta.Valor.AS);
        } else {
            // Verifico se a pilha está cheia e se o naipe da carta corresponde ao naipe da pilha e se a carta é sequência
            if (fundacao.size() < getConfig().getCartasPorNaipe() &&
                    naipeIgual(origem, fundacao) && cartaIsSequencia(origem, fundacao)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** Verifica se uma fileira é válida
     *
     * @param origem                                Carta do baralho que deseja validar.
     * @param destino                               Identificador da fileira de destino.
     * @return                                      <code>true</code> se a carta for válida;
     *                                              <code>false</code> caso contrário.
     * @see                                         naipeDiferenteNaFileira(); cartaIsSequencia(); fileiraIsEmpty();
     */
    public boolean validaFileiraDestino(Carta carta, Pilhas fileira) {
        // Se a fileira estiver vazia verifico se a carta de origem é um REI
        if (fileira.isEmpty()) {
            return carta.valor().equals(Carta.Valor.REI);
        } else {
            if (naipeDiferente(carta, fileira) && cartaIsSequencia(carta, fileira)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** Verifica se o naipe de uma carta é diferente do naipe do topo da estrutura destino
     *
     * @param origem                                Carta do baralho que deseja validar
     * @param destino                               Identificador da fileira de destino
     * @return                                      <code>true</code> se a carta for válida;
     *                                              <code>false</code> caso contrário.
     */
    public boolean naipeDiferente(Carta carta, Pilhas pilha) {
        if (carta.naipe() != pilha.peek().naipe()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean naipeIgual(Carta carta, Pilhas pilha) {
        if (carta.naipe() == pilha.peek().naipe()) {
            return true;
        } else {
            return false;
        }
    }

    /** Verifica se a carta forma uma sequencia com as cartas da pilha de destino
     *
     * @param origem                                Carta do baralho que deseja validar
     * @param destino                               Identificador da fileira de destino
     * @return boolean                              (true) se a carta for válida, caso contrário (false)
     */
    public boolean cartaIsSequencia(Carta carta, Pilhas pilha) {
        if (pilha.peek().cartaValor() == (carta.cartaValor() + 1)) {
            return true;
        } else {
            return false;
        }
    }
}
