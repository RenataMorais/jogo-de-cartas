package jogodecartas.core.paciencia;

import jogodecartas.core.GlobalConfig;

/** Classe de configuração do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Config {

    private int baralhos = 1;
    private int fundacoes = 4;
    private int fileiras = 7;
    private int modoDeJogo = 1;
    GlobalConfig config = new GlobalConfig();

    public Config() {
        config.setBaralhos(baralhos);
        config.setFundacoes(fundacoes);
        config.setFileiras(fileiras);
        config.setModoDeJogo(modoDeJogo);
    }

    /** Configuração inicial do jogo paciência
     *
     */
//    public void setConfigs() {
//        config.setBaralhos(baralhos);
//        config.setFundacoes(fundacoes);
//        config.setFileiras(fileiras);
//        config.setModoDeJogo(modoDeJogo);
//    }

    public int getBaralhos() {
        return baralhos;
    }

    public void setBaralhos(int baralhos) {
        this.baralhos = baralhos;
    }

    public int getFileiras() {
        return fileiras;
    }

    public void setFileiras(int fileiras) {
        this.fileiras = fileiras;
    }

    public int getFundacoes() {
        return fundacoes;
    }

    public void setFundacoes(int fundacoes) {
        this.fundacoes = fundacoes;
    }

    public int getModoDeJogo() {
        return modoDeJogo;
    }

    public void setModoDeJogo(int modoDeJogo) {
        this.modoDeJogo = modoDeJogo;
    }
}
