package domain.model.aggregates;

import java.util.UUID;

import application.utilityclasses.DoubleBigDecimalConverter;
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
        this.recipientIban = new Iban(paymentcommand.getRecipientIban());
        this.auftraggeberIban = new Iban(paymentcommand.getAuftraggeberIban());
        this.auftraggeberName = new AuftraggeberName(paymentcommand.getAuftraggeberName());
        this.recipientName = new RecipientName(paymentcommand.getRecipientName());
        this.paymentAmount = new PaymentAmount(
                DoubleBigDecimalConverter.convertToBigDecimal(paymentcommand.getPaymentAmount()));

        // here would be DOMAIN EVENT
        System.out.println("Payment created in Aggregate Root");
    }

    @Override
    public String toString() {
        return "PaymentId: " + this.paymentId.getPaymentIdentifier() + ", EmpfaengerIBAN: "
                + this.recipientIban.getIbanString() + ", Auftragg.IBAN: " + this.auftraggeberIban.getIbanString()
                + ", Auftraggebername: " + this.auftraggeberName.getAuftraggeberName() + ", Empfaenger: "
                + this.recipientName.getrecipientName() + ", Betrag in EUR: " + this.paymentAmount.getAsString() + "\n";
    }

    public PaymentId getPaymentId() {
        return paymentId;
    }

    public Iban getRecipientIban() {
        return recipientIban;
    }

    public Iban getAuftraggeberIban() {
        return auftraggeberIban;
    }

    public AuftraggeberName getAuftraggeberName() {
        return auftraggeberName;
    }

    public RecipientName getRecipientName() {
        return recipientName;
    }

    public PaymentAmount getPaymentAmount() {
        return paymentAmount;
    }

    public AuftraggeberAdresse getAuftraggeberAdresse() {
        return auftraggeberAdresse;
    }

    public RecipientAdresse getRecipientAdresse() {
        return recipientAdresse;
    }

    public VerwendungsZweck getVerwendungsZweck() {
        return verwendungsZweck;
    }

    public ZahlungsReferenz getZahlungsReferenz() {
        return zahlungsReferenz;
    }

}
