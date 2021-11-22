package application.utilityclasses;

import java.math.BigDecimal;

public class DoubleBigDecimalConverter {

    // Double to BigDecimal
    public static BigDecimal convertToBigDecimal(Double amount) {
        return BigDecimal.valueOf(amount.doubleValue());
    }

    // BigDecimal to Double
    public static Double convertToDouble(BigDecimal amount) {
        return amount.doubleValue();
    }
}
