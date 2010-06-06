package jogodecartas.estrutura;

import java.util.Stack;
import jogodecartas.Carta;
import jogodecartas.core.GlobalConfig;
import jogodecartas.core.RegrasGlobais;

/** 
 * Classe que define um identificador para cada conjunto de cartas e o modo de
 * jogo que implica na forma como algumas cartas podem ser manipuladas.
 * Representa a classe pai das estruturas do jogo, onde são implementados
 * métodos comuns às diferentes estruturas.
 *
 * @author João Carlos Nunes Bittencourt
 * @version 2.0a
 */
public class Pilhas extends Stack<Carta> {

    RegrasGlobais controle;
    GlobalConfig config;

    public int posicao(int pilha, int profundidade){
        return this.size() - profundidade;
    }

    
}
