package domain.model.valueobjects;

/**
 * Value Object, only being created if validation in service-class passes.
 */
public final class ZahlungsReferenz {
    private String referenz;

    public ZahlungsReferenz(String referenz) {
        this.referenz = referenz;
    }

    public String getReferenz() {
        return referenz;
    }

}
