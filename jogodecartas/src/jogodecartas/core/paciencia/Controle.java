package jogodecartas.core.paciencia;

import java.util.Stack;
import jogodecartas.Baralho;
import jogodecartas.core.ControladorGlobal;
import jogodecartas.estrutura.Estoque;
import jogodecartas.estrutura.Pilhas;

/** Classe de controle do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class Controle extends ControladorGlobal {

    public Estoque estoque = new Estoque();
    ControladorGlobal global;

    public void distribuiCartas(Baralho baralho){
        //global.getConfig().setFileiras(7);
        //System.out.println(global.getConfig().getFileiras());
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < i+1; j++){
                getFilas().getFileiras().get(i).push(baralho.getBaralho().remove(j));
            }
        }
        Pilhas pilha = new Pilhas();
        
        pilha.addAll(baralho.getBaralho());
        baralho.getBaralho().clear();
        estoque.setEstoque(pilha);
    }

    public Pilhas getEstoque() {
        return getEstoque();
    }

}
