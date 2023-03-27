package classes.menus;
import java.util.Scanner;

import classes.menus.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        MenuOption option1 = new MenuOption("Offerte overzicht Menu");
        option1.addSubMenuOption(new SubMenuOption("1. Zie Offertes - nieuw menu"));
        option1.addSubMenuOption(new SubMenuOption("2. Nieuwe offerte toevoegen"));
        menu.addOption(option1);

        MenuOption option2 = new MenuOption("Klantenbeheer Menu");
        option2.addSubMenuOption(new SubMenuOption("1. Alle klanten weergeven - nieuwe menu"));
        option2.addSubMenuOption(new SubMenuOption("2. Klant aanmaken"));
        menu.addOption(option2);

        MenuOption option3 = new MenuOption("Offerte Aanmaken");
        option3.addSubMenuOption(new SubMenuOption("Offerte opties"));
        option3.addSubMenuOption(new SubMenuOption("Offerte Kortingen"));
        menu.addOption(option3);

        menu.display();
    }
}
