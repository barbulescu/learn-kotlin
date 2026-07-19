package ex16.legacy;

import java.math.BigDecimal;

/**
 * Kotlin: data class Paid(val amount: BigDecimal) : Payment()
 *
 * Note: equals/hashCode/toString omitted "for brevity" — which is exactly how they go
 * missing in real codebases, until two logically equal payments fail an assertEquals.
 */
public class Paid extends Payment {

    private final BigDecimal amount;

    public Paid(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() { return amount; }
}
