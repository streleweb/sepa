package infrastructure.repository.SimulatedDB;

import java.util.List;

import domain.model.aggregates.Payment;

public interface PaymentsDao {

    void insertNewPayment(Payment payment);

    List<Payment> getAllPayments();

}
