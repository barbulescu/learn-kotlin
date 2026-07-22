package ex22

import ex22.legacy.LegacyBilling
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

// PASSES from the start, by design — the green tests are the bug reports [the ex16
// trick]. Don't fix the Java: the exercise is to port it.
class LegacyJavaTest {

    @Test
    fun `BUG REPORT - customer and product swapped, compiler silent`() {
        // The call site got the arguments backwards. Both are String, so this
        // compiles, runs, and invoices customer "P-7" for 3 units of "C-42".
        assertEquals("Invoice P-7: 3 x C-42", LegacyBilling.invoiceLine("P-7", "C-42", 3))
    }

    @Test
    fun `validation by convention validates nothing`() {
        // looksLikeCustomerId exists — and the unvalidated path compiles just as well.
        assertTrue(LegacyBilling.looksLikeCustomerId("C-42"))
        assertEquals("Invoice oops: 1 x whatever", LegacyBilling.invoiceLine("oops", "whatever", 1))
    }
}
