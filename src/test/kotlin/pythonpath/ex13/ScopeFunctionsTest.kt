package pythonpath.ex13

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ScopeFunctionsTest {

    @Test
    @Disabled("TODO: implement processInput() to make these pass")
    fun `processInput trims and uppercases`() = assertEquals("HELLO", processInput("  hello  "))

    @Test
    @Disabled("TODO: implement processInput() to make these pass")
    fun `processInput returns NONE for null`() = assertEquals("NONE", processInput(null))

    @Test
    @Disabled("TODO: implement processInput() to make these pass")
    fun `processInput on already clean string`() = assertEquals("WORLD", processInput("world"))

    @Test
    @Disabled("TODO: implement defaultConfig() to make these pass")
    fun `defaultConfig has correct entries`() {
        val config = defaultConfig()
        assertEquals("localhost", config["host"])
        assertEquals("8080", config["port"])
        assertEquals("true", config["debug"])
        assertEquals(3, config.size)
    }

    @Test
    @Disabled("TODO: implement sumWithLog() to make these pass")
    fun `sumWithLog returns correct sum`() {
        val log = mutableListOf<String>()
        assertEquals(15, sumWithLog(listOf(1, 2, 3, 4, 5), log))
    }

    @Test
    @Disabled("TODO: implement sumWithLog() to make these pass")
    fun `sumWithLog appends to log`() {
        val log = mutableListOf<String>()
        sumWithLog(listOf(1, 2, 3, 4, 5), log)
        assertEquals(listOf("sum=15"), log)
    }

    @Test
    @Disabled("TODO: implement distinctCharCount() to make these pass")
    fun `distinctCharCount of hello is 4`() = assertEquals(4, distinctCharCount("hello"))

    @Test
    @Disabled("TODO: implement distinctCharCount() to make these pass")
    fun `distinctCharCount of aabbcc is 3`() = assertEquals(3, distinctCharCount("aabbcc"))

    @Test
    @Disabled("TODO: implement distinctCharCount() to make these pass")
    fun `distinctCharCount of a is 1`() = assertEquals(1, distinctCharCount("a"))
}
