package classes;

public class Main {
    public static void main(String[] args) {
        HoofdMenu menu = new HoofdMenu();
        menu.createMenu();
        menu.execute(menu.printMenu());
    }
}
