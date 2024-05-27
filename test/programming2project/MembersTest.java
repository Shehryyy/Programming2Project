/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package programming2project;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shahe
 */
public class MembersTest {
    
    public MembersTest() {
    }
    /**
     * Test of isPhoneNumberValid method, of class Members.
     */
    @Test
    public void testIsPhoneNumberValid() throws Exception {
        System.out.println("isPhoneNumberValid");
        String phoneNumber = "514-345-9375";
        boolean expResult = true;
        boolean result = Members.isPhoneNumberValid(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
