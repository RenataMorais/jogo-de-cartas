package jogodecartas.core;

import jogodecartas.Carta;

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
    public boolean validaFundacaoDestino(Carta origem, int destino) {
        // Verifico se a fundação está vazia e libero apenas se a nova carta for um AS
        if (getFundacoes().getFundacoes().get(destino).isEmpty()) {
            return origem.valor().equals(Carta.Valor.AS);
        } else {
            // Verifico se a pilha está cheia e se o naipe da carta corresponde ao naipe da pilha e se a carta é sequência
            if (getFundacoes().getFundacoes().get(destino).size() < getConfig().getCartasPorNaipe() &&
                    !naipeIsDiferente(origem, destino, "fundacoes") && cartaIsSequencia(origem, destino, "fundacoes")) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** Verifica se uma fileira é válida
     *
     * @param origem                                Carta do baralho que deseja validar
     * @param destino                               Identificador da fileira de destino
     * @return boolean                              (true) se a carta for válida, caso contrário (false)
     * @see                                         naipeIsDiferente(); cartaIsSequencia(); fileiraIsEmpty();
     */
    public boolean validaFileiraDestino(Carta carta, int destino) {
        // Se a fileira estiver vazia verifico se a carta de origem é um REI
        if (getFilas().getFileiras().get(destino).isEmpty()) {
            return carta.valor().equals(Carta.Valor.REI);
        } else {
            if (naipeIsDiferente(carta, destino, "fileiras") && cartaIsSequencia(carta, destino, "fileiras")) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** Verifica se o naipe de uma carta é diferente do naipe do topo da Fileira de destino
     *
     * @param origem                                Carta do baralho que deseja validar
     * @param destino                               Identificador da fileira de destino
     * @return boolean                              (true) se a carta for válida, caso contrário (false)
     */
    public boolean naipeIsDiferente(Carta carta, int destino, String estrutura) {
        if (estrutura.equalsIgnoreCase("fileiras")) {
            if (carta.naipe() != getFilas().getFileiras().get(destino).peek().naipe()) {
                return true;
            } else {
                return false;
            }
        } else if (estrutura.equalsIgnoreCase("fundacoes")) {
            if (carta.naipe() != getFundacoes().getFundacoes().get(destino).peek().naipe()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /** Verifica se a carta forma uma sequencia com as cartas da fileira de destino
     *
     * @param origem                                Carta do baralho que deseja validar
     * @param destino                               Identificador da fileira de destino
     * @return boolean                              (true) se a carta for válida, caso contrário (false)
     */
    public boolean cartaIsSequencia(Carta carta, int destino, String estrutura) {
        if (estrutura.equalsIgnoreCase("fileiras")) {
            if (getFilas().getFileiras().get(destino).peek().cartaValor() == (carta.cartaValor() + 1)) {
                return true;
            } else {
                return false;
            }
        } else if (estrutura.equalsIgnoreCase("fundacoes")) {
            if (getFundacoes().getFundacoes().get(destino).peek().cartaValor() == (carta.cartaValor() + 1)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
