package classes;

public class Gebruiker {
    private String naam;
    private int ID;
    private String password;
    private String email;
    private String straatnaam;
    private int huisNr;
    private String postcode;

    public Gebruiker(String naam, int ID, String password, String email, String straatnaam, int huisNr, String postcode) {
        this.naam = naam;
        this.ID = ID;
        this.password = password;
        this.email = email;
        this.straatnaam = straatnaam;
        this.huisNr = huisNr;
        this.postcode = postcode;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisNr() {
        return huisNr;
    }

    public void setHuisNr(int huisNr) {
        this.huisNr = huisNr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}