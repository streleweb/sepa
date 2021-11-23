package infrastructure.repository.SimulatedDB;

import java.util.ArrayList;
import java.util.List;

import domain.model.aggregates.Payment;
import domain.model.commands.PaymentCommand;

public class PaymentsDaoDummyImpl implements PaymentsDao {
    private ArrayList<Payment> listOfSuccessfulPayments = new ArrayList<>();
    private ArrayList<PaymentCommand> listOfAbortedPayments = new ArrayList<>();

    @Override
    public void insertNewSuccessfulPayment(Payment payment) {
        listOfSuccessfulPayments.add(payment);
        // write it into CSV-File aswell (utilityclasses)
    }

    @Override
    public List<Payment> getAllSuccessfulPayments() {
        return this.listOfSuccessfulPayments;
    }

    @Override
    public void insertNewAbortedPayment(PaymentCommand paymentCommand) {
        this.listOfAbortedPayments.add(paymentCommand);

    }

    @Override
    public List<PaymentCommand> getAllAbortedPayments() {
        return this.listOfAbortedPayments;
    }

    @Override
    public Boolean doesPaymentExist(Payment payment) {
        return listOfSuccessfulPayments.contains(payment);// true or false
    }

}
