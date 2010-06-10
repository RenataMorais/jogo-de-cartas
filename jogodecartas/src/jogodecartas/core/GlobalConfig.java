package jogodecartas.core;

/**
 * Classe de configuração comum à todos os jogos de carta. Seus atributos
 * generalizados podem ser modificados a depender do jogo que deseja-se implementar.
 * 
 * @author João Carlos Nunes Bittencourt
 */
public class GlobalConfig {
    private int naipes;
    private int cartas;
    private int cartaPorNaipe;
    private int fundacoes;
    private int fileiras;
    private int modoDeJogo;

    public GlobalConfig(){
        naipes = 4;
        cartas = 52;
        cartaPorNaipe = 13;
    }

    public int getCartas() {
        return cartas;
    }
//
//    public void setCartas(int cartas) {
//        this.cartas = cartas;
//    }
//
    public int getCartasPorNaipe() {
        return cartaPorNaipe;
    }
//
//    public void setCartasPorNaipes(int cartaPorNaipe) {
//        this.cartaPorNaipe = cartaPorNaipe;
//    }

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

//    public void setNaipes(int naipes) {
//        this.naipes = naipes;
//    }
    
}
