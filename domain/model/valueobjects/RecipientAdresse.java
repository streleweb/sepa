package domain.model.valueobjects;

/**
 * Value Object
 */
public final class RecipientAdresse {
    private String adressOfRecipient;

    public RecipientAdresse(String adressOfRecipient) {
        this.adressOfRecipient = adressOfRecipient;
    }

    public String getAdressOfRecipient() {
        return adressOfRecipient;
    }

}
