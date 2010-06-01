package jogodecartas.estrutura;

import java.util.ArrayList;

/**
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 * @version 1.0a
 */
public class Fileira extends Pilhas {

    private ArrayList<Pilhas> fileiras;

    /** Método cria um ArrayList de Pilhas que representam as Fileiras de um jogo de cartas
     *
     * @param int quantidade                            Informe a quantidade de fileiras que deseja criar
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
