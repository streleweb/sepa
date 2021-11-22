package domain.model.entities;

import domain.model.valueobjects.Iban;

/**
 * Bank Client Entity (Bank Customer).
 */
public class Bankclient {
    private final String UUID; // In case name and IBAN change
    private String clientName;
    private Iban clientIban;

    public Bankclient(String uUID, String clientName, Iban clientIban) {
        this.UUID = uUID;
        this.clientName = clientName;
        this.clientIban = clientIban;
    }

    public String getUUID() {
        return UUID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Iban getClientIban() {
        return clientIban;
    }

    public void setClientIban(Iban clientIban) {
        this.clientIban = clientIban;
    }

}
