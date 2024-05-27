/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package programming2project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shahe
 */
public class Programming2ProjectTest {
    
    public Programming2ProjectTest() {
    }

    /**
     * Test of isValidPassword method, of class Programming2Project.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        int password = 0;
        int remainingTries = 2;
        boolean expResult = false;
        boolean result = Programming2Project.isValidPassword(password, remainingTries);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
       /**
     * Test of isValidPassword method, of class Programming2Project.
     */
    @Test
    public void testIsValidPassword2() {
        System.out.println("isValidPassword");
        int password = 9814; //password is 9814 so it will return true
        int remainingTries = 2; 
        boolean expResult = true;
        boolean result = Programming2Project.isValidPassword(password, remainingTries);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
