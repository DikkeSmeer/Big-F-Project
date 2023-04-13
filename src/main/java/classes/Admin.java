package classes;

public class Admin extends Gebruiker{
    private boolean isAdmin;

    public Admin(String naam, int ID, String password, String email, boolean isAdmin) {
        super(naam, ID, password, email);
        this.isAdmin = isAdmin;
    }
    // getter en setter
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
