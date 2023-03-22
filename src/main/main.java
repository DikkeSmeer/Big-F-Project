package main;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int keuze = 0;

        // blijft loopen totdat er de applicatie word afgesloten
        while (keuze != 3) {
            System.out.println("Hoofdmenu:");
            // opties gaan naar een ander 'menu'

            System.out.println("1. Optie 1");
            System.out.println("2. Optie 2");
            System.out.println("3. Exit");

            // Lees de invoer van de gebruiker
            if (scanner.hasNextInt()) {
                keuze = scanner.nextInt();

                switch (keuze) {
                    case 1:
                        System.out.println("Optie 1 geselecteerd.");
                        break;
                    case 2:
                        System.out.println("Optie 2 geselecteerd.");
                        break;
                    case 3:
                        System.out.println("Programma afgesloten.");
                        break;
                    default:
                        System.out.println("Ongeldige invoer. Probeer het opnieuw.");
                        break;
                }

            } else {
                System.out.println("Ongeldige invoer. Probeer het opnieuw.");
                scanner.next();
            }
        }
    }
}
