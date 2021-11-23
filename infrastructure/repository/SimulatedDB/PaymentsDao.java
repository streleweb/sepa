package infrastructure.repository.SimulatedDB;

import java.util.ArrayList;
import java.util.List;

import domain.model.aggregates.Payment;
import domain.model.aggregates.PaymentId;
import domain.model.commands.PaymentCommand;

public interface PaymentsDao {

    void insertNewSuccessfulPayment(Payment payment);

    void insertNewAbortedPayment(PaymentCommand paymentCommand);

    Boolean doesPaymentExist(Payment payment);

    List<Payment> getAllSuccessfulPayments();

    List<PaymentCommand> getAllAbortedPayments();

}
