package ex13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScopeFunctionsTest {

    @Test
    fun `processInput trims and uppercases`() = assertEquals("HELLO", processInput("  hello  "))

    @Test
    fun `processInput returns NONE for null`() = assertEquals("NONE", processInput(null))

    @Test
    fun `processInput on already clean string`() = assertEquals("WORLD", processInput("world"))

    @Test
    fun `defaultConfig has correct entries`() {
        val config = defaultConfig()
        assertEquals("localhost", config["host"])
        assertEquals("8080", config["port"])
        assertEquals("true", config["debug"])
        assertEquals(3, config.size)
    }

    @Test
    fun `sumWithLog returns correct sum`() {
        val log = mutableListOf<String>()
        assertEquals(15, sumWithLog(listOf(1, 2, 3, 4, 5), log))
    }

    @Test
    fun `sumWithLog appends to log`() {
        val log = mutableListOf<String>()
        sumWithLog(listOf(1, 2, 3, 4, 5), log)
        assertEquals(listOf("sum=15"), log)
    }

    @Test
    fun `summarize kotlin`() = assertEquals("kotlin has 6 chars, first k, last n", summarize("kotlin"))

    @Test
    fun `summarize hi`() = assertEquals("hi has 2 chars, first h, last i", summarize("hi"))
}
