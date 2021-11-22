package infrastructure.repository;

import java.util.List;

import domain.model.entities.Bankclient;

/**
 * This class would extend JpaRepository for instance, dummy version
 */
public interface BankClientRepo {
    Bankclient findBankClientById(String id);

    List<Bankclient> getAllBankClients();
}
