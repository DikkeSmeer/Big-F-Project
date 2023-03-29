package classes;
import sun.java2d.loops.GeneralRenderer;

import java.util.ArrayList;
import java.util.Scanner;

public class Gebruiker {
    private String naam;
    private int ID;
    private String password;
    private String email;

    private ArrayList<Gebruiker> gebruikers;


    public Gebruiker(String naam, int ID, String password, String email) {
        this.naam = naam;
        this.ID = ID;
        this.password = password;
        this.email = email;
    }

    public Gebruiker() {
        this.gebruikers = new ArrayList<>();
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

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void setGebruikers(ArrayList<Gebruiker> gebruikers) {
        this.gebruikers = gebruikers;
    }

//    class GebruikerMenu extends Menu {
//        public void createMenu(){
//            menu.add(new gebruikerAanmakenItem("Klant Aanmaken"));
//            menu.add(new gebruikerBekijkenItem("Klanten Bekijken"));
//            menu.add(new TerugItem("Terug"));
//        }
//    }
    public void maakGebruikerAan(){
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

        Gebruiker nieuweGebruiker = new Gebruiker(naam, ID, password, email);
        gebruikers.add(nieuweGebruiker);
        scanner.close();
        System.out.println("Klant is toegevoegd!");
    }
    public void verwijderGebruiker(int ID){
        int j = 0;
        for (j = 0; j < gebruikers.size(); j++) {
            Gebruiker huidigGebruiker = gebruikers.get(j);
            if (huidigGebruiker.getID() == getID()) {
                gebruikers.remove(getID());
                System.out.println("Gebruiker met ID:" + getID() + " is verwijderd");
            }
        }
    }

    public void bekijkenGebruiker(){
        for (Gebruiker gebruikers : gebruikers){
            System.out.println("Naam: " + gebruikers.getNaam() + "/n" + "ID: " + gebruikers.getID() + "/n" + gebruikers.getEmail() + "/n" + "email: " + "/n" + gebruikers.getNaam());
        }
    }
}
