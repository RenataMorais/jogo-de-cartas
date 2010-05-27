/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas;

import java.util.ArrayList;
import java.util.Collections;
import jogodecartas.core.paciencia.Controle;

/**
 * 
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0b
 */
public class Baralho {
    private ArrayList<Carta> baralho;

    /** Cria as cartas do baralho de acordo com o jogo escolhido
     *
     */
    public void cria(){
        Controle paciencia = new Controle();
        
        baralho = paciencia.criaBaralho();
    }
    /** Método embaralha o baralho
     *
     */
    public void embaralha() {
        Collections.shuffle(baralho);
    }
    /** Exibe todas as cartas do baralho
     *
     */
    public void mostra() {
        for (int i = 0; i < baralho.size(); i++) {
            System.out.println(baralho.get(i).getNaipe() + ", " + baralho.get(i).getValor() + ", " + baralho.get(i).isVirada());
        }
    }
    /**
     *
     * @param Carta carta
     * @return boolean
     */
    public boolean contem(Carta carta){
        boolean achou = false;

        for (int j = 0; j < baralho.size() - 1; j++) {
            if ((baralho.get(j).getNaipe() == carta.getNaipe()) && (baralho.get(j).getValor() == carta.getValor())) {
                achou = true;
                break;
            } else {
                achou = false;
            }
        }
        return achou;
    }
    /**
     *
     * @return ArrayList<Carta> baralho
     */
    public ArrayList<Carta> getBaralho() {
        return baralho;
    }
    /**
     *
     * @param ArrayList<Carta> baralho
     */
    public void setBaralho(ArrayList<Carta> baralho) {
        this.baralho = baralho;
    }
}
