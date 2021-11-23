package application.commandservices;

import domain.model.entities.Bankclient;
import infrastructure.repository.SimulatedDB.BankclientDao;

public class BankclientCommandService {
    private BankclientDao bankclientDao;

    public void addBankclient(Bankclient bankclient) {
        bankclientDao.insertBankclient(bankclient);
    }

    public void updateExistingBankclient(Bankclient bankclient) {
        bankclientDao.updateBankclient(bankclient);
    }
}
