package userinterfaces.mapper;

import domain.model.commands.PaymentCommand;
import userinterfaces.resources.PaymentResource;

/**
 * Transforms incoming Resources to PaymentCommand-objects
 */
public class PaymentCMDAssembler {
    public static PaymentCommand toCommandFromCMD(PaymentResource paymentResource) {

        // if VERWENDUNGSZWECK is set
        if (paymentResource.getZahlungsReferenz() == null && (paymentResource.getVerwendungsZweck() != null)) {
            return new PaymentCommand(

                    paymentResource.getRecipientIban(), paymentResource.getAuftraggeberIban(),
                    paymentResource.getAuftraggeberName(), paymentResource.getRecipientName(),
                    paymentResource.getPaymentAmount(), paymentResource.getAuftraggeberAdresse(),
                    paymentResource.getRecipientAdresse(), paymentResource.getVerwendungsZweck());
        } else {
            // if ZAHLUNGSREFERENZ is set
            return new PaymentCommand(paymentResource.getPaymentAmount(), paymentResource.getRecipientIban(),
                    paymentResource.getAuftraggeberIban(), paymentResource.getAuftraggeberName(),
                    paymentResource.getRecipientName(), paymentResource.getAuftraggeberAdresse(),
                    paymentResource.getRecipientAdresse(), paymentResource.getZahlungsReferenz());
        }
    }
}
