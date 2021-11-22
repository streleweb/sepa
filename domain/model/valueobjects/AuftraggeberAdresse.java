package domain.model.valueobjects;

/**
 * Value-object, because customer or bank-client adresses are saved as
 * bank-client adresses. This ensures that there won`t be inconsistent data,
 * when customer / bank-client adresses are being changed in the future.
 * 
 * Those changes are being made in the customer / bank-client data.
 * 
 * Instances of this class are only created, if the customer / bank-client
 * adress matches the data of the user-input.
 */
public final class AuftraggeberAdresse {
    private String adresse;

    public AuftraggeberAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }
}
