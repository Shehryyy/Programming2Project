/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

/**
 *
 * @author Shahe
 */
public class regularMembership extends memberships {

    public regularMembership() {
        super("Regular", 180);
    }

    @Override
    public String detailType() {
        String str = "";
        str += "Type of Membership: " + super.getType() + "\nPrice: " + super.getPrice() + "$ Yearly";
        str += "\nAccess To Gym (24/7) \nChanging rooms \nShowers";
        return str;
    }

    @Override
    public String toString() {
        return detailType();
    }
    
    

}
