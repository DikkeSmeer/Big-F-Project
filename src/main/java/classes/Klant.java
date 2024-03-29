package classes;

public class Klant extends Gebruiker{
    private String klantType;
    private double klantKorting;

    public Klant(String naam, int ID, String password, String email, String straatnaam, int huisNr, String postcode, String plaatsnaam, String klantType, double klantKorting) {
        super(naam, ID, password, email, straatnaam, huisNr, postcode, plaatsnaam);
        this.klantType = klantType;
        this.klantKorting = klantKorting;
    }



    public String getKlantType() {
        return klantType;
    }

    public void setKlantType(String klantType) {
        this.klantType = klantType;
    }

    public double getKlantKorting() {
        return klantKorting;
    }

    public void setKlantKorting(double klantKorting) {
        this.klantKorting = klantKorting;
    }
}