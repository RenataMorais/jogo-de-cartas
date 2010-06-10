package jogodecartas.core.paciencia;

import jogodecartas.Baralho;

/** 
 * Classe principal do jogo Paciência
 * @author João Carlos Nunes Bittencourt
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
        controle.distribuiCartas(baralho);
        controle.alternaModoDeJogo(1);
//        System.out.println("Fileiras:");
//        for (int i = 0; i < controle.global.getConfig().getFileiras(); i++) {
//            controle.global.getControleFileiras().mostraFileira(i);
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
