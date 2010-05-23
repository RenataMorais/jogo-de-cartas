package paciencia;

import java.util.Stack;

/**
 * @projeto Jogo de Cartas
 * @disciplina Padrões e Frameworks
 * @autor João Carlos Nunes Bittencourt
 */
public class Baralho {

    public Stack produzBaralho() {
        Stack<Carta> pilha = new Stack<Carta>();
        Carta carta = new Carta();
        int i = 0;

        while (i <= 52) {
            carta = carta.geraCarta();
            if (carta.getNaipe() != 0 && carta.getValor() != 0) {
                if (pilha.contains(carta) == false) {
                    pilha.push(carta);
                    i++;
                }
            }
//        System.out.println("Saí!");
//        for(i = 0; i == pilha.size(); i++){
//            carta = pilha.pop();
//            System.out.println(carta.getValor());
        }
        return pilha;
    }
}
