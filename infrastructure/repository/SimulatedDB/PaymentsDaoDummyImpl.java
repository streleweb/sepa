package infrastructure.repository.SimulatedDB;

import java.util.ArrayList;
import java.util.List;

import domain.model.aggregates.Payment;
import domain.model.commands.PaymentCommand;

public class PaymentsDaoDummyImpl implements PaymentsDao {
    private ArrayList<Payment> listOfSuccessfulPayments = new ArrayList<Payment>();
    private ArrayList<PaymentCommand> listOfAbortedPayments = new ArrayList<PaymentCommand>();

    @Override
    public void insertNewSuccessfulPayment(Payment payment) {
        System.out.println("successPaymentMessage from [DAODUMMYIMPL]");
        listOfSuccessfulPayments.add(payment);

        System.out.println("Retrieving payment data from pseudo DB list in 3 seconds...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Payment paymentt : listOfSuccessfulPayments) {
            System.out.println(paymentt.toString());
        }
    }

    @Override
    public List<Payment> getAllSuccessfulPayments() {
        for (Payment payment : listOfSuccessfulPayments) {
            System.out.println("PaymentID: " + payment.getPaymentIdString());
            System.out.println("Auftraggeber: " + payment.getAuftraggeberNameString());
            System.out.println("Auftraggeber Name: " + payment.getAuftraggeberIbanString());
            System.out.println("Empfaenger Name: " + payment.getRecipientNameString());
            System.out.println("Empfaenger IBAN: " + payment.getRecipientIbanString());
            System.out.println("Betrag in EUR: " + payment.getPaymentAmountString());
        }

        return this.listOfSuccessfulPayments;
    }

    @Override
    public void insertNewAbortedPayment(PaymentCommand paymentCommand) {
        this.listOfAbortedPayments.add(paymentCommand);

        System.out.println("Retrieving payment data from aborted pseudo DB list in 3 seconds...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (PaymentCommand paymentC : listOfAbortedPayments) {
            System.out.println("PaymentID: " + paymentC.getPaymentId());
            System.out.println("Auftraggeber: " + paymentC.getAuftraggeberNameString());
            System.out.println("Auftraggeber Name: " + paymentC.getAuftraggeberIbanString());
            System.out.println("Empfaenger Name: " + paymentC.getRecipientNameString());
            System.out.println("Empfaenger IBAN: " + paymentC.getRecipientIbanString());
            System.out.println("Betrag in EUR: " + paymentC.getPaymentAmountString());

        }

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
