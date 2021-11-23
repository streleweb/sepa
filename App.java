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

        commandLineController.newVerwendungsZweckPayment("recipientIban", "auftraggeberIban", "auftraggeberName",
                "recipientName", 100.0, "auftraggeberAdresse", "recipientAdresse", "verwendungsZweck");

    }
}