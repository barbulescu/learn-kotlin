package pythonpath.ex14

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AdvancedCollectionsTest {

    @Test fun `groupByLength groups correctly`() {
        val result = groupByLength(listOf("hi", "bye", "ok", "hello"))
        assertEquals(listOf("hi", "ok"), result[2])
        assertEquals(listOf("bye"), result[3])
        assertEquals(listOf("hello"), result[5])
    }

    @Test fun `groupByLength on empty list`() = assertEquals(emptyMap<Int, List<String>>(), groupByLength(emptyList()))

    @Test fun `partitionEvenOdd splits correctly`() {
        val (evens, odds) = partitionEvenOdd(listOf(1, 2, 3, 4, 5))
        assertEquals(listOf(2, 4), evens)
        assertEquals(listOf(1, 3, 5), odds)
    }

    @Test fun `partitionEvenOdd all even`() {
        val (evens, odds) = partitionEvenOdd(listOf(2, 4, 6))
        assertEquals(listOf(2, 4, 6), evens)
        assertEquals(emptyList<Int>(), odds)
    }

    @Test fun `allWords flattens sentences`() =
        assertEquals(listOf("hello", "world", "foo", "bar"), allWords(listOf("hello world", "foo bar")))

    @Test fun `allWords on single word sentences`() =
        assertEquals(listOf("a", "b", "c"), allWords(listOf("a", "b", "c")))

    @Test fun `zipPairs combines two lists`() =
        assertEquals(listOf("a" to 1, "b" to 2, "c" to 3), zipPairs(listOf("a", "b", "c"), listOf(1, 2, 3)))

    @Test fun `zipPairs stops at shorter list`() =
        assertEquals(listOf("a" to 1, "b" to 2), zipPairs(listOf("a", "b", "c"), listOf(1, 2)))
}
