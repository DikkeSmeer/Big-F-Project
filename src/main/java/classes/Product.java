package classes;

public class Product {
    private String product;
    private int aantal;
    private int tarief;
    private int bedrag;

    public Product(String product, int aantal, int tarief, int bedrag) {
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

    public int getTarief() {
        return tarief;
    }

    public void setTarief(int tarief) {
        this.tarief = tarief;
    }

    public int getBedrag() {
        return bedrag;
    }

    public void setBedrag(int bedrag) {
        this.bedrag = bedrag;
    }
}
