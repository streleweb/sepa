package domain.model.valueobjects;

/**
 * Validation of the complete Iban happens through validating the IbanCommand,
 * which contains Länder-Code, Prüfziffer, BLZ, and Kontonummer in application-
 * service classes, since it contains business-logic.
 * 
 * This class is intended to being used for Recepient IBAN and Auftraggeber IBAN
 * 
 * Immutable, so a used IBAN can not be changed. In case the bank-client has to
 * change his IBAN, a new Iban-instance has to be created through the command-
 * service for IBAN`s.
 */
public final class Iban {
    private String ibanString;

    public Iban(String IbanString) {
        this.ibanString = IbanString;
    }

    public String getIbanString() {
        return ibanString;
    }

}
