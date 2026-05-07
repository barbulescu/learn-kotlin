package pythonpath.ex02

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringTemplatesTest {

    @Test fun `formatGreeting Alice 30`() =
        assertEquals("Hello, Alice! You are 30 years old.", formatGreeting("Alice", 30))

    @Test fun `formatGreeting Bob 25`() =
        assertEquals("Hello, Bob! You are 25 years old.", formatGreeting("Bob", 25))

    @Test fun `formatFullName John Doe`() =
        assertEquals("Full name: John Doe (8 characters)", formatFullName("John", "Doe"))

    @Test fun `formatFullName Alice Smith`() =
        assertEquals("Full name: Alice Smith (11 characters)", formatFullName("Alice", "Smith"))

    @Test fun `showArithmetic 3 and 4`() =
        assertEquals("3 + 4 = 7", showArithmetic(3, 4))

    @Test fun `showArithmetic 10 and 5`() =
        assertEquals("10 + 5 = 15", showArithmetic(10, 5))
}
