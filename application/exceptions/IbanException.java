package application.exceptions;

/**
 * When Iban <>20 etc..
 */
public class IbanException extends Exception {
    public IbanException(String msg) {
        super(msg);
    }
}
