/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogodecartas;

import java.util.List;


/**
 *
 * @author joaocarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Carta> baralho = Baralho.novoBaralho();

        //Baralho.embaralha();
        Baralho.mostra();
     
    }

}
