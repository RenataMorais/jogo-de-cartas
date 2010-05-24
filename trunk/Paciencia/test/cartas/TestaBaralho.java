/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cartas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;  
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import paciencia.Baralho;
import paciencia.Carta;
import static org.junit.Assert.*;

/**
 *
 * @author joaocarlos
 */
public class TestaBaralho {
    Baralho baralho = new Baralho();

    public TestaBaralho() {
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
    public void testaGeraBaralho() {
        Stack<Carta> pilha = new Stack<Carta>();
        Baralho p1 = new Baralho();
        Collection<Carta> b1 = new ArrayList<Carta>();
        boolean verify;

        pilha = p1.produzBaralho();
        verify = testaBaralhoAux(pilha);
        assertEquals(true,verify);

    }
    public Carta[] converteBaralhoEmArray(Stack<Carta> pilha){
        Carta[] aux = new Carta[52];
        Carta carta = new Carta();
        int i = 0;

        while(i < 52){
            carta = pilha.pop();
            aux[i] = carta;
            i++;
        }
        
        return aux;
    }

    public boolean testaBaralhoAux(Stack<Carta> pilha) {
        Carta carta = new Carta();

        carta.setNaipe(1);
        carta.setValor(1);
        return pilha.contains(carta);
//        for(int i = 1; i < 5; i++){
//            for(int j = 1; j < 14; j++){
//                carta.setNaipe(i);
//                carta.setValor(j);
//                carta.setStatus(false);
//                b1.add(carta);
//            }
//        }
    }
}