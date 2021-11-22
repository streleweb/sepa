import infrastructure.repository.SimulatedDB.BankclientDaoDummyImpl;

public class App {

    public static void main(String[] args) {
        // Fill dummy databases
        BankclientDaoDummyImpl dummyImpl = new BankclientDaoDummyImpl();
    }
}