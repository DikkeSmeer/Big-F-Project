package classes;

import java.util.ArrayList;

public class TOI extends Offerte{
    public TOI(int offerteID, String naam, String beschrijving, ArrayList<EssentieleFeatures> essentieleFeatures, ArrayList<Klant> klant, double milieuKorting, double totaalPrijs) {
        super(offerteID, naam, beschrijving, essentieleFeatures, klant, milieuKorting, totaalPrijs);
    }

    public static double nieuwePrijs(double prijs, double korting) {
        double factor = (korting / 100);

        return prijs * factor;
    }

    public static void main(String[] args) {
        double testPrijs1 = 120.50;
        double testPrijs2 = 567.30;
        double testPrijs3 = 300.00;
        double korting = 30.0;

        System.out.println(nieuwePrijs(testPrijs1, korting));
    }

}
// Big F

// KlantNaam
// KlantAdres

// OfferteDatum
// Vervaldag

// Product | Aantal | Tarief | BTW | Bedrag