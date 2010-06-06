package jogodecartas.estrutura;

import java.util.ArrayList;

/**
 * Classe que implementa a estrutura que representa as fileiras em um jogo de
 * carta qualquer.
 *
 * @author João Carlos Nunes Bittencourt
 * @version 2.0a
 */
public class Fileira extends Pilhas {

    private ArrayList<Pilhas> fileiras;

    /** Método cria um ArrayList de Pilhas que representam as Fileiras de um jogo de cartas
     *
     * @param quantidade                            Informe a quantidade de fileiras que deseja criar
     */
    public Fileira(int quantidade) {
        fileiras = new ArrayList<Pilhas>();
        for (int i = 0; i < quantidade; i++) {
            fileiras.add(new Pilhas());
        }
    }

    public void mostraFileira(int id) {
        System.out.print("Fileira " + id + ": ");
        for (int i = 0; i < fileiras.get(id).size(); i++) {
            System.out.print(fileiras.get(id).get(i));
        }
    }

    public ArrayList<Pilhas> getFileiras() {
        return fileiras;
    }

    public void setFileiras(ArrayList<Pilhas> fileiras) {
        this.fileiras = fileiras;
    }
}
