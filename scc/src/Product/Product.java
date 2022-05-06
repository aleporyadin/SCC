package Product;


public class Product {
    public static int counter=0;
    public int id;
    public String name;
    public int quantity;
    public float price;

    public String toString() {
        return "ID: "+id+"\nName: "+name+"\nCount: "+quantity+"\nPrice: "+price;
    }
}
