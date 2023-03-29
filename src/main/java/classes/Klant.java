package classes;
import java.util.Scanner;
import java.util.ArrayList;


public class Klant extends Gebruiker{
    private String klantType;
    private double klantKorting;

    private ArrayList<Klant> klant; // de klant die bij het offerte hoort
    public Klant(String naam, int ID, String password, String email, String klantType, double klantKorting) {
        super(naam, ID, password, email);
        this.klantType = klantType;
        this.klantKorting = klantKorting;
    }

    public ArrayList<Klant> getKlant() {
        return klant;
    }

    public void setKlant(ArrayList<Klant> klant) {
        this.klant = klant;
    }

    public Klant(){
        this.klant = new ArrayList<>();
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

    public void maakKlantAan(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer uw naam in:");
        String naam = scanner.nextLine();

        System.out.println("Voer het ID van de klant in:");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Voer het wachtwoord van de klant in:");
        String password = scanner.nextLine();

        System.out.println("Voer het emailadres van de klant in:");
        String email = scanner.nextLine();

        System.out.println("Voer klanttype van de klant in:");
        String klantType = scanner.nextLine();

        System.out.println("Voer de klantkorting van de klant in:");
        double klantKorting = scanner.nextDouble();

        Klant nieuweKlant = new Klant(naam, ID, password, email, klantType, klantKorting);
        klant.add(nieuweKlant);
        scanner.close();
        System.out.println("Klant is toegevoegd!");
    }
    public void verwijderKlant(int ID) {
        int i;
        for (i = 0; i < klant.size(); i++) ;
        Klant huidigKlant = klant.get(i);
        if (huidigKlant.getID() == getID()) {
            klant.remove(getID());
            System.out.println("Klant met ID:" + getID() + " is verwijderd");
        }
    }

    public void bekijkenKlant(){
        for (Klant klant : klant){
            System.out.println("Naam: " + klant.getNaam() + "/n" + "ID: " + klant.getID() + "/n" + klant.getEmail() + "/n" + "email: " + "/n" + klant.getNaam());
        }
    }

}