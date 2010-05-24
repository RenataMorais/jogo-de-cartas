package paciencia;

import java.util.Stack;

/**
 * @version 1.0b
 * @see Disciplina Padrões e Frameworks
 * @author João Carlos Nunes Bittencourt
 */
public class Baralho {

    /**
     *
     */
    public Stack produzBaralho() {
        Stack<Carta> baralho = new Stack<Carta>();
        Carta carta = new Carta();
        int i = 0;

        while (i < 53) {
            carta = carta.geraCarta();
            for (int j = 0; j < baralho.size(); j++) {
                while ((baralho.elementAt(j).getNaipe() == carta.getNaipe()) && (baralho.elementAt(j).getValor() == carta.getValor())) {
                    carta = carta.geraCarta();
                }
            }
            baralho.push(carta);
            i++;
        }
        return baralho;
    }
}
