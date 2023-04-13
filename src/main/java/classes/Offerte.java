package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Offerte{

    /* Save Objects vvv */
    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json"); // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de .json file naam "KlantInformatie.json".
    /* Save Objects ^^^ */
    /* Load Objects vvv */
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");
    /* Load Objects ^^^ */

    LocalDate offertedatum = LocalDate.now();
    LocalDate vervaldatum = offertedatum.plus(14, ChronoUnit.DAYS);

    private int offerteID;
    private String offerteNaam;
    private String beschrijving;

    private ArrayList<EssentieleFeatures> essentieleFeatures; // bound to change
    private ArrayList<ExtraOpties> extraOpties;
    private ArrayList<Klant> klant; // de klant die bij de offerte hoort

    private double milieuKorting;
    private double totaalPrijs; // wordt ge-set vanuit de optionele kosten (van essentieleOpties) en kortingen


    //    public Offerte(String naam, String beschrijving, ArrayList<EssentieleFeatures> essentieleFeatures, ArrayList<Klant> klant, double milieuKorting) {
    //    this.naam = naam;
    //    this.beschrijving = beschrijving;
    //    this.essentieleFeatures = essentieleFeatures;
    //    this.klant = klant;
    //    this.milieuKorting = milieuKorting;
    //    }


    public Offerte() {
        aanmakenOfferte();
    }

    public String getOfferteNaam() {
        return offerteNaam;
    }

    public void setNaam(String offerteNaam) {
        this.offerteNaam = offerteNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public ArrayList<EssentieleFeatures> essentieleFeatures() {
        return essentieleFeatures;
    }

    public void setEssentieleOpties(ArrayList<EssentieleFeatures> essentieleFeatures) {
        this.essentieleFeatures = essentieleFeatures;
    }

    public void setExtraOpties(ArrayList<ExtraOpties> extraOpties) {
        this.extraOpties = extraOpties;
    }

    public ArrayList<Klant> getKlant() {
        return klant;
    }

    public void setKlant(ArrayList<Klant> klant) {
        this.klant = klant;
    }

    public double getMilieuKorting() {
        return milieuKorting;
    }

    public void setMilieuKorting(double milieuKorting) {
        this.milieuKorting = milieuKorting;
    }

    public double getTotaalPrijs() {
        return totaalPrijs;
    }

    public void setTotaalPrijs(double totaalPrijs) {
        this.totaalPrijs = totaalPrijs;
    }


    public void aanmakenOfferte() {
        // Load the list of Klant objects from the JSON file
        List<Klant> loadedObjects = objectLoader.loadObjects();

        Scanner scanner = new Scanner(System.in);
        // vraag om alle info


        // vraag om een naam via scanner
        System.out.println("Wat is de naam van de offerte?");
        String tempNaam = scanner.nextLine();
        this.offerteNaam = tempNaam;

        System.out.println("");

        // vraag om een beschrijving via scanner
        System.out.println("Beschrijf de offerte: ");
        String tempBeschrijving = scanner.nextLine();
        this.beschrijving = tempBeschrijving;


        //vraag om extra opties
        ArrayList<ExtraOpties> addExtraOpties = new ArrayList<>();

        // Vraag of er een feature bij moet - ja, blijf loopen - nee, break
        System.out.println("-- Hoeveel extra opties wilt u toevoegen?: ");
        // scanner
        int aantal = scanner.nextInt();

        // van int naar een String moet een empty line erbij
        scanner.nextLine();

        for (int i = 0; i < aantal; aantal--) {
            // naam van de feature - check is het een String

            System.out.println("-- Wat is de naam van de feature?: ");
            String featureName = scanner.nextLine();

            // vraag om de prijs - check is het een int
            // scanner
            System.out.println("-- Wat wordt de prijs?: (2 decimale getal) ");
            double featurePrice = scanner.nextDouble();

            // van int naar een String moet een empty line erbij
            scanner.nextLine();

            // voeg de 2 variabelen toe aan een extra opties
            ExtraOpties optie = new ExtraOpties(featureName, featurePrice);
            addExtraOpties.add(optie);
        }

        this.setExtraOpties(addExtraOpties);

        double totaal = 0.00;
        for (ExtraOpties optie : this.extraOpties) {
            System.out.println(optie.getName() + optie.getPrijs());
            totaal += optie.getPrijs();
        }
        System.out.println("Het totale bedrag = " + totaal);


        System.out.println("--Voor welke klant wordt de offerte aangemaakt?: "); // vraag voor welke klant de offerte is

        List<Klant> loadedObject = objectLoader.loadObjects();                   // laat een lijst met alle klanten zien en print alleen id en naam ( - [--klant 1: naamKlant])

        for (Klant obj : loadedObject) {                                         // scanner index == met id van een klant - pak die klant en druk af op het scherm
            System.out.println("\nKlant naam: " + obj.getNaam() + "\nKlant ID: " + obj.getID());
        }

        int ingevuldeKlantID;
        System.out.println("\nVul klant ID in: ");
        ingevuldeKlantID = scanner.nextInt();
        scanner.nextLine(); // Add this line to consume the newline character

        // Search for the Klant object with the entered ID and print its details
        for (Klant objSearch : loadedObjects) {
            if (objSearch.getID() == ingevuldeKlantID) {
                String klantNaam = objSearch.getNaam();
                int klantID = objSearch.getID();
                String klantPassword = objSearch.getPassword();
                String klantEmail = objSearch.getEmail();
                String klantType = objSearch.getKlantType();
                double klantKorting = objSearch.getKlantKorting();
            }
        }

        // vraag of er een milieu korting moet worden toegevoegd
        System.out.println("\n--Wilt u milieukorting toevoegen?: (ja/nee)");

        // scanner - als het ja is set de korting vanuit scanner
        String antwoord = scanner.nextLine();
            while(true){
        if (antwoord.equalsIgnoreCase("ja")) {
                milieuKorting = scanner.nextDouble();
                break;
            }
        // is het nee set de korting op 0.00
            else {
                break;
        }
    }
            Offerte.MaakOfferte();
        System.out.println("De offerte wordt gemaakt!");

}

    public static void MaakOfferte() {// functie voor het aanmaken van de offerte met de klantgegevens
        String klantNaam;
        String straatnaam;
        int huisNr;
        String postcode;
        String plaatsnaam;
        LocalDate offertedatum = LocalDate.now();
        LocalDate vervaldatum = offertedatum.plus(14, ChronoUnit.DAYS);
        String product;
        int aantal;
        int tarief;
        int bedrag;

        System.out.println("Big F");// overzicht van de opgestelde offerte met de klantgegevens
        System.out.println("");
        System.out.println("klantNaam");
        System.out.println("straatnaam" + " " + "huisNr");
        System.out.println("postcode" + " " + "plaatsnaam");
        System.out.println();
        System.out.println("Offertedatum: " + offertedatum);
        System.out.println("Vervaldag: " + vervaldatum);
        System.out.println("Product | Aantal | Tarief | BTW | Bedrag ");
        System.out.printf("%-11s %-7s %-7s %-6s %-5s\n", "product", "aantal", "€" + "tarief", "21%", "€" + "bedrag");

        MenuItem terug = new TerugItem("Back to main");           // terug functie
        terug.execute();
    }

}


