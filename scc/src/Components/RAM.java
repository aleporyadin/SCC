package Components;

import Utils.Component;
import Utils.Product;

public class RAM  extends Component implements Product {

    public RAM(String name, int quantity, float price) {
        this.id = counter++;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void changeDecrement() {
        counter--;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
