package userinterfaces.resources;

/*
* Resourc that gets filled with userinputs using
* Builder Pattern
*/
public class PaymentResource {

    // private String paymentId;
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

    // only getters
    public String getRecipientIban() {
        return this.recipientIban;
    }

    public String getAuftraggeberIban() {
        return this.auftraggeberIban;
    }

    public String getAuftraggeberName() {
        return this.auftraggeberName;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public double getPaymentAmount() {
        return this.paymentAmount;
    }

    public String getAuftraggeberAdresse() {
        return this.auftraggeberAdresse;
    }

    public String getRecipientAdresse() {
        return this.recipientAdresse;
    }

    public String getVerwendungsZweck() {
        return this.verwendungsZweck;
    }

    public String getZahlungsReferenz() {
        return this.zahlungsReferenz;
    }

    /**
     * Private constructor, so no instances of PaymentResource can get created
     */
    private PaymentResource() {
    }

    /*
     * Nested static Builder class, helps avoid mistakes because of the many
     * parameters.
     *********************************************************************************************************/
    public static class Builder {

        // private String paymentId;
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

        /*
         * Constructor only takes the nessesary parameters for a payment. Every optional
         * parameter can be added via wither-Pattern
         */
        public Builder(String recipientIban, String auftraggIban, String recipientName, String auftraggName,
                double amount) {
            this.recipientIban = recipientIban;
            this.auftraggeberIban = auftraggIban;
            this.recipientName = recipientName;
            this.auftraggeberName = auftraggName;
            this.paymentAmount = amount;
        }

        /**
         * withSenderAdress returns a Builder-Object
         */
        public Builder withSenderAdress(String senderAdress) {
            if (senderAdress == null || senderAdress.isEmpty())
                this.auftraggeberAdresse = "Empty";
            else
                this.auftraggeberAdresse = senderAdress;
            return this;
        }

        /**
         * withRecipientAdress returns a Builder-Object
         */
        public Builder withRecipientAdress(String recipientAdress) {
            if (recipientAdress == null || recipientAdress.isEmpty())
                this.recipientAdresse = "Empty";
            else
                this.recipientAdresse = recipientAdress;
            return this;
        }

        /**
         * withVerwendungsZweck returns a Builder-Object
         */
        public Builder withVerwendungsZweck(String verwendungsZweck) {
            if (verwendungsZweck == null || verwendungsZweck.isEmpty()) {
                this.verwendungsZweck = null;
            } else {
                this.verwendungsZweck = verwendungsZweck;
                this.zahlungsReferenz = null;
            }
            return this;
        }

        /**
         * withZahlungsReferenz returns a Builder-Object
         */
        public Builder withZahlungsReferenz(String zahlungsReferenz) {
            if (zahlungsReferenz == null || zahlungsReferenz.isEmpty()) {
                this.zahlungsReferenz = null;
            } else {
                this.zahlungsReferenz = zahlungsReferenz;
                this.verwendungsZweck = null; // both cannot be filled in
            }
            return this;
        }

        /*
         * Builds PaymentResource Objects Gibt Observer Informationan als Push weiter
         */
        public PaymentResource build() {
            // small validation, so program responds faster. Real validation happens in the
            // servicelayer
            if (recipientIban == null || auftraggeberIban == null || recipientName == null || auftraggeberName == null
                    || (paymentAmount == 0.0)) {
                System.out.println("Kein Feld darf leer sein!");
                return null;
                // throw new Exception("Leere Eingabe erkannt...");
            } else {

                PaymentResource paymentResource = new PaymentResource();
                // mandatory
                paymentResource.recipientIban = this.recipientIban;
                paymentResource.auftraggeberIban = this.auftraggeberIban;
                paymentResource.auftraggeberName = this.auftraggeberName;
                paymentResource.recipientName = this.recipientName;
                paymentResource.paymentAmount = this.paymentAmount;

                // optional
                if (this.auftraggeberAdresse != null)
                    paymentResource.auftraggeberAdresse = this.auftraggeberAdresse;
                if (this.recipientAdresse != null)
                    paymentResource.recipientAdresse = this.recipientAdresse;
                // validate that zahlungsReferenz is empty, if verwendungsZweck was filled in
                if ((this.verwendungsZweck != null) && (this.zahlungsReferenz == null))
                    paymentResource.verwendungsZweck = this.verwendungsZweck;
                // validate that verwendungsZweck is empty, if zahlungsReferenz was filled in
                if ((this.verwendungsZweck == null) && (this.zahlungsReferenz == null))
                    paymentResource.zahlungsReferenz = this.zahlungsReferenz;

                // here could be observerinfo

                // return as paymentResource object
                return paymentResource;
            }

        }

    }
}
