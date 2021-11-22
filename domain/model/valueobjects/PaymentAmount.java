package domain.model.valueobjects;

import java.math.BigDecimal;

/**
 * Immutable payment instances are created. Validation of payment amount etc.
 * happen in the payment-service-class, before instances of this class are
 * created.
 * 
 * Usage of BigDecimal, since decimals are not accurate.
 */
public final class PaymentAmount {
    private BigDecimal amount;

    public PaymentAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
