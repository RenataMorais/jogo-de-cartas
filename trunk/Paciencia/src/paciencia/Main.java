/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paciencia;

import java.util.Stack;

/**
 *
 * @author joaocarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Baralho b1 = new Baralho();
        Stack<Carta> pilha = new Stack<Carta>();
        Carta c1 = new Carta();
        int i = 0;

        /*rdm = random.geraRandom(14, 13);
        while(i <= 12) {
        System.out.println(rdm[i]);
        i++;
        }*/
        //c1 = c1.geraCarta();
        //System.out.println(c1.getValor());
        pilha = b1.produzBaralho();
        while (i <= pilha.size()-1) {
            c1 = pilha.pop();
            System.out.println(c1.getNaipe()+ ", " +c1.getValor());
        }
    }
}
