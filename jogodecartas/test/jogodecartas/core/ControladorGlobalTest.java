package jogodecartas.core;

import jogodecartas.Baralho;
import jogodecartas.Carta;
import jogodecartas.core.paciencia.Controle;
import jogodecartas.estrutura.Estoque;
import jogodecartas.estrutura.Fileira;
import jogodecartas.estrutura.Fundacao;
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
public class ControladorGlobalTest {

    Baralho baralho;

    public ControladorGlobalTest() {
        baralho = new Baralho();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Iniciando testes... \n");

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("\nTestes finalizados");
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
     * Testo enviar uma carta do descarte de valor vaior a outra carta
     * localizada em uma fileira. Neste caso o resultado esperado deve ser 1,
     * indicando que a carta foi inserida na fileira.
     */
    @Test
    public void testMoveDescarteToFileiraCartaAntecedente() {
        System.out.println("Testando: moveDescarteToFileira() início");
        Estoque estoque = new Estoque();
        System.out.println(" > Movendo carta menor do descarte para uma fileira");
        estoque.getDescarte().push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS));
        int idFileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFileiras().getFileiras().get(idFileira).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.AS));
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFileira(estoque, idFileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Testo enviar uma carta que do descarte sequencia de outra carta
     * localizada em uma fileira. Neste caso o resultado esperado deve ser 1,
     * indicando que a carta não pode ser inserida na fileira
     */
    @Test
    public void testMoveDescarteToFileiraCartaSubsequente() {
        System.out.println(" > Movendo carta de valor maior do descarte para uma fileira");
        Estoque estoque = new Estoque();
        estoque.getDescarte().push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS));
        int idFileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFileiras().getFileiras().get(idFileira).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.TRES));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFileira(estoque, idFileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Testo enviar uma carta que do descarte sequencia de outra carta
     * localizada em uma fileira vazia. Neste caso o resultado esperado deve ser 1,
     * indicando que a carta não pode ser inserida na fileira.
     */
    @Test
    public void testMoveDescarteToFileiraVazia() {
        System.out.println(" > Movendo carta do descarte para uma fileira vazia");
        Estoque estoque = new Estoque();
        estoque.getDescarte().push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS));
        int idFileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFileira(estoque, idFileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Testo enviar uma carta que do descarte sequencia de outra carta
     * localizada em uma fileira vazia. Neste caso o resultado esperado deve ser 1,
     * indicando que a carta não pode ser inserida na fileira.
     */
    @Test
    public void testMoveREIDescarteToFileiraVazia() {
        System.out.println(" > Movendo [REI de OUROS] do descarte para uma fileira vazia");
        Estoque estoque = new Estoque();
        estoque.getDescarte().push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.REI));
        int idFileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFileira(estoque, idFileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Testo enviar uma carta que do descarte, quando o mesmo está vazio
     * Neste caso o resultado esperado deve ser -1, indicando que o descarte
     * está vazio.
     */
    @Test
    public void testMoveDescarteVazioToFileira() {
        System.out.println(" > Tentando mover carta do descarte vazio para uma fileira");
        Estoque estoque = new Estoque();
        int idFileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        int expResult = -1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFileira(estoque, idFileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of moveDescarteFundacoes method, of class ControladorGlobal.
     */
    @Test
    public void testMoveDescarteFundacaoVazia() {
        System.out.println("Testando: moveDescarteFundacoes() início");
        System.out.println(" > Movendo [AS de ESPADAS] do descarte para uma fundacao vazia");
        Estoque descarte = new Estoque();
        descarte.getDescarte().push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.AS));
        int idFundacao = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFundacoes(descarte, idFundacao);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);

    }

    /**
     * Test of moveDescarteFundacoes method, of class ControladorGlobal.
     */
    @Test
    public void testMoveCartaDiferenteDeASDescarteToFundacaoVazia() {
        System.out.println(" > Movendo [REI de OUROS] do descarte para uma fundacao vazia");
        Estoque descarte = new Estoque();
        descarte.getDescarte().push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.REI));
        int idFundacao = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFundacoes(descarte, idFundacao);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveDescarteFundacoes method, of class ControladorGlobal.
     */
    @Test
    public void testMoveCartaMaiorDeNaipeDiferenteDescarteToFundacaoNaoVazia() {
        System.out.println(" > Movendo carta do descarte de naipe diferente para uma fundacao não vazia");
        Estoque descarte = new Estoque();
        descarte.getDescarte().push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.AS));
        descarte.getDescarte().push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.DOIS));
        int idFundacao = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFundacoes().getFundacoes().get(idFundacao).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.TRES));
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveDescarteFundacoes(descarte, idFundacao);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of moveFundacaoToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveFundacaoToFileira() {
        System.out.println("Testando: moveFundacaoToFileira() início");
        System.out.println(" > Movendo carta menor da fundação para fileira");
        int fundacao = 0;
        int fileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.AS));
        instance.getControleFileiras().getFileiras().get(fileira).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.DOIS));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFundacaoToFileira(fundacao, fileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFundacaoToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveFundacaoToFileiraVazia() {
        System.out.println(" > Movendo carta da Fundação para Fileira vazia");
        int fundacao = 0;
        int fileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.AS));
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFundacaoToFileira(fundacao, fileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFundacaoToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveFundacaoVaziaToFileira() {
        System.out.println(" > Movendo carta da Fundação vazia para Fileira");
        int fundacao = 0;
        int fileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFileiras().getFileiras().get(fileira).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.DOIS));
        int expResult = -1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFundacaoToFileira(fundacao, fileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFundacaoToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveREIFundacaoToFileiraVazia() {
        System.out.println(" > Movendo carta REI da Fundação vazia para Fileira vazia");
        int fundacao = 0;
        int fileira = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.REI));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFundacaoToFileira(fundacao, fileira);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of moveFileiraToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveFileiraToFileira() {
        System.out.println("Testando: moveFileiraToFileira() início");
        System.out.println(" > Movendo uma carta entre duas fileiras");
        int origem = 1;
        int destino = 0;
        int profundidade = 1;
        ControladorGlobal instance = new ControladorGlobal(2, 1);
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.DEZ));
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.NOVE));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.COPAS, Carta.Valor.NOVE));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.OITO));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFileira(origem, destino, profundidade);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveDuasCartasFileiraToFileira() {
        System.out.println(" > Movendo duas carta entre duas fileiras");
        int origem = 1;
        int destino = 0;
        int profundidade = 2;
        ControladorGlobal instance = new ControladorGlobal(2, 1);
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.DEZ));
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.NOVE));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.OITO));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.COPAS, Carta.Valor.SETE));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFileira(origem, destino, profundidade);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveCincoCartasFileiraToFileira() {
        System.out.println(" > Movendo duas carta entre duas fileiras");
        int origem = 1;
        int destino = 0;
        int profundidade = 5;
        ControladorGlobal instance = new ControladorGlobal(2, 1);
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.REI));
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.DAMA));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.VALETE));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.COPAS, Carta.Valor.DEZ));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.NOVE));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.OITO));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.COPAS, Carta.Valor.SETE));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFileira(origem, destino, profundidade);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveDuasCartasFileiraToFileiraNaipesMesmaCor() {
        System.out.println(" > Movendo duas carta entre duas fileiras com naipes de mesma cor");
        int origem = 1;
        int destino = 0;
        int profundidade = 2;
        ControladorGlobal instance = new ControladorGlobal(2, 1);
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.DEZ));
        instance.getControleFileiras().getFileiras().get(destino).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.NOVE));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.COPAS, Carta.Valor.OITO));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.SETE));
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFileira(origem, destino, profundidade);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveDuasCartasFileiraToFileiraVazia() {
        System.out.println(" > Movendo duas carta de uma fileira para outra vazia");
        int origem = 1;
        int destino = 0;
        int profundidade = 3;
        ControladorGlobal instance = new ControladorGlobal(2, 1);
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.COPAS, Carta.Valor.REI));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.DAMA));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.VALETE));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFileira(origem, destino, profundidade);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFileira method, of class ControladorGlobal.
     */
    @Test
    public void testMoveDuasCartasFileiraToFileiraVaziaErrado() {
        System.out.println(">> Movendo duas carta de uma fileira para outra vazia");
        int origem = 1;
        int destino = 0;
        int profundidade = 2;
        ControladorGlobal instance = new ControladorGlobal(2, 1);
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.COPAS, Carta.Valor.DEZ));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.ESPADAS, Carta.Valor.NOVE));
        instance.getControleFileiras().getFileiras().get(origem).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.OITO));
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFileira(origem, destino, profundidade);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

    /**
     * Test of moveFileiraToFundacao method, of class ControladorGlobal.
     */
    @Test
    public void testMoveFileiraToFundacao() {
        System.out.println("Testando: moveFileiraToFundacao() início");
        System.out.println(" > Enviando carta [AS de OUROS] da fileira para uma fundação vazia");
        int fileira = 0;
        int fundacao = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFileiras().getFileiras().get(fileira).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.AS));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFundacao(fileira, fundacao);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFundacao method, of class ControladorGlobal.
     */
    @Test
    public void testMoveCartaErradaFileiraToFundacaoVazia() {
        System.out.println("Testando: moveFileiraToFundacao() início");
        System.out.println(" > Enviando carta [REI de OUROS] da fileira para uma fundação vazia");
        int fileira = 0;
        int fundacao = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFileiras().getFileiras().get(fileira).push(geraCarta(Carta.Naipe.OUROS, Carta.Valor.REI));
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFundacao(fileira, fundacao);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFundacao method, of class ControladorGlobal.
     */
    @Test
    public void testMoveCartaErradaFileiraToFundacao() {
        System.out.println("Testando: moveFileiraToFundacao() início");
        System.out.println(" > Enviando carta [DEZ de PAUS] da fileira para uma fundação com 3 cartas");
        int fileira = 0;
        int fundacao = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFileiras().getFileiras().get(fileira).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.DEZ));
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.AS));
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.DOIS));
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.TRES));
        int expResult = 1;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFundacao(fileira, fundacao);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of moveFileiraToFundacao method, of class ControladorGlobal.
     */
    @Test
    public void testMoveCartaFileiraToFundacao() {
        System.out.println("Testando: moveFileiraToFundacao() início");
        System.out.println(" > Enviando carta [QUATRO de PAUS] da fileira para uma fundação com 3 cartas");
        int fileira = 0;
        int fundacao = 0;
        ControladorGlobal instance = new ControladorGlobal(1, 1);
        instance.getControleFileiras().getFileiras().get(fileira).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.QUATRO));
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.AS));
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.DOIS));
        instance.getControleFundacoes().getFundacoes().get(fundacao).push(geraCarta(Carta.Naipe.PAUS, Carta.Valor.TRES));
        int expResult = 0;
        System.out.println("Resultado esperado: " + expResult);
        int result = instance.moveFileiraToFundacao(fileira, fundacao);
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of completou method, of class ControladorGlobal.
     */
    @Test
    public void testCompletou() {
        System.out.println("Testando: completou() início");
        System.out.println(" > Com as fundações completas, eu verifico se o jogo terminou");
        baralho.novoBaralho();
        ControladorGlobal instance = new ControladorGlobal(1, 4);
        for (int i = 0; i < instance.getControleFundacoes().getFundacoes().size(); i++) {
            for (int j = 0; j < 13; j++) {
                instance.getControleFundacoes().getFundacoes().get(i).push(baralho.getBaralho().get(i * j));
            }
        }
        boolean expResult = true;
        System.out.println("Resultado esperado: " + expResult);
        boolean result = instance.completou();
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of completou method, of class ControladorGlobal.
     */
    @Test
    public void testCompletouFundacoesVazias() {
        System.out.println("Testando: completou() início");
        System.out.println(" > Com as fundações vazias, eu verifico se o jogo terminou");
        baralho.novoBaralho();
        ControladorGlobal instance = new ControladorGlobal(1, 4);        
        boolean expResult = false;
        System.out.println("Resultado esperado: " + expResult);
        boolean result = instance.completou();
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of completou method, of class ControladorGlobal.
     */
    @Test
    public void testCompletouFundacoesIncompletas() {
        System.out.println("Testando: completou() início");
        System.out.println(" > Com as fundações incompletas, eu verifico se o jogo terminou");
        baralho.novoBaralho();
        ControladorGlobal instance = new ControladorGlobal(1, 4);
        for (int i = 0; i < instance.getControleFundacoes().getFundacoes().size(); i++) {
            for (int j = 0; j < 8; j++) {
                instance.getControleFundacoes().getFundacoes().get(i).push(baralho.getBaralho().get(i * j));
            }
        }
        boolean expResult = false;
        System.out.println("Resultado esperado: " + expResult);
        boolean result = instance.completou();
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of completou method, of class ControladorGlobal.
     */
    @Test
    public void testCompletouUmaFundacaoCompleta() {
        System.out.println("Testando: completou() início");
        System.out.println(" > Com uma fundação completas, eu verifico se o jogo terminou");
        baralho.novoBaralho();
        ControladorGlobal instance = new ControladorGlobal(1, 4);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 13; j++) {
                instance.getControleFundacoes().getFundacoes().get(i).push(baralho.getBaralho().get(i * j));
            }
        }
        boolean expResult = false;
        System.out.println("Resultado esperado: " + expResult);
        boolean result = instance.completou();
        System.out.println("Resultado obtido: " + result);
        assertEquals(expResult, result);
        System.out.println("fim");
    }

}
