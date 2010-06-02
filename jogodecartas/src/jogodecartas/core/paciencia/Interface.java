package jogodecartas.core.paciencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author João Carlos Nunes Bittencourt
 * @author Gabriel Sanches de Almeida
 */
public class Interface {

    Controle controle;

    public void titulo() {
        System.out.println("============= Paciência UEFS ============= \n");
    }

    public void imprimeEstoque(Controle controle) {
        this.controle = controle;
        System.out.print("ESTOQUE == ");
        for (int i = 0; i < controle.pilhaDeEstoque.getEstoque().size(); i++) {
            if (controle.pilhaDeEstoque.getEstoque().get(i).isVirada()) {
                System.out.print(controle.pilhaDeEstoque.getEstoque().get(i) + ", ");
            } else {
                System.out.print("[< >] ");
            }
        }
        System.out.println("");
    }

    public void imprimeDescarte(Controle controle) {
        System.out.print("DESCARTE == ");
        for (int i = 0; i < controle.pilhaDeEstoque.getDescarte().size(); i++) {
            if (controle.pilhaDeEstoque.getDescarte().get(i).isVirada()) {
                System.out.print(controle.pilhaDeEstoque.getDescarte().get(i));
            } else {
                System.out.print("[< >] ");
            }
        }
        System.out.println("");
    }

    public void imprimeFundacoes(Controle controle) {
        System.out.println("FUNDACAO 1 == ");
        System.out.println("FUNDACAO 2 == ");
        System.out.println("FUNDACAO 3 == ");
        System.out.println("FUNDACAO 4 == ");
    }

    public void imprimeFileiras(Controle controle) {
        System.out.print("FILEIRA 1 == ");
        for (int i = 0; i < controle.getFilas().getFileiras().get(0).size(); i++) {
            if (controle.getFilas().getFileiras().get(0).get(i).isVirada()) {
                System.out.print(controle.getFilas().getFileiras().get(0).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("FILEIRA 2 == ");
        for (int i = 0; i < controle.getFilas().getFileiras().get(1).size(); i++) {
            if (controle.getFilas().getFileiras().get(1).get(i).isVirada()) {
                System.out.print(controle.getFilas().getFileiras().get(1).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("FILEIRA 3 == ");
        for (int i = 0; i < controle.getFilas().getFileiras().get(2).size(); i++) {
            if (controle.getFilas().getFileiras().get(2).get(i).isVirada()) {
                System.out.print(controle.getFilas().getFileiras().get(2).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("FILEIRA 4 == ");
        for (int i = 0; i < controle.getFilas().getFileiras().get(3).size(); i++) {
            if (controle.getFilas().getFileiras().get(3).get(i).isVirada()) {
                System.out.print(controle.getFilas().getFileiras().get(3).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("FILEIRA 5 == ");
        for (int i = 0; i < controle.getFilas().getFileiras().get(4).size(); i++) {
            if (controle.getFilas().getFileiras().get(4).get(i).isVirada()) {
                System.out.print(controle.getFilas().getFileiras().get(4).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("FILEIRA 6 == ");
        for (int i = 0; i < controle.getFilas().getFileiras().get(5).size(); i++) {
            if (controle.getFilas().getFileiras().get(5).get(i).isVirada()) {
                System.out.print(controle.getFilas().getFileiras().get(5).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("FILEIRA 7 == ");
        for (int i = 0; i < controle.getFilas().getFileiras().get(6).size(); i++) {
            if (controle.getFilas().getFileiras().get(6).get(i).isVirada()) {
                System.out.print(controle.getFilas().getFileiras().get(6).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
    }

    public void menu(Controle controle) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = new String();

        System.out.println("\nAÇÕES DO JOGO PACIÊNCIA");
        System.out.println("Digite o número de uma das opções abaixo [1 - 5]:");
        System.out.println("1 - MOVER CARTAS");
        System.out.println("2 - VIRAR ESTOQUE");
        System.out.println("3 - ALTERAR MODO DE JOGO");
        System.out.println("4 - REINICIAR");
        System.out.println("5 - SAIR DO JOGO");
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input.equals("2")) {
            controle.pilhaDeEstoque.moveToDescarte();
            controle.telaPrincipal(controle);
        }
        if (input.equals("5")) {
            System.exit(0);
        }
    }
}
