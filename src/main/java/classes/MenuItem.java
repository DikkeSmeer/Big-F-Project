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

class KlantInfoToevoegen {
    public static Klant enterKlantInfo(Scanner scanner) {
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

            System.out.println("Klant straatnaam: ");
            String klantStraatnaam = scanner.nextLine();
            System.out.println("Klant huisnummer: ");
            int klantHuisNr = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Klant postcode: ");
            String klantPostcode = scanner.nextLine();

            System.out.println("Klant type: ");
            String klantType = scanner.nextLine();
            System.out.println("Klant korting: ");
            double klantKorting = scanner.nextDouble();
            scanner.nextLine();

            Klant klant = new Klant(klantNaam, klantID, klantWachtwoord, klantEmail, klantStraatnaam, klantHuisNr, klantPostcode, klantType, klantKorting);
            return klant;
    }
}
// Klanten Overzicht Menu Items

class KlantAanmakenItem extends MenuItem{
    Scanner scanner = new Scanner(System.in);
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

        while (true) {

            // Ask for the new Klant details
            Klant klantinfo = KlantInfoToevoegen.enterKlantInfo(scanner);

            // Toon de nieuwe gegevens aan de gebruiker ter verificatie
            System.out.println("\nHier zijn de gegeven klantgegevens:");
            System.out.println("Klant naam: " + klantinfo.getNaam());
            System.out.println("Klant ID: " + klantinfo.getID());
            System.out.println("Klant wachtwoord: " + klantinfo.getPassword());
            System.out.println("Klant email: " + klantinfo.getEmail());

            System.out.println("Klant straatnaam: " + klantinfo.getStraatnaam());
            System.out.println("Klant huisnummer: " + klantinfo.getHuisNr());
            System.out.println("Klant postcode: " + klantinfo.getPostcode());

            System.out.println("Klant type: " + klantinfo.getKlantType());
            System.out.println("Klant korting: " + klantinfo.getKlantKorting());

            System.out.println("\nZijn deze klantgegevens correct? (ja/nee): ");

            String antwoord = scanner.nextLine();
            if (antwoord.equalsIgnoreCase("ja")) {

                // Laad de bestaande klantgegevens uit het JSON-bestand
                List<Klant> existingKlanten = objectLoader.loadObjects();

                Klant klant = new Klant(klantinfo.getNaam(), klantinfo.getID(), klantinfo.getPassword(), klantinfo.getEmail(), klantinfo.getStraatnaam(), klantinfo.getHuisNr(), klantinfo.getPostcode(), klantinfo.getKlantType(), klantinfo.getKlantKorting());

                // Voeg het nieuwe KlantInfo-object toe aan de bestaande lijst
                existingKlanten.add(klant);

                // Sla de bijgewerkte lijst met klantgegevens op in het JSON-bestand
                objectSaver.saveObjects(existingKlanten);

                System.out.println("\nDe klantgegevens zijn opgeslagen!");
                break;
            } else {
                System.out.println("\nLaten we het opnieuw proberen.");
            }
        }

        System.out.println("Wil je terug naar het hoofdmenu? (ja/nee): ");
        String menuAntwoord = scanner.nextLine();
        if (menuAntwoord.equalsIgnoreCase("ja")) {
            HoofdMenu menu = new HoofdMenu();
            menu.createMenu();
            menu.execute(menu.printMenu());
        }
    }
}
class KlantenBekijkenItem extends MenuItem {
    Scanner scanner = new Scanner(System.in);
    /* Save Objects vvv */
    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json");
    /* Save Objects ^^^ */
    /* Load Objects  vvv */
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");
    /* Load Objects  ^^^ */

    public KlantenBekijkenItem(String name) {
        super(name);
    }

    public void execute() {
        while (true) {
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

            Klant selectedKlant = null;

            // Search for the Klant object with the entered ID
            for (Klant objSearch : loadedObjects) {
                if (objSearch.getID() == ingevuldeID) {
                    selectedKlant = objSearch;
                    break;
                }
            }

            if (selectedKlant == null) {
                System.out.println("Klant niet gevonden. Probeer het opnieuw.");
                continue;
            }

            // Print the Klant details
            printKlantDetails(selectedKlant);

            System.out.println("\nZijn deze klantgegevens correct? (ja/nee): ");
            System.out.println("\nOf wil je deze klantgegevens verwijderen? (verwijder): ");

            String gegevensCorrect = scanner.nextLine();
            if (gegevensCorrect.equalsIgnoreCase("nee")) {
                System.out.println("\nVoer nieuwe gegevens in:");

                // Ask for the new Klant details
                Klant klantinfo = KlantInfoToevoegen.enterKlantInfo(scanner);

                updateKlant(selectedKlant, klantinfo);

                // Save the updated Klant objects to the JSON file
                objectSaver.saveObjects(loadedObjects);

                // Print a message to confirm that the Klant details have been updated
                System.out.println("\nDe klantgegevens zijn opgeslagen!");

            } else if (gegevensCorrect.equalsIgnoreCase("ja")) {
                System.out.println("De klantgegevens zijn correct.");
            } else if (gegevensCorrect.equalsIgnoreCase("verwijder")) {
                verwijderKlant(loadedObjects, selectedKlant);

                // Save the updated Klant objects to the JSON file
                objectSaver.saveObjects(loadedObjects);
            } else {
                System.out.println("Antwoord niet herkend, probeer opnieuw (ja/nee/verwijder): ");
                continue;
            }

            System.out.println("Wil je terug naar het hoofdmenu? (ja/nee): ");
            String antwoord = scanner.nextLine();
            if (antwoord.equalsIgnoreCase("ja")) {
                HoofdMenu menu = new HoofdMenu();
                menu.createMenu();
                menu.execute(menu.printMenu());
                break;
            }
        }
    }

    private void printKlantDetails(Klant klant) {
        System.out.println("\nKlant naam: " + klant.getNaam());
        System.out.println("Klant ID: " + klant.getID());
        System.out.println("Klant wachtwoord: " + klant.getPassword());
        System.out.println("Klant e-mail: " + klant.getEmail());

        System.out.println("Klant straatnaam: " + klant.getStraatnaam());
        System.out.println("Klant huisnummer: " + klant.getHuisNr());
        System.out.println("Klant postcode: " + klant.getPostcode());

        System.out.println("Klant type: " + klant.getKlantType());
        System.out.println("Klant korting: " + klant.getKlantKorting());
    }

    private void updateKlant(Klant selectedKlant, Klant klantinfo) {
        selectedKlant.setNaam(klantinfo.getNaam());
        selectedKlant.setID(klantinfo.getID());
        selectedKlant.setPassword(klantinfo.getPassword());
        selectedKlant.setEmail(klantinfo.getEmail());

        selectedKlant.setStraatnaam(klantinfo.getStraatnaam());
        selectedKlant.setHuisNr(klantinfo.getHuisNr());
        selectedKlant.setPostcode(klantinfo.getPostcode());

        selectedKlant.setKlantType(klantinfo.getKlantType());
        selectedKlant.setKlantKorting(klantinfo.getKlantKorting());

        // Print the updated Klant details for the user to verify
        System.out.println("\nHier zijn de nieuwe klantgegevens:");
        printKlantDetails(selectedKlant);
    }

    private void verwijderKlant(List<Klant> loadedObjects, Klant selectedKlant) {
        loadedObjects.remove(selectedKlant);
        System.out.println("Klant is succesvol verwijderd!");
    }
}