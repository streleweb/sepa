import java.io.IOException;
import java.util.Scanner;

public class UserMenu {
    static Scanner scan = new Scanner(System.in);
    static boolean userQuits = false;
    static int cmdClear = 25; // for scrolldown

    public static void run() {
        while (!userQuits) {
            userMenu();
        }
    }

    public static void enterToStart() {
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // startingScreen
    public static void startingScreen() {

        System.out.println(
                "................................................................................................");
        System.out.println(" _____ ______ _____          _______ ______  _____ _______ ");
        System.out.println("/ ____|  ____|  __ \\ /\\     |__   __|  ____|/ ____|__   __|");
        System.out.println("| (___ | |__  | |__) /  \\ ______| |  | |__  | (___    | |   ");
        System.out.println(" \\___ \\|  __| |  ___/ /\\ \\______| |  |  __|  \\___ \\   | |   ");
        System.out.println(" ____) | |____| |  / ____ \\     | |  | |____ ____) |  | |   ");
        System.out.println("|_____/|______|_| /_/    \\_\\    |_|  |______|_____/   |_|   ");
        System.out.println(
                "                         Bitte CMD-Konsole maximieren!!                                         ");
        enterToStart();

    }

    public static void clearScreen() {
        for (int i = 0; i < cmdClear; i++) {
            System.out.println("");
        }
    }

    static void userMenu() {
        scan.nextLine();
        // maybe print last payments here

        System.out.println("\n\nWaehlen Sie bitte Ihre naechste Aktion:");
        System.out.println("\n1, Neue Zahlung mit Verwendungszweck starten.");
        System.out.println("2, Neue Zahlung mit Zahlungsreferenz beginnen.");
        System.out.println("3, Erfolgreiche Zahlungen aus PseudoDB anzeigen.");
        System.out.println("4, Gescheiterte Zahlungen aus PseudoDB anzeigen");
        System.out.println("5, Erfolgreiche Zahlungen aus successful.csv anzeigen.");
        System.out.println("6, Gescheiterte Zahlungen aus aborted.csv anzeigen");

        System.out.println("7, Quit.");

        int choice = Integer.parseInt(scan.nextLine());

        clearScreen();

        switch (choice) {
        case 1:
            UserFunctions.verwendungsZweckPayment();
            break;
        case 2:
            UserFunctions.zahlungsReferenzPayment();
            break;
        case 3:
            UserFunctions.getSuccessfulPaymentsFromPseudoDB();
            break;
        case 4:
            UserFunctions.getAbortedPaymentsFromPseudoDB();
            break;
        case 5:
            UserFunctions.getSuccessfulPaymentsFromCSV();
            break;
        case 6:
            UserFunctions.getAbortedPaymentsFromCSV();
            break;

        case 7:
            userQuits = true;
            break;
        default:
            System.out.println("Bitte eine Zahl zwischen 1 und 5 eingeben!");
            break;
        }// end switch case
    }// end userMenu()

}
