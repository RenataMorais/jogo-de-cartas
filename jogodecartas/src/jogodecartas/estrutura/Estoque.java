package jogodecartas.estrutura;

import java.util.Stack;
import jogodecartas.Carta;

/**
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel
 * @version 1.0a
 */
public class Estoque extends Pilhas {

    private Stack<Carta> estoque = new Stack<Carta>();
    private Stack<Carta> descarte = new Stack<Carta>();

    /** Move carta do topo do estoque para o descarte
     *  
     */
    public void move() {
        for (int i = 0; i < getGameMode(); i++) {
            Carta carta = this.estoque.pop();           // removo a carta do estoque
            carta.setVirada();                          // viro a carta
            descarte.push(carta);
        }
    }

    /** Remove uma carta do topo da pilha
     * 
     * @return Carta                    Carta do topo do estoque.
     */
    public Carta remove() {
        return estoque.pop();
    }

    /** Adiciona uma carta à pilha de descarte
     *
     * @param Carta carta               Carta que será adicionada à Pilha de Descarte
     */
    public void add(Carta carta) {
        descarte.push(carta);
    }

    /** Restaura a Pilha de Estoque
     *
     * @return boolean                  Informa se os dados foram inseridos na nova pilha
     */
    public boolean restaura() {
        inverte();
        return estoque.addAll(descarte);
    }

    /** Inverte a pilha de descarte para restaurar a ordem correta
     *
     */
    public void inverte() {
        Stack<Carta> aux = new Stack<Carta>();

        for (int i = 0; i < descarte.size(); i++) {
            Carta carta = descarte.pop();
            aux.push(carta);
        }
        descarte.addAll(aux);
    }

    public Stack<Carta> getDescarte() {
        return descarte;
    }

    public void setDescarte(Stack<Carta> descarte) {
        this.descarte = descarte;
    }

    public Stack<Carta> getEstoque() {
        return estoque;
    }

    public void setEstoque(Stack<Carta> estoque) {
        this.estoque = estoque;
    }
}
