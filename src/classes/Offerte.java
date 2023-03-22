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

}
