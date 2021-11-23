import domain.model.entities.Bank;
import infrastructure.repository.SimulatedDB.BankclientDaoDummyImpl;
import userinterfaces.CommandLineController;

public class App {

    public static void main(String[] args) {
        // Fill dummy databases
        BankclientDaoDummyImpl dummyImpl = new BankclientDaoDummyImpl();
        // Fill bank-data for our dummybank
        final Bank bank = new Bank((short) 1, "BTV");

        // ----------------------------------------------------------------
        UserMenu.startingScreen();
        UserMenu.run();

    }

}