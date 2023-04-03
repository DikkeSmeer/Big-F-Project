package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Offerte {
    private int offerteID;
    private String naam;
    private String beschrijving;

    private ArrayList<EssentieleFeatures> essentieleFeatures; // bound to change
    private ArrayList<Klant> klant; // de klant die bij het offerte hoort

    private double milieuKorting;
    private double totaalPrijs; // word ge-set vanuit de optionele kosten (van essentieleOpties) en kortingen


    public Offerte(int offerteID, String naam, String beschrijving, ArrayList<EssentieleFeatures> essentieleFeatures, ArrayList<Klant> klant, double milieuKorting, double totaalPrijs) {
        this.offerteID = offerteID;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.essentieleFeatures = essentieleFeatures;
        this.klant = klant;
        this.milieuKorting = milieuKorting;
        this.totaalPrijs = totaalPrijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
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

    public void aanmakenOfferte(){
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running){

            // vraag om alle info

            // vraag om een naam via scanner
            System.out.println("Naam: ");
            String offerteNaam = scanner.nextLine();

            // vraag om een beschrijving via scanner
            System.out.println("Beschrijving: ");
            String offerteBeschrijving = scanner.nextLine();

            // vraag om essentiele features
            ArrayList<EssentieleFeatures> addEssentieleFeatures = new ArrayList<>();

            while (true)
            {
                // Vraag of er een feature bij moet - ja blijf loopen - nee break
                System.out.println("Moet er nog een feature bij? (ja/nee)");
                // scanner
                String scannerAntwoord = scanner.nextLine();
                if (scannerAntwoord.equals("nee")) {break;}

                // naam van de feature - check is het een string
                // scanner
                String featureName = "";
                //--
                // vraag om de prijs - check is het een int
                // scanner
                double featurePrice = 0.00;

                // voeg de 2 variablen toe aan een essentiele feature
                EssentieleFeatures feature = new EssentieleFeatures(featureName, featurePrice);

                addEssentieleFeatures.add(feature);
            }

            // vraag voor welke klant dit is
            // laat een lijst met alle klanten zien en print alleen id en naam - [--klant 1: naamKlant]
            // scanner index == met id van een klant - pak die klant en voeg het KLANT OBJECT toe
            Klant addKlant;

            // vraag of er een milieu korting moet worden toegevoegd
            // scanner - als het ja is set de korting vanuit scanner
            // is het nee set de korting als 0.00
            double addMilieuKorting = 0.00;



            Offerte offerte = new Offerte(offerteNaam, offerteBeschrijving, addEssentieleFeatures, addKlant, addMilieuKorting);



        }
    }

}
