package Components;

public class Motherboard {
    private static int counter=0;
    private int id;
    private String name;
    private int count;
    private int price;

    public Motherboard(String name, int count, int price) {
        this.id = counter++;
        this.name = name;
        this.count = count;
        this.price = price;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
