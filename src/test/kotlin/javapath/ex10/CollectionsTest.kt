package javapath.ex10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class CollectionsTest {

    @Test fun `doubleAll doubles each element`() =
        assertEquals(listOf(2, 4, 6), doubleAll(listOf(1, 2, 3)))

    @Test fun `doubleAll on empty list`() =
        assertEquals(emptyList<Int>(), doubleAll(emptyList()))

    @Test fun `onlyEven keeps even numbers`() =
        assertEquals(listOf(2, 4, 6), onlyEven(listOf(1, 2, 3, 4, 5, 6)))

    @Test fun `onlyEven on all odd returns empty`() =
        assertEquals(emptyList<Int>(), onlyEven(listOf(1, 3, 5)))

    @Test fun `sumAll returns correct sum`() = assertEquals(15, sumAll(listOf(1, 2, 3, 4, 5)))
    @Test fun `sumAll on empty list is 0`() = assertEquals(0, sumAll(emptyList()))

    @Test fun `longestWord returns longest`() =
        assertEquals("kotlin", longestWord(listOf("hi", "kotlin", "ok")))

    @Test fun `longestWord returns null on empty list`() =
        assertNull(longestWord(emptyList()))
}
