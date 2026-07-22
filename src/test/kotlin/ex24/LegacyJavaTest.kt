package ex24

import ex24.legacy.LegacyFutures
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

// PASSES from the start, by design [the ex16 trick] — these greens document
// ceremony rather than a bug: three combinator words and a blocking, checked-
// exception-wrapped escape hatch, for logic the port writes as plain lines.
class LegacyJavaTest {

    @Test
    fun `the future pipeline works - inside out`() {
        assertEquals("Hello, user7!", LegacyFutures.greetingFor(7).get())
    }

    @Test
    fun `leaving future-land costs a blocked thread and a try-catch`() {
        assertEquals("user7: 42", LegacyFutures.scoreLineNow(7))
    }
}
