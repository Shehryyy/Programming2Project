/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Shahe
 */
public class Menu {

    private String memberName;
    private String memberAddress;
    private String memberPhoneNumber;
    private String membershipType;
    private String payment;

    PaymentMethods c1 = new CashPayment();
    PaymentMethods c2 = new CreditCardPayment();
    Members m = new Members();

    public String presentMenu() throws IOException, InvalidPhoneNumber {
        try {
            System.out.println(""" 
                         Choose one of the following options: 
                         1. Membership Options 
                         2. New Member 
                         3. Recommendations 
                         4. Rules
                         5. Cancelling Membership
                         6. Balance
                         7. Transactions
                         8. Exit
                         Enter your choice: """);
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    MembershipTypes(); //calls this method to show the perks of both membership
                    break;
                case 2:
                    newMember(); //calls this method to create a new method
                    break;
                case 3:
                    Recommendations(); //calls this method to help user show which machine to use for specific body part
                    break;
                case 4:
                    Rules(); // shows the gym rule
                    break;
                case 5:
                    cancel(); //calls this method to cancel a existing membership
                    break;
                case 6:
                    balance(); //calls this method to show the balance
                    break;
                case 7:
                    transactions(); //calls this method to show transactions
                    break;
                case 8:
                    System.exit(0); //ends the system
                    break;
                default:
                    presentMenu(); //any other number inserted that is not between 1-8 will present the menu again
            }
        } catch (InputMismatchException iom) {
            presentMenu();
        }
        return "";
    }

    public void MembershipTypes() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        regularMembership rm = new regularMembership();
        premiumMembership pm = new premiumMembership();
        System.out.println("\n" + rm.toString());
        System.out.println("-----------------------------------");
        System.out.println(pm.toString());
        System.out.println("\nPress [1] to go back");
        switch (input.nextInt()) {
            case 1:
                presentMenu();
                break;
            default:
                presentMenu();
                break;
        }
    }

    public void newMember() throws IOException, InvalidPhoneNumber {
        memberName = "";
        memberAddress = "";
        memberPhoneNumber = "";
        membershipType = "";

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        memberName();

        System.out.println("Enter your address: ");
        memberAddress();

        System.out.println("Enter your phone number (xxx-xxx-xxxx): ");
        memberPhoneNumber();

        try {
            System.out.println("Enter which membership you would want to buy (Regular or Premium)");
            membershipType = input.next();
            if (!membershipType.toLowerCase().equals("regular") && !membershipType.toLowerCase().equals("premium")) {
                throw new IllegalArgumentException("Invalid membership type");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Enter a valid choice");
            System.out.println("Which membership you would want to buy (Regular or Premium)");
            membershipType = input.next();
            while (!membershipType.toLowerCase().equalsIgnoreCase("regular") && !membershipType.toLowerCase().equalsIgnoreCase("premium")) {
                membershipType = input.next();
            }
        }
        payment();
    }

    public String memberName() {
        Scanner input = new Scanner(System.in);
        memberName += input.nextLine();

        return memberName;
    }

    public String memberAddress() {
        Scanner input = new Scanner(System.in);
        memberAddress += input.nextLine();

        return memberAddress;
    }

    public String memberPhoneNumber() throws InvalidPhoneNumber, IOException {
        Scanner input = new Scanner(System.in);
        memberPhoneNumber += input.next();

        try {
            if (Members.isPhoneNumberValid(memberPhoneNumber)) {
                return memberPhoneNumber;
            }
        } catch (InvalidPhoneNumber ipn) {
            System.out.println(ipn.getMessage() + "\n");
            newMember();
        }
        return "";
    }

    public String payment() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                         Choose one of the payment options: 
                         1. Monthly
                         2. Yearly
                         Enter your choice: """);
        switch (input.nextInt()) {
            case 1:
                System.out.println(""" 
                         Choose one of the payment options: 
                         1. Cash
                         2. Credit card
                         Enter your choice: """);
                switch (input.nextInt()) {
                    case 1:
                        if (membershipType.equalsIgnoreCase("regular")) {
                            c1.makePayment(15);
                        } else if (membershipType.equalsIgnoreCase("premium")) {
                            c1.makePayment(22.10);
                        }
                        payment += c1.toString();
                        status();
                        break;
                    case 2:
                        System.out.println("Enter the 12 digits:");
                        String cardNumber = input.next();
                        System.out.println("Enter the expiration date (MM/YY):");
                        String cardExp = input.next();
                        if (isValidCreditCardNumber(cardNumber) && isValidExpirationDate(cardExp)) {
                            System.out.println("\nCredit card is valid\n");
                            if (membershipType.equalsIgnoreCase("regular")) {
                                c2.makePayment(15);
                            } else if (membershipType.equalsIgnoreCase("premium")) {
                                c2.makePayment(22.10);
                            }
                        } else {
                            System.out.println("\nCredit card is not valid\n");
                            payment();
                        }
                        payment += c2.toString();
                        status();
                        break;
                    default:
                        payment();
                        break;
                }
            case 2:
                System.out.println(""" 
                         Choose one of the payment options: 
                         1. Cash
                         2. Credit card
                         Enter your choice: """);
                switch (input.nextInt()) {
                    case 1:
                        if (membershipType.equalsIgnoreCase("regular")) {
                            c1.makePayment(180);
                        } else if (membershipType.equalsIgnoreCase("premium")) {
                            c1.makePayment(265);
                        }
                        payment += c1.toString();
                        status();
                        break;
                    case 2:
                        System.out.println("Enter the 12 digits:");
                        String cardNumber = input.next();
                        System.out.println("Enter the expiration date (MM/YY):");
                        String cardExp = input.next();
                        if (isValidCreditCardNumber(cardNumber) && isValidExpirationDate(cardExp)) {
                            System.out.println("\nCredit card is valid\n");
                            if (membershipType.equalsIgnoreCase("regular")) {
                                c2.makePayment(180);
                            } else if (membershipType.equalsIgnoreCase("premium")) {
                                c2.makePayment(265);
                            }
                        } else {
                            System.out.println("\nCredit card is not valid\n");
                            payment();
                        }
                        payment += c2.toString();
                        status();
                        break;
                    default:
                        payment();
                }
            default:
                payment();
                break;

        }
        return "";
    }

    public void status() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        Members m = new Members();
        m.setName(memberName);
        m.setAddress(memberAddress);
        m.setPhoneNumber(memberPhoneNumber);
        m.setType(membershipType);
        Members.addMembers(m); //Everytime a new member is added it creates a file of that member info
        System.out.println(m.toString());
        System.out.println("-----------------");
        System.out.println("""
                                   1. back to menu 
                                   2. exit""");
        switch (input.nextInt()) {
            case 1:
                presentMenu();
                break;
            case 2:
                System.exit(0);
            default:
                System.exit(0);
        }
    }

    public void Recommendations() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        System.out.println(""" 
                         Choose which body part do you want to work out?: 
                         1. Chest
                         2. Shoulders
                         3. Back
                         4. Arms
                         5. Legs
                         6. Body fat
                         7. To go back
                         8. Exit
                         Enter your choice: """);
        switch (input.nextInt()) {
            case 1:
                System.out.println("""
                                   
                                   Bench press
                                   Cable crossover
                                   Machine chest press
                                   Machine fly
                                   """);
                System.out.println("press 1 to go back");
                switch (input.nextInt()) {
                    case 1 ->
                        Recommendations();
                    default ->
                        Recommendations();
                }

            case 2:
                System.out.println("""
                                   
                                   Push-Press
                                   Seated dumbbell press
                                   Lateral raise
                                   Front raise
                                   """);
                System.out.println("press 1 to go back");
                switch (input.nextInt()) {
                    case 1 ->
                        Recommendations();
                    default ->
                        Recommendations();
                }

            case 3:
                System.out.println("""
                                   
                                   Pull up
                                   Deadlift
                                   Pull down
                                   Seated row
                                   """);
                System.out.println("press 1 to go back");
                switch (input.nextInt()) {
                    case 1 ->
                        Recommendations();
                    default ->
                        Recommendations();
                }

            case 4:
                System.out.println("""
                                   
                                   Barbell curl
                                   Dip
                                   Hammer curl
                                   Cable tricep pushdown
                                   """);
                System.out.println("press 1 to go back");
                switch (input.nextInt()) {
                    case 1 ->
                        Recommendations();
                    default ->
                        Recommendations();
                }

            case 5:
                System.out.println("""
                                   
                                   Barbell back squat
                                   Hack squat
                                   Lunge
                                   Leg press
                                   """);
                System.out.println("press 1 to go back");
                switch (input.nextInt()) {
                    case 1 ->
                        Recommendations();
                    default ->
                        Recommendations();
                }

            case 6:
                System.out.println("""
                                   
                                   Treadmills
                                   Exercise bike
                                   Stair climber
                                   Rowing machine
                                   """);
                System.out.println("press 1 to go back");
                switch (input.nextInt()) {
                    case 1 ->
                        Recommendations();
                    default ->
                        Recommendations();
                }

            case 7:
                presentMenu();
                break;
            case 8:
                System.exit(0);
            default:
                Recommendations();
                break;

        }
    }

    public void Rules() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        System.out.println(""
                + "- Sanitize equipment after use\n"
                + "- Return weights after use\n"
                + "- Lock your valuables in the locker (We are not responsible for your belongings)\n"
                + "- Never slam or drop weights\n"
                + "- Always bring a towel and a water bottle\n"
                + "- Be respectful\n"
                + "- Press [1] to go back");
        switch (input.nextInt()) {
            case 1:
                presentMenu();
                break;
            default:
                presentMenu();
                break;
        }

    }

    public void cancel() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the member ID: ");
        int Id = input.nextInt();
        boolean found = false;
        for (int i = 0; i < Members.getMembers().size(); i++) {
            if (Members.getMembers().get(i).getID() == Id) {
                Members.removeMembers(Members.getMembers().get(i));
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Membership has successfully been cancelled.");
            System.out.println("Press [1] to go back");
            switch (input.nextInt()) {
                case 1:
                    presentMenu();
                    break;
                default:
                    presentMenu();
                    break;
            }
        } else {
            System.out.println("No member found with that ID.");
            System.out.println("""
                                   1. back to menu 
                                   2. Try again""");
            switch (input.nextInt()) {
                case 1:
                    presentMenu();
                    break;
                case 2:
                    cancel();
                    break;
                default:
                    presentMenu();
                    break;
            }
        }
        presentMenu();
    }

    public void balance() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("Press [1] to go back");
        switch (input.nextInt()) {
            case 1:
                presentMenu();
                break;
            default:
                presentMenu();
                break;
        }
    }

    public void transactions() throws IOException, InvalidPhoneNumber {
        Scanner input = new Scanner(System.in);
        System.out.println("Transactions: ");
        if (PaymentMethods.getTransactions().isEmpty()) {
            System.out.println("No transactions has been made");
            System.out.println("Press [1] to go back");
            switch (input.nextInt()) {
                case 1:
                    presentMenu();
                    break;
                default:
                    presentMenu();
                    break;
            }
        } else {
            System.out.println(PaymentMethods.getTransactions());
            System.out.println("Press [1] to go back");
            switch (input.nextInt()) {
                case 1:
                    presentMenu();
                    break;
                default:
                    presentMenu();
                    break;
            }
        }
    }

    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        if (creditCardNumber.length() != 12) {
            return false;
        } else {
            for (int i = 0; i < creditCardNumber.length(); i++) {
                if (Character.isDigit(creditCardNumber.charAt(i))) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static boolean isValidExpirationDate(String expirationDate) {
        if (expirationDate.length() != 5 || expirationDate.charAt(2) != '/') {
            return false;
        }

        int month = Integer.parseInt(expirationDate.substring(0, 2));
        int year = Integer.parseInt(expirationDate.substring(3));

        return month >= 1 && month <= 12 && year >= 24 && year <= 99;
    }
}
