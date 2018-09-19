/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ls.mycompany.controles;

import ls.mycompany.controles.IBAN;
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
public class IBANTest {
    
    public IBANTest() {
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
     * Test of filtreChar method, of class IBAN.
     */
    @Test
    public void testFiltreChar() {
        System.out.println("filtreChar");
        String numero = "BE71 3770 4583 3769";
        String expResult = "BE71377045833769";
        String result = IBAN.filtreChar(numero);
        assertEquals(expResult, result);
    }
    @Test
    public void testFiltreChar2() {
        System.out.println("filtreChar");
        String numero = "be71 3770 4583 3769";
        String expResult = "BE71377045833769";
        String result = IBAN.filtreChar(numero);
        assertEquals(expResult, result);
    }

    /**
     * Test of check method, of class IBAN.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        String number = "BE71377045835769";
        boolean expResult = true;
        boolean result = IBAN.check(number);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheck2() {
        System.out.println("check");
        String number = "GB87 BARC 2065 8244 9716 55";
        boolean expResult = true;
        boolean result = IBAN.check(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertirLettreEnChiffre method, of class IBAN.
     */
    @Test
    public void testConvertirLettreEnChiffre() {
        System.out.println("convertirLettreEnChiffre");
        String nombre = "BE199";
        String expResult = "1114199";
        String result = IBAN.convertirLettreEnChiffre(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculModulo method, of class IBAN.
     */
//    @Test
//    public void testCalculModulo_String_String() {
//        System.out.println("calculModulo");
//        String pays = "BE";
//        String numero = "377045835769";
//        String expResult = "71";
//        String result = IBAN.calculModulo(pays, numero);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of calculModulo method, of class IBAN.
     */
    @Test
    public void testCalculModulo_String() {
        System.out.println("calculModulo");
        String numero = "BE71377045835769";
        String expResult = "71";
        String result = IBAN.calculModulo(numero);
        assertEquals(expResult, result);
    }

    /**
     * Test of format method, of class IBAN.
     */
    @Test
    public void testFormat() {
        System.out.println("format");
        String numero = "BE71377045835769";
        String expResult = "BE71 3770 4583 5769";
        String result = IBAN.format(numero);
        assertEquals(expResult, result);
    }

    /**
     * Test of toBban method, of class IBAN.
     */
    @Test
    public void testToBban() {
        System.out.println("toBban");
        String numero = "BE71377045835769";
        String expResult = "377045835769";
        String result = IBAN.toBban(numero);
        assertEquals(expResult, result);
    }
    
}
