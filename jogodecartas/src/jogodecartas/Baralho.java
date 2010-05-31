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

    private static final List<Carta> baralho = new ArrayList<Carta>();

    // Inicializa o conjunto do baralho
    static {
        for (Naipe naipe : Naipe.values()) {
            for (Valor valor : Valor.values()) {
                baralho.add(new Carta(valor, naipe) {
                });
            }
        }
    }

    /** Contrutor do baralho
     *
     * @return ArrayList<Carta>                             Cópia do baralho
     */
    public static ArrayList<Carta> novoBaralho() {
        return new ArrayList<Carta>(baralho);
    }

    /** Método embaralha o baralho
     *
     */
    public static void embaralha() {
        Collections.shuffle(baralho);
    }

    /** Exibe todas as baralho do baralho
     *
     */
    public static void mostra() {
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
}
