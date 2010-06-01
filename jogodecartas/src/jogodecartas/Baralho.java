package jogodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jogodecartas.Carta.Naipe;
import jogodecartas.Carta.Valor;

/**
 * 
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0b
 */
public class Baralho {

    private final List<Carta> baralho = new ArrayList<Carta>(); // Verificar o atributo estático. Se ele gera mais de um baralho

    // Inicializa o conjunto do baralho
    public Baralho(){
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                baralho.add(new Carta(valor, naipe) {
                });
            }
        }
    }
//    static {
//        for (Naipe naipe : Naipe.values()) {
//            for (Valor valor : Valor.values()) {
//                baralho.add(new Carta(valor, naipe) {
//                });
//            }
//        }
//    }

    /** Contrutor do baralho
     *
     * @return ArrayList<Carta>                             Cópia do baralho
     */
    public ArrayList<Carta> novoBaralho() {
        return new ArrayList<Carta>(baralho);
    }

    /** Método embaralha o baralho
     *
     */
    public void embaralha() {
        Collections.shuffle(baralho);
    }

    public Carta removeCarta(int indice){
        return baralho.remove(indice);
    }

    /** Exibe todas as baralho do baralho
     *
     */
    public void mostraBaralho() { // mudar para toString()
        for (int i = 0; i < baralho.size(); i++) {
            System.out.println(baralho.get(i).valor() + " de " + baralho.get(i).naipe() + ": " + baralho.get(i).isVirada());
        }
    }

    /** Verifica se a carta existe no baralho
     *
     * @param Carta carta
     * @return boolean
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

    public List<Carta> getBaralho() {
        return baralho;
    }
}
