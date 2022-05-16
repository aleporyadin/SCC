package Utils;

public abstract class Component {
    protected static int counter = 0;
    protected int id = 0;
    protected String name = null;
    protected int quantity = 0;
    protected float price = 0;
    public static void decrementCounter() {
        counter--;
    }
}
