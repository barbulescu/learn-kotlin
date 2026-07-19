package ex16

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CapstoneTest {

    private val alice = Customer("Alice", "Alice@Example.COM", vip = true)
    private val bob = Customer("Bob", null)

    private val order1 = Order(
        1,
        alice,
        listOf(LineItem("Widget", 2, BigDecimal("5.00")), LineItem("Gizmo", 1, BigDecimal("2.50"))),
    )
    private val order2 = Order(2, bob, listOf(LineItem("Cable", 3, BigDecimal("4.00"))))
    private val order3 = Order(3, alice, listOf(LineItem("Monitor", 1, BigDecimal("150.00"))))

    @Test
    fun `lineTotal multiplies quantity by unit price`() =
        assertEquals(BigDecimal("10.00"), LineItem("Widget", 2, BigDecimal("5.00")).lineTotal())

    @Test
    fun `lineTotal for a single item`() =
        assertEquals(BigDecimal("2.50"), LineItem("Gizmo", 1, BigDecimal("2.50")).lineTotal())

    @Test
    fun `grandTotal sums all line items`() = assertEquals(BigDecimal("12.50"), order1.grandTotal())

    @Test
    fun `grandTotal of a one-line order`() = assertEquals(BigDecimal("12.00"), order2.grandTotal())

    @Test
    fun `contactLine lowercases the email`() = assertEquals("Alice <alice@example.com>", contactLine(alice))

    @Test
    fun `contactLine handles a missing email`() = assertEquals("Bob (no email)", contactLine(bob))

    @Test
    fun `paymentMessage for Paid`() = assertEquals("Paid 49.99", paymentMessage(Paid(BigDecimal("49.99"))))

    @Test
    fun `paymentMessage for Refunded`() =
        assertEquals("Refunded 12.50 (damaged box)", paymentMessage(Refunded(BigDecimal("12.50"), "damaged box")))

    @Test
    fun `paymentMessage for Pending`() = assertEquals("Awaiting payment", paymentMessage(Pending))

    @Test
    fun `receipt with all defaults`() = assertEquals(
        """
        Order #1 for Alice (VIP)
        2 x Widget = 10.00 EUR
        1 x Gizmo = 2.50 EUR
        Total: 12.50 EUR
        Thank you!
        """.trimIndent(),
        receipt(order1),
    )

    @Test
    fun `receipt with named arguments`() = assertEquals(
        """
        Order #2 for Bob
        3 x Cable = 12.00 USD
        Total: 12.00 USD
        See you soon
        """.trimIndent(),
        receipt(order2, currency = "USD", footer = "See you soon"),
    )

    @Test
    fun `bigSpenders with the default minimum`() =
        assertEquals(listOf("Alice"), bigSpenders(listOf(order1, order2, order3)))

    @Test
    fun `bigSpenders sums across a customer's orders`() =
        // Alice alone: 12.50 + 150.00 = 162.50 — order1 by itself would not qualify.
        assertEquals(listOf("Alice"), bigSpenders(listOf(order1, order3), minimum = BigDecimal("160")))

    @Test
    fun `bigSpenders with a low minimum is sorted`() =
        assertEquals(listOf("Alice", "Bob"), bigSpenders(listOf(order2, order1, order3), minimum = BigDecimal("10")))

    @Test
    fun `bigSpenders on no orders`() = assertEquals(emptyList<String>(), bigSpenders(emptyList()))

    @Test
    fun `withDiscount halves prices at 50 percent`() =
        // Multiply first, divide by 100 last (see the stub hint) and the arithmetic —
        // and even the BigDecimal scale — stays exact: 4.00 → 2.00.
        assertEquals(
            Order(2, bob, listOf(LineItem("Cable", 3, BigDecimal("2.00")))),
            withDiscount(order2, percentOff = 50),
        )

    @Test
    fun `withDiscount defaults to 10 percent`() =
        assertEquals(BigDecimal("10.80"), withDiscount(order2).grandTotal())

    @Test
    fun `withDiscount never mutates the original order`() {
        // This is the test the Java version (OrderUtils.applyDiscount) cannot pass:
        // it corrupts the order in place — LegacyJavaTest proves that. Here the data
        // classes are immutable, so the original is provably untouched.
        val before = order1.copy()
        withDiscount(order1, percentOff = 50)
        assertEquals(before, order1)
        assertEquals(BigDecimal("12.50"), order1.grandTotal())
    }
}
