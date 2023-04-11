package classes;

import Interfaces.MenuItemInterface;
import jdk.nashorn.internal.ir.WhileNode;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

abstract class MenuItem implements MenuItemInterface {
    // een menu item heeft een naam en een execute functie, deze word overwritten per item
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
            System.out.println("Klant ID: " + KlantInfo.getID());
            System.out.println("Klant wachtwoord: " + KlantInfo.getPassword());
            System.out.println("Klant email: " + KlantInfo.getEmail());
            System.out.println("Klant functie: " + KlantInfo.getKlantType());
            System.out.println("Klant korting: " + KlantInfo.getKlantKorting());

            System.out.println("\nZijn deze klantgegevens correct? (ja/nee): ");
            String antwoord = scanner.nextLine();
            if (antwoord.equalsIgnoreCase("ja")) {correcteGegevens = true;

                // Laad de bestaande klantgegevens uit het JSON-bestand
                List<Klant> existingKlanten = objectLoader.loadObjects();

                // Voeg het nieuwe KlantInfo-object toe aan de bestaande lijst
                existingKlanten.add(KlantInfo);

                // Sla de bijgewerkte lijst met klantgegevens op in het JSON-bestand
                objectSaver.saveObjects(existingKlanten);

                System.out.println("\nDe klantgegevens zijn opgeslagen!");

            } else {
                System.out.println("\nLaten we het opnieuw proberen.");
            }
        }

        System.out.println("Wil je terug naar het hoofdmenu? (ja/nee): ");
        String antwoord = scanner.nextLine();
        if (antwoord.equalsIgnoreCase("ja")) {
            HoofdMenu menu = new HoofdMenu();
            menu.createMenu();
            menu.execute(menu.printMenu());
        }

    }
}
class KlantenBekijkenItem extends MenuItem {
    Scanner scanner = new Scanner(System.in);


    /* Save Objects vvv*/
    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json"); // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de .json file naam "KlantInformatie.json".
    /* Save Objects ^^^*/
    /* Load Objects  vvv */
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");
    /* Load Objects  ^^^ */

    List<Klant> loadedObjects = objectLoader.loadObjects();

    public KlantenBekijkenItem(String name) {
        super(name);
    }

    public void execute() {
        // Load the list of Klant objects from the JSON file
        List<Klant> loadedObjects = objectLoader.loadObjects();

        // Print the list of loaded Klant objects
        for (Klant objPrint : loadedObjects) {
            System.out.println("\nKlantnaam: " + objPrint.getNaam() + "\nID: " + objPrint.getID());
        }

        // Ask the user to enter a Klant ID
        int ingevuldeID;
        System.out.println("\nVul klant ID in: ");
        ingevuldeID = scanner.nextInt();
        scanner.nextLine(); // Add this line to consume the newline character

        // Search for the Klant object with the entered ID and print its details
        for (Klant objSearch : loadedObjects) {
            if (objSearch.getID() == ingevuldeID) {
                System.out.println("\nKlant naam: " + objSearch.getNaam() + "\nKlant ID: " + objSearch.getID() + "\nKlant wachtwoord: " + objSearch.getPassword() + "\nKlant e-mail: " + objSearch.getEmail() + "\nKlant type: " + objSearch.getKlantType() + "\nKlant korting: " + objSearch.getKlantKorting());
            }
        }

        boolean correcteGegevens = false;

        // Ask the user if the details are correct
        System.out.println("\nZijn deze klantgegevens correct? (ja/nee): ");
        System.out.println("\nOf wil je deze klantgegevens verwijderen? (verwijder): ");

        while (!correcteGegevens) {
            String gegevensCorrect = scanner.nextLine();
            if (gegevensCorrect.equalsIgnoreCase("nee")) {
                // Ask the user to enter new Klant details
                System.out.println("\nVoer nieuwe gegevens in:");

                // Ask for the new Klant details
                System.out.print("Klant naam: ");
                String klantNaam = scanner.nextLine();
                System.out.print("Klant wachtwoord: ");
                String klantWachtwoord = scanner.nextLine();
                System.out.print("Klant e-mail: ");
                String klantEmail = scanner.nextLine();
                System.out.print("Klant type: ");
                String klantType = scanner.nextLine();
                System.out.print("Klant korting: ");
                double klantKorting = scanner.nextDouble();
                scanner.nextLine(); // Add this line to consume the newline character

                // Search for the Klant object with the entered ID and update its details
                for (Klant objSearch : loadedObjects) {
                    if (objSearch.getID() == ingevuldeID) {
                        objSearch.setNaam(klantNaam);
                        objSearch.setPassword(klantWachtwoord);
                        objSearch.setEmail(klantEmail);
                        objSearch.setKlantType(klantType);
                        objSearch.setKlantKorting(klantKorting);

                        // Print the updated Klant details for the user to verify
                        System.out.println("\nHier zijn de nieuwe klantgegevens:");
                        System.out.println("Klant naam: " + objSearch.getNaam());
                        System.out.println("Klant ID: " + objSearch.getID());
                        System.out.println("Klant wachtwoord: " + objSearch.getPassword());
                        System.out.println("Klant e-mail: " + objSearch.getEmail());
                        System.out.println("Klant type: " + objSearch.getKlantType());
                        System.out.println("Klant korting: " + objSearch.getKlantKorting());
                    }
                }

                // Save the updated Klant objects to the JSON file
                for (Klant obj : loadedObjects) {
                    objectSaver.addObject(obj);
                }
                objectSaver.saveObjects();

                // Print a message to confirm that the Klant details have been updated
                System.out.println("\nDe klantgegevens zijn opgeslagen!");

                correcteGegevens = true;
            } else if (gegevensCorrect.equalsIgnoreCase("ja")) {
                correcteGegevens = true;
            } else if (gegevensCorrect.equalsIgnoreCase("verwijder")){

                Iterator<Klant> iterator = loadedObjects.iterator();

                while (iterator.hasNext()) {
                    Klant objSearch = iterator.next();
                    if (objSearch.getID() == ingevuldeID) {
                        iterator.remove();
                        System.out.println("Klant is succesvol verwijderd!");

                        // Save the updated Klant objects to the JSON file
                        objectSaver.saveObjects(loadedObjects);

                        break;
                    }
                }
            } else {
                System.out.println("Antwoord niet herkend, probeer opnieuw (ja/nee/verwijder): ");
            }

            System.out.println("Wil je terug naar het hoofdmenu? (ja/nee): ");
            String antwoord = scanner.nextLine();
            if (antwoord.equalsIgnoreCase("ja")) {
                HoofdMenu menu = new HoofdMenu();
                menu.createMenu();
                menu.execute(menu.printMenu());
            }
        }
    }
}


// voeg hier meerdere menuitems toe op basis van een Menu Class in Menu