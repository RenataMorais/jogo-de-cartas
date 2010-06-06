package jogodecartas.core.paciencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe responsável por implementar os métodos de exibição do sistema
 *
 * @author João Carlos Nunes Bittencourt
 */
public class Interface {

    Controle controle;

    public void titulo() {
        System.out.println("============= Paciência UEFS ============= \n");
    }

    public void imprimeEstoque(Controle controle) {
        this.controle = controle;
        System.out.print("ESTOQUE == ");
        for (int i = 0; i < controle.getpilhaDeEstoque().getEstoque().size(); i++) {
            if (controle.getpilhaDeEstoque().getEstoque().get(i).isVirada()) {
                System.out.print(controle.getpilhaDeEstoque().getEstoque().get(i) + ", ");
            } else {
                System.out.print("[< >] ");
            }
        }
        System.out.println("");
    }

    public void imprimeDescarte(Controle controle) {
        System.out.print("0 - DESCARTE == ");
        for (int i = 0; i < controle.getpilhaDeEstoque().getDescarte().size(); i++) {
            if (controle.getpilhaDeEstoque().getDescarte().get(i).isVirada()) {
                System.out.print(controle.getpilhaDeEstoque().getDescarte().get(i));
            } else {
                System.out.print("[< >] ");
            }
        }
        System.out.println("");
    }

    public void imprimeFundacoes(Controle controle) {
        System.out.print("1 - FUNDACAO 1 == ");
        for (int i = 0; i < controle.global.getControleFundacoes().getFundacoes().get(0).size(); i++) {
            System.out.print(controle.getControleGlobal().getControleFundacoes().getFundacoes().get(0).get(i));
        }
        System.out.println("");
        System.out.print("2 - FUNDACAO 2 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFundacoes().getFundacoes().get(1).size(); i++) {
            System.out.print(controle.getControleGlobal().getControleFundacoes().getFundacoes().get(1).get(i));
        }
        System.out.println("");
        System.out.print("3 - FUNDACAO 3 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFundacoes().getFundacoes().get(2).size(); i++) {
            System.out.print(controle.getControleGlobal().getControleFundacoes().getFundacoes().get(2).get(i));
        }
        System.out.println("");
        System.out.print("4 - FUNDACAO 4 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFundacoes().getFundacoes().get(3).size(); i++) {
            System.out.print(controle.getControleGlobal().getControleFundacoes().getFundacoes().get(3).get(i));
        }
        System.out.println("");
    }

    public void imprimeFileiras(Controle controle) {
        System.out.print("5 - FILEIRA 1 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFileiras().getFileiras().get(0).size(); i++) {
            if (controle.getControleGlobal().getControleFileiras().getFileiras().get(0).get(i).isVirada()) {
                System.out.print(controle.getControleGlobal().getControleFileiras().getFileiras().get(0).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("6 - FILEIRA 2 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFileiras().getFileiras().get(1).size(); i++) {
            if (controle.getControleGlobal().getControleFileiras().getFileiras().get(1).get(i).isVirada()) {
                System.out.print(controle.getControleGlobal().getControleFileiras().getFileiras().get(1).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("7 - FILEIRA 3 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFileiras().getFileiras().get(2).size(); i++) {
            if (controle.getControleGlobal().getControleFileiras().getFileiras().get(2).get(i).isVirada()) {
                System.out.print(controle.getControleGlobal().getControleFileiras().getFileiras().get(2).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("8 - FILEIRA 4 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFileiras().getFileiras().get(3).size(); i++) {
            if (controle.getControleGlobal().getControleFileiras().getFileiras().get(3).get(i).isVirada()) {
                System.out.print(controle.getControleGlobal().getControleFileiras().getFileiras().get(3).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("9 - FILEIRA 5 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFileiras().getFileiras().get(4).size(); i++) {
            if (controle.getControleGlobal().getControleFileiras().getFileiras().get(4).get(i).isVirada()) {
                System.out.print(controle.getControleGlobal().getControleFileiras().getFileiras().get(4).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("10 - FILEIRA 6 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFileiras().getFileiras().get(5).size(); i++) {
            if (controle.getControleGlobal().getControleFileiras().getFileiras().get(5).get(i).isVirada()) {
                System.out.print(controle.getControleGlobal().getControleFileiras().getFileiras().get(5).get(i));
            } else {
                System.out.print("[< >]");
            }
        }
        System.out.println("");
        System.out.print("11 - FILEIRA 7 == ");
        for (int i = 0; i < controle.getControleGlobal().getControleFileiras().getFileiras().get(6).size(); i++) {
            if (controle.getControleGlobal().getControleFileiras().getFileiras().get(6).get(i).isVirada()) {
                System.out.print(controle.getControleGlobal().getControleFileiras().getFileiras().get(6).get(i));
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
        if (input.equals("1")) {
            System.out.print("Informe o número do local onde a carta se encontra: ");
            try {
                input = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String origem = input;
            System.out.print("Informe o número do local para onde deseja mover a carta: ");
            try {
                input = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String destino = input;
            seletorDeMovimentacao(origem, destino);
        } else if (input.equals("2")) {
            controle.getpilhaDeEstoque().moveToDescarte();
            controle.telaPrincipal(controle);
        } else if (input.equals("5")) {
            System.exit(0);
        }
    }

    public void seletorDeMovimentacao(String a, String b) {
        int origem = Integer.parseInt(a);
        int destino = Integer.parseInt(b);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = new String();

        if (origem == destino) {
            System.out.println("ATENÇÃO! A pilha onde a carte se encontra deve ser diferente do local onde deseja mover a carta.");
            controle.telaPrincipal(controle);
        } else {
            if (origem == 0 && (destino >= 1 && destino <= 4)) {
                movimentaDescarteToFundacao(destino - 1);
            } else if (origem == 0 && (destino >= 5 && destino <= 11)) {
                movimentaDecarteToFileira(destino - 5);
            } else if ((origem >= 5 && origem <= 11) && (destino >= 5 && destino <= 11)) {
                System.out.println("Quantas cartas desta fileira deseja mover: ");
                try {
                    input = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String deep = input;
                int profundidade = Integer.parseInt(deep);
                movimentaFileiraToFileira(origem - 5, destino - 5, profundidade);
            } else if ((origem >= 5 && origem <= 11) && (destino >= 1 && destino <= 4)) {
                movimentaFileiraToFundacao(origem - 5, destino - 1);
            } else if((origem >= 1 && origem <= 4) && (destino >= 5 && destino <= 11)) {

            } else {
                System.out.println("Opção Inválida!");
                controle.telaPrincipal(controle);
            }
        }
    }

    public void movimentaDescarteToFundacao(int destino) {
        int verify = controle.getControleGlobal().moveDescarteFundacoes(controle.getpilhaDeEstoque(), destino);
        if (verify == -1) {
            System.out.println("\nATENÇÃO! Pilha de descarte vazia! Mova uma carta do estoque primeiro.");
        } else if (verify == 1) {
            System.out.println("\nATENÇÃO! Carta inválida para esta fundação! Tente novamente.");
        } else if (verify == 0) {
            if (!controle.getpilhaDeEstoque().getDescarte().isEmpty()) {
                controle.getpilhaDeEstoque().getDescarte().peek().setVirada();
            }
            System.out.println("\nCarta movida com sucesso!");

        }
        controle.telaPrincipal(controle);
    }

    public void movimentaDecarteToFileira(int destino) {
        int verify = controle.getControleGlobal().moveDescarteFileira(controle.getpilhaDeEstoque(), destino);

        if (verify == -1) {
            System.out.println("\nATENÇÃO! Pilha de descarte vazia! Mova uma carta do estoque primeiro.");
        } else if (verify == 1) {
            System.out.println("\nATENÇÃO! Carta inválida para esta fileira! Tente novamente.");
        } else if (verify == 0) {
            if (!controle.getpilhaDeEstoque().getDescarte().isEmpty()) {
                controle.getpilhaDeEstoque().getDescarte().peek().setVirada();
            }
            System.out.println("\nCarta movida com sucesso!");
        }
        controle.telaPrincipal(controle);
    }

    public void movimentaFileiraToFileira(int origem, int destino, int profundidade) {
        int verify = controle.getControleGlobal().moveFileiraToFileira(origem, destino, profundidade);

        if (verify == -1) {
            System.out.println("\nATENÇÃO! A fileira está vazia vazia.");
        } else if (verify == 1) {
            System.out.println("\nATENÇÃO! Carta inválida para esta fileira! Tente novamente.");
        } else if (verify == 0) {
            if (!controle.getControleGlobal().getControleFileiras().getFileiras().get(origem).isEmpty() && !controle.getControleGlobal().getControleFileiras().getFileiras().get(origem).peek().isVirada()) {
                controle.getControleGlobal().getControleFileiras().getFileiras().get(origem).peek().setVirada();
            }
            System.out.println("\nCarta movida com sucesso!");
        }
        controle.telaPrincipal(controle);
    }

    public void movimentaFileiraToFundacao(int origem, int destino){
        int verify = controle.getControleGlobal().moveFileiraToFundacao(origem, destino);

        if (verify == -1) {
            System.out.println("\nATENÇÃO! Pilha de descarte vazia! Mova uma carta do estoque primeiro.");
        } else if (verify == 1) {
            System.out.println("\nATENÇÃO! Carta inválida para esta fileira! Tente novamente.");
        } else if (verify == 0) {
            if (!controle.getControleGlobal().getControleFileiras().getFileiras().get(origem).isEmpty() && !controle.getControleGlobal().getControleFileiras().getFileiras().get(origem).peek().isVirada()) {
                controle.getControleGlobal().getControleFileiras().getFileiras().get(origem).peek().setVirada();
            }
            System.out.println("\nCarta movida com sucesso!");
        }
        controle.telaPrincipal(controle);
    }

    public void movimentaFundacaoToFileira(int origem, int destino){
        int verify = controle.getControleGlobal().moveFundacaoToFileira(origem, destino);

        if (verify == -1) {
            System.out.println("\nATENÇÃO! Fundação vazia.");
        } else if (verify == 1) {
            System.out.println("\nATENÇÃO! Carta inválida para esta fileira! Tente novamente.");
        } else if (verify == 0) {
            System.out.println("\nCarta movida com sucesso!");
        }
        controle.telaPrincipal(controle);
    }
}
