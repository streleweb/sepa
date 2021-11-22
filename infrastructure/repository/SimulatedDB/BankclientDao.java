package infrastructure.repository.SimulatedDB;

import java.util.List;

import domain.model.entities.Bankclient;

public interface BankclientDao {

	void insertBankclient(Bankclient bankclient);

	void updateBankclient(Bankclient bankclient);

	void deleteBankclient(String uuid);

	List<Bankclient> getAllBankclients();

}