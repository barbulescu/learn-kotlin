package ex21

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class BuildersTest {

    @Test
    fun `getRequest fills every default`() {
        val request = getRequest("https://example.com")
        assertEquals("https://example.com", request.url)
        assertEquals("GET", request.method)
        assertNull(request.body)
        assertEquals(30_000, request.timeoutMillis)
    }

    @Test
    fun `jsonPost sets method and body, keeps the rest`() {
        val request = jsonPost("https://api.example.com", """{"id":1}""")
        assertEquals("https://api.example.com", request.url)
        assertEquals("POST", request.method)
        assertEquals("""{"id":1}""", request.body)
        assertEquals(30_000, request.timeoutMillis)
    }

    @Test
    fun `withTimeout changes exactly one field`() =
        assertEquals(
            Request("https://example.com", timeoutMillis = 500),
            withTimeout(getRequest("https://example.com"), 500),
        )

    @Test
    fun `withTimeout never mutates the original`() {
        val original = getRequest("https://example.com")
        withTimeout(original, 500)
        assertEquals(30_000, original.timeoutMillis)
    }

    @Test
    fun `ciPool configures the pool in one block`() {
        val pool = ciPool("ci")
        assertEquals("ci", pool.name)
        assertEquals(4, pool.maxConnections)
        assertEquals(0, pool.retries)
    }
}
