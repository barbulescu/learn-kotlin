package ex24

import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FuturesTest {

    @Test
    fun `greetingFor composes sequentially - no thenCompose in sight`() = runTest {
        assertEquals("Hello, user7!", greetingFor(7))
    }

    @Test
    fun `scoreLine combines both results`() = runTest {
        assertEquals("user7: 42", scoreLine(7))
    }

    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)   // for currentTime
    @Test
    fun `scoreLine fetches name and score concurrently`() = runTest {
        scoreLine(7)
        // Two 100ms fetches, 100ms total on the virtual clock — they overlapped.
        // A sequential implementation reads 200 here.
        assertEquals(100L, currentTime)
    }
}
