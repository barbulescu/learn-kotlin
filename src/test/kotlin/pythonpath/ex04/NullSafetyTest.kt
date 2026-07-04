package pythonpath.ex04

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class NullSafetyTest {

    @Test
    @Disabled("TODO: implement safeLength() to make these pass")
    fun `safeLength of hello is 5`() = assertEquals(5, safeLength("hello"))

    @Test
    @Disabled("TODO: implement safeLength() to make these pass")
    fun `safeLength of null is 0`() = assertEquals(0, safeLength(null))

    @Test
    @Disabled("TODO: implement greetNullable() to make these pass")
    fun `greetNullable with name`() = assertEquals("Hello, Alice!", greetNullable("Alice"))

    @Test
    @Disabled("TODO: implement greetNullable() to make these pass")
    fun `greetNullable with null`() = assertEquals("Hello, stranger!", greetNullable(null))

    @Test
    @Disabled("TODO: implement firstOrNull() to make these pass")
    fun `firstOrNull returns first element`() = assertEquals(42, firstOrNull(listOf(42, 1, 2)))

    @Test
    @Disabled("TODO: implement firstOrNull() to make these pass")
    fun `firstOrNull returns null for empty list`() = assertNull(firstOrNull(emptyList()))

    @Test
    @Disabled("TODO: implement cityOf() to make these pass")
    fun `cityOf returns uppercased city`() = assertEquals("BERLIN", cityOf(User("Alice", Address("Berlin"))))

    @Test
    @Disabled("TODO: implement cityOf() to make these pass")
    fun `cityOf returns UNKNOWN when city is null`() = assertEquals("UNKNOWN", cityOf(User("Bob", Address(null))))

    @Test
    @Disabled("TODO: implement cityOf() to make these pass")
    fun `cityOf returns UNKNOWN when address is null`() = assertEquals("UNKNOWN", cityOf(User("Eve", null)))
}
