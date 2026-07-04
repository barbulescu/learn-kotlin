package javapath.ex15

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CoroutinesTest {

    @Test
    @Disabled("TODO: implement fetchGreeting() to make these pass")
    fun `fetchGreeting returns correct message`() = runBlocking {
        assertEquals("Hello, Alice!", fetchGreeting("Alice"))
    }

    @Test
    @Disabled("TODO: implement fetchGreeting() to make these pass")
    fun `fetchGreeting works for any name`() = runBlocking {
        assertEquals("Hello, Kotlin!", fetchGreeting("Kotlin"))
    }

    @Test
    @Disabled("TODO: implement fetchBoth() to make these pass")
    fun `fetchBoth returns both greetings`() = runBlocking {
        val (first, second) = fetchBoth("Alice", "Bob")
        assertEquals("Hello, Alice!", first)
        assertEquals("Hello, Bob!", second)
    }

    @Test
    @Disabled("TODO: implement fetchBoth() to make these pass")
    fun `fetchBoth runs concurrently`() = runBlocking {
        // Two 50ms calls should finish in ~50ms, not ~100ms
        val elapsed = measureTimeMillis { fetchBoth("Alice", "Bob") }
        assert(elapsed < 125) { "Expected concurrent execution (~50ms), took ${elapsed}ms" }
    }
}
