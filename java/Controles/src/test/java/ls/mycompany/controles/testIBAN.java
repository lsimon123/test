package ls.mycompany.controles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class testIBAN {
    
    public testIBAN() {
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
    public void testIban(){
        assertTrue("BE71377045833769".equals(IBAN.filtreChar("BE71 3770 4583 3769")));
        assertTrue("BE71377045833769".equals(IBAN.filtreChar("be71 3770 4583 3769")));
        assertTrue("BE71377045833769".equals(IBAN.filtreChar("be71 37('à70 4583 3769")));
        assertTrue("".equals(IBAN.filtreChar("('à")));
    }
}
