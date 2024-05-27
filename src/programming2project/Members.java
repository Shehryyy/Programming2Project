/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

import java.io.*;
import java.util.*;

/**
 *
 * @author Shahe
 */
public class Members {

    private static ArrayList<Members> members = new ArrayList<>();
    private String name;
    private String address;
    private String phoneNumber;
    private String type;
    private static int counter = 10000;
    private int ID;

    public Members() {
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
    }

    public Members(String name, String address, String phoneNumber, String type) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public static void addMembers(Members m) throws IOException {
        members.add(m);
        MemberFile(m);
    }

    public static void removeMembers(Members m) {
        members.remove(m);
    }

    public static ArrayList<Members> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.ID = ++counter;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private static void MemberFile(Members members) throws IOException {
        String filename = members.getID() + ".ser";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Name : " + members.getName() + "\n");
            writer.write("Address : " + members.getAddress() + "\n");
            writer.write("Phone number : " + members.getPhoneNumber() + "\n");
        }catch(IOException ioe){
            ioe.printStackTrace();

        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.address);
        hash = 17 * hash + Objects.hashCode(this.phoneNumber);
        hash = 17 * hash + Objects.hashCode(this.type);
        hash = 17 * hash + this.ID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Members other = (Members) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    public static boolean isPhoneNumberValid(String phoneNumber) throws InvalidPhoneNumber {
        try {
            if (phoneNumber.length() != 12) {
                throw new InvalidPhoneNumber("\nInvalid phone number format");
            }
            for (int i = 0; i < phoneNumber.length(); i++) {
                char c = phoneNumber.charAt(i);
                if (i == 3 || i == 7) {
                    if (c != '-') {
                        throw new InvalidPhoneNumber("Invalid phone number format please try again\n");
                    }
                } else {
                    if (!Character.isDigit(c)) {
                        throw new InvalidPhoneNumber("Invalid phone number format please try again\n");
                    }
                }
            }
            return true;
        } catch (InvalidPhoneNumber ipn) {
            throw new InvalidPhoneNumber("\nInvalid phone number format please try again");
        }
    }
    
  public static boolean serialize(Members m) {
        File file = new File("Project.ser");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Members> DeserializeList(String path) {
        Object obj = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            ObjectInputStream oos = new ObjectInputStream(fis);
            obj = oos.readObject();
        } catch (Exception e) {
            System.out.println("");
            return null;
        }
        return (ArrayList<Members>) obj;
    }


    @Override
    public String toString() {
        String str = "";
        str += "Member Info \n";
        str += "Member Name: " + this.name + "\n";
        str += "Member Phone Number: " + this.phoneNumber + "\n";
        str += "Member Address: " + this.address + "\n";
        str += "Membership Type: " + this.type + "\n";
        str += "Member Id: " + this.ID + "\n";
        return str;
    }

}
