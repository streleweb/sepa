package application.commandservices;

import java.util.UUID;

import application.utilityclasses.ReadOrWriteToCSV;
import domain.model.aggregates.Payment;
import domain.model.aggregates.PaymentId;
import domain.model.commands.PaymentCommand;
import infrastructure.repository.SimulatedDB.PaymentsDao;

/**
 * Business Logic for Payments implemented here.
 */
public class PaymentCommandService {
    private PaymentsDao paymentsDao;

    public PaymentId createPayment(PaymentCommand paymentCommand) throws Exception {
        // todo validate with queryservice.doesstuffexist etc.

        // if !exists and all validation passes (WRITE VALIDATION CLASSES)
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
        ReadOrWriteToCSV.writeToSuccessfulPayments(paymentCommand);

        return new PaymentId(uuid);

        // IF NOT ADD to the list of abortedPayments, don`t forget to store in csv files
    }

}
