package jogodecartas.core;

import java.util.Stack;
import jogodecartas.Carta;
import jogodecartas.estrutura.Estoque;
import jogodecartas.estrutura.Fileira;
import jogodecartas.estrutura.Fundacao;

/** Classe de controle geral do framework, implementa os métodos gerais para os jogos de cartas
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class ControladorGlobal {

    private GlobalConfig config;
    private Fundacao fundacoes;
    private Fileira filas;
    private RegrasGlobais regras;

    public ControladorGlobal(){
         config = new GlobalConfig();
         fundacoes = new Fundacao(config.getFundacoes());
         filas = new Fileira(7);
    }

    /** Move a carta do topo do estoque para uma fileira
     *
     * @param Pilhas estoque                                        // Estoque de cartas
     * @param int idFileira                                         // Identificador da fileira de destino
     */
    public void moveDescarteFileira(Estoque descarte, int idFileira) {
        if (regras.validaFileiraDestino(descarte.getDescarte().peek(), idFileira)) {
            filas.getFileiras().get(idFileira).push(descarte.getDescarte().pop());
        }
    }

    /** Move a carta do topo do estoque para uma fundação
     *
     * @param Pilhas estoque                                        // Estoque de cartas
     * @param int idFileira                                         // Identificador da fileira de destino
     */
    public void moveDescarteFundacoes(Estoque descarte, int idFundacao) {
        if (regras.validaFundacaoDestino(descarte.getDescarte().peek(), idFundacao)) {
            fundacoes.getFundacoes().get(idFundacao).push(descarte.getDescarte().pop());
        }
    }

    /** Move carta de uma fundação para uma fileira
     *
     * @param int idFundacao
     * @param int idFileira
     */
    public void moveFundacaoToFileira(int fundacao, int fileira) {
        if (regras.validaFileiraDestino(fundacoes.getFundacoes().get(fundacao).peek(), fileira)) {
            filas.getFileiras().get(fileira).push(fundacoes.getFundacoes().get(fundacao).pop());
        }
    }

    /** 
     * Move carta entre duas filas
     * @param int origem
     * @param int destino
     * @param int profundidade
     */
    public void moveFileiraToFileira(int origem, int destino, int profundidade) {
        Stack<Carta> pilha = new Stack<Carta>();

        int posicao = filas.getFileiras().get(origem).posicao(origem, profundidade); //filas.getFileiras().get(origem).size() - profundidade;
        // Valida a fileira comparando o destino com a carta presente na posição definida pela profundidade
        if (regras.validaFileiraDestino(filas.getFileiras().get(origem).elementAt(posicao), destino)) {
            //filas.getFileiras().get(destino).push(filas.getFileiras().get(origem).pop());
            for (int i = 0; i < profundidade; i++) {
                pilha.push(filas.getFileiras().get(origem).pop());
            }
            filas.getFileiras().get(destino).addAll(pilha);
            // Se a última carta não estiver virada, vire
            if (!filas.getFileiras().get(origem).peek().isVirada()) {
                filas.getFileiras().get(origem).peek().setVirada();
            }
        }
    }

    /**
     * Move cartas de uma fileira para uma fundação
     * @param int fileira
     * @param int fundacao
     * @param int profundidade
     */
    public void moveFileiraToFundacao(int fileira, int fundacao, int profundidade) {
        int posicao = filas.getFileiras().get(fileira).size() - profundidade;
        if (regras.validaFundacaoDestino(filas.getFileiras().get(fileira).elementAt(posicao), fundacao)) {
        }
    }

    /** Verifica se o usuário completou as funcacoes
     *
     * @return boolean
     */
    public boolean completou() {
        for (int i = 0; i <
                fundacoes.getFundacoes().size(); i++) {
            if (fundacoes.getFundacoes().get(i).size() == config.getCartasPorNaipe()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public Fileira getFilas() {
        return filas;
    }

    public Fundacao getFundacoes() {
        return fundacoes;
    }

    public GlobalConfig getConfig() {
        return config;
    }

    public void setConfig(GlobalConfig config) {
        this.config = config;
    }

    public void setFilas(Fileira fileiras) {
        this.filas = fileiras;
    }

    public void setFundacoes(Fundacao fundacoes) {
        this.fundacoes = fundacoes;
    }

    public RegrasGlobais getRegras() {
        return regras;
    }

    public void setRegras(RegrasGlobais regras) {
        this.regras = regras;
    }

}
