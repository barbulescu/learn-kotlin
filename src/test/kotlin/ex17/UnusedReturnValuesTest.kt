package ex17

import java.math.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UnusedReturnValuesTest {

    @Test
    fun `normalize trims surrounding whitespace`() =
        assertEquals("kotlin", normalize("  kotlin  "))

    @Test
    fun `normalize lowercases`() =
        assertEquals("hello world", normalize("Hello World"))

    @Test
    fun `normalize does both at once`() =
        assertEquals("hello world", normalize("  Hello World  "))

    @Test
    fun `topThree returns the three highest, best first`() =
        assertEquals(listOf(9, 8, 7), topThree(listOf(7, 2, 9, 8, 5)))

    @Test
    fun `topThree with fewer than three scores returns them all, sorted`() =
        assertEquals(listOf(4, 1), topThree(listOf(1, 4)))

    @Test
    fun `withTrack appends the track`() =
        assertEquals(listOf("Intro", "Verse", "Outro"), withTrack(listOf("Intro", "Verse"), "Outro"))

    @Test
    fun `withTrack on an empty playlist`() =
        assertEquals(listOf("Solo"), withTrack(emptyList(), "Solo"))

    @Test
    fun `grandTotal sums the line totals`() =
        assertEquals(BigDecimal("12.50"), grandTotal(listOf(BigDecimal("10.00"), BigDecimal("2.50"))))

    @Test
    fun `grandTotal keeps accumulating across many lines`() =
        assertEquals(BigDecimal("6"), grandTotal(listOf(BigDecimal.ONE, BigDecimal("2"), BigDecimal("3"))))
}
