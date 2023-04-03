package classes;

public class ExtraOpties {
    private String name;
    private double prijs;

    public ExtraOpties(String name, double prijs) {
        this.name = name;
        this.prijs = prijs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
