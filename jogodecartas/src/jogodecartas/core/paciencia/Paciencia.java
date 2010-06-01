/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas.core.paciencia;

import jogodecartas.Baralho;

/** Classe principal do jogo
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class Paciencia {
    Controle controle = new Controle();
    Baralho baralho = new Baralho();
    Config config = new Config();

    public void start() {
        System.out.println("Começou o jogo! \n");
        baralho.novoBaralho();
        baralho.embaralha();
        //baralho.mostraBaralho();
        controle.distribuiCartas(baralho);
        System.out.println("Fileiras:");
        for (int i = 0; i < config.getFileiras(); i++) {
            controle.getFilas().mostraFileira(i);
            System.out.println("");
        }
        baralho.mostraBaralho(); // baralho está vazio
        System.out.println("\nCartas do Estoque:");
        controle.estoque.mostraEstoque();

    }
}
