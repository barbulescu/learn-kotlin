package ex23

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class SequencesTest {

    @Test
    fun `firstLongUpper finds and uppercases the first long word`() {
        assertEquals("GIGANTIC", firstLongUpper(listOf("ok", "hi", "gigantic", "modest", "words")) {})
    }

    @Test
    fun `firstLongUpper stops at the first hit - laziness, enforced`() {
        val visited = mutableListOf<String>()
        val result = firstLongUpper(listOf("ok", "hi", "gigantic", "nope", "never")) { visited += it }
        assertEquals("GIGANTIC", result)
        assertEquals(listOf("ok", "hi", "gigantic"), visited)   // the legacy version visits all five
    }

    @Test
    fun `firstLongUpper returns null when nothing is long`() {
        assertNull(firstLongUpper(listOf("all", "small")) {})
    }

    @Test
    fun `firstPowerOfTwoAbove finds 128`() = assertEquals(128, firstPowerOfTwoAbove(100))

    @Test
    fun `firstPowerOfTwoAbove is strict - an exact power moves up`() =
        assertEquals(256, firstPowerOfTwoAbove(128))

    @Test
    fun `totalLength sums the lengths`() = assertEquals(11, totalLength(listOf("one", "two", "three")))
}
