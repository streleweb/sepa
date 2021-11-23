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
            System.out.println("\n");
            System.out.println(paymentt.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Payment> getAllSuccessfulPayments() {
        System.out.println("Getting successPayments from PseudoDB...");

        for (int i = 0; i < listOfSuccessfulPayments.size(); i++) {
            System.out.println(listOfSuccessfulPayments.get(i).toString());
        }

        return this.listOfSuccessfulPayments;
    }

    @Override
    public void insertNewAbortedPayment(PaymentCommand paymentCommand) {
        this.listOfAbortedPayments.add(paymentCommand);
        System.out.println("Payment aborted and saved to list of aborted payments. \n");
        System.out.println("Retrieving payment data from aborted pseudo DB list in 3 seconds...\n");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (PaymentCommand paymentC : listOfAbortedPayments) {
            System.out.println("PaymentID: " + paymentC.getPaymentId());
            System.out.println("Auftraggeber: " + paymentC.getAuftraggeberName());
            System.out.println("Auftraggeber Name: " + paymentC.getAuftraggeberIban());
            System.out.println("Empfaenger Name: " + paymentC.getRecipientName());
            System.out.println("Empfaenger IBAN: " + paymentC.getRecipientIban());
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
