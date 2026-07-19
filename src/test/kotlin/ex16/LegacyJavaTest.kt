package ex16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import ex16.legacy.OrderUtils
import ex16.legacy.Customer as JavaCustomer
import ex16.legacy.LineItem as JavaLineItem
import ex16.legacy.Order as JavaOrder

/**
 * These tests exercise the LEGACY JAVA code in src/main/kotlin/ex16/legacy — and they
 * PASS from the very first run. They are not the goal; they are the bug reports.
 * Each green test below documents a defect that compiles without a warning in Java
 * and that your Kotlin port (CapstoneTest) makes unwritable.
 */
class LegacyJavaTest {

    private fun bobsOrder() = JavaOrder(
        2,
        JavaCustomer("Bob", null),
        mutableListOf(JavaLineItem("Cable", 3, BigDecimal("4.00"))),
    )

    @Test
    fun `careless null handling compiles fine and explodes at runtime`() {
        // c.getEmail().toLowerCase() — no warning from javac, NPE in production.
        // The Kotlin equivalent (customer.email.lowercase() on a String?) does not compile.
        assertThrows(NullPointerException::class.java) {
            OrderUtils.contactLineCareless(JavaCustomer("Bob", null))
        }
    }

    @Test
    fun `applyDiscount corrupts the order it was given`() {
        val order = bobsOrder()
        assertEquals(BigDecimal("12.00"), OrderUtils.grandTotal(order))

        OrderUtils.applyDiscount(order, 50)

        // The ORIGINAL order now has different prices — so does every cache, audit log,
        // and half-printed receipt holding this reference.
        assertEquals(BigDecimal("6.00"), OrderUtils.grandTotal(order))
    }

    @Test
    fun `applyDiscount called twice doubles the discount`() {
        val order = bobsOrder()

        OrderUtils.applyDiscount(order, 50)
        OrderUtils.applyDiscount(order, 50)   // e.g. a retried message or a double-click

        assertEquals(BigDecimal("3.00"), OrderUtils.grandTotal(order))
    }

    @Test
    fun `getItems leaks the internal list`() {
        val order = bobsOrder()

        order.items.clear()   // we don't own this order, but we can empty it

        assertEquals(BigDecimal.ZERO, OrderUtils.grandTotal(order))
    }

    @Test
    fun `swapping receipt arguments compiles and prints garbage`() {
        // currency and footer are both String — this call has them backwards.
        val text = OrderUtils.receipt(bobsOrder(), "Thank you!", "EUR")

        assertTrue(text.endsWith("EUR"))                    // the "footer" is a currency code
        assertTrue(text.contains("12.00 Thank you!"))       // the "currency" is a farewell
    }

    @Test
    fun `BigDecimal equals is scale-sensitive - a JDK landmine Kotlin inherits`() {
        // 2.0 and 2.00 are the same amount of money, but equals() says no — so HashSet,
        // HashMap, and assertEquals all disagree with your accountant. This one Kotlin
        // does NOT fix (== calls equals); compare money with compareTo, or < <= > >=
        // in Kotlin, which map to compareTo and ignore scale.
        assertNotEquals(BigDecimal("2.0"), BigDecimal("2.00"))
        assertEquals(0, BigDecimal("2.0").compareTo(BigDecimal("2.00")))
    }
}
