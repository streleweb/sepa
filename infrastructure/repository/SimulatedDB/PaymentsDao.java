package infrastructure.repository.SimulatedDB;

import java.util.ArrayList;
import java.util.List;

import domain.model.aggregates.Payment;
import domain.model.aggregates.PaymentId;

public interface PaymentsDao {

    void insertNewSuccessfulPayment(Payment payment);

    void insertNewAbortedPayment(Payment payment);

    Boolean doesPaymentExist(Payment payment);

    List<Payment> getAllSuccessfulPayments();

    List<Payment> getAllAbortedPayments();

    public ArrayList<Payment> getListOfAllPayments();

}
