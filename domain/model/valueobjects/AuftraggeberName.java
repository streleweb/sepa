package domain.model.valueobjects;

/**
 * Name of the sender of a payment. Value object, which only gets instanced if
 * the AuftraggeberName exists in the pseudo-DB for bank-clients.
 * 
 * * Name-changes are possible, aswell as occurences of the same name, which
 * would make this an entity, however, the entities themselves are stored
 * seperately as bank-client-data.
 * 
 * Instances of this class are only created if the AuftraggeberName matches the
 * bank-client data in the pseudo-bank-DB.
 * 
 */
public final class AuftraggeberName {
    private String auftraggeberName;

    public AuftraggeberName(String auftraggeberName) {
        this.auftraggeberName = auftraggeberName;
    }

    public String getAuftraggeberName() {
        return auftraggeberName;
    }

}
