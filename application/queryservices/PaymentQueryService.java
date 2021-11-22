package application.queryservices;

import java.util.List;

import domain.model.aggregates.Payment;
import infrastructure.repository.SimulatedDB.PaymentsDao;

/**
 * Payment Query Services business logic could in production be extended with an
 * interface for SOLID principles
 */
public class PaymentQueryService {
    private PaymentsDao paymentsDao; // would normally be JPA repository via dependency injection

    // checks if the payment already exists
    public Boolean doesPaymentAlreadyExist(Payment payment) {
        return paymentsDao.doesPaymentExist(payment);
    }

    // get list of all successful payments
    public List<Payment> getListOfAllSuccessfulPayments() {
        return paymentsDao.getAllSuccessfulPayments();
    }

    // get list of all aborted payments
    public List<Payment> getListOfAllAbortedPayments() {
        return paymentsDao.getAllAbortedPayments();
    }

    // get list of all payments (success & aborted)
    public List<Payment> getCompleteListOfAllPayments() {
        return paymentsDao.getListOfAllPayments();
    }

}
