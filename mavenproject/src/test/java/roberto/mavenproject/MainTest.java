/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roberto.mavenproject;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto
 */
public class MainTest {
    
    public MainTest() {
    }

    /**
     * Test of sayHi method, of class Main.
     */
    @Test
    public void testSayHi() {
        Main main=new Main();
        String expected="Hi!";
        String actual=main.sayHi();
        
        assertEquals(expected, actual);
        
    }
    
}
