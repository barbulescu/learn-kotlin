package ex20

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DelegationTest {

    @Test
    fun `CountingStore counts writes`() {
        val store = CountingStore(MemoryStore())
        store.put("a", "1")
        store.put("b", "2")
        assertEquals(2, store.puts)
    }

    @Test
    fun `CountingStore still stores - put reaches the inner store`() {
        val store = CountingStore(MemoryStore())
        store.put("a", "1")
        assertEquals("1", store.get("a"))
    }

    @Test
    fun `CountingStore forwards get, size and contains`() {
        val inner = MemoryStore()
        inner.put("a", "1")
        val store = CountingStore(inner)
        assertEquals("1", store.get("a"))
        assertEquals(1, store.size)
        assertTrue(store.contains("a"))
        assertFalse(store.contains("zzz"))
        assertNull(store.get("zzz"))
    }

    @Test
    fun `LazyConfig loads lazily and exactly once`() {
        var loads = 0
        val lazyConfig = LazyConfig {
            loads++
            mapOf("k" to "v")
        }
        assertEquals(0, loads)                      // nothing loaded yet
        assertEquals("v", lazyConfig.config["k"])   // first read triggers the load
        assertEquals("v", lazyConfig.config["k"])   // second read reuses it
        assertEquals(1, loads)
    }
}
