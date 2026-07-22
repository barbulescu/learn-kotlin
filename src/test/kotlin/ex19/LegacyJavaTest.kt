package ex19

import ex19.legacy.LegacyDirectory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

// PASSES from the start, by design — the green tests are the bug reports [the ex16
// trick]. Don't fix the Java: the exercise is to port it.
class LegacyJavaTest {

    @Test
    fun `BUG REPORT - domainOf returns garbage instead of failing`() {
        // No '@' anywhere: indexOf said "not found" with -1, nobody checked, and
        // substring(-1 + 1) politely returned the entire input as a "domain".
        assertEquals("no-at-sign", LegacyDirectory.domainOf("no-at-sign"))
    }

    @Test
    fun `four dialects of not-there in one small class`() {
        // Same directory, four absence protocols — the caller must memorize which
        // method speaks which: throw, Optional, null, sentinel.
        assertFalse(LegacyDirectory.findMemberMaybe(emptyList(), "Zed").isPresent)   // Optional
        assertNull(LegacyDirectory.tryParseAge("oops"))                              // null
        assertEquals("n/a", LegacyDirectory.emailOrPlaceholder(emptyList(), "Zed")) // pyramid
    }
}
