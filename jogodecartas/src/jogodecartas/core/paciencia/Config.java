package jogodecartas.core.paciencia;

/** Classe de configuração do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Config {

    int sizeFundacoes;
    int sizeFileiras;
    int modoDeJogo;

    public Config() {
        sizeFundacoes = 4;
        sizeFileiras = 7;
        modoDeJogo = 1;
    }

    public void mostraFundacoes() {
        System.out.println(sizeFundacoes);
    }

    public int getSizeFileiras() {
        return sizeFileiras;
    }

    public void setSizeFileiras(int sizeFileiras) {
        this.sizeFileiras = sizeFileiras;
    }

    public int getSizeFundacoes() {
        return sizeFundacoes;
    }

    public void setSizeFundacoes(int sizeFundacoes) {
        this.sizeFundacoes = sizeFundacoes;
    }

    public int getModoDeJogo() {
        return modoDeJogo;
    }

    public void setModoDeJogo(int modoDeJogo) {
        this.modoDeJogo = modoDeJogo;
    }
}
