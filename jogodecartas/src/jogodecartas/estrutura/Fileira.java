package jogodecartas.estrutura;

import jogodecartas.*;
import java.util.ArrayList;
import java.util.Stack;
import jogodecartas.Carta;
import jogodecartas.core.Controller;

/**
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Fileira extends Pilhas {

    private ArrayList<Stack<Carta>> fileiras;
    Controller controle = new Controller();

    /** Método cria um ArrayList de Pilhas que representam as Fileiras de um jogo de cartas
     *
     * @param int quantidade                            Informe a quantidade de fileiras que deseja criar
     */
    public Fileira(int quantidade) {
        fileiras = new ArrayList<Stack<Carta>>();
        for (int i = 0; i < quantidade; i++) {
            fileiras.add(new Stack<Carta>());
        }
    }

    /** Move um conjunto de cartas entre as fundações
     *
     * @param int origem                    Fundação de origem
     * @param int destino                   Fundação de destino
     * @param int profundidade              Índice da primeira carta do conjunto de cartas da pilha que deseja-se mover
     */
    public void move(int origem, int destino, int profundidade) {
        Stack<Carta> pilha = new Stack<Carta>();        

        if (controle.validaFileiraDestino(fileiras.get(origem).elementAt(origem), destino)) {
            for (int i = 0; i < profundidade; i++) {
                Carta carta = new Carta();
                carta = fileiras.get(origem).pop();
                pilha.push(carta);
            }
        }

    }

    /** Verifica se uma fileira é válida
     *
     * @param origem
     * @param destino
     * @return
     */
    @Deprecated
    private boolean fileiraValida(Carta origem, int destino) {
        if (origem.naipe() == fileiras.get(destino).peek().naipe()) {
            return false;
        } else {
            return true;
        }
    }

    /** Move uma carta entre duas fundações diferentes
     *
     * @param int origem
     * @param int destino
     * @deprecated Criei um método que move mais de uma carta entre as fileiras
     */
    @Deprecated
    public void move(int origem, int destino) {
        Carta carta = fileiras.get(origem).pop();
        fileiras.get(destino).push(carta);
    }

    public ArrayList<Stack<Carta>> getFileiras() {
        return fileiras;
    }

    public void setFileiras(ArrayList<Stack<Carta>> fileiras) {
        this.fileiras = fileiras;
    }
}
