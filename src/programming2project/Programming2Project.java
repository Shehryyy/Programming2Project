/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programming2project;

import java.io.*;
import java.util.*;

/**
 *
 * @author Shahe
 */
public class Programming2Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InvalidPhoneNumber {

        Scanner input = new Scanner(System.in);
        int remainingTries = 4;
        Menu m = new Menu();
        Staff s = new Staff();

        while (remainingTries > 0) {
            System.out.print("Enter password: ");
            int password = input.nextInt();
            boolean isValid = isValidPassword(password, remainingTries);
            if (isValid) {
                System.out.println("\nAccess granted! Welcome " + s.getStaffName());
                m.presentMenu();
                break; // Exit loop after successful login
            } else {
                remainingTries--;
            }
        }
        if (remainingTries == 0) {
            System.out.println("Sorry, you have reached the maximum number of failed login attempts.");
        }
    }

    public static boolean isValidPassword(int password, int remainingTries) {
        if (password == Staff.getStaffPassword()) {
            return true; // Password is correct
        } else {
            if (remainingTries > 1) {
                System.out.println("Incorrect password! Please try again (" + (remainingTries - 1) + " remaining)");
            }
            return false;
        }
    }
}
