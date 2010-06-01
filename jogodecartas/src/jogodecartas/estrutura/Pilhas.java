package jogodecartas.estrutura;

import java.util.ArrayList;
import java.util.Stack;
import jogodecartas.Carta;
import jogodecartas.core.GlobalConfig;
import jogodecartas.core.RegrasGlobais;

/** Classe que define um identificador para cada conjunto de cartas e o modo de jogo que implica na forma como algumas cartas podem ser manipuladas
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Pilhas extends Stack<Carta> {

    private boolean cheia;
    RegrasGlobais controle;
    GlobalConfig config;


    /** Retorna se a fileira está vazia ou não
     *
     * @param int destino                   Identificador da fileira de origem
     * @return boolean                      (true) fileira está vazia. (false) fileira não está vazia
     */
    public boolean isEmpty(int destino) {
        return this.isEmpty();
    }

    public boolean isFull() {
        return cheia;
    }

    public void setCheia(boolean cheia) {
        this.cheia = cheia;
    }

    public int posicao(int pilha, int profundidade){
        return this.size() - profundidade;
    }

    
}
