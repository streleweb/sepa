package domain.model.commands;

/**
 * For Command objects, which get filled with the users inputs as Strings and
 * double. Conversion to actual business-objects is done in
 * paymentcommandservice-class.
 */
public class PaymentCommand {
    private String paymentId; // Id gets set later, when all validation is finished
    private String recipientIban;
    private String auftraggeberIban;
    private String auftraggeberName;
    private String recipientName;
    private double paymentAmount;

    // optional
    private String auftraggeberAdresse;
    private String recipientAdresse;
    private String verwendungsZweck;
    private String zahlungsReferenz;

    // all args constructor with verwendungsZweck (without ID, since it ID is
    // created when all validation passes)
    public PaymentCommand(String recipientIban, String auftraggeberIban, String auftraggeberName, String recipientName,
            double paymentAmount, String auftraggeberAdresse, String recipientAdresse, String verwendungsZweck) {
        this.recipientIban = recipientIban;
        this.auftraggeberIban = auftraggeberIban;
        this.auftraggeberName = auftraggeberName;
        this.recipientName = recipientName;
        this.paymentAmount = paymentAmount;
        this.auftraggeberAdresse = auftraggeberAdresse;
        this.recipientAdresse = recipientAdresse;
        this.verwendungsZweck = verwendungsZweck;
    }

    // all args constructor with zahlungsReferenz (without ID, since it ID is
    // created when all validation passes)
    public PaymentCommand(double paymentAmount, String recipientIban, String auftraggeberIban, String auftraggeberName,
            String recipientName, String auftraggeberAdresse, String recipientAdresse, String zahlungsReferenz) {
        this.recipientIban = recipientIban;
        this.auftraggeberIban = auftraggeberIban;
        this.auftraggeberName = auftraggeberName;
        this.recipientName = recipientName;
        this.paymentAmount = paymentAmount;
        this.auftraggeberAdresse = auftraggeberAdresse;
        this.recipientAdresse = recipientAdresse;
        this.zahlungsReferenz = zahlungsReferenz;
    }

    // basic data constructor
    public PaymentCommand(String paymentId, String recipientIban, String auftraggeberIban, String auftraggeberName,
            String recipientName, double paymentAmount) {
        this.paymentId = paymentId;
        this.recipientIban = recipientIban;
        this.auftraggeberIban = auftraggeberIban;
        this.auftraggeberName = auftraggeberName;
        this.recipientName = recipientName;
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRecipientIban() {
        return recipientIban;
    }

    public void setRecipientIban(String recipientIban) {
        this.recipientIban = recipientIban;
    }

    public String getAuftraggeberIban() {
        return auftraggeberIban;
    }

    public void setAuftraggeberIban(String auftraggeberIban) {
        this.auftraggeberIban = auftraggeberIban;
    }

    public String getAuftraggeberName() {
        return auftraggeberName;
    }

    public void setAuftraggeberName(String auftraggeberName) {
        this.auftraggeberName = auftraggeberName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getAuftraggeberAdresse() {
        return auftraggeberAdresse;
    }

    public void setAuftraggeberAdresse(String auftraggeberAdresse) {
        this.auftraggeberAdresse = auftraggeberAdresse;
    }

    public String getRecipientAdresse() {
        return recipientAdresse;
    }

    public void setRecipientAdresse(String recipientAdresse) {
        this.recipientAdresse = recipientAdresse;
    }

    public String getVerwendungsZweck() {
        return verwendungsZweck;
    }

    public void setVerwendungsZweck(String verwendungsZweck) {
        this.verwendungsZweck = verwendungsZweck;
    }

    public String getZahlungsReferenz() {
        return zahlungsReferenz;
    }

    public void setZahlungsReferenz(String zahlungsReferenz) {
        this.zahlungsReferenz = zahlungsReferenz;
    }

}
