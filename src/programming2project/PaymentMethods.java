/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

import java.util.*;

/**
 *
 * @author Shahe
 */
public abstract class PaymentMethods extends Payment {

    protected double balance = 0;
    protected static ArrayList<Double> transactions;

    public PaymentMethods() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    public void addTransaction(double amount) {
        transactions.add(-amount);
    }

    public static ArrayList<Double> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return balance;
    }
   

}
