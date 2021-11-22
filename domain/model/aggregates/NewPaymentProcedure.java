package domain.model.aggregates;

/**
 * Payment "Root"-Aggregate, every new Payment is being created via a command.
 * 
 */
public class NewPaymentProcedure {
    private String paymentId;
}
