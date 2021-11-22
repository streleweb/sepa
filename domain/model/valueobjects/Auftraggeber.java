package domain.model.valueobjects;

import domain.model.entities.AuftraggeberName;

/**
 * Implemented as value-object, the customer or bank-client itself is being
 * created in the BankClient-class. This way the data for every transaction is
 * being made immutable.
 * 
 * This class has seperate constructors, it can be used strictly for
 * Auftraggeber-relevant data, or data including all the relevant payment data.
 */
public final class Auftraggeber {
    private Iban iban;
    private AuftraggeberName auftraggeberName;
    private AuftraggeberAdresse auftraggebberAdresse;
    private VerwendungsZweck verwendungsZweck;
    private ZahlungsReferenz zahlungsReferenz;
    private PaymentAmount paymentAmount;

    /**
     * Constructor with all Payment-Data
     * 
     * @param iban
     * @param auftraggeberName
     * @param auftraggebberAdresse
     * @param verwendungsZweck
     * @param zahlungsReferenz
     * @param paymentAmount
     */
    public Auftraggeber(Iban iban, AuftraggeberName auftraggeberName, AuftraggeberAdresse auftraggebberAdresse,
            VerwendungsZweck verwendungsZweck, ZahlungsReferenz zahlungsReferenz, PaymentAmount paymentAmount) {
        this.iban = iban;
        this.auftraggeberName = auftraggeberName;
        this.auftraggebberAdresse = auftraggebberAdresse;
        this.verwendungsZweck = verwendungsZweck;
        this.zahlungsReferenz = zahlungsReferenz;
        this.paymentAmount = paymentAmount;
    }

    public Auftraggeber(Iban iban, AuftraggeberName auftraggeberName, VerwendungsZweck verwendungsZweck) {
        this.iban = iban;
        this.auftraggeberName = auftraggeberName;
        this.auftraggebberAdresse = auftraggebberAdresse;
        this.verwendungsZweck = verwendungsZweck;
    }

    public Iban getIban() {
        return iban;
    }

    public AuftraggeberName getAuftraggeberName() {
        return auftraggeberName;
    }

    public AuftraggeberAdresse getAuftraggebberAdresse() {
        return auftraggebberAdresse;
    }

    public VerwendungsZweck getVerwendungsZweck() {
        return verwendungsZweck;
    }

}
