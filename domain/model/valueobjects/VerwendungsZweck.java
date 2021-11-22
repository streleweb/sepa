package domain.model.valueobjects;

/**
 * VerwendungsZweck implemented as value object, since it is only created, if
 * validation is positive. Payment when initiated is final, so the data should
 * be final too.
 * 
 * In case validation fails, no VerwendungsZweck object is created.
 */
public final class VerwendungsZweck {
    private String verwendungsZweckString;

    public VerwendungsZweck(String verwendungsZweckString) {
        this.verwendungsZweckString = verwendungsZweckString;
    }

    public String getVerwendungsZweckString() {
        return verwendungsZweckString;
    }

}
