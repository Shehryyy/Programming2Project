/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

/**
 *
 * @author Shahe
 */
public class CashPayment extends PaymentMethods{

    public CashPayment() {
        super();
    }

    @Override
    public void makePayment(double amount) {
      balance -= amount;
      addTransaction(amount);  
    }
    
    
    
     @Override
    public String toString() {
        return "Cash Balance: " + getBalance();
    }
   
    
    
    
}
