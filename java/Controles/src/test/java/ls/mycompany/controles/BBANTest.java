/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ls.mycompany.controles;

import ls.mycompany.controles.BBAN;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ls
 */
public class BBANTest {
    
    public BBANTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of check method, of class BBAN.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        String nombre = "377-0458357-69";
        boolean expResult = true;
        boolean result = BBAN.check(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of filtreChar method, of class BBAN.
     */
    @Test
    public void testFiltreChar() {
        System.out.println("filtreChar");
        String numero = "377-0458357-69";
        String expResult = "377045835769";
        String result = BBAN.filtreChar(numero);
        assertEquals(expResult, result);
    }

    /**
     * Test of toIban method, of class BBAN.
     */
    @Test
    public void testToIban() {
        System.out.println("toIban");
        String numero = "377-0458357-69";
        String expResult = "BE71377045835769";
        String result = BBAN.toIban(numero);
        assertEquals(expResult, result);
    }
    
}
