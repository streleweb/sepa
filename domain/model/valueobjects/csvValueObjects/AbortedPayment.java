package domain.model.valueobjects.csvValueObjects;

public class AbortedPayment {
    private String id;
    private String auftraggIban;
    private String recipientIban;
    private String auftraggName;
    private String recipientName;
    private String amount;

    public AbortedPayment(String id, String auftraggIban, String recipientIban, String auftraggName,
            String recipientName, String amount) {
        this.id = id;
        this.auftraggIban = auftraggIban;
        this.recipientIban = recipientIban;
        this.auftraggName = auftraggName;
        this.recipientName = recipientName;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getAuftraggIban() {
        return auftraggIban;
    }

    public String getRecipientIban() {
        return recipientIban;
    }

    public String getAuftraggName() {
        return auftraggName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getAmount() {
        return amount;
    }

}
