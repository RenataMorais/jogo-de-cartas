package jogodecartas.core;

/**
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class GlobalConfig {
    private int naipes = 4;
    private int cartas = 52;
    private int cartaPorNaipe = 13;
    private int baralhos;
    private int fundacoes;
    private int fileiras;
    private int modoDeJogo;

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

    public int getCartasPorNaipe() {
        return cartaPorNaipe;
    }

    public void setCartasPorNaipes(int cartaPorNaipe) {
        this.cartaPorNaipe = cartaPorNaipe;
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

    public int getNaipes() {
        return naipes;
    }

    public void setNaipes(int naipes) {
        this.naipes = naipes;
    }
    
}
