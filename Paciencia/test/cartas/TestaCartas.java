/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import paciencia.Carta;
import static org.junit.Assert.*;

/**
 *
 * @author joaocarlos
 */
public class TestaCartas {

    public TestaCartas() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaViraCarta() {
        Carta x = new Carta();

        x.setStatus(true);
        x.viraCarta(x);
        assertFalse(x.isStatus());
    }

    @Test
    public void testaGeraCarta() {
        int i = 0;
        boolean test;

        test = geraCartaAux();
        assertEquals(true, test);      
    }

    public boolean geraCartaAux() {
        Carta carta = new Carta();
        boolean a = false;

        for (int i = 0; i < 52; i++) {
            carta = carta.geraCarta();
            if (carta.getValor() >= 1 && carta.getValor() <= 13) {
                a = true;
            } else {
                a = false;
            }
        }
        return a;
    }
}
