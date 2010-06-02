package jogodecartas.core.paciencia;


/** Classe de configuração do jogo Paciência
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Config {

    int sizeBaralhos = 1;
    int sizeFundacoes = 4;
    int sizeFileiras = 7;
    int modoDeJogo = 1;

    public void mostraFundacoes(){
        System.out.println(sizeFundacoes);
    }

    public int getSizeBaralhos() {
        return sizeBaralhos;
    }

    public void setSizeBaralhos(int sizeBaralhos) {
        this.sizeBaralhos = sizeBaralhos;
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
