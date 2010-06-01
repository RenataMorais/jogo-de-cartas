/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogodecartas;

import jogodecartas.core.paciencia.Paciencia;

/**
 *
 * @author joaocarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //List<Carta> baralho = Baralho.novoBaralho();
        //Fileira estoque = new Fileira(2);
        //Controle controle = new Controle();
        //Config config = new Config();
        //Baralho.embaralha();
        //Baralho.mostra();
        //config.setConfigs();
        //estoque.getFileiras().get(1).addAll(baralho);
        //System.out.println(estoque.getFileiras().get(1).size());
        //controle.estoque.getEstoque().addAll(baralho);
        //controle.moveEstoqueFileira(controle.estoque.getEstoque(), 0);

        //System.out.println(controle.getFileiras().get(1).peek());

        Paciencia paciencia = new Paciencia();

        paciencia.start();
     
    }

}
