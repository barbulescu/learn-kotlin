package ex18

import ex18.legacy.LegacyConfig
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

// PASSES from the start, by design — the green tests are the bug reports [the ex16
// trick]. Don't fix the Java: the exercise is to port it so the bugs become unwritable.
class LegacyJavaTest {

    @Test
    fun `BUG REPORT - a typo'd line silently vanishes`() {
        // Three lines in, two ports out, no error, no log. The checked exception that
        // was supposed to make errors impossible to ignore got swallowed in the one
        // place the type system couldn't reach: inside the loop that wanted to be a
        // lambda.
        assertEquals(listOf(80, 443), LegacyConfig.parsePorts(listOf("80", "oops", "443")))
    }

    @Test
    fun `the fallback dance works - at five lines per call site`() {
        assertEquals(9999, LegacyConfig.portOrDefault("oops", 9999))
    }
}
