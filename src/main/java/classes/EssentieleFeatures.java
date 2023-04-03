package classes;

public class EssentieleFeatures {
    private String name;
    private double price;

    public EssentieleFeatures(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
