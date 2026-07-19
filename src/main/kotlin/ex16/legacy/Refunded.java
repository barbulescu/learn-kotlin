package ex16.legacy;

import java.math.BigDecimal;

/**
 * Kotlin: data class Refunded(val amount: BigDecimal, val reason: String) : Payment()
 */
public class Refunded extends Payment {

    private final BigDecimal amount;
    private final String reason;

    public Refunded(BigDecimal amount, String reason) {
        this.amount = amount;
        this.reason = reason;
    }

    public BigDecimal getAmount() { return amount; }

    public String getReason() { return reason; }
}
