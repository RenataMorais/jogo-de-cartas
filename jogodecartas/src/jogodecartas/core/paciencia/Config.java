package jogodecartas.core.paciencia;


/** Classe de configuração do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Config {

    private int naipes = 4;
    private int cartas = 52;
    private int cartas_naipes = 13;
    private int baralhos = 1;
    private int fundacoes = 4;
    private int fileiras = 7;
    private int modoDeJogo = 1;


    public int getBaralhos() {
        return baralhos;
    }

    public void setBaralhos(int baralhos) {
        this.baralhos = baralhos;
    }

    public int getCartas() {
        return cartas;
    }

    public void setCartas(int cartas) {
        this.cartas = cartas;
    }

    public int getCartas_naipes() {
        return cartas_naipes;
    }

    public void setCartas_naipes(int cartas_naipes) {
        this.cartas_naipes = cartas_naipes;
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

    public int getNaipes() {
        return naipes;
    }

    public void setNaipes(int naipes) {
        this.naipes = naipes;
    }

    public int getModoDeJogo() {
        return modoDeJogo;
    }

    public void setModoDeJogo(int modoDeJogo) {
        this.modoDeJogo = modoDeJogo;
    }


    
}
