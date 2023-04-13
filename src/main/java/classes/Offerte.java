package classes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Offerte{

    // Bewaart objecten
    ObjectSaver<Klant> objectSaver = new ObjectSaver<>("KlantInformatie.json");
    // Maak een nieuw ObjectSaver-object voor KlantInfo-objecten met de .json file naam "KlantInformatie.json".

    // Laadt objecten
    ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json");

    LocalDate offertedatum = LocalDate.now();
    LocalDate vervaldatum = offertedatum.plus(14, ChronoUnit.DAYS);

    private int offerteID;
    private String offerteNaam;
    private String beschrijving;
    static private int ingevuldeKlantID;

    private ArrayList<EssentieleFeatures> essentieleFeatures; // Bound to change
    private ArrayList<ExtraOpties> extraOpties;
    private ArrayList<Klant> offerteKlant; // Klant die bij de offerte hoort

    private double milieuKorting;
    private double totaalPrijs; // Wordt ge-set vanuit de optionele kosten (van essentieleOpties) en kortingen


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

    public ArrayList <Klant> getOfferteKlant() {
        return offerteKlant;
    }

    public void setKlant(ArrayList <Klant> offerteKlant) {
        this.offerteKlant = offerteKlant;
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

        // List<Klant> loadedObjects = objectLoader.loadObjects();

        Scanner scanner = new Scanner(System.in);
        // Vraag om alle info


        // Vraag om de naam van de offerte via scanner
        System.out.println("Wat is de naam van de offerte?");
        String tempNaam = scanner.nextLine();
        this.offerteNaam = tempNaam;

        System.out.println("");

        // Vraag om een beschrijving van de offerte via scanner
        System.out.println("Beschrijf de offerte: ");
        String tempBeschrijving = scanner.nextLine();
        this.beschrijving = tempBeschrijving;

        // Vraag om extra opties
        ArrayList<ExtraOpties> addExtraOpties = new ArrayList<>();

        // Vraag of er een feature bij moet - ja, blijf loopen - nee, break
        System.out.println("-- Hoeveel extra opties wilt u toevoegen?: ");
        // Scanner
        int aantal = scanner.nextInt();

        // Van int naar een String, lege regel erbij
        scanner.nextLine();

        for (int i = 0; i < aantal; aantal--) {
            // Naam van de feature - check is het een String

            System.out.println("-- Wat is de naam van de feature?: ");
            String featureName = scanner.nextLine();

            // Vraag om de prijs - check is het een int
            // Scanner
            System.out.println("-- Wat wordt de prijs?: (2 decimale getal) ");
            double featurePrice = scanner.nextDouble();

            // Van int naar een String, lege regel erbij
            scanner.nextLine();

            // Voeg de 2 variabelen toe aan een extra opties
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


        System.out.println("--Voor welke klant wordt de offerte aangemaakt?: ");
        // Vraag voor welke klant de offerte is

        List<Klant> loadedObject = objectLoader.loadObjects();
        // Laat een lijst van alle klanten zien

        // Print alleen id en naam van de klant
        for (Klant obj : loadedObject) { // scanner index == met id van een klant - pak die klant en druk af op het scherm
            System.out.println("\nKlant naam: " + obj.getNaam() + "\nKlant ID: " + obj.getID());
        }


        System.out.println("\nVul klant ID in: ");
        ingevuldeKlantID = scanner.nextInt();
        scanner.nextLine();

        // Vraag of er een milieu korting moet worden toegevoegd
        System.out.println("\n--Wilt u milieukorting toevoegen?: (ja/nee)");

        // Scanner - als het ja is set de korting vanuit scanner
        String antwoord = scanner.nextLine();
            while(true){
        if (antwoord.equalsIgnoreCase("ja")) {
                milieuKorting = scanner.nextDouble();
                break;
            }
        // Is het nee set de korting op 0.00
            else {
                break;
        }
    }
            Offerte.MaakOfferte();
        System.out.println("De offerte wordt gemaakt!");

}

    public static void MaakOfferte() { // Functie voor het aanmaken van de offerte met de klantgegevens

        ObjectLoader<Klant> objectLoader = new ObjectLoader<>(Klant.class, "KlantInformatie.json"); //laadt objecten
        List<Klant> loadedObject = objectLoader.loadObjects(); // laat een lijst van alle klanten zien


        LocalDate offertedatum = LocalDate.now();
        LocalDate vervaldatum = offertedatum.plus(14, ChronoUnit.DAYS);
        String product;
        int aantal;
        double tarief;
        double bedrag;



        for (Klant objSearch : loadedObject) {
            if (objSearch.getID() == ingevuldeKlantID) {
                String klantNaam = objSearch.getNaam();
                String straatnaam= objSearch.getEmail();
                int huisNr = objSearch.getID();
                String postcode = objSearch.getKlantType();
                double plaatsnaam = objSearch.getKlantKorting();
            }
        }

        System.out.println("Big F"); // Overzicht van de opgestelde offerte met de klantgegevens
        System.out.println("");
        System.out.println("klantNaam");
        System.out.println("straatnaam" + " " + "huisNr");
        System.out.println("postcode" + " " + "plaatsnaam");
        System.out.println();
        System.out.println("Offertedatum: " + offertedatum);
        System.out.println("Vervaldag: " + vervaldatum);
        System.out.println("Product | Aantal | Tarief | BTW | Bedrag ");
        System.out.printf("%-11s %-7s %-7s %-6s %-5s\n", "product", "aantal", "€" + "tarief", "21%", "€" + "bedrag");

        MenuItem terug = new TerugItem("Back to main"); // Terug functie
        terug.execute();
    }

}


