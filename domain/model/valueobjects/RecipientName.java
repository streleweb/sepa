package domain.model.valueobjects;

/**
 * Name of the recipient of a payment. Value object.
 * 
 */
public class RecipientName {
    private String recipientName;

    public RecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getrecipientName() {
        return recipientName;
    }
}
