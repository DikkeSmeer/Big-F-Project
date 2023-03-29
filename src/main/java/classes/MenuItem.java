package classes;

import Interfaces.MenuItemInterface;

abstract class MenuItem implements MenuItemInterface {
    // een menu item heeft een naam en een execute functie, deze word overwritten per item
    String name;

    // construct en name Getter
    public MenuItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class OfferteOverzichtItem extends MenuItem {
    public OfferteOverzichtItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        OfferteMenu bmenu = new OfferteMenu();
        bmenu.createMenu();
        bmenu.execute(bmenu.printMenu());
    }
}
class KlantenOverzichtItem extends MenuItem {
    public KlantenOverzichtItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        OfferteMenu bmenu = new OfferteMenu();
        bmenu.createMenu();
        bmenu.execute(bmenu.printMenu());
        System.out.println("Test");
    }
}

class TerugItem extends MenuItem {
    public TerugItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        // FIX THIS
    }
}

//sub menu Items per SubMenu

// Offerte Overzicht Menu Items
class OfferteAanmakenItem extends MenuItem {
    public OfferteAanmakenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Dit voert de :Offerte Aanmaken: uit.");
    }
}

class OfferteBekijkenItem extends MenuItem {
    public OfferteBekijkenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        //Lijst.printLijst(Lijst.getLijst(),3);
        System.out.println("Dit voert de :Alle Offerte Laten zien: uit.");
    }
}

// Klanten Overzicht Menu Items
class KlantAanmakenItem extends MenuItem{
    public KlantAanmakenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Dit voert de :Klant aanmaken: uit.");
    }
}
class KlantenBekijkenItem extends MenuItem{
    public KlantenBekijkenItem(String name) {
        super(name);
    }
    @Override
    public void execute() {
        System.out.println("Dit voert de :Klanten Overzicht: uit.");
    }
}

// voeg hier meerdere menuitems toe op basis van een Menu Class in Menu
