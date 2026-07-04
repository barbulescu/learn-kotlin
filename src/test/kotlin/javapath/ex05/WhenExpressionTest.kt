package javapath.ex05

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class WhenExpressionTest {

    @Test
    @Disabled("TODO: implement classify() to make these pass")
    fun `classify negative`() = assertEquals("negative", classify(-5))

    @Test
    @Disabled("TODO: implement classify() to make these pass")
    fun `classify zero`() = assertEquals("zero", classify(0))

    @Test
    @Disabled("TODO: implement classify() to make these pass")
    fun `classify small`() = assertEquals("small", classify(7))

    @Test
    @Disabled("TODO: implement classify() to make these pass")
    fun `classify boundary small`() = assertEquals("small", classify(1))

    @Test
    @Disabled("TODO: implement classify() to make these pass")
    fun `classify boundary large`() = assertEquals("large", classify(10))

    @Test
    @Disabled("TODO: implement classify() to make these pass")
    fun `classify large`() = assertEquals("large", classify(42))

    @Test
    @Disabled("TODO: implement dayType() to make these pass")
    fun `dayType Monday is weekday`() = assertEquals("weekday", dayType(1))

    @Test
    @Disabled("TODO: implement dayType() to make these pass")
    fun `dayType Friday is weekday`() = assertEquals("weekday", dayType(5))

    @Test
    @Disabled("TODO: implement dayType() to make these pass")
    fun `dayType Saturday is weekend`() = assertEquals("weekend", dayType(6))

    @Test
    @Disabled("TODO: implement dayType() to make these pass")
    fun `dayType Sunday is weekend`() = assertEquals("weekend", dayType(7))

    @Test
    @Disabled("TODO: implement fizzBuzz() to make these pass")
    fun `fizzBuzz 3 is Fizz`() = assertEquals("Fizz", fizzBuzz(3))

    @Test
    @Disabled("TODO: implement fizzBuzz() to make these pass")
    fun `fizzBuzz 5 is Buzz`() = assertEquals("Buzz", fizzBuzz(5))

    @Test
    @Disabled("TODO: implement fizzBuzz() to make these pass")
    fun `fizzBuzz 15 is FizzBuzz`() = assertEquals("FizzBuzz", fizzBuzz(15))

    @Test
    @Disabled("TODO: implement fizzBuzz() to make these pass")
    fun `fizzBuzz 7 is 7`() = assertEquals("7", fizzBuzz(7))
}
