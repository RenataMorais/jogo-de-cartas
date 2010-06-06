package jogodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jogodecartas.Carta.Naipe;
import jogodecartas.Carta.Valor;

/**
 * Um baralho em um jogo de cartas é um conjunto de diferentes cartas. O mesmo é
 * formado por 52 cartas, divididas em quatro naipes distintos, cada um composto
 * por treze cartas. Esta classe implementa um baralho a partir da classe Carta.
 * A estrutura gerada retorna um ArrayList de Cartas.
 *
 * @author João Carlos Nunes Bittencourt
 * @version 2.0a
 */
public class Baralho {

    private final List<Carta> baralho = new ArrayList<Carta>(); 

    /**
     * Produz um conjunto de Cartas de acordo com os valores definidos na classe geradora de Cartas
     */
    public Baralho(){
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                baralho.add(new Carta(valor, naipe) {
                });
            }
        }
    }

    /** 
     * Cria um novo baralho
     *
     * @return um vetor composto por cartas do baralho
     */
    public ArrayList<Carta> novoBaralho() {
        return new ArrayList<Carta>(baralho);
    }

    /** 
     * Embaralha o baralho de forma aleatória
     */
    public void embaralha() {
        Collections.shuffle(baralho);
    }

    /**
     * Remove uma carta do baralho
     *
     * @param indice                        a posição no vetor onde se encontra a carta que deseja-se retirar
     * @return                              a carta localizada na posição índice do vetor
     */
    public Carta removeCarta(int indice){
        return baralho.remove(indice);
    }

    /** 
     * Exibe todas as baralho do baralho
     */
    public void mostraBaralho() { 
        for (int i = 0; i < baralho.size(); i++) {
            System.out.println(baralho.get(i).valor() + " de " + baralho.get(i).naipe() + ": " + baralho.get(i).isVirada());
        }
    }

    /** 
     * Verifica se a carta existe no baralho
     *
     * @param carta                     a carta que deseja-se buscar dentro do baralho
     * @return                          <code>true</code> se a carta está no baralho
     *                                  <code>false</code> caso contrário.
     */
    public boolean contem(Carta carta) {
        boolean achou = false;

        for (int j = 0; j < baralho.size() - 1; j++) {
            if ((baralho.get(j).naipe() == carta.naipe()) && (baralho.get(j).valor() == carta.valor())) {
                achou = true;
                break;
            } else {
                achou = false;
            }
        }
        return achou;
    }

    /**
     * Acesso direto ao baralho
     * 
     * @return                          lista de cartas contidas no baralho
     */
    public List<Carta> getBaralho() {
        return baralho;
    }
}
