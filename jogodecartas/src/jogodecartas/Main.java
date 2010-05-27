/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jogodecartas;

import java.util.ArrayList;
import jogodecartas.core.paciencia.Config;
import jogodecartas.Baralho;

/**
 *
 * @author joaocarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        baralho.cria();
        baralho.embaralha();
        baralho.mostra();
     
    }

}
