package classes;

public class Product {
    private String product;
    private int aantal;
    private double tarief;
    private double bedrag;

    public Product(String product, int aantal, double tarief, double bedrag) {
        this.product = product;
        this.aantal = aantal;
        this.tarief = tarief;
        this.bedrag = bedrag;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    public double getTarief() {
        return tarief;
    }

    public void setTarief(double tarief) {
        this.tarief = tarief;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }
}
