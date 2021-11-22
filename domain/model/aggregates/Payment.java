package domain.model.aggregates;

import java.util.UUID;

import domain.model.commands.PaymentCommand;
import domain.model.valueobjects.AuftraggeberAdresse;
import domain.model.valueobjects.AuftraggeberName;
import domain.model.valueobjects.Iban;
import domain.model.valueobjects.PaymentAmount;
import domain.model.valueobjects.RecipientAdresse;
import domain.model.valueobjects.RecipientName;
import domain.model.valueobjects.VerwendungsZweck;
import domain.model.valueobjects.ZahlungsReferenz;

/**
 * Payment "Root"-Aggregate, every new Payment is being created via a command.
 * 
 */
public class Payment {
    private PaymentId paymentId;
    private Iban recipientIban;
    private Iban auftraggeberIban;
    private AuftraggeberName auftraggeberName;
    private RecipientName recipientName;
    private PaymentAmount paymentAmount;

    // optional
    private AuftraggeberAdresse auftraggeberAdresse;
    private RecipientAdresse recipientAdresse;
    private VerwendungsZweck verwendungsZweck;
    private ZahlungsReferenz zahlungsReferenz;

    /**
     * Basic Data constructor (without optional data)
     * 
     * @param paymentId
     * @param recipientIban
     * @param auftraggeberIban
     * @param auftraggeberName
     * @param recipientName
     * @param paymentAmount
     */
    public Payment(PaymentCommand paymentcommand) {
        this.paymentId = new PaymentId(paymentcommand.getPaymentId());
        this.recipientIban = recipientIban;
        this.auftraggeberIban = auftraggeberIban;
        this.auftraggeberName = auftraggeberName;
        this.recipientName = recipientName;
        this.paymentAmount = paymentAmount;
    }

}
