/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas.core.paciencia;

import jogodecartas.Baralho;
import jogodecartas.core.ControladorGlobal;
import jogodecartas.estrutura.Estoque;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaocarlos
 */
public class ControleTest {

    public ControleTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Iniciando testes da classe Controle do jogo Paciência... \n");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("\nTestes da classe Controle finalizados.");
        System.out.println("bye");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of distribuiCartas method, of class Controle.
     */
    @Test
    public void testDistribuiCartasFundacoes() {
        System.out.println("Testando: distribuiCartas() inicio");
        System.out.println(" > Verificando se todas as fundações estão vazias...");
        Baralho baralho = new Baralho();
        baralho.novoBaralho();
        Controle instance = new Controle();
        instance.distribuiCartas(baralho);
        int expResult = 0;
        System.out.println("  Resultado esperado: " + expResult);
        int fundacao1 = instance.getControleGlobal().getControleFundacoes().getFundacoes().get(0).size();
        System.out.println("  Resultado obtido na F1: " + fundacao1);
        assertEquals(expResult, fundacao1);
        int fundacao2 = instance.getControleGlobal().getControleFundacoes().getFundacoes().get(1).size();
        System.out.println("  Resultado obtido na F2: " + fundacao2);
        assertEquals(expResult, fundacao2);
        int fundacao3 = instance.getControleGlobal().getControleFundacoes().getFundacoes().get(2).size();
        System.out.println("  Resultado obtido na F3: " + fundacao3);
        assertEquals(expResult, fundacao3);
        int fundacao4 = instance.getControleGlobal().getControleFundacoes().getFundacoes().get(3).size();
        System.out.println("  Resultado obtido na F4: " + fundacao4);
        assertEquals(expResult, fundacao4);
    }

    /**
     * Test of distribuiCartas method, of class Controle.
     */
    @Test
    public void testDistribuiCartasFileiras() {
        System.out.println(" > Verificando se todas as fileiras estão preenchidas corretamente...");
        Baralho baralho = new Baralho();
        baralho.novoBaralho();
        Controle instance = new Controle();
        instance.distribuiCartas(baralho);
        int expResult = 1;
        System.out.println("  Resultado esperado: " + expResult);
        int fileira1 = instance.getControleGlobal().getControleFileiras().getFileiras().get(0).size();
        System.out.println("  Resultado obtido na F1: " + fileira1);
        assertEquals(expResult, fileira1);
        expResult = 2;
        System.out.println("  Resultado esperado: " + expResult);
        int fileira2 = instance.getControleGlobal().getControleFileiras().getFileiras().get(1).size();
        System.out.println("  Resultado obtido na F2: " + fileira2);
        assertEquals(expResult, fileira2);
        expResult = 3;
        System.out.println("  Resultado esperado: " + expResult);
        int fileira3 = instance.getControleGlobal().getControleFileiras().getFileiras().get(2).size();
        System.out.println("  Resultado obtido na F3: " + fileira3);
        assertEquals(expResult, fileira3);
        expResult = 4;
        System.out.println("  Resultado esperado: " + expResult);
        int fileira4 = instance.getControleGlobal().getControleFileiras().getFileiras().get(3).size();
        System.out.println("  Resultado obtido na F4: " + fileira4);
        assertEquals(expResult, fileira4);
        expResult = 5;
        System.out.println("  Resultado esperado: " + expResult);
        int fileira5 = instance.getControleGlobal().getControleFileiras().getFileiras().get(4).size();
        System.out.println("  Resultado obtido na F2: " + fileira5);
        assertEquals(expResult, fileira5);
        expResult = 6;
        System.out.println("  Resultado esperado: " + expResult);
        int fileira6 = instance.getControleGlobal().getControleFileiras().getFileiras().get(5).size();
        System.out.println("  Resultado obtido na F3: " + fileira6);
        assertEquals(expResult, fileira6);
        expResult = 7;
        System.out.println("  Resultado esperado: " + expResult);
        int fileira7 = instance.getControleGlobal().getControleFileiras().getFileiras().get(6).size();
        System.out.println("  Resultado obtido na F4: " + fileira7);
        assertEquals(expResult, fileira7);
        System.out.println("  Total de cartas: " + (fileira1 + fileira2 + fileira3 + fileira4 + fileira5 + fileira6 + fileira7));
    }

    /**
     * Test of distribuiCartas method, of class Controle.
     */
    @Test
    public void testDistribuiCartasEstoque() {
        System.out.println(" > Verificando se as cartas restantes foram parar no estoque...");
        Baralho baralho = new Baralho();
        baralho.novoBaralho();
        Controle instance = new Controle();
        instance.distribuiCartas(baralho);
        int expResult = 24;
        System.out.println("  Resultado esperado: " + expResult + " cartas");
        int estoque = instance.getpilhaDeEstoque().getEstoque().size();
        System.out.println("  Resultado obtido: " + estoque + " cartas");
        assertEquals(expResult, estoque);
        System.out.println("fim");
    }

    /**
     * Test of alternaModoDeJogo method, of class Controle.
     */
    @Test
    public void testAlternaModoDeJogo() {
        System.out.println("\nTestando: alternaModoDeJogo() inicio");
        System.out.println(" > Alterno para o modo de jogo 3 (vira três cartas do estoque)");
        int novoModo = 3;
        System.out.println("  Novo modo de jogo: " + novoModo);
        Controle instance = new Controle();
        instance.alternaModoDeJogo(novoModo);
        int i = instance.getpilhaDeEstoque().getCartasViradas();
        System.out.println("  Resultado da mudança: " + i);
        assertEquals(novoModo, i);
    }

    /**
     * Test of alternaModoDeJogo method, of class Controle.
     */
    @Test
    public void testAlternaModoDeJogoViraCartas() {
        System.out.println(" > Testando a estrutura ao alternar modo de jogo");
        Baralho baralho = new Baralho();
        baralho.novoBaralho();
        Controle instance = new Controle();
        instance.distribuiCartas(baralho);
        int modoAtual = 1;
        System.out.println("  Movo de jogo padrão: " + modoAtual);
        System.out.println("  Movendo carta para o descarte...");
        instance.getpilhaDeEstoque().moveToDescarte();
        int i = instance.getpilhaDeEstoque().getDescarte().size();
        System.out.println("  Cartas no descarte: " + i);
        instance.getpilhaDeEstoque().restauraEstoque();
        System.out.println("  Alternando o modo de jogo...");
        int novoModo = 3;
        instance.alternaModoDeJogo(novoModo);
        instance.getpilhaDeEstoque().moveToDescarte();
        i = instance.getpilhaDeEstoque().getDescarte().size();
        System.out.println("  Cartas no descarte: " + i);
        assertEquals(novoModo, i);
        System.out.println("fim");
    }
}
