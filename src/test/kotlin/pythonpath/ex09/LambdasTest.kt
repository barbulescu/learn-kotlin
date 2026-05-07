package pythonpath.ex09

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LambdasTest {

    @Test fun `applyTwice increments twice`() = assertEquals(5, applyTwice(3) { it + 1 })
    @Test fun `applyTwice doubles twice`() = assertEquals(12, applyTwice(3) { it * 2 })
    @Test fun `applyTwice with identity`() = assertEquals(7, applyTwice(7) { it })

    @Test fun `keepIf filters evens`() =
        assertEquals(listOf(2, 4), keepIf(listOf(1, 2, 3, 4)) { it % 2 == 0 })

    @Test fun `keepIf returns empty when nothing matches`() =
        assertEquals(emptyList<Int>(), keepIf(listOf(1, 3, 5)) { it % 2 == 0 })

    @Test fun `keepIf on strings`() =
        assertEquals(listOf("hi"), keepIf(listOf("hi", "hello")) { it.length == 2 })

    @Test fun `transformAll uppercases strings`() =
        assertEquals(listOf("HI", "BYE"), transformAll(listOf("hi", "bye")) { it.uppercase() })

    @Test fun `transformAll converts ints to strings`() =
        assertEquals(listOf("1", "2", "3"), transformAll(listOf(1, 2, 3)) { it.toString() })
}
