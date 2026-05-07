package pythonpath.ex01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VariablesTest {

    @Test fun `sumUpTo 0 returns 0`() = assertEquals(0, sumUpTo(0))
    @Test fun `sumUpTo 1 returns 1`() = assertEquals(1, sumUpTo(1))
    @Test fun `sumUpTo 5 returns 15`() = assertEquals(15, sumUpTo(5))
    @Test fun `sumUpTo 10 returns 55`() = assertEquals(55, sumUpTo(10))

    @Test fun `initials of John Doe`() = assertEquals("J.D.", initials("John", "Doe"))
    @Test fun `initials of Alice Wonderland`() = assertEquals("A.W.", initials("Alice", "Wonderland"))
}
