package ex21

import ex21.legacy.LegacyRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

// PASSES from the start, by design — the green tests are the bug reports [the ex16
// trick]. Don't fix the Java: the exercise is to port it.
class LegacyJavaTest {

    @Test
    fun `BUG REPORT - build() builds a request with no url`() {
        // Nothing forced .url(...) before .build(): the "immutable, safe" object is
        // born broken, and the NPE will fire wherever the url is first USED — far
        // from this line. In the Kotlin port, leaving out the url does not compile.
        val request = LegacyRequest.Builder().method("POST").build()
        assertNull(request.url)
    }

    @Test
    fun `forty lines of Builder do the work of four defaults`() {
        val request = LegacyRequest.Builder().url("https://example.com").build()
        assertEquals("GET", request.method)
        assertEquals(30_000, request.timeoutMillis)
    }
}
