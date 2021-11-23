import java.util.List;
import java.util.Scanner;

import domain.model.aggregates.Payment;
import userinterfaces.CommandLineController;

public class UserFunctions {

    final static CommandLineController commandLineController = new CommandLineController();

    public static void verwendungsZweckPayment() {
        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                System.out.println("Geben Sie Ihren IBAN ein: ");
                String iban = s.nextLine();
                System.out.println("Geben Sie den IBAN des Empfaengers ein: ");
                String ibanE = s.nextLine();
                System.out.println("Geben Sie den Betrag ein: ");
                double betrag = Double.valueOf(s.nextLine());
                System.out.println("Geben Sie Ihren Namen ein: ");
                String auftName = s.nextLine();
                System.out.println("Geben Sie den Empfängernamen ein: ");
                String empfName = s.nextLine();
                System.out.println("Trying to initiate payment...\n\n");

                Thread.sleep(2000);
                commandLineController.newVerwendungsZweckPayment(iban, ibanE, auftName, empfName, betrag,
                        "auftraggeberAdresse", "recipientAdresse", "verwendungsZweck");
                System.out.println("Payment Successful!\n\n");
                break;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());

            }
        }
    }

    public static void zahlungsReferenzPayment() {
        try {
            commandLineController.newZahlungsReferenzPayment(100.0, "12333333333333333333", "12333333333333333333",
                    "auftraggeberName", "recipientName", "auftraggeberAdresse", "recipientAdresse", "zahlungsReferenz");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getSuccessfulPaymentsFromPseudoDB() {
        List<Payment> successFromPseudoDB = commandLineController.getSuccessFulPaymentsFromDB();
        for (Payment p : successFromPseudoDB) {
            System.out.println(p.toString());
        }
    }

    public static void getAbortedPaymentsFromPseudoDB() {
        commandLineController.getAbortedPaymentsFromDB();
    }

    public static void getSuccessfulPaymentsFromCSV() {
        commandLineController.readSuccessfulFromCSV();
    }

    public static void getAbortedPaymentsFromCSV() {
        commandLineController.readSuccessfulFromCSV();
    }
}
