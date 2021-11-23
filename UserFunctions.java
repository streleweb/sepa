import userinterfaces.CommandLineController;

public class UserFunctions {

    final static CommandLineController commandLineController = new CommandLineController();

    public static void verwendungsZweckPayment() {
        try {
            commandLineController.newVerwendungsZweckPayment("12333333333333333333", "12333333333333333333",
                    "auftraggeberName", "recipientName", 100.0, "auftraggeberAdresse", "recipientAdresse",
                    "verwendungsZweck");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
        commandLineController.getSuccessFulPaymentsFromDB();
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
