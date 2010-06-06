package jogodecartas.estrutura;

import java.util.ArrayList;

/** 
 * Classe que manipula as fundações do jogo identificando o naipe e preenchendo
 * as estruturas em ordem ascendente
 * 
 * @author João Carlos Nunes Bittencourt
 * @version 2.0a
 */
public class Fundacao extends Pilhas {

    private ArrayList<Pilhas> fundacoes;

    /** 
     * Contrutor da classe, cria um ArrayList de objetos Stack, representando
     * as Fundações.
     *
     * @param quantidade                        quantidade de fundações que devem
     *                                          ser criadas.
     */
    public Fundacao(int quantidade) {
        fundacoes = new ArrayList<Pilhas>();
        for (int i = 0; i < quantidade; i++) {
            fundacoes.add(new Pilhas());
        }
    }

    /** 
     * Retorna se a pilha da fundação está cheia.
     * 
     * @param fundacao                          identificador da fundação que deseja-se verificar;
     * @return boolean                          <code>true</code> se a fundação está cheia;
     *                                          <code>false</code> se incompleta
     */
    public boolean isFull(int fundacao) {
        if (fundacoes.get(fundacao).size() == 13) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Acesso ao conjunto de fundações
     *
     * @return                          vetor contendo as pilhas das fundações.
     */
    public ArrayList<Pilhas> getFundacoes() {
        return fundacoes;
    }
}
