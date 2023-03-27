package classes.menus;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<MenuOption> options;
    private Scanner scanner;

    public Menu() {
        options = new ArrayList<MenuOption>();
        scanner = new Scanner(System.in);
    }

    public void addOption(MenuOption option) {
        options.add(option);
    }

    public void display() {
        while (true) {
            System.out.println("Main Menu:");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i).getName());
            }
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice >= 1 && choice <= options.size()) {
                options.get(choice - 1).displaySubMenu(scanner);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}

class MenuOption {
    private String name;
    private ArrayList<SubMenuOption> subMenuOptions;

    public MenuOption(String name) {
        this.name = name;
        subMenuOptions = new ArrayList<SubMenuOption>();
    }

    public String getName() {
        return name;
    }

    public void addSubMenuOption(SubMenuOption option) {
        subMenuOptions.add(option);
    }

    public void displaySubMenu(Scanner scanner) {
        while (true) {
            System.out.println(this.giveSubmenuName());
            for (int i = 0; i < subMenuOptions.size(); i++) {
                System.out.println((i + 1) + ". " + subMenuOptions.get(i).getName());
            }
            System.out.println("0. Back");

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice >= 1 && choice <= subMenuOptions.size()) {
                subMenuOptions.get(choice - 1).performAction();
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
    public String giveSubmenuName(){
        return this.getName();
    }
}

class SubMenuOption {
    private String name;

    public SubMenuOption(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void performAction() {
        System.out.println("Performing action for " + name);
    }
}
