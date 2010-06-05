package jogodecartas.core;

import java.util.Stack;
import jogodecartas.Carta;
import jogodecartas.core.paciencia.Regras;
import jogodecartas.estrutura.Estoque;
import jogodecartas.estrutura.Fileira;
import jogodecartas.estrutura.Fundacao;

/** 
 * Classe de controle geral do framework, implementa os métodos gerais
 * para os jogos de cartas.
 *
 * @author João Carlos Nunes Bittencourt
 * @version 1.0a
 */
public class ControladorGlobal {

    private GlobalConfig config;
    private Fundacao controleFundacoes;
    private Fileira controleFileiras;
    private RegrasGlobais regras;

    /**
     * Contrutor necessário para as classes que herdam de {@link #ControladorGlobal()}
     */
    public ControladorGlobal() {
    }

    /**
     * Construtor do objeto define a quantdade de fileiras e fundações que
     * serão instanciadas ao mesmo tempo.
     *
     * @param fileiras                      quantidade de fileiras
     * @param fundacoes                     quantidade de fundações
     */
    public ControladorGlobal(int fileiras, int fundacoes) {
        config = new GlobalConfig();
        controleFundacoes = new Fundacao(fundacoes);
        controleFileiras = new Fileira(fileiras);
        regras = new Regras();
    }

    /** 
     * Move a carta do topo do estoque para uma fileira
     *
     * @param estoque                       estoque de cartas
     * @param idFileira                     índice do vetor que contém a fileira de destino
     */
    public void moveDescarteFileira(Estoque descarte, int idFileira) {
        if (regras.validaFileiraDestino(descarte.getDescarte().peek(), controleFileiras.getFileiras().get(idFileira))) {
            controleFileiras.getFileiras().get(idFileira).push(descarte.getDescarte().pop());
        }
    }

    /** 
     * Move a carta do topo do estoque para uma fundação
     * 
     * @param estoque                       estoque de cartas
     * @param idFileira                     índice do vetor que contém a fileira de destino
     * @return                              <code>-1</code> caso a pilha de descarte esteja vazia;
     *                                      <code>1</code> caso a movimentação não seja válida;
     *                                      <code>0</code> se a carta foi movida para a fundação
     *                                      com sucesso.
     */
    public int moveDescarteFundacoes(Estoque descarte, int idFundacao) {
        if (descarte.getDescarte().isEmpty()) {
            return -1;
        } else {
            if (regras.validaFundacaoDestino(descarte.getDescarte().peek(), controleFundacoes.getFundacoes().get(idFundacao))) {
                controleFundacoes.getFundacoes().get(idFundacao).push(descarte.getDescarte().pop());
                return 0;
            } else {
                return 1;
            }
        }
    }

    /** 
     * Move carta de uma fundação para uma fileira
     *
     * @param int idFundacao                índice do vetor que contém a fundação
     * @param int idFileira                 índice do vetor que contém a fileira
     */
    public void moveFundacaoToFileira(int fundacao, int fileira) {
        if (regras.validaFileiraDestino(controleFundacoes.getFundacoes().get(fundacao).peek(), controleFileiras.getFileiras().get(fileira))) {
            controleFileiras.getFileiras().get(fileira).push(controleFundacoes.getFundacoes().get(fundacao).pop());
        }
    }

    /** 
     * Move carta entre duas fileiras
     * 
     * @param origem                        índice do vetor que contém a fileira de origem
     * @param destino                       ínidice do vetor que contém a fileira destino
     * @param profundidade                  quantidade de cartas, a partir do topo da pilha
     *                                      que devem ser transferidas para fileira de
     *                                      destino
     */
    public void moveFileiraToFileira(int origem, int destino, int profundidade) {
        Stack<Carta> pilha = new Stack<Carta>();

        int posicao = controleFileiras.getFileiras().get(origem).posicao(origem, profundidade); //controleFileiras.getFileiras().get(origem).size() - profundidade;
        // Valida a fileira comparando o destino com a carta presente na posição definida pela profundidade
        if (regras.validaFileiraDestino(controleFileiras.getFileiras().get(origem).elementAt(posicao), controleFileiras.getFileiras().get(destino))) {
            //controleFileiras.getFileiras().get(destino).push(controleFileiras.getFileiras().get(origem).pop());
            for (int i = 0; i < profundidade; i++) {
                pilha.push(controleFileiras.getFileiras().get(origem).pop());
            }
            controleFileiras.getFileiras().get(destino).addAll(pilha);
            // Se a última carta não estiver virada, vire
            if (!controleFileiras.getFileiras().get(origem).peek().isVirada()) {
                controleFileiras.getFileiras().get(origem).peek().setVirada();
            }
        }
    }

    /**
     * Move cartas de uma fileira para uma fundação
     *
     * @param fileira                       índice do vetor que contém a fileira de origem
     * @param fundacao                      índice do vetor que contém a fundação
     */
    public void moveFileiraToFundacao(int fileira, int fundacao) {
        //if (regras.validaFundacaoDestino(controleFileiras.getFileiras().get(fileira).peek(), fundacao)) {
        //}
    }

    /** 
     * Verifica se o usuário completou as funcacoes
     * @return                              <code>true</code> se o usuário completou o jogo
     *                                      <code>false</code> caso contrário.
     */
    public boolean completou() {
        for (int i = 0; i <
                controleFundacoes.getFundacoes().size(); i++) {
            if (controleFundacoes.getFundacoes().get(i).size() == config.getCartasPorNaipe()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /** 
     * Objeto instanciado de Fileira na classe ControladorGlobal
     * 
     * @return Fileira                     vetor de fileiras
     */
    public Fileira getControleFileiras() {
        return controleFileiras;
    }

    /** 
     * Objeto instanciado de Fundações na classe ControladorGlobal
     * 
     * @return Fundacao                     vetor de fundações
     */
    public Fundacao getControleFundacoes() {
        return controleFundacoes;
    }

    /** 
     * Objeto de configuração getControleFundacoes do jogo
     *
     * @return GlobalConfig                objeto com todas as configurações do jogo
     */
    public GlobalConfig getConfig() {
        return config;
    }

    /** 
     * Objeto que define as configurações do jogo
     * @param config                       objeto contendo as configurações
     */
    public void setConfig(GlobalConfig config) {
        this.config = config;
    }

    /** 
     * Objeto instanciado na classe ControladorGlobal define um conjunto de fileiras
     *
     * @param fileiras                    acesso ao controle que define as fileiras do jogo
     */
    public void setControleFileiras(Fileira fileiras) {
        this.controleFileiras = fileiras;
    }

    /** Objeto instanciado na classe ControladorGlobal define um conjunto de fundacoes
     *
     * @param fundacoes                  acesso ao controle que define as fundações do jogo
     */
    public void setControleFundacoes(Fundacao fundacoes) {
        this.controleFundacoes = fundacoes;
    }

    /** 
     * Conjunto de regras globais dos jogos de carta
     * @return RegrasGlobais            conjunto de métodos que determinam as regas do jogo
     */
    public RegrasGlobais getRegras() {
        return regras;
    }
}
