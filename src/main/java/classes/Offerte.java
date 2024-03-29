package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Offerte {
    private int offerteID;
    private String naam;
    private String beschrijving;

    private ArrayList<EssentieleFeatures> essentieleFeatures; // bound to change
    private ArrayList<ExtraOpties> extraOpties;

    private ArrayList<Klant> klant; // de klant die bij het offerte hoort

    private double milieuKorting;
    private double totaalPrijs; // word ge-set vanuit de optionele kosten (van essentieleOpties) en kortingen


//    public Offerte(String naam, String beschrijving, ArrayList<EssentieleFeatures> essentieleFeatures, ArrayList<Klant> klant, double milieuKorting) {
//        this.naam = naam;
//        this.beschrijving = beschrijving;
//        this.essentieleFeatures = essentieleFeatures;
//        this.klant = klant;
//        this.milieuKorting = milieuKorting;
//    }
    public Offerte(){
        aanmakenOfferte();
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


    public void aanmakenOfferte(){
        Scanner invoer = new Scanner(System.in);
        // vraag om alle info


        // vraag om een naam via scanner
        System.out.println("Wat wordt de naam van dit offerte?");
        String tempNaam = invoer.nextLine();
        this.naam = tempNaam;

        System.out.println("");

        // vraag om een beschrijving via scanner
        System.out.println("Beschrijf dit offerte: ");
        String tempBeschrijving = invoer.nextLine();
        this.beschrijving = tempBeschrijving;


        //vraag om essentiele features
        ArrayList<ExtraOpties> addExtraOpties = new ArrayList<>();

        // Vraag of er een feature bij moet - ja blijf loopen - nee break
        System.out.println("-- Hoeveel extra opties wilt u toevoegen: ");
        // scanner
        int aantal = invoer.nextInt();

        // van int naar een string moet een empty line erbij
        invoer.nextLine();

        for (int i = 0; i < aantal; aantal--) {
            // naam van de feature - check is het een string

            System.out.println("-- Wat is de naam van de Feature: ");
            String featureName = invoer.nextLine();

            // vraag om de prijs - check is het een int
            // scanner
            System.out.println("-- Wat word de prijs: (2 decimale getal) ");
            double featurePrice = invoer.nextDouble();

            // van int naar een string moet een empty line erbij
            invoer.nextLine();

            // voeg de 2 variablen toe aan een essentiele feature
            ExtraOpties optie = new ExtraOpties(featureName, featurePrice);
            addExtraOpties.add(optie);
        }

        this.setExtraOpties(addExtraOpties);

        double totaal = 0.00;
        for(ExtraOpties optie : this.extraOpties){
            System.out.println(optie.getName() + optie.getPrijs());
            totaal += optie.getPrijs();
        }
        System.out.println("Het totaal bedrag = " + totaal);

            // vraag voor welke klant dit is
            // laat een lijst met alle klanten zien en print alleen id en naam - [--klant 1: naamKlant]
            // scanner index == met id van een klant - pak die klant en voeg het KLANT OBJECT toe
            //Klant addKlant;

            // vraag of er een milieu korting moet worden toegevoegd
            // scanner - als het ja is set de korting vanuit scanner
            // is het nee set de korting als 0.00
            //double addMilieuKorting = 0.00;

    }

}
