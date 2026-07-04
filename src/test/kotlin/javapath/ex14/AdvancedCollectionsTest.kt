package javapath.ex14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class AdvancedCollectionsTest {

    @Test
    @Disabled("TODO: implement groupByLength() to make these pass")
    fun `groupByLength groups correctly`() {
        val result = groupByLength(listOf("hi", "bye", "ok", "hello"))
        assertEquals(listOf("hi", "ok"), result[2])
        assertEquals(listOf("bye"), result[3])
        assertEquals(listOf("hello"), result[5])
    }

    @Test
    @Disabled("TODO: implement groupByLength() to make these pass")
    fun `groupByLength on empty list`() = assertEquals(emptyMap<Int, List<String>>(), groupByLength(emptyList()))

    @Test
    @Disabled("TODO: implement partitionEvenOdd() to make these pass")
    fun `partitionEvenOdd splits correctly`() {
        val (evens, odds) = partitionEvenOdd(listOf(1, 2, 3, 4, 5))
        assertEquals(listOf(2, 4), evens)
        assertEquals(listOf(1, 3, 5), odds)
    }

    @Test
    @Disabled("TODO: implement partitionEvenOdd() to make these pass")
    fun `partitionEvenOdd all even`() {
        val (evens, odds) = partitionEvenOdd(listOf(2, 4, 6))
        assertEquals(listOf(2, 4, 6), evens)
        assertEquals(emptyList<Int>(), odds)
    }

    @Test
    @Disabled("TODO: implement allWords() to make these pass")
    fun `allWords flattens sentences`() =
        assertEquals(listOf("hello", "world", "foo", "bar"), allWords(listOf("hello world", "foo bar")))

    @Test
    @Disabled("TODO: implement allWords() to make these pass")
    fun `allWords on single word sentences`() =
        assertEquals(listOf("a", "b", "c"), allWords(listOf("a", "b", "c")))

    @Test
    @Disabled("TODO: implement zipPairs() to make these pass")
    fun `zipPairs combines two lists`() =
        assertEquals(listOf("a" to 1, "b" to 2, "c" to 3), zipPairs(listOf("a", "b", "c"), listOf(1, 2, 3)))

    @Test
    @Disabled("TODO: implement zipPairs() to make these pass")
    fun `zipPairs stops at shorter list`() =
        assertEquals(listOf("a" to 1, "b" to 2), zipPairs(listOf("a", "b", "c"), listOf(1, 2)))
}
