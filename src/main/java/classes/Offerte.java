package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Offerte {

    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json");
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");

    LocalDate offertedatum = LocalDate.now();
    LocalDate vervaldatum = offertedatum.plus(14, ChronoUnit.DAYS);

    private int offerteID;
    private String offerteNaam;
    private String beschrijving;
    private static int ingevuldeKlantID;
    private static String IDNaam;
    private static String IDstraatnaam;
    private static int IDhuisNr;
    private static String IDpostcode;
    private static String IDplaatsnaam;
    private String tempBeschrijving;
    private String featureName;
    private double featurePrice;
    private double totaal;
    private double milieuKorting;
    private double totaalPrijs;
    private ArrayList<EssentieleFeatures> essentieleFeatures;
    private ArrayList<ExtraOpties> extraOpties;
    private ArrayList<Klant> offerteKlant; // Klant die bij de offerte hoort

    public Offerte() {
        aanmakenOfferte();
    }

    public void aanmakenOfferte() {

        Scanner scanner = new Scanner(System.in);
        // Vraag om alle info

        // Vraag om de naam van de offerte via scanner
        System.out.println("-- Wat is de naam van de offerte?");
        offerteNaam = scanner.nextLine();

        // Vraag om een beschrijving van de offerte via scanner
        System.out.println("\nBeschrijf de offerte: ");
        tempBeschrijving = scanner.nextLine();

        // Vraag om extra opties
        ArrayList<ExtraOpties> addExtraOpties = new ArrayList<>();

        // Initialize extraOpties
        extraOpties = new ArrayList<>();

        // Vraag of er een feature bij moet - ja, blijf loopen - nee, break
        System.out.println("-- Hoeveel extra opties wilt u toevoegen?: ");
        // Scanner
        int aantal = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < aantal; aantal--) {
            System.out.println("-- Wat is de naam van de feature?: ");
            featureName = scanner.nextLine();

            System.out.println("-- Wat wordt de prijs?: ");
            featurePrice = scanner.nextDouble();
            scanner.nextLine();

            // Voeg de 2 variabelen toe aan een extra opties
            ExtraOpties optie = new ExtraOpties(featureName, featurePrice);
            addExtraOpties.add(optie);
        }

        extraOpties = addExtraOpties;
        berekenTotaal();

        System.out.println("-- Voor welke klant wordt de offerte aangemaakt?: ");
        List<Klant> loadedObject = objectLoader.loadObjects();

        for (Klant obj : loadedObject) {
            System.out.println("\nKlant naam: " + obj.getNaam() + "\nKlant ID: " + obj.getID());
        }

        System.out.println("\nVul klant ID in: ");
        ingevuldeKlantID = scanner.nextInt();
        scanner.nextLine();

        // Vraag of er milieukorting moet worden toegevoegd
        System.out.println("\n-- Wilt u milieukorting toevoegen?: (ja/nee)");
        String antwoord = scanner.nextLine();
        while (true) {
            if (antwoord.equalsIgnoreCase("ja")) {
                System.out.println("\nVul milieukorting in: ");
                milieuKorting = scanner.nextDouble();
                break;
            } else {
                break;
            }
        }
        MaakOfferte();
        System.out.println("De offerte is aangemaakt!");
    }

    public void berekenTotaal() {
        totaal = 0.00;
        for (ExtraOpties optie : extraOpties) {
            System.out.println(optie.getName() + optie.getPrijs());
            totaal += optie.getPrijs();
        }
        System.out.println("Het totale bedrag = € " + totaal);
    }

    public static void MaakOfferte() { // Functie voor het aanmaken van de offerte met de klantgegevens
        Scanner scanner = new Scanner(System.in);
        ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json"); //Laadt objecten
        List<Klant> loadedObject = objectLoader.loadObjects(); // Laat een lijst van alle klanten zien

        LocalDate offertedatum = LocalDate.now();
        LocalDate vervaldatum = offertedatum.plus(14, ChronoUnit.DAYS);
        String product;
        int aantal;
        double tarief;
        double bedrag;

        for (Klant objSearch : loadedObject) {
            if (objSearch.getID() == ingevuldeKlantID) {
                IDNaam = objSearch.getNaam();
                IDstraatnaam = objSearch.getStraatnaam();
                IDhuisNr = objSearch.getHuisNr();
                IDpostcode = objSearch.getPostcode();
                IDplaatsnaam = objSearch.getPlaatsnaam();
            }
        }

        System.out.println(); // Overzicht van de opgestelde offerte met de klantgegevens
        System.out.println(IDNaam);
        System.out.println(IDstraatnaam + " " + IDhuisNr);
        System.out.println(IDpostcode + " " + IDplaatsnaam);
        System.out.println("\nOffertedatum: " + offertedatum);
        System.out.println("Vervaldag: " + vervaldatum);
        System.out.println("Product | Aantal | Tarief | BTW | Bedrag ");
        System.out.printf("%-11s %-7s %-7s %-6s %-5s\n", "product", "aantal", "€ " + "tarief", "21%", "€ " + "bedrag");

        System.out.println("Wilt u terug naar het hoofdmenu? (ja/nee): ");
        String antwoord = scanner.nextLine();
        if (antwoord.equalsIgnoreCase("ja")) {
            HoofdMenu menu = new HoofdMenu();
            menu.createMenu();
            menu.execute(menu.printMenu());
        }
    }
}