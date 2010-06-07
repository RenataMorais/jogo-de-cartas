package jogodecartas.core.paciencia;

import jogodecartas.Baralho;
import jogodecartas.core.ControladorGlobal;
import jogodecartas.estrutura.Estoque;
import jogodecartas.estrutura.Pilhas;

/** 
 * Classe de controle do jogo Paciência responsável por executar as ações
 * referentes à jogabilidade do sistema.
 *
 * @author João Carlos Nunes Bittencourt
 * @version 1.0b
 */
public class Controle {

    private Estoque pilhaDeEstoque = new Estoque();
    private Config config = new Config();
    private Interface interfacePaciencia = new Interface();
    ControladorGlobal global = new ControladorGlobal(config.getSizeFileiras(), config.getSizeFundacoes());

    /**
     * Distribui as cartas do baralho nas estruturas de acordo com as
     * configurações do controlador getControleFundacoes
     *
     * @param baralho                   conjunto de cartas que deve ser distribuídas
     *                                  entre as estruturas do baralho.
     */
    public void distribuiCartas(Baralho baralho) {
        //global.getConfig().setFileiras(7);
        for (int i = 0; i < config.getSizeFileiras(); i++) {
            for (int j = 0; j < i + 1; j++) {
                global.getControleFileiras().getFileiras().get(i).push(baralho.getBaralho().remove(j));
            }
            global.getControleFileiras().getFileiras().get(i).peek().setVirada();
        }
        Pilhas pilha = new Pilhas();

        pilha.addAll(baralho.getBaralho());
        baralho.getBaralho().clear();
        pilhaDeEstoque.setEstoque(pilha);
    }

    /**
     * Alterna entre os diferentes modos de jogo do Paciência. Basicamente
     * altera a quantidade de cartas que podem ser visualizadas ao mesmo tempo
     * na pilha de descarte.
     *
     * @param novoModo                  quantidade de cartas que podem ser vistas
     *                                  simultaneamente no descarte.
     */
    public void alternaModoDeJogo(int novoModo) {
        pilhaDeEstoque.setCartasViradas(novoModo);
    }

    /**
     * Exibe a tela principal do jogo.
     * @param controle                  referência que considera o objeto criado
     *                                  a partir do objeto principal do paciência
     */
    public void telaPrincipal(Controle controle) {
        interfacePaciencia.titulo();
        interfacePaciencia.imprimeEstoque(controle);
        interfacePaciencia.imprimeDescarte(controle);
        interfacePaciencia.imprimeFundacoes(controle);
        interfacePaciencia.imprimeFileiras(controle);
        interfacePaciencia.menu(controle);
    }

    /**
     * Acesso à pilha de estoque
     *
     * @return                          objeto contendo as pilhas de estoque e descarte
     */
    public Estoque getpilhaDeEstoque() {
        return pilhaDeEstoque;
    }

    public void restart(){
        Paciencia paciencia = new Paciencia();
        paciencia.start();
    }

    /**
     * Acesso aos métodos do controlador getControleFundacoes do framework
     *
     * @return                          objeto referência para acesso ao métodos
     *                                  e atributos do controlador geral.
     */
    public ControladorGlobal getControleGlobal() {
        return global;
    }
}
