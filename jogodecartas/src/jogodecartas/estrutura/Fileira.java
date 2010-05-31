package jogodecartas.estrutura;

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

        if (controle.validaFileiraDestino(fileiras.get(origem).elementAt(fileiras.get(origem).size()-profundidade), destino)) {
            for (int i = 0; i < profundidade; i++) {
                pilha.push(fileiras.get(origem).pop());
            }
            fileiras.get(destino).addAll(pilha);
        }
    }

    public ArrayList<Stack<Carta>> getFileiras() {
        return fileiras;
    }

    public void setFileiras(ArrayList<Stack<Carta>> fileiras) {
        this.fileiras = fileiras;
    }
}
