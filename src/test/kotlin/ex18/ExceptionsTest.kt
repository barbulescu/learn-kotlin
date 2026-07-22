package ex18

import java.io.FilterReader
import java.io.StringReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionsTest {

    @Test
    fun `parsePort parses a trimmed int`() = assertEquals(443, parsePort(" 443 "))

    @Test
    fun `parsePort throws on garbage - no checked ceremony at the call site`() {
        assertThrows<NumberFormatException> { parsePort("oops") }
    }

    @Test
    fun `parsePorts maps all good lines`() =
        assertEquals(listOf(80, 443, 8080), parsePorts(listOf("80", "443", "8080")))

    @Test
    fun `parsePorts fails loudly on a bad line - nothing is swallowed`() {
        // The legacy version returns [80, 443] here and hides the typo forever
        // (LegacyJavaTest documents it).
        assertThrows<NumberFormatException> { parsePorts(listOf("80", "oops", "443")) }
    }

    @Test
    fun `portOrDefault returns the parsed port`() = assertEquals(80, portOrDefault("80", 9999))

    @Test
    fun `portOrDefault falls back on garbage`() = assertEquals(9999, portOrDefault("oops", 9999))

    private class CloseTrackingReader(text: String) : FilterReader(StringReader(text)) {
        var closed = false

        override fun close() {
            closed = true
            super.close()
        }
    }

    @Test
    fun `readPorts reads every line`() =
        assertEquals(listOf(80, 443), readPorts(StringReader("80\n443")))

    @Test
    fun `readPorts closes the reader`() {
        val reader = CloseTrackingReader("80\n443")
        readPorts(reader)
        assertTrue(reader.closed)
    }

    @Test
    fun `readPorts closes the reader even when a line is garbage`() {
        val reader = CloseTrackingReader("80\noops")
        assertThrows<NumberFormatException> { readPorts(reader) }
        assertTrue(reader.closed)
    }
}
