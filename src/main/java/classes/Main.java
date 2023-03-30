package classes;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /* Save Objects vvv*/

        ObjectSaver<KlantInfo> objectSaver = new ObjectSaver<>("KlantInformatie.json"); // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de naam "KlantInformatie.json".

        KlantInfo klant1 = new KlantInfo("Jan", 1, "wachtwoord1", "jan@mail.com", "particulier", 0.05); // Maak een nieuw KlantInfo-object genaamd klant1.
        KlantInfo klant2 = new KlantInfo("Piet", 2, "wachtwoord2", "piet@mail.com", "particulier", 0.10); // Maak een nieuw KlantInfo-object genaamd klant2.
        KlantInfo klant3 = new KlantInfo("Klaas", 3, "wachtwoord3", "klaas@mail.com", "bedrijf", 0.15); // Maak een nieuw KlantInfo-object genaamd klant3.
        KlantInfo klant4 = new KlantInfo("Henk", 4, "wachtwoord4", "henk@mail.com", "bedrijf", 0.20); // Maak een nieuw KlantInfo-object genaamd klant4.
        KlantInfo klant5 = new KlantInfo("Sjaak", 5, "wachtwoord5", "sjaak@mail.com", "particulier", 0.05); // Maak een nieuw KlantInfo-object genaamd klant5.

        objectSaver.addObject(klant1); // Voeg het klant1-object toe aan de lijst van objecten die opgeslagen moeten worden.
        objectSaver.addObject(klant2); // Voeg het klant2-object toe aan de lijst van objecten die opgeslagen moeten worden.
        objectSaver.addObject(klant3); // Voeg het klant3-object toe aan de lijst van objecten die opgeslagen moeten worden.
        objectSaver.addObject(klant4); // Voeg het klant4-object toe aan de lijst van objecten die opgeslagen moeten worden.
        objectSaver.addObject(klant5); // Voeg het klant5-object toe aan de lijst van objecten die opgeslagen moeten worden.
        objectSaver.saveObjects(); // Sla alle objecten in de lijst op in het JSON-bestand met de naam opgeslagen in de instantievariabele fileName van het ObjectSaver-object.


        /* Save Objects ^^^*/


//        /* Load Objects  vvv */
//
//        ObjectLoader<KlantInfo> objectLoader = new ObjectLoader<>(KlantInfo.class, "KlantInformatie.json");
//
//        List<KlantInfo> loadedObjects = objectLoader.loadObjects();
//
//        for (KlantInfo obj : loadedObjects) {
//            System.out.println("\nNaam: " + obj.getNaam() + "\nLeeftijd: " + obj.getLeeftijd() + "\nWachtwoord: " + obj.getPassword() + "\nEmail: " + obj.getEmail() + "\nFunctie: " + obj.getFunctie() + "\nKorting: " + obj.getKorting());
//        }
//        /* Load Objects  ^^^ */


// gebruiker vragen om gegevens in te vullen vvvvv
//        boolean juisteGegevens = false;
//
//        while (!juisteGegevens) {
//            System.out.print("\nZijn deze klantgegevens correct? (Ja/Nee) ");
//            String antwoord = scanner.nextLine();
//
//            if (antwoord.equalsIgnoreCase("Ja")) {
//                juisteGegevens = true;
//            } else if (antwoord.equalsIgnoreCase("Nee")) {
//                // Vraag om nieuwe gebruikersinformatie
//                System.out.println("\nVul uw gegevens in:");
//                System.out.print("Klant naam: ");
//                String klantNaam = scanner.nextLine();
//                System.out.print("Klant leeftijd: ");
//                int klantLeeftijd = scanner.nextInt();
//                System.out.print("Klant wachtwoord: ");
//                String klantWachtwoord = scanner.nextLine();
//                System.out.println("Klant email: ");
//                String klantEmail = scanner.nextLine();
//                System.out.println("Klant functie: ");
//                String klantFunctie = scanner.nextLine();
//                System.out.println("Klant korting: ");
//                double klantKorting = scanner.nextDouble();
//
//                // wijzig de waarden van de instantie van de klasse Gebruiker
//                KlantInfo.setNaam(klantNaam);
//                KlantInfo.setLeeftijd(klantLeeftijd);
//                KlantInfo.setAdres(klantWachtwoord);
//                KlantInfo.setPostcode(klantEmail);
//                KlantInfo.setPlaats(klantFunctie);
//                KlantInfo.setPlaats(klantKorting);
//
//
//                // Toon de nieuwe gegevens aan de gebruiker ter verificatie
//                System.out.println("\nHier zijn uw nieuwe gegevens:");
//                System.out.println("Klant naam: " + gebruiker.getNaamBedrijf());
//                System.out.println("Klant leeftijd: " + gebruiker.getNaamGebruiker());
//                System.out.println("Klant wachtwoord: " + gebruiker.getAdres());
//                System.out.println("Klant email: " + gebruiker.getPostcode());
//                System.out.println("Klant functie: " + gebruiker.getPlaats());
//                System.out.println("Klant korting: " + KlantInfo.getBedrijfEmail());
//            } else {
//                System.out.println("Niet herkend wat je hebt ingevuld, probeer opnieuw.");
//            }
//        }
// gebruiker vragen om gegevens in te vullen^^^^





        HoofdMenu menu = new HoofdMenu();
        menu.createMenu();
        System.out.println();
        menu.execute(menu.printMenu());

    }
}

class KlantInfo {
    private String naam;
    private int leeftijd;
    private String password;
    private String email;
    private String functie;
    private double korting;

    public KlantInfo(String naam, int leeftijd, String password, String email, String functie, double korting) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.password = password;
        this.email = email;
        this.functie = functie;
        this.korting = korting;
    }

    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFunctie() {
        return functie;
    }

    public double getKorting() {
        return korting;
    }

    public void setName(String naam) {
        this.naam = naam;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public void setKorting(double korting) {
        this.email = email;
    }

}