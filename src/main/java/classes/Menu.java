package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    protected ArrayList<MenuItem> menu = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public int printMenu() {
        int index = 1;
        System.out.println("Kies uw optie: ");
        for (MenuItem item : menu) {
            System.out.println(index + ": " + item.getName());
            index++;
        }
        return sc.nextInt();
    }
}
class HoofdMenu extends Menu {
    public void createMenu() {
        // Voegt opties toe aan het menu die een eigen extend hebben - zoals offerteAanmaak menu
        // - OfferteMenu - KlantenMenu
        menu.add(new OfferteOverzichtItem("Offerte Overzicht"));
        menu.add(new KlantenOverzichtItem("Klanten Overzicht"));

    }

    public void execute(int input) {
        menu.get(input -1 ).execute();
    }
}

    // Alle sub-menu's die items uitvoeren hieronder
    // Offerte Sub Menu
class OfferteMenu extends Menu {
    public void createMenu() {
        menu.add(new OfferteAanmakenItem("Offerte Aanmaken"));
        menu.add(new OfferteBekijkenItem("Offertes Bekijken"));
        menu.add(new TerugItem("Terug"));
    }
    public void execute(int input) {
        // Execute de execute van de menu item, leest input van de scanner
        menu.get(input-1).execute();
    }
}
    // Klanten Menu
class KlantenMenu extends Menu {
    public void createMenu(){
        menu.add(new KlantAanmakenItem("Klant Aanmaken"));
        menu.add(new KlantenBekijkenItem("Klanten Bekijken"));
        menu.add(new TerugItem("Terug"));
    }
    public void execute(int input) {
        // Execute de execute van de mnu item, leest input van de scanner
        menu.get(input-1).execute();
    }
}

// Voeg hier een Menu toe voor wat je nodig hebt en add de Menu items die je wilt gebruiken aan de array list