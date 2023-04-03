package classes;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        /* Save Objects vvv*/
        ObjectSaver<KlantInfo> objectSaver = new ObjectSaver<>("KlantInformatie.json"); // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de .json file naam "KlantInformatie.json".
//        /* Save Objects ^^^*/


        /* Load Objects  vvv */

        ObjectLoader<KlantInfo> objectLoader = new ObjectLoader<>(KlantInfo.class, "KlantInformatie.json");

//        List<KlantInfo> loadedObjects = objectLoader.loadObjects();

//        for (KlantInfo obj : loadedObjects) {
//            System.out.println("\nNaam: " + obj.getNaam() + "\nLeeftijd: " + obj.getLeeftijd() + "\nWachtwoord: " + obj.getPassword() + "\nEmail: " + obj.getEmail() + "\nFunctie: " + obj.getFunctie() + "\nKorting: " + obj.getKorting());
//        }
        /* Load Objects  ^^^ */


// gebruiker vragen om gegevens in te vullen vvvvv

        boolean juisteGegevens = false;

        while (!juisteGegevens) {
            System.out.print("\nZijn deze klantgegevens correct? (Ja/Nee) ");
            String antwoord = scanner.nextLine();

            if (antwoord.equalsIgnoreCase("Ja")) {
                juisteGegevens = true;
            } else if (antwoord.equalsIgnoreCase("Nee")) {
                // Vraag om nieuwe gebruikersinformatie
                System.out.println("\nVul uw gegevens in:");
                System.out.print("Klant naam: ");
                String klantNaam = scanner.nextLine();
                System.out.print("Klant leeftijd: ");
                int klantLeeftijd = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Klant wachtwoord: ");
                String klantWachtwoord = scanner.nextLine();
                System.out.println("Klant email: ");
                String klantEmail = scanner.nextLine();
                System.out.println("Klant functie: ");
                String klantFunctie = scanner.nextLine();
                System.out.println("Klant korting: ");
                double klantKorting = scanner.nextDouble();
                scanner.nextLine();

                // wijzig de waarden van de instantie van de klasse Gebruiker
                KlantInfo Klant = new KlantInfo("", 20, "wachtwoord", "email", "functie", 0.05);
                Klant.setNaam(klantNaam);
                Klant.setLeeftijd(klantLeeftijd);
                Klant.setPassword(klantWachtwoord);
                Klant.setEmail(klantEmail);
                Klant.setFunctie(klantFunctie);
                Klant.setKorting(klantKorting);

                objectSaver.addObject(Klant); // Voeg het klant1-object toe aan de lijst van objecten die opgeslagen moeten worden.
                objectSaver.saveObjects(); // Sla alle objecten in de lijst op in het JSON-bestand met de naam opgeslagen in de instantievariabele fileName van het ObjectSaver-object.

                List<KlantInfo> loadedObjects = objectLoader.loadObjects();
                for (KlantInfo obj : loadedObjects) {

                    // Toon de nieuwe gegevens aan de gebruiker ter verificatie
                    System.out.println("\nHier zijn uw nieuwe gegevens:");
                    System.out.println("Klant naam: " + obj.getNaam());
                    System.out.println("Klant leeftijd: " + obj.getLeeftijd());
                    System.out.println("Klant wachtwoord: " + obj.getPassword());
                    System.out.println("Klant email: " + obj.getEmail());
                    System.out.println("Klant functie: " + obj.getFunctie());
                    System.out.println("Klant korting: " + obj.getKorting());

                }
            } else {
                System.out.println("Niet herkend wat je hebt ingevuld, probeer opnieuw.");
            }
        }
// gebruiker vragen om gegevens in te vullen^^^^





        HoofdMenu menu = new HoofdMenu();
        menu.createMenu();
        System.out.println();
        menu.execute(menu.printMenu());

    }
}

class KlantInfo{
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

    public void setNaam(String naam) {
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
        this.korting = korting;
    }

}