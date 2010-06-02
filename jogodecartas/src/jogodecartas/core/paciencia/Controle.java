package jogodecartas.core.paciencia;

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

    public Estoque pilhaDeEstoque = new Estoque();
    Config config = new Config();
    Interface interfacePaciencia = new Interface();

    public void distribuiCartas(Baralho baralho) {
        //getConfig().setFileiras(7);
        for (int i = 0; i < config.getSizeFileiras(); i++) {
            for (int j = 0; j < i + 1; j++) {
                getFilas().getFileiras().get(i).push(baralho.getBaralho().remove(j));
            }
            getFilas().getFileiras().get(i).peek().setVirada();
        }
        Pilhas pilha = new Pilhas();

        pilha.addAll(baralho.getBaralho());
        baralho.getBaralho().clear();
        pilhaDeEstoque.setEstoque(pilha);
    }

    public void setConfigs() {
        getConfig().setFileiras(config.getSizeFileiras());
        getConfig().setBaralhos(config.getSizeBaralhos());
        getConfig().setFundacoes(config.getSizeFundacoes());
        getConfig().setModoDeJogo(config.getModoDeJogo());
    }

    public void telaPrincipal(Controle controle) {
        interfacePaciencia.titulo();
        interfacePaciencia.imprimeEstoque(controle);
        interfacePaciencia.imprimeDescarte(controle);
        interfacePaciencia.imprimeFundacoes(controle);
        interfacePaciencia.imprimeFileiras(controle);
        interfacePaciencia.menu(controle);
    }

    public Pilhas getpilhaDeEstoque() {
        return pilhaDeEstoque;
    }
}
