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
public class MenuTest {
    
    public MenuTest() {
    }

    /**
     * Test of isValidCreditCardNumber method, of class Menu.
     */
    @Test
    public void testIsValidCreditCardNumber() {
        System.out.println("isValidCreditCardNumber");
        String creditCardNumber = "1234567891"; //it only has 10 digits not 12
        boolean expResult = false;
        boolean result = Menu.isValidCreditCardNumber(creditCardNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
      @Test
    public void testIsValidCreditCardNumber2() {
        System.out.println("isValidCreditCardNumber");
        String creditCardNumber = "123456789123"; //it has 12 digits so it will return true
        boolean expResult = true;
        boolean result = Menu.isValidCreditCardNumber(creditCardNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isValidExpirationDate method, of class Menu.
     */
    @Test
    public void testIsValidExpirationDate() {
        System.out.println("isValidExpirationDate");
        String expirationDate = "12/22"; //card is expired
        boolean expResult = false;
        boolean result = Menu.isValidExpirationDate(expirationDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
        /**
     * Test of isValidExpirationDate method, of class Menu.
     */
    @Test
    public void testIsValidExpirationDate2() {
        System.out.println("isValidExpirationDate");
        String expirationDate = "0/22"; // 0 as month does not count
        boolean expResult = false;
        boolean result = Menu.isValidExpirationDate(expirationDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
      
        /**
     * Test of isValidExpirationDate method, of class Menu.
     */
    @Test
    public void testIsValidExpirationDate3() {
        System.out.println("isValidExpirationDate");
        String expirationDate = "12/24"; //valid expiration date
        boolean expResult = true;
        boolean result = Menu.isValidExpirationDate(expirationDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
}
