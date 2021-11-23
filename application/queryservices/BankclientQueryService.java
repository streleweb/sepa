package application.queryservices;

import java.util.List;

import domain.model.entities.Bankclient;
import infrastructure.repository.SimulatedDB.BankclientDao;

public class BankclientQueryService {
    private BankclientDao bankclientDao; // would normally be JPA repository via dependency injection

    public Boolean doesBankclientExistAlready(Bankclient bankclient) {
        return bankclientDao.doesBankclientExist(bankclient);
    }

    public List<Bankclient> getAllBankClients() {
        return bankclientDao.getAllBankclients();
    }
}
