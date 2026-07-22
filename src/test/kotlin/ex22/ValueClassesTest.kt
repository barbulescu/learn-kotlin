package ex22

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ValueClassesTest {

    @Test
    fun `invoiceLine formats the line`() =
        assertEquals("Invoice C-42: 3 x P-7", invoiceLine(CustomerId("C-42"), ProductId("P-7"), 3))

    // There is no test for the swapped-arguments bug, because there cannot be one:
    // invoiceLine(ProductId("P-7"), CustomerId("C-42"), 3) does not compile.
    // That is the exercise.

    @Test
    fun `value classes compare by value`() {
        // Already green from the start — equality came free with the declaration.
        assertEquals(CustomerId("C-42"), CustomerId("C-42"))
    }

    @Test
    fun `customerIdOrNull accepts a well-formed id`() =
        assertEquals(CustomerId("C-42"), customerIdOrNull("C-42"))

    @Test
    fun `customerIdOrNull rejects a product id`() = assertNull(customerIdOrNull("P-7"))

    @Test
    fun `productIdOrNull accepts a well-formed id`() =
        assertEquals(ProductId("P-7"), productIdOrNull("P-7"))

    @Test
    fun `productIdOrNull rejects a bare number`() = assertNull(productIdOrNull("7"))
}
