package ex23

import ex23.legacy.LegacyPipeline
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

// PASSES from the start, by design — the green test is the bug report [the ex16
// trick]. Don't fix the Java: the exercise is to port it.
class LegacyJavaTest {

    @Test
    fun `BUG REPORT - the answer was at index 2, all five words paid for it`() {
        val visited = mutableListOf<String>()
        val result = LegacyPipeline.firstLongUpper(listOf("ok", "hi", "gigantic", "nope", "never")) { visited += it }
        assertEquals("GIGANTIC", result)
        assertEquals(5, visited.size)   // two full passes, two intermediate lists — see the CLUTTER notes
    }
}
