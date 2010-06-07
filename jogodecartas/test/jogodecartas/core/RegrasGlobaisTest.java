/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodecartas.core;

import jogodecartas.Carta;
import jogodecartas.estrutura.Pilhas;
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
public class RegrasGlobaisTest {

    public RegrasGlobaisTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Iniciando testes da classe RegrasGlobais... \n");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("\nTestes da classe RegrasGlobais finalizados.");
        System.out.println("bye");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public Carta geraCarta(Carta.Naipe naipe, Carta.Valor valor) {
        return new Carta(valor, naipe);
    }

    /**
     * Test of validaFundacaoDestino method, of class RegrasGlobais.
     */
    @Test
    public void testValidaFundacaoDestino() {
        System.out.println("\nTestando: validaFundacaoDestino() início");
        System.out.println(" > Envio carta diferente de REI para uma fundação vazia: ");
        Carta origem = geraCarta(Carta.Naipe.OUROS, Carta.Valor.DEZ);
        Pilhas fundacao = new Pilhas();
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = false;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.validaFundacaoDestino(origem, fundacao);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaFundacaoDestino method, of class RegrasGlobais.
     */
    @Test
    public void testValidaFundacaoDestinoCartaREI() {
        System.out.println(" > Envio um AS para uma fundação vazia: ");
        Carta origem = geraCarta(Carta.Naipe.OUROS, Carta.Valor.AS);
        Pilhas fundacao = new Pilhas();
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = true;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.validaFundacaoDestino(origem, fundacao);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of validaFileiraDestino method, of class RegrasGlobais.
     */
    @Test
    public void testValidaFileiraDestinoCartaMaior() {
        System.out.println("\nTestando: validaFileiraDestino() início");
        System.out.println(" > Mandando carta maior que a última carta da fileira");
        Carta carta = geraCarta(Carta.Naipe.PAUS, Carta.Valor.TRES);
        Pilhas fileira = new Pilhas();
        alimentaFileira(fileira);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = false;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.validaFileiraDestino(carta, fileira);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    public Pilhas alimentaFileira(Pilhas pilha) {
        Carta carta = geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS);
        pilha.push(carta);
        return pilha;
    }

    /**
     * Test of validaFileiraDestino method, of class RegrasGlobais.
     */
    @Test
    public void testValidaFileiraDestinoCartaMenor() {
        System.out.println(" > Mandando carta menor que a última carta da fileira");
        Carta carta = geraCarta(Carta.Naipe.PAUS, Carta.Valor.AS);
        Pilhas fileira = new Pilhas();
        alimentaFileira(fileira);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = true;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.validaFileiraDestino(carta, fileira);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of naipeDiferente method, of class RegrasGlobais.
     */
    @Test
    public void testNaipeIgual() {
        System.out.println("\nTestando: naipeDiferente() início");
        System.out.println(" > Duas cartas de naipes iguais");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS);
        Carta c2 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.DEZ);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = true;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.naipeIgual(c1, c2);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of naipeDiferente method, of class RegrasGlobais.
     */
    @Test
    public void testNaipeIgualCartasDiferentes() {
        System.out.println("\nTestando: naipeIgual() início");
        System.out.println(" > Duas cartas de naipes diferentes");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS);
        Carta c2 = geraCarta(Carta.Naipe.PAUS, Carta.Valor.DEZ);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = false;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.naipeIgual(c1, c2);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of naipeDiferente method, of class RegrasGlobais.
     */
    @Test
    public void testNaipeCorIgual() {
        System.out.println("\nTestando: naipeCorIgual() início");
        System.out.println(" > Duas cartas de naipes diferentes e da mesma cor");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS);
        Carta c2 = geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.DEZ);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = true;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.naipeCorIgual(c1, c2);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of naipeDiferente method, of class RegrasGlobais.
     */
    @Test
    public void testNaipeCorIgualComCoresDiferentes() {
        System.out.println(" > Duas cartas de naipes diferentes e de cores diferentes");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS);
        Carta c2 = geraCarta(Carta.Naipe.PAUS, Carta.Valor.DEZ);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = false;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.naipeCorIgual(c1, c2);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of cartaIsSequencia method, of class RegrasGlobais.
     */
    @Test
    public void testCartaIsSequencia() {
        System.out.println("\nTestando: cartaIsSequencia() início");
        System.out.println(" > Carta nova possui valor menor ao da carta de referência");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.TRES);
        Carta c2 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.QUATRO);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = false;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.cartaIsSequencia(c1, c2);
        assertEquals(expResult, result);
        System.out.println("  Resultado obtido: " + result);
    }

    /**
     * Test of cartaIsSequencia method, of class RegrasGlobais.
     */
    @Test
    public void testCartaIsSequenciaComCartaMenor() {
        System.out.println(" > Carta nova possui valor maior ao da carta de referência");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.CINCO);
        Carta c2 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.QUATRO);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = true;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.cartaIsSequencia(c1, c2);
        assertEquals(expResult, result);
        System.out.println("  Resultado obtido: " + result);
        System.out.println("fim");
    }

    /**
     * Test of cartaIsSequencia method, of class RegrasGlobais.
     */
    @Test
    public void testCartaIsAntecedente() {
        System.out.println("\nTestando: cartaIsAntecedente() início");
        System.out.println(" > Carta nova possui valor menor ao da carta referência.");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.TRES);
        Carta c2 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.QUATRO);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = true;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.cartaIsAntecedente(c1, c2);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of cartaIsSequencia method, of class RegrasGlobais.
     */
    @Test
    public void testCartaIsAntecedenteComCartaMaior() {
        System.out.println(" > Carta nova possui valor maior ao da carta referência.");
        Carta c1 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.QUATRO);
        Carta c2 = geraCarta(Carta.Naipe.OUROS, Carta.Valor.TRES);
        RegrasGlobais instance = new RegrasGlobais();
        boolean expResult = false;
        System.out.println("  Resultado esperado: " + expResult);
        boolean result = instance.cartaIsAntecedente(c1, c2);
        System.out.println("  Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }
}
