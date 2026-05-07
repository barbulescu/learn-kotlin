package pythonpath.ex15

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CoroutinesTest {

    @Test fun `fetchGreeting returns correct message`() = runBlocking {
        assertEquals("Hello, Alice!", fetchGreeting("Alice"))
    }

    @Test fun `fetchGreeting works for any name`() = runBlocking {
        assertEquals("Hello, Kotlin!", fetchGreeting("Kotlin"))
    }

    @Test fun `fetchBoth returns both greetings`() = runBlocking {
        val (first, second) = fetchBoth("Alice", "Bob")
        assertEquals("Hello, Alice!", first)
        assertEquals("Hello, Bob!", second)
    }

    @Test fun `fetchBoth runs concurrently`() = runBlocking {
        // Two 50ms calls should finish in ~50ms, not ~100ms
        val elapsed = measureTimeMillis { fetchBoth("Alice", "Bob") }
        assert(elapsed < 90) { "Expected concurrent execution (~50ms), took ${elapsed}ms" }
    }
}
