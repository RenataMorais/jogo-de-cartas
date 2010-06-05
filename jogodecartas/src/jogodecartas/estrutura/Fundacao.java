package jogodecartas.estrutura;

import java.util.ArrayList;
import jogodecartas.Carta;

/** Classe que manipula as fundações do jogo identificando o naipe e preenchendo as estruturas em ordem ascendente
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
// Inplementar Mover da fundação para fileira
public class Fundacao extends Pilhas {

    private ArrayList<Pilhas> fundacoes;

    /** Contrutor da classe, cria um ArrayList de objetos Stack, representando as Fundações
     *
     * @param quantidade
     */
    public Fundacao(int quantidade) {
        fundacoes = new ArrayList<Pilhas>();
        for (int i = 0; i < quantidade; i++) {
            fundacoes.add(new Pilhas());
        }
    }

//    /** Aciciona uma carta na fundação
//     *
//     * @param Carta carta                       Carta a ser inserida
//     * @param int destino                       Identificador da fundação de destino
//     * @return boolean                          (true) se a carta for inserida na fundação, caso contrário (false)
//     */
//    public void add(Carta carta, int destino) {
//        //if (controle.validaFundacaoDestino(carta, destino, this.fundacoes)) {
//            fundacoes.get(destino).push(carta);
//        //}
//        if(fundacoes.get(destino).size() < config.getCartasPorNaipe()) {
//            fundacoes.get(destino).setCheia(true);
//        }
//    }

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
    public ArrayList<Pilhas> getFundacoes() {
        return fundacoes;
    }

    /**
     *
     * @param ArrayList<Stack<Carta>> fundações
     */
    public void setFundacoes(ArrayList<Pilhas> fundacoes) {
        this.fundacoes = fundacoes;
    }
}
