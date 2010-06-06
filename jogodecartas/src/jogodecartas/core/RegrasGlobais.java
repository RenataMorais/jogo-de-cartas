package jogodecartas.core;

import jogodecartas.Carta;
import jogodecartas.estrutura.Pilhas;

/**
 * As regras globais compreendem um conjunto de limitações impostas pelos jogos
 * de cartas semelhantes ao paciência. Esta classe implementa os métodos que
 * validam a movimentação das c1 no tabuleiro.
 *
 * @author João Carlos Nunes Bittencourt
 * @version 2.0a
 */
public class RegrasGlobais extends ControladorGlobal {

    /** 
     * Determina se uma fundação pode receber uma nova c1.
     * Especificações:
     * <ul>
     * <li>Se uma fundação está vazia ela só pode receber um AS;</li>
     * <li>A fundação não pode ter atingido o seu tamanho limite;</li>
     * <li>O naipe da nova c1 e da fundação destino devem ser iguais;</li>
     * <li>A nova c1 deve ser sequência da c1 no topo da fundação;</li>
     * </ul>
     *
     * @param c1             c1 que será validada.
     * @param destino           idenficiador da fundação de destino.
     * @return                  <code>true</code> se a c1 é válida na fundação
     *                          <code>false</code> caso contrário.
     */
    public boolean validaFundacaoDestino(Carta origem, Pilhas fundacao) {
        GlobalConfig config = new GlobalConfig();
        // Verifico se a fundação está vazia e libero apenas se a nova c1 for um AS
        if (fundacao.isEmpty()) {
            return origem.valor().equals(Carta.Valor.AS);
        } else {
            // Verifico se a pilha está cheia e se o naipe da c1 corresponde ao naipe da pilha e se a c1 é sequência
            if (fundacao.size() < config.getCartasPorNaipe() &&
                    naipeIgual(origem, fundacao.peek()) && cartaIsSequencia(origem, fundacao.peek())) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** 
     * Determina se uma fileira é válida para receber uma nova c1 específica.
     * Especificações:
     * <ul>
     * <li>Se uma fileira está vazia ela só pode receber um REI;</li>
     * <li>O naipe da nova c1 e da fileira destino devem ser diferentes;</li>
     * <li>A o valor da nova c1 deve anteceder a c1 no topo da fundação;</li>
     * </ul>
     * 
     * @param origem                                Carta do baralho que deseja validar.
     * @param destino                               Identificador da fileira de destino.
     * @return                                      <code>true</code> se a c1 for válida;
     *                                              <code>false</code> caso contrário.
     */
    public boolean validaFileiraDestino(Carta carta, Pilhas fileira) {
        // Se a fileira estiver vazia verifico se a c1 de origem é um REI
        if (fileira.isEmpty()) {
            return carta.valor().equals(Carta.Valor.REI);
        } else {
            if (!naipeCorIgual(carta, fileira.peek()) && cartaIsAntecedente(carta, fileira.peek())) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Determina de duas cartas possuem naipes iguais
     * 
     * @param c1
     * @param c2
     * @return
     */
    public boolean naipeIgual(Carta c1, Carta c2) {
        if (c1.naipe() == c2.naipe()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Determina se as core dos naipes de duas cartas são iguais.
     *
     * @param c1                     primeira carta que deseja validar
     * @param c2                     segunda carta que deseja validar
     * @return                       <code>true</code> se as cartas possuem
     *                               naipes de cores iguais;
     *                               <code>false</code> caso contrário.
     */
    public boolean naipeCorIgual(Carta c1, Carta c2) {
        /* naipes pretos possuem valor ímpar, logo retornam 1, enquanto naipes
           vermelhos possuem valor par e logo retornam 0 */
        if (c1.naipeColor() % 2 == c2.naipeColor() % 2) {
            return true;
        } else {
            return false;
        }
    }

    /** 
     * Verifica se a carta origem é sequencia da carta que deseja-se validar:
     * destino = novaCarta - 1.
     * Este método é utilizado para validar cartas que são inseridas
     * em uma fundação.
     *
     * @param c1                     nova carta do baralho que deseja validar
     * @param c2                     carta utilizada como referência para validar
     * @return                       <code>true</code> se a nova carta é sequencia
     *                               <code>false</code> caso contrário.
     */
    public boolean cartaIsSequencia(Carta c1, Carta c2) {
        if (c2.cartaValor() == (c1.cartaValor() - 1)) {
            return true;
        } else {
            return false;
        }
    }

    /** 
     * Verifica se o valor da carta c2 antecede a carta c1 da pilha de destino.
     * Método utilizado para validar cartas que são inseridas em uma fileira.
     *
     * @param c1                     nova carta do baralho que deseja validar
     * @param c2                     carta utilizada como referência para validar
     * @return                       <code>true</code> se o valor da nova carta
     *                               antecede a carta de referência;
     *                               <code>false</code> caso contrário.
     */
    public boolean cartaIsAntecedente(Carta c1, Carta c2) {
        if (c2.cartaValor() == (c1.cartaValor() + 1)) {
            return true;
        } else {
            return false;
        }
    }
}
