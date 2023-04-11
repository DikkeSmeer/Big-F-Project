package classes;

import Interfaces.MenuItemInterface;
import java.util.Scanner;
import java.util.List;

abstract class MenuItem implements MenuItemInterface {
    // een menu item heeft een naam en een execute functie, deze wordt overwritten per item
    String name;

    // construct en name Getter
    public MenuItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class OfferteOverzichtItem extends MenuItem {
    public OfferteOverzichtItem(String name) {
        super(name);
    }
    public void execute() {
        OfferteMenu bmenu = new OfferteMenu();
        bmenu.createMenu();
        bmenu.execute(bmenu.printMenu());
    }
}
class KlantenOverzichtItem extends MenuItem {
    public KlantenOverzichtItem(String name) {
        super(name);
    }
    public void execute() {
        KlantenMenu kmenu = new KlantenMenu();
        kmenu.createMenu();
        kmenu.execute(kmenu.printMenu());
    }
}

class TerugItem extends MenuItem {
    public TerugItem(String name) {
        super(name);
    }
    public void execute() {
        // FIX THIS
    }
}

//sub menu Items per SubMenu

// Offerte Overzicht Menu Items
class OfferteAanmakenItem extends MenuItem {
    public OfferteAanmakenItem(String name) {
        super(name);
    }
    public void execute() {
        System.out.println("Dit voert de :Offerte Aanmaken: uit.");
        // hier execute offerte aanmaak functie in offerte.java
        Offerte offerte = new Offerte();
    }
}

class OfferteBekijkenItem extends MenuItem {
    public OfferteBekijkenItem(String name) {
        super(name);
    }
    public void execute() {
        //Lijst.printLijst(Lijst.getLijst(),3);
        System.out.println("Dit voert de :Alle Offerte Laten zien: uit.");
    }
}

// Klanten Overzicht Menu Items
class KlantAanmakenItem extends MenuItem{

    /* Save Objects vvv*/
    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json"); // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de .json file naam "KlantInformatie.json".
    /* Save Objects ^^^*/
    /* Load Objects  vvv */
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");
    /* Load Objects  ^^^ */

    public KlantAanmakenItem(String name) {
        super(name);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        Klant klantArthur = new Klant("Arthur",3,"admin","arthur@example.nl","codepapi",100);
        Klant klantAlicia = new Klant("Alicia",30,"admin","alicia@example.nl","codemama",20);
        Klant klantQuincy = new Klant("Quincy",100,"admin","quincy@example.nl","codepollito",50);

        objectSaver.addObject(klantArthur); // Voeg het klant-object toe aan de lijst van objecten die opgeslagen moeten worden.
        objectSaver.addObject(klantAlicia); // Voeg het klant-object toe aan de lijst van objecten die opgeslagen moeten worden.
        objectSaver.addObject(klantQuincy); // Voeg het klant-object toe aan de lijst van objecten die opgeslagen moeten worden.

        objectSaver.saveObjects(); // Sla alle objecten in de lijst op in het JSON-bestand met de naam opgeslagen in de instantievariabele fileName van het ObjectSaver-object.

        boolean correcteGegevens = false;

        while (!correcteGegevens) {
            // Vraag om nieuwe gebruikersinformatie
            System.out.println("\nVul uw gegevens in:");
            System.out.print("Klant naam: ");
            String klantNaam = scanner.nextLine();
            System.out.print("Klant ID: ");
            int klantID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Klant wachtwoord: ");
            String klantWachtwoord = scanner.nextLine();
            System.out.println("Klant email: ");
            String klantEmail = scanner.nextLine();
            System.out.println("Klant type: ");
            String klantType = scanner.nextLine();
            System.out.println("Klant korting: ");
            double klantKorting = scanner.nextDouble();
            scanner.nextLine();

            // Wijzig de waarden van de instantie van de klasse Gebruiker
            Klant KlantInfo = new Klant("", 20, "wachtwoord", "email", "functie", 0.05);
            KlantInfo.setNaam(klantNaam);
            KlantInfo.setID(klantID);
            KlantInfo.setPassword(klantWachtwoord);
            KlantInfo.setEmail(klantEmail);
            KlantInfo.setKlantType(klantType);
            KlantInfo.setKlantKorting(klantKorting);

            // Toon de nieuwe gegevens aan de gebruiker ter verificatie
            System.out.println("\nHier zijn de nieuwe klantgegevens:");
            System.out.println("Klant naam: " + KlantInfo.getNaam());
            System.out.println("Klant leeftijd: " + KlantInfo.getID());
            System.out.println("Klant wachtwoord: " + KlantInfo.getPassword());
            System.out.println("Klant email: " + KlantInfo.getEmail());
            System.out.println("Klant functie: " + KlantInfo.getKlantType());
            System.out.println("Klant korting: " + KlantInfo.getKlantKorting());

            System.out.println("\nZijn deze klantgegevens correct? (ja/nee): ");
            String antwoord = scanner.nextLine();
            if (antwoord.equalsIgnoreCase("ja")) {
                correcteGegevens = true;
                objectSaver.addObject(KlantInfo); // Voeg het klant1-object toe aan de lijst van objecten die opgeslagen moeten worden.
                objectSaver.saveObjects(); // Sla alle objecten in de lijst op in het JSON-bestand met de naam opgeslagen in de instantievariabele fileName van het ObjectSaver-object.

                List<Klant> loadedObjects = objectLoader.loadObjects();
                for (Klant obj : loadedObjects) {
                    System.out.println("\nDe klantgegevens zijn opgeslagen!");
                }
            } else {
                System.out.println("\nLaten we het opnieuw proberen.");
            }
        }
    }
}
class KlantenBekijkenItem extends MenuItem {

    /* Save Objects vvv*/
    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json"); // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de .json file naam "KlantInformatie.json".
    /* Save Objects ^^^*/
    /* Load Objects  vvv */
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");
    /* Load Objects  ^^^ */

    public KlantenBekijkenItem(String name) {
        super(name);
    }

    public void execute() {

        List<Klant> loadedObjects = objectLoader.loadObjects();
        for (Klant obj : loadedObjects) {
            System.out.println("\nKlantnaam: " + obj.getNaam() + "\nKlantID: " + obj.getID() + "\nKlant wachtwoord: " + obj.getPassword() + "\nKlant email: " + obj.getEmail() + "\nKlanttype: " + obj.getKlantType() + "\nKlantkorting: " + obj.getKlantKorting());
        }
        MenuItem terug = new TerugItem("Back to main");
        terug.execute();
    }
}