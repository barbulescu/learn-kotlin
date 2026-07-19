package ex03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class NullSafetyTest {

    @Test
    fun `safeLength of hello is 5`() = assertEquals(5, safeLength("hello"))

    @Test
    fun `safeLength of null is 0`() = assertEquals(0, safeLength(null))

    @Test
    fun `greetNullable with name`() = assertEquals("Hello, Alice!", greetNullable("Alice"))

    @Test
    fun `greetNullable with null`() = assertEquals("Hello, stranger!", greetNullable(null))

    @Test
    fun `firstOrNull returns first element`() = assertEquals(42, firstOrNull(listOf(42, 1, 2)))

    @Test
    fun `firstOrNull returns null for empty list`() = assertNull(firstOrNull(emptyList()))

    @Test
    fun `cityOf returns uppercased city`() = assertEquals("BERLIN", cityOf(User("Alice", Address("Berlin"))))

    @Test
    fun `cityOf returns UNKNOWN when city is null`() = assertEquals("UNKNOWN", cityOf(User("Bob", Address(null))))

    @Test
    fun `cityOf returns UNKNOWN when address is null`() = assertEquals("UNKNOWN", cityOf(User("Eve", null)))
}
