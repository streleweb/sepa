package infrastructure.repository.SimulatedDB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.model.entities.Bankclient;
import domain.model.valueobjects.Iban;

/**
 * Dummy Implementation
 */

public class BankclientDaoDummyImpl implements BankclientDao {
    private ArrayList<Bankclient> listOfBankclients = new ArrayList<>();

    /**
     * Dummy Constructor, 3 Test instances are created when program is started.
     */
    public BankclientDaoDummyImpl() {
        String uuid1 = UUID.randomUUID().toString();
        String uuid2 = UUID.randomUUID().toString();
        String uuid3 = UUID.randomUUID().toString();
        listOfBankclients.add(new Bankclient(uuid1, "Hans Wurst", new Iban("AT611904300234573201")));
        listOfBankclients.add(new Bankclient(uuid2, "Peter Strele", new Iban("AT611904300234573202")));
        listOfBankclients.add(new Bankclient(uuid3, "Max Mustermann", new Iban("AT611904300234573203")));
    }

    @Override
    public void insertBankclient(Bankclient bankclient) {
        listOfBankclients.add(bankclient);
    }

    @Override
    public Boolean doesBankclientExist(Bankclient bankclient) {
        return listOfBankclients.contains(bankclient);
    }

    @Override
    public List<Bankclient> getAllBankclients() {

        return this.listOfBankclients;
    }

    @Override
    public void updateBankclient(Bankclient bankclient) {
        listOfBankclients.remove(bankclient);
        listOfBankclients.add(bankclient);
    }

}
