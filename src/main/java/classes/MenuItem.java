package classes;

import Interfaces.MenuItemInterface;
import jdk.nashorn.internal.ir.WhileNode;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

abstract class MenuItem implements MenuItemInterface {
    // MenuItem heeft een naam en een execute functie, deze worden overwritten per item
    String name;

    // Constructor en name getter
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
    }
}

//sub menu Items per SubMenu

// Offerte overzicht menu items
class OfferteAanmakenItem extends MenuItem {
    public OfferteAanmakenItem(String name) {
        super(name);
    }
    public void execute() {
        // Hier execute offerteAanmaak functie in offerte.java
        Offerte offerte = new Offerte();
    }
}

class OfferteBekijkenItem extends MenuItem {
    public OfferteBekijkenItem(String name) {
        super(name);
    }
    public void execute(){
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
            System.out.println("Klant plaatsnaam: ");
            String klantPlaatsnaam = scanner.nextLine();

            System.out.println("Klant type: ");
            String klantType = scanner.nextLine();
            System.out.println("Klant korting: ");
            double klantKorting = scanner.nextDouble();
            scanner.nextLine();

            Klant klant = new Klant(klantNaam, klantID, klantWachtwoord, klantEmail, klantStraatnaam, klantHuisNr, klantPostcode, klantPlaatsnaam, klantType, klantKorting);
            return klant;
    }
}
// Klanten Overzicht Menu Items

class KlantAanmakenItem extends MenuItem{
    Scanner scanner = new Scanner(System.in);

    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json"); // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de .json file naam "KlantInformatie.json".
    // Slaat objecten op
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");
    // Laadt objecten

    public KlantAanmakenItem(String name) {
        super(name);
    }

    public void execute() {

        while (true) {

            // Vraag om klantInfo
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
            System.out.println("Klant plaatsnaam: " + klantinfo.getPlaatsnaam());

            System.out.println("Klant type: " + klantinfo.getKlantType());
            System.out.println("Klant korting: " + klantinfo.getKlantKorting());

            System.out.println("\nZijn deze klantgegevens correct? (ja/nee): ");

            String antwoord = scanner.nextLine();
            if (antwoord.equalsIgnoreCase("ja")) {

                // Laadt de bestaande klantgegevens uit het JSON-bestand
                List<Klant> existingKlanten = objectLoader.loadObjects();

                Klant klant = new Klant(klantinfo.getNaam(), klantinfo.getID(), klantinfo.getPassword(), klantinfo.getEmail(), klantinfo.getStraatnaam(), klantinfo.getHuisNr(), klantinfo.getPostcode(), klantinfo.getPlaatsnaam(), klantinfo.getKlantType(), klantinfo.getKlantKorting());

                // Voegt het nieuwe klantInfo-object toe aan de bestaande lijst
                existingKlanten.add(klant);

                // Slaat de bijgewerkte lijst met klantGegevens op in het JSON-bestand
                objectSaver.saveObjects(existingKlanten);

                System.out.println("\nDe klantgegevens zijn opgeslagen!");
                break;
            } else {
                System.out.println("\nLaten we het opnieuw proberen.");
            }
        }

        System.out.println("Wilt u terug naar het hoofdmenu? (ja/nee): ");
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

    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json");
    // Slaat objecten op

    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");
    // Laadt objecten

    public KlantenBekijkenItem(String name) {
        super(name);
    }

    public void execute() {
        while (true) {
            //Laadt de lijst van klantObjecten uit json file
            List<Klant> loadedObjects = objectLoader.loadObjects();

            //Print de lijst van klantObjecten
            for (Klant objPrint : loadedObjects) {
                System.out.println("\nKlantnaam: " + objPrint.getNaam() + "\nID: " + objPrint.getID());
            }

            // KlantOverzicht filteren op klantID
            int ingevuldeID;
            System.out.println("\nVul klant ID in: ");
            ingevuldeID = scanner.nextInt();
            scanner.nextLine();
            Klant selectedKlant = null;

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

            // Print de klantInfo
            printKlantDetails(selectedKlant);

            System.out.println("\nZijn deze klantgegevens correct? (ja/nee): ");
            System.out.println("\nOf wilt u deze klantgegevens verwijderen? (verwijder): ");

            String gegevensCorrect = scanner.nextLine();
            if (gegevensCorrect.equalsIgnoreCase("nee")) {
                System.out.println("\nVoer de nieuwe gegevens in: ");

                // Vraag om nieuwe klantInfo
                Klant klantinfo = KlantInfoToevoegen.enterKlantInfo(scanner);

                updateKlant(selectedKlant, klantinfo);

                // Slaat de nieuwe klantInfo op in json file
                objectSaver.saveObjects(loadedObjects);

                System.out.println("\nDe klantgegevens zijn opgeslagen!");

            } else if (gegevensCorrect.equalsIgnoreCase("ja")) {
                System.out.println("De klantgegevens zijn correct.");
            } else if (gegevensCorrect.equalsIgnoreCase("Verwijder")) {
                verwijderKlant(loadedObjects, selectedKlant);

                // Slaat de nieuwe klantInfo op in json file
                objectSaver.saveObjects(loadedObjects);
            } else {
                System.out.println("Antwoord niet herkend, probeer het opnieuw (ja/nee/verwijder): ");
                continue;
            }

            System.out.println("Wilt u terug naar het hoofdmenu? (ja/nee): ");
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
        System.out.println("Klant plaatsnaam: " + klant.getPlaatsnaam());

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
        selectedKlant.setPlaatsnaam(klantinfo.getPlaatsnaam());

        selectedKlant.setKlantType(klantinfo.getKlantType());
        selectedKlant.setKlantKorting(klantinfo.getKlantKorting());

        // Print de nieuw klantgegevens zodat de klant ze kan bekijken
        System.out.println("\nHier zijn de nieuwe klantgegevens: ");
        printKlantDetails(selectedKlant);
    }

    private void verwijderKlant(List<Klant> loadedObjects, Klant selectedKlant) {
        loadedObjects.remove(selectedKlant);
        System.out.println("Klant is succesvol verwijderd.");
    }
}