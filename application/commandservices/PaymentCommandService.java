package application.commandservices;

import java.io.IOException;
import java.util.UUID;

import application.utilityclasses.PaymentCommandValidation;
import application.utilityclasses.ReadOrWriteToCSV;
import domain.model.aggregates.Payment;
import domain.model.aggregates.PaymentId;
import domain.model.commands.PaymentCommand;
import infrastructure.repository.SimulatedDB.PaymentsDao;
import infrastructure.repository.SimulatedDB.PaymentsDaoDummyImpl;

/**
 * Business Logic for Payments implemented here.
 */
public class PaymentCommandService {
    // would normally be autowired via dependency injection
    private PaymentsDao paymentsDao = new PaymentsDaoDummyImpl();

    public PaymentId createPayment(PaymentCommand paymentCommand) throws Exception {
        // todo validate with queryservice.doesstuffexist etc.
        // System.out.println("Debug");
        if (PaymentCommandValidation.validatePaymentCommand(paymentCommand)) {
            String uuidString = UUID.randomUUID().toString().toUpperCase();
            String uuid = uuidString.substring(0, uuidString.indexOf("-")); // from index 0 to - sign
            System.out.println("New uuid :" + uuid);

            // id gets added now, so that if validation fails, no id is created beforehand
            paymentCommand.setPaymentId(uuid);
            // Actual root-aggregate receives the paymentCommand in its constructor
            // (commandhandler)
            Payment payment = new Payment(paymentCommand);

            // persist the Data to our pseudo repository / DB
            paymentsDao.insertNewSuccessfulPayment(payment);
            // create new Successful payment value object and save it to the successful.csv
            // file
            try {
                ReadOrWriteToCSV.writeToSuccessfulPayments(paymentCommand);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return new PaymentId(uuid);
        }

        else {
            // persist the Data to our pseudo repository / DB
            // Don`t instanciate a Payment, since it has to be aborted
            paymentsDao.insertNewAbortedPayment(paymentCommand);

            try {
                ReadOrWriteToCSV.writeToSuccessfulPayments(paymentCommand);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

        // IF NOT ADD to the list of abortedPayments, don`t forget to store in csv files
    }

}
