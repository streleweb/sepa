package infrastructure.repository.SimulatedDB;

import java.util.ArrayList;
import java.util.List;

import domain.model.aggregates.Payment;

public class PaymentsDaoDummyImpl implements PaymentsDao {
    private ArrayList<Payment> listOfSuccessfulPayments;
    private ArrayList<Payment> listOfAbortedPayments;
    private ArrayList<Payment> listOfAllPayments;

    @Override
    public void insertNewSuccessfulPayment(Payment payment) {
        listOfSuccessfulPayments.add(payment);
        listOfAllPayments.add(payment);
        // write it into CSV-File aswell (utilityclasses)
    }

    @Override
    public List<Payment> getAllSuccessfulPayments() {
        return this.listOfSuccessfulPayments;
    }

    @Override
    public void insertNewAbortedPayment(Payment payment) {
        this.listOfAbortedPayments.add(payment);
        listOfAllPayments.add(payment);
    }

    @Override
    public List<Payment> getAllAbortedPayments() {
        return this.listOfAbortedPayments;
    }

    @Override
    public Boolean doesPaymentExist(Payment payment) {
        return listOfAllPayments.contains(payment); // true or false
    }

    @Override
    public ArrayList<Payment> getListOfAllPayments() {
        return listOfAllPayments;
    }

}
