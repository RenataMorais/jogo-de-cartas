package jogodecartas.core.paciencia;

import jogodecartas.Baralho;

/** Classe principal do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class Paciencia {

    Controle controle;
    Baralho baralho;

    public Paciencia() {
        controle = new Controle();
        baralho = new Baralho();
    }

    public void start() {
        baralho.novoBaralho();
        baralho.embaralha();
        //baralho.mostraBaralho();
        controle.setConfigs();
        controle.distribuiCartas(baralho);
//        System.out.println("Fileiras:");
//        for (int i = 0; i < controle.getConfig().getFileiras(); i++) {
//            controle.getFilas().mostraFileira(i);
//            System.out.println("");
//        }
        baralho.mostraBaralho(); // baralho está vazio
        //System.out.println("\nCartas do Estoque:");
        //controle.pilhaDeEstoque.mostraEstoque();
        //System.out.println(controle.pilhaDeEstoque.getEstoque().get(1));
        //System.out.println(controle.getConfig().getFileiras());
        controle.telaPrincipal(controle);
    }
}
