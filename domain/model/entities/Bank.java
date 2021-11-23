package domain.model.entities;

/**
 * Bankdetails of our Bank - Entity
 */
public class Bank {
    private short bankNr;
    private String bankName;

    public Bank(short bankNr, String bankName) {
        this.bankNr = bankNr; // gets filled as dummydata when program is executed in App.java
        this.bankName = bankName;
    }

}
