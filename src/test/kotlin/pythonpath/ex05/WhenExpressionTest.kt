package pythonpath.ex05

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WhenExpressionTest {

    @Test fun `classify negative`() = assertEquals("negative", classify(-5))
    @Test fun `classify zero`() = assertEquals("zero", classify(0))
    @Test fun `classify small`() = assertEquals("small", classify(7))
    @Test fun `classify boundary small`() = assertEquals("small", classify(1))
    @Test fun `classify boundary large`() = assertEquals("large", classify(10))
    @Test fun `classify large`() = assertEquals("large", classify(42))

    @Test fun `dayType Monday is weekday`() = assertEquals("weekday", dayType(1))
    @Test fun `dayType Friday is weekday`() = assertEquals("weekday", dayType(5))
    @Test fun `dayType Saturday is weekend`() = assertEquals("weekend", dayType(6))
    @Test fun `dayType Sunday is weekend`() = assertEquals("weekend", dayType(7))

    @Test fun `fizzBuzz 3 is Fizz`() = assertEquals("Fizz", fizzBuzz(3))
    @Test fun `fizzBuzz 5 is Buzz`() = assertEquals("Buzz", fizzBuzz(5))
    @Test fun `fizzBuzz 15 is FizzBuzz`() = assertEquals("FizzBuzz", fizzBuzz(15))
    @Test fun `fizzBuzz 7 is 7`() = assertEquals("7", fizzBuzz(7))
}
