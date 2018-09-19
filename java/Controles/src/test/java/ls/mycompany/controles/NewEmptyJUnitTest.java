package ls.mycompany.controles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testDivision(){
        int r = Commun.resteDivision("1996230911", 97);
        assertTrue("Dision ok", r == 11);
        
        
        assertTrue(Commun.resteDivision("1996230911", 97)==11);
        assertTrue(Commun.resteDivision("3770458357", 97)==69);
        assertTrue(Commun.modulo97("1996230911")==11);
        assertTrue(Commun.modulo97("3770458357")==69);
        assertTrue(Commun.moduloComplement97("660401123")==97);
        assertTrue(Commun.moduloComplement97("660401124")==96);
        assertTrue(Commun.moduloComplement97("660401122")==1);
    }
}
