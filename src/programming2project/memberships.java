/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming2project;

/**
 *
 * @author Shahe
 */
public abstract class memberships {

    protected int price;
    protected String Type;

    public memberships() {
        price = 0;
        Type = "";
    }

    public memberships(String Type, int price) {
        this.Type = Type;
        this.price = price;
    }

    public abstract String detailType();

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    
}
