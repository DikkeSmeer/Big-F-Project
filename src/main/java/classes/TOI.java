package classes;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

        MaakOfferte();
    }

    public static void MaakOfferte() {
        String klantNaam = "John Doe";
        String straatnaam = "Faka mon ami niet zo negatiefstraat";
        int nr = 32;
        String postcode = "1234AB";
        String plaatsnaam = "Den Haag";
        LocalDate offertedatum = LocalDate.now();
        LocalDate vervaldag = offertedatum.plus(30, ChronoUnit.DAYS);
        String product = "dinghie";
        int aantal = 5;
        int tarief = 200;
        int bedrag = 500;


        System.out.println("Big F");
        System.out.println();
        System.out.println(klantNaam);
        System.out.println(straatnaam + " " + nr);
        System.out.println(postcode + " " + plaatsnaam);
        System.out.println();
        System.out.println("Offertedatum: " + offertedatum);
        System.out.println("vervaldag: " + vervaldag);
        System.out.println("Product | Aantal | Tarief | BTW | Bedrag ");
        System.out.printf("%-11s %-7s %-7s %-6s %-5s\n", product, aantal, "€" + tarief, "21%", "€" + bedrag);



    }

}
// Big F

// KlantNaam
// KlantAdres

// OfferteDatum
// Vervaldag

// Product | Aantal | Tarief | BTW | Bedrag