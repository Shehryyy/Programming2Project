/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

/**
 *
 * @author Shahe
 */
public class premiumMembership extends memberships{
    
     public premiumMembership() {
        super("Premium", 265);
    }

    @Override
    public String detailType() {
        String str = "";
        str += "Type of Membership: " + super.getType() + "\nPrice: " + super.getPrice() + "$ Yearly";
        str += "\nAccess To Gym (24/7) \nChanging rooms \nShowers \nAccess to Yoga section "
            +  "\nAccess to massage chairs \nMembership card sharing ";
        return str;
    }
    
       @Override
    public String toString() {
        return detailType();
    }
}
