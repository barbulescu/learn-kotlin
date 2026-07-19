package ex10

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RangesTest {

    @Test
    fun `sumRange 1 to 5 is 15`() = assertEquals(15, sumRange(1, 5))

    @Test
    fun `sumRange 1 to 1 is 1`() = assertEquals(1, sumRange(1, 1))

    @Test
    fun `sumRange 3 to 6 is 18`() = assertEquals(18, sumRange(3, 6))

    @Test
    fun `countdown from 5`() = assertEquals(listOf(5, 4, 3, 2, 1), countdown(5))

    @Test
    fun `countdown from 1`() = assertEquals(listOf(1), countdown(1))

    @Test
    fun `everyNth 1 to 10 step 3`() = assertEquals(listOf(1, 4, 7, 10), everyNth(1, 10, 3))

    @Test
    fun `everyNth 2 to 10 step 2`() = assertEquals(listOf(2, 4, 6, 8, 10), everyNth(2, 10, 2))

    @Test
    fun `everyNth step 1 is full range`() = assertEquals(listOf(1, 2, 3), everyNth(1, 3, 1))
}
