package classes;
import java.util.ArrayList;

import java.util.Scanner;

public class Klant extends Gebruiker {
    private String klantType;
    private double klantKorting;
    private ArrayList<Klant> klant; // De klant die bij de offerte hoort

    public Klant(String naam, int ID, String password, String email, String straatnaam, int huisNr, String postcode, String plaatsnaam, String klantType, double klantKorting) {
        super(naam, ID, password, email, straatnaam, huisNr, postcode, plaatsnaam);
        this.klantType = klantType;
        this.klantKorting = klantKorting;
        this.klant = new ArrayList<Klant>();
    }
// getters en setters
    public ArrayList<Klant> getKlant() {
        return klant;
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

    boolean gegevensCorrect = false;

    public void maakKlantAan() { // functie om klanten mee aan te maken
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voer de naam van de gebruiker in:");
        String naam = scanner.nextLine();
        System.out.println("Voer het ID van de gebruiker in:");
        int ID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Voer het e-mailadres van de gebruiker in:");
        String email = scanner.nextLine();
        System.out.println("Voer het wachtwoord van de gebruiker in:");
        String password = scanner.nextLine();

        Klant nieuweKlant = new Klant(naam, ID, password, email, "particulier", 0);
        klant.add(nieuweKlant);
        System.out.println("Klant " + naam + " met ID " + ID + " is aangemaakt.");
        // Slaat klant op in de lijst
    }

    public void createMenu(){
        klant.add(new Klant("Klant Aanmaken", 0, "", "", "", 0));
        klant.add(new Klant("Klanten Bekijken", 0, "", "", "", 0));
        klant.add(new Klant("Terug", 0, "", "", "", 0));
        // Klantgegevens aanmaken
    }

    public void verwijderGebruiker(int ID){ // Functie om klanten te verwijderen
        for (int j = 0; j < klant.size(); j++) {
            Klant huidigeKlant = klant.get(j);
            if (huidigeKlant.getID() == ID) {
                klant.remove(huidigeKlant);
                System.out.println("Gebruiker met ID:" + ID + " is verwijderd");
                return;
            }
        }
        System.out.println("Gebruiker met ID:" + ID + " is niet gevonden.");
    }

    public void bekijkenGebruiker(){ // Functie om klant met klantgegevens te bekijken
        for (Klant klant : klant){
            System.out.println("Naam: " + klant.getNaam() + "\nID: " + klant.getID() + "\nE-mail: " + klant.getEmail());
        }
    }
}