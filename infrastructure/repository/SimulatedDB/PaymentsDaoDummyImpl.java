package infrastructure.repository.SimulatedDB;

import java.util.ArrayList;
import java.util.List;

import domain.model.aggregates.Payment;

public class PaymentsDaoDummyImpl implements PaymentsDao {
    private ArrayList<Payment> listOfPayments;

    @Override
    public void insertNewPayment(Payment payment) {
        listOfPayments.add(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return this.listOfPayments;
    }

}
