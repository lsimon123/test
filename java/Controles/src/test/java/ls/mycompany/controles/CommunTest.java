/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ls.mycompany.controles;

import ls.mycompany.controles.Commun;
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
public class CommunTest {
    
    public CommunTest() {
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
     * Test of resteDivision method, of class Commun.
     */
    @Test
    public void testResteDivision_String_int() {
        System.out.println("resteDivision");
        String nombre = "1996230911";
        int diviseur = 97;
        int expResult = 11;
        int result = Commun.resteDivision(nombre, diviseur);
        assertEquals(expResult, result);
    }

    /**
     * Test of resteDivision method, of class Commun.
     */
    @Test
    public void testResteDivision_int_int() {
        System.out.println("resteDivision");
        int nombre = 1996230911;
        int diviseur = 97;
        int expResult = 11;
        int result = Commun.resteDivision(nombre, diviseur);
        assertEquals(expResult, result);
    }

    /**
     * Test of modulo97 method, of class Commun.
     */
    @Test
    public void testModulo97_String() {
        System.out.println("modulo97");
        String nombre = "1996230911";
        int expResult = 11;
        int result = Commun.modulo97(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of modulo97 method, of class Commun.
     */
    @Test
    public void testModulo97_int() {
        System.out.println("modulo97");
        int nombre = 1996230911;
        int expResult = 11;
        int result = Commun.modulo97(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of moduloComplement97 method, of class Commun.
     */
    @Test
    public void testModuloComplement97_String() {
        System.out.println("moduloComplement97");
        String nombre = "660401123";
        int expResult = 97;
        int result = Commun.moduloComplement97(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of moduloComplement97 method, of class Commun.
     */
    @Test
    public void testModuloComplement97_int() {
        System.out.println("moduloComplement97");
        int nombre = 660401123;
        int expResult = 97;
        int result = Commun.moduloComplement97(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class Commun.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Commun.main(args);
//    }
    
}
