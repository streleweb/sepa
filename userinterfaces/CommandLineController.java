package userinterfaces;

import java.util.List;

/**
 * CMD-Controller
 * Has instances of the Service-Layer-Classes, which get called here to perform the business logic.
 */

import application.commandservices.BankclientCommandService;
import application.commandservices.PaymentCommandService;
import application.queryservices.BankclientQueryService;
import application.queryservices.PaymentQueryService;
import domain.model.aggregates.Payment;
import domain.model.aggregates.PaymentId;
import domain.model.commands.PaymentCommand;
import userinterfaces.mapper.PaymentCMDAssembler;
import userinterfaces.resources.PaymentResource;

public class CommandLineController {
    // would normally be autowired, dependency injection
    private BankclientCommandService bankclientCommandService = new BankclientCommandService();
    private PaymentCommandService paymentCommandService = new PaymentCommandService();

    private BankclientQueryService bankclientQueryService = new BankclientQueryService();
    private PaymentQueryService paymentQueryService = new PaymentQueryService();

    /**
     * Takes the UserInput-Data and creates PaymentResource, normally the Parameter
     * would be a REST-@RequestBody that gets mapped to a paymentResource-object.
     * 
     * Calls the paymentCommandService, which performs the business-logic.
     * 
     * @throws Exception
     * 
     * @params The User-Input Data
     */
    public PaymentId newVerwendungsZweckPayment(String recipientIban, String auftraggeberIban, String auftraggeberName,
            String recipientName, double paymentAmount, String auftraggeberAdresse, String recipientAdresse,
            String verwendungsZweck) throws Exception {

        // Builder with verwendungsZweck
        PaymentResource paymentResource = new PaymentResource.Builder(recipientIban, auftraggeberIban, recipientName,
                auftraggeberName, paymentAmount).withRecipientAdress(recipientAdresse)
                        .withSenderAdress(auftraggeberAdresse).withVerwendungsZweck(verwendungsZweck).build();

        // transform Resource to command object, just for display purposes, this makes
        // no sense in this application ;D
        PaymentCommand paymentCommand = PaymentCMDAssembler.toCommandFromCMD(paymentResource);

        PaymentId paymentId = paymentCommandService.createPayment(paymentCommand);
        // if successful
        return paymentId;

        // if not successful

    }

    public PaymentId newZahlungsReferenzPayment(double paymentAmount, String recipientIban, String auftraggeberIban,
            String auftraggeberName, String recipientName, String auftraggeberAdresse, String recipientAdresse,
            String zahlungsReferenz) {

        // Builder with verwendungsZweck
        PaymentResource paymentResource = new PaymentResource.Builder(recipientIban, auftraggeberIban, recipientName,
                auftraggeberName, paymentAmount).withRecipientAdress(recipientAdresse)
                        .withSenderAdress(auftraggeberAdresse).withZahlungsReferenz(zahlungsReferenz).build();

        // transform Resource to command object, just for display purposes, this makes
        // no sense in this application ;D
        PaymentCommand paymentCommand = PaymentCMDAssembler.toCommandFromCMD(paymentResource);
        try {
            PaymentId paymentId = paymentCommandService.createPayment(paymentCommand);
            // if successful
            return paymentId;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Could not create ZahlungsReferenzPayment.");
            // if not successful
            return null;
        }
    }

    public List<Payment> getSuccessFulPaymentsFromDB() {
        return paymentQueryService.getListOfAllSuccessfulPayments();
    }

    // returns command object, since it got aborted and no instance of a new payment
    // in the aggregate root was created.
    public List<PaymentCommand> getAbortedPaymentsFromDB() {
        return paymentQueryService.getListOfAllAbortedPayments();
    }

    // delegated to queryservice and then to Utility class (ReadOrWriteToCSV)
    public void readSuccessfulFromCSV() {
        paymentQueryService.getListOfAllSuccessfulPaymentsFromCSV();
    }

    // delegated to queryservice and then to Utility class (ReadOrWriteToCSV)
    public void readAbortedFromCSV() {
        paymentQueryService.getListOfAllAbortedPaymentsFromCSV();
    }

}
