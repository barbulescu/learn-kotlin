package ex20

import ex20.legacy.LegacyDelegation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

// PASSES from the start, by design [the ex16 trick] — these greens document cost,
// not bugs: the line counts are the complaint. Don't fix the Java.
class LegacyJavaTest {

    @Test
    fun `the hand-rolled decorator works - three forwarding methods for one feature`() {
        val store = LegacyDelegation.CountingStore(LegacyDelegation.MemoryStore())
        store.put("a", "1")
        assertEquals(1, store.puts)
        assertEquals("1", store.get("a"))
    }

    @Test
    fun `eleven lines of double-checked locking do the work of one keyword`() {
        var loads = 0
        val lazyConfig = LegacyDelegation.LazyConfig {
            loads++
            mapOf("k" to "v")
        }
        assertEquals("v", lazyConfig.config["k"])
        assertEquals("v", lazyConfig.config["k"])
        assertEquals(1, loads)
    }
}
