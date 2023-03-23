package classes;

import java.util.ArrayList;

public class Offerte {
    private int offerteID;
    private String naam;
    private String beschrijving;

    private ArrayList<EssentieleOpties> essentieleOpties; // bound to change
    private ArrayList<Klant> klant; // de klant die bij het offerte hoort

    private double milieuKorting;
    private double totaalPrijs; // word ge-set vanuit de optionele kosten (van essentieleOpties) en kortingen


    public Offerte(int offerteID, String naam, String beschrijving, ArrayList<EssentieleOpties> essentieleOpties, ArrayList<Klant> klant, double milieuKorting, double totaalPrijs) {
        this.offerteID = offerteID;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.essentieleOpties = essentieleOpties;
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

    public ArrayList<EssentieleOpties> getEssentieleOpties() {
        return essentieleOpties;
    }

    public void setEssentieleOpties(ArrayList<EssentieleOpties> essentieleOpties) {
        this.essentieleOpties = essentieleOpties;
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
}
