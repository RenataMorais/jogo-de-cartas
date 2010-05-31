package jogodecartas.estrutura;

import java.util.ArrayList;
import java.util.Stack;
import jogodecartas.Carta;

/** Classe que manipula as fundações do jogo identificando o naipe e preenchendo as estruturas em ordem ascendente
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Fundacao extends Pilhas {

    private ArrayList<Stack<Carta>> fundacoes;
    private int naipe;
    private boolean cheia; // (true) cheia (false) vazia

    /** Contrutor da classe, cria um ArrayList de objetos Stack, representando as Fundações
     *
     * @param quantidade
     */
    public Fundacao(int quantidade) {
        fundacoes = new ArrayList<Stack<Carta>>();
        for (int i = 0; i < quantidade; i++) {
            fundacoes.add(new Stack<Carta>());
        }
    }

    /** Aciciona uma carta na fundação
     *
     * @param Carta carta                       Carta a ser inserida
     * @param int destino                       Identificador da fundação de destino
     * @return boolean                          (true) se a carta for inserida na fundação, caso contrário (false)
     */
    public void add(Carta carta, int destino) {
        if (controle.validaFundacaoDestino(carta, destino)) {
            fundacoes.get(destino).push(carta);
        }
    }

    /** Retorna se a pilha da fundação está cheia
     *
     * @param int fundacao                      Identificador da fundação que deseja-se verificar
     * @return boolean                          (true) se cheia e (false) se incompleta
     */
    public boolean isFull(int fundacao) {
        if (fundacoes.get(fundacao).size() == 13) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @return ArrayList<Stack<Carta>>
     */
    public ArrayList<Stack<Carta>> getFundacoes() {
        return fundacoes;
    }

    /**
     *
     * @param ArrayList<Stack<Carta>> fundações
     */
    public void setFundacoes(ArrayList<Stack<Carta>> fundacoes) {
        this.fundacoes = fundacoes;
    }

    /**
     *
     * @return int
     */
    public int getNaipe() {
        return naipe;
    }

    /**
     *
     * @param int naipe
     */
    public void setNaipe(int naipe) {
        this.naipe = naipe;
    }

    /** Retorna se a pilha está completa (true) ou incompleta (false)
     *
     * @return boolean
     */
    public boolean isCheia() {
        return cheia;
    }

    /** Define se uma pilha de fundações está completa
     *
     * @param boolena cheia
     */
    public void setCheia(boolean cheia) {
        this.cheia = cheia;
    }
}
