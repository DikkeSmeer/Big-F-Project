package classes;

public class Gebruiker {
    private String naam;
    private int ID;
    private String password;
    private String email;

    public Gebruiker(String naam, int ID, String password, String email) {
        this.naam = naam;
        this.ID = ID;
        this.password = password;
        this.email = email;
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
}
