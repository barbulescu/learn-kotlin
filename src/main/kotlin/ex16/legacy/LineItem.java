package ex16.legacy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Money is BigDecimal — never double — so every price formula in this program becomes
 * a .multiply()/.divide() method chain (see OrderUtils). Kotlin overloads the
 * arithmetic operators for BigDecimal, so the SAME type reads like arithmetic there.
 *
 * Kotlin: data class LineItem(val product: String, val quantity: Int, val unitPrice: BigDecimal)
 */
public class LineItem {

    private String product;
    private int quantity;
    private BigDecimal unitPrice;   // DANGER: mutable — see OrderUtils.applyDiscount

    public LineItem(String product, int quantity, BigDecimal unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProduct() { return product; }

    public void setProduct(String product) { this.product = product; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getUnitPrice() { return unitPrice; }

    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    // DANGER: BigDecimal.equals is scale-sensitive — an item priced 2.0 and one priced
    // 2.00 are "not equal" here, and neither HashSet nor assertEquals will warn you why.
    // Compare money with compareTo. (To be fair: Kotlin's data class == inherits this
    // JDK landmine — see LegacyJavaTest.)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return quantity == lineItem.quantity
                && Objects.equals(product, lineItem.product)
                && Objects.equals(unitPrice, lineItem.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, unitPrice);
    }

    @Override
    public String toString() {
        return "LineItem{product='" + product + "', quantity=" + quantity + ", unitPrice=" + unitPrice + "}";
    }
}
