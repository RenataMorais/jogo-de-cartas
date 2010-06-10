package jogodecartas.estrutura;

import jogodecartas.Carta;

/**
 * Estoque é uma classe que representa o conjunto de cartas utilizadas
 * para armazenar cartas que podem ser utilizadas livremente no decorrer
 * do jogo. Esta estrutura consiste de dois objetos do tipo Pilhas
 * que representam o conjunto de cartas que podem ser utilizadas descarte
 * e estoque aquelas que estão armazenadas e podem ser transferidas
 * para o descarte.
 * 
 * @author João Carlos Nunes Bittencourt
 * @version 1.0a
 */
public class Estoque extends Pilhas {

    private Pilhas estoque = new Pilhas();
    private Pilhas descarte = new Pilhas();
    private int cartasViradas = 1;

    /** 
     * Exibe as cartas presentes no descarte, de acordo com {@link #getCartasViradas()}
     */
    public void mostraDescarte() {
        for (int i = 0; i < this.cartasViradas; i++) {
            System.out.print(descarte.elementAt(i));
        }
    }

    /** 
     * Exibe as cartas presentes no descarte
     */
    public void mostraEstoque() {
        for (int i = 0; i < estoque.size(); i++) {
            System.out.println(estoque.elementAt(i));
        }
    }

    /** 
     * Move carta do topo do estoque para o descarte e restaura o estoque
     * quando todas as cartas já terem sido transferidas para o descarte.
     */
    public void moveToDescarte() {
        // viro as cartas que já estão no descarte
        for (int j = 0; j < descarte.size(); j++) {
            if (descarte.get(j).isVirada()) {
                descarte.get(j).setVirada();
            }
        }
        if (estoque.isEmpty()) {
            restauraEstoque();
            descarte.clear();
        } else {
//        System.out.println(config.getModoDeJogo());
            // movo cartas do estoque para o descarte
            for (int i = 0; i < this.cartasViradas; i++) {
                Carta carta = this.estoque.pop();                   // removo a carta do estoque
                carta.setVirada();                                  // viro a carta
                this.descarte.push(carta);                          // adiciono carta virada no descarte
            }
        }
    }

    public void viraUltimaCartaDescarte() {
        if (config.getModoDeJogo() == 1) {
            descarte.peek().setVirada();
        } else {
            // vira a última carta da base conforme a quantidade de cartas que podem estar viradas
            descarte.elementAt(descarte.size() - (this.cartasViradas - 1)).setVirada();
        }
    }

    /** 
     * Remove uma carta do topo da pilha
     *
     * @return                  Carta posicionada no topo da pilha de {@link #getEstoque()}.
     */
    public Carta removeFromEstoque() {
        return estoque.pop();
    }

    /** 
     * Adiciona uma carta à pilha de {@link #descarte}
     *
     * @param carta             Carta que será adicionada à pilha de {@link #getDescarte()}
     */
    public void addToDescarte(Carta carta) {
        descarte.push(carta);
    }

    /** 
     * Transfere as cartas da pilha de {@link #estoque} para a pilha de {@link #getDescarte()}
     */
    public void restauraEstoque() {
        while (!descarte.isEmpty()) {
            estoque.push(descarte.pop());
        }
    }

    /** 
     * Acesso à pilha de descarte
     * @return                  Pilha de descarte
     */
    public Pilhas getDescarte() {
        return descarte;
    }

    /** 
     * Acesso à pilha de estoque
     *
     * @return                  Pilha de estoque
     */
    public Pilhas getEstoque() {
        return estoque;
    }

    /** 
     * Recebe uma pilha de cartas para serem armazenadas no estoque.
     *
     * @param estoque           Objeto do tipo Pilhas que será admitido na
     *                          pilha do estoque
     */
    public void setEstoque(Pilhas estoque) {
        this.estoque = estoque;
    }

    /** 
     * Acesso à quantidade de cartas que podem estar viradas
     * simultaneamente no descarte.
     *
     * @return int              valor inteiro correspondente à quantidade de cartas
     *                          que podem estar viradas
     */
    public int getCartasViradas() {
        return cartasViradas;
    }

    /** 
     * Define quantas cartas podem estar viradas simultaneamente no destaque.
     *
     * @param cartasViradas    quantidade de cartas que podem estar viradas
     */
    public void setCartasViradas(int cartasViradas) {
        this.cartasViradas = cartasViradas;
    }
}
