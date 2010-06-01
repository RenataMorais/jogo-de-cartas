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

    private Pilhas estoque = new Pilhas();
    private Pilhas descarte = new Pilhas();

    /** Exibe as cartas presentes no descarte, de acordo com
     *
     */
    public void mostraDescarte() {
        for (int i = 0; i < config.getModoDeJogo(); i++) {
            System.out.print(descarte.elementAt(i));
        }
    }

    public void mostraEstoque() {
        for (int i = 0; i < estoque.size(); i++) {
            System.out.println(estoque.elementAt(i));
        }
    }

    /** Move carta do topo do estoque para o descarte
     *  
     */
    public void moveToDescarte() {
        // viro as cartas que já estão no descarte ( Papel da Interface )
        for (int j = 0; j < descarte.size(); j++) {
            descarte.elementAt(j).setVirada();
        }
        // movo cartas do estoque para o descarte
        for (int i = 0; i < config.getModoDeJogo(); i++) {
            Carta carta = this.estoque.pop();               // removo a carta do estoque
            carta.setVirada();                              // viro a carta
            descarte.push(carta);                           // adiciono carta virada no descarte
        }
    }

    public void viraUltimaCartaDescarte() {
        if (config.getModoDeJogo() == 1) {
            descarte.peek().setVirada();
        } else {
            // vira a última carta da base conforme a quantidade de cartas que podem estar viradas
            descarte.elementAt(descarte.size() - (config.getModoDeJogo() - 1)).setVirada();
        }
    }

    /** Remove uma carta do topo da pilha
     * 
     * @return Carta                    Carta do topo do estoque.
     */
    public Carta removeFromEstoque() {
        return estoque.pop();
    }

    /** Adiciona uma carta à pilha de descarte
     *
     * @param Carta carta               Carta que será adicionada à Pilha de Descarte
     */
    public void addToDescarte(Carta carta) {
        descarte.push(carta);
    }

    /** Restaura a Pilha de Estoque
     *
     * @return boolean                  Informa se os dados foram inseridos na nova pilha
     */
    public boolean restauraEstoque() {
        inverteEstoque();
        return estoque.addAll(descarte);
    }

    /** Inverte a pilha de descarte para restaurar a ordem correta
     *
     */
    public void inverteEstoque() {
        Stack<Carta> aux = new Stack<Carta>();

        for (int i = 0; i < descarte.size(); i++) {
            Carta carta = descarte.pop();
            aux.push(carta);
        }
        descarte.addAll(aux);
    }

    public Pilhas getDescarte() {
        return descarte;
    }

    public void setDescarte(Pilhas descarte) {
        this.descarte = descarte;
    }

    public Pilhas getEstoque() {
        return estoque;
    }

    public void setEstoque(Pilhas estoque) {
        this.estoque = estoque;
    }
}
