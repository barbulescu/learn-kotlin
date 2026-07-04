package javapath.ex01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class VariablesTest {

    @Test
    @Disabled("TODO: implement sumUpTo() to make these pass")
    fun `sumUpTo 0 returns 0`() = assertEquals(0, sumUpTo(0))

    @Test
    @Disabled("TODO: implement sumUpTo() to make these pass")
    fun `sumUpTo 1 returns 1`() = assertEquals(1, sumUpTo(1))

    @Test
    @Disabled("TODO: implement sumUpTo() to make these pass")
    fun `sumUpTo 5 returns 15`() = assertEquals(15, sumUpTo(5))

    @Test
    @Disabled("TODO: implement sumUpTo() to make these pass")
    fun `sumUpTo 10 returns 55`() = assertEquals(55, sumUpTo(10))

    @Test
    @Disabled("TODO: implement initials() to make these pass")
    fun `initials of John Doe`() = assertEquals("J.D.", initials("John", "Doe"))

    @Test
    @Disabled("TODO: implement initials() to make these pass")
    fun `initials of Alice Wonderland`() = assertEquals("A.W.", initials("Alice", "Wonderland"))
}
