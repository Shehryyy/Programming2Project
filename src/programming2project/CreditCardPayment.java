/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

/**
 *
 * @author Shahe
 */
public class CreditCardPayment extends PaymentMethods{

    public CreditCardPayment() {
        super();
    }
        
    @Override
    public void makePayment(double amount) {
        balance -= amount;
      addTransaction(amount);  
    }
    
    @Override
    public String toString() {
        return "Credit Card Balance: " + getBalance();
    }
}
