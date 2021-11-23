import domain.model.entities.Bank;
import infrastructure.repository.SimulatedDB.BankclientDaoDummyImpl;
import userinterfaces.CommandLineController;

public class App {

    public static void main(String[] args) {
        // Fill dummy databases
        BankclientDaoDummyImpl dummyImpl = new BankclientDaoDummyImpl();
        // Fill bank-data for our dummybank
        final Bank bank = new Bank((short) 1, "BTV");

        final CommandLineController commandLineController = new CommandLineController();

        try {
            commandLineController.newVerwendungsZweckPayment("12333333333333333333", "12333333333333333333",
                    "auftraggeberName", "recipientName", 100.0, "auftraggeberAdresse", "recipientAdresse",
                    "verwendungsZweck");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}