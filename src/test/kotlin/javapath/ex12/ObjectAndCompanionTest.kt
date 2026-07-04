package javapath.ex12

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ObjectAndCompanionTest {

    @Test
    @Disabled("TODO: implement MathUtils.factorial() to make these pass")
    fun `factorial of 0 is 1`() = assertEquals(1L, MathUtils.factorial(0))

    @Test
    @Disabled("TODO: implement MathUtils.factorial() to make these pass")
    fun `factorial of 1 is 1`() = assertEquals(1L, MathUtils.factorial(1))

    @Test
    @Disabled("TODO: implement MathUtils.factorial() to make these pass")
    fun `factorial of 5 is 120`() = assertEquals(120L, MathUtils.factorial(5))

    @Test
    @Disabled("TODO: implement MathUtils.factorial() to make these pass")
    fun `factorial of 10 is 3628800`() = assertEquals(3628800L, MathUtils.factorial(10))

    @Test
    @Disabled("TODO: implement MathUtils.isPrime() to make these pass")
    fun `1 is not prime`() = assertFalse(MathUtils.isPrime(1))

    @Test
    @Disabled("TODO: implement MathUtils.isPrime() to make these pass")
    fun `2 is prime`() = assertTrue(MathUtils.isPrime(2))

    @Test
    @Disabled("TODO: implement MathUtils.isPrime() to make these pass")
    fun `7 is prime`() = assertTrue(MathUtils.isPrime(7))

    @Test
    @Disabled("TODO: implement MathUtils.isPrime() to make these pass")
    fun `4 is not prime`() = assertFalse(MathUtils.isPrime(4))

    @Test
    @Disabled("TODO: implement MathUtils.isPrime() to make these pass")
    fun `13 is prime`() = assertTrue(MathUtils.isPrime(13))

    @Test
    @Disabled("TODO: implement Temperature.toFahrenheit() to make these pass")
    fun `toFahrenheit of 0C is 32F`() = assertEquals(32.0, Temperature(0.0).toFahrenheit(), 1e-9)

    @Test
    @Disabled("TODO: implement Temperature.toFahrenheit() to make these pass")
    fun `toFahrenheit of 100C is 212F`() = assertEquals(212.0, Temperature(100.0).toFahrenheit(), 1e-9)

    @Test
    @Disabled("TODO: implement Temperature.fromFahrenheit() and Temperature.boiling() to make these pass")
    fun `fromFahrenheit 32 is 0C`() = assertEquals(0.0, Temperature.fromFahrenheit(32.0).celsius, 1e-9)

    @Test
    @Disabled("TODO: implement Temperature.fromFahrenheit() and Temperature.boiling() to make these pass")
    fun `fromFahrenheit 212 is 100C`() = assertEquals(100.0, Temperature.fromFahrenheit(212.0).celsius, 1e-9)

    @Test
    @Disabled("TODO: implement Temperature.fromFahrenheit() and Temperature.boiling() to make these pass")
    fun `boiling is 100C`() = assertEquals(100.0, Temperature.boiling().celsius, 1e-9)
}
