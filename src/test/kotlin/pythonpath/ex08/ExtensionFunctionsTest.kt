package pythonpath.ex08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ExtensionFunctionsTest {

    @Test
    @Disabled("TODO: implement isPalindrome() to make these pass")
    fun `racecar is a palindrome`() = assertTrue("racecar".isPalindrome())

    @Test
    @Disabled("TODO: implement isPalindrome() to make these pass")
    fun `madam is a palindrome`() = assertTrue("madam".isPalindrome())

    @Test
    @Disabled("TODO: implement isPalindrome() to make these pass")
    fun `hello is not a palindrome`() = assertFalse("hello".isPalindrome())

    @Test
    @Disabled("TODO: implement isPalindrome() to make these pass")
    fun `single char is a palindrome`() = assertTrue("a".isPalindrome())

    @Test
    @Disabled("TODO: implement isEven() to make these pass")
    fun `4 is even`() = assertTrue(4.isEven())

    @Test
    @Disabled("TODO: implement isEven() to make these pass")
    fun `7 is not even`() = assertFalse(7.isEven())

    @Test
    @Disabled("TODO: implement isEven() to make these pass")
    fun `0 is even`() = assertTrue(0.isEven())

    @Test
    @Disabled("TODO: implement wordCount() to make these pass")
    fun `wordCount of hello world is 2`() = assertEquals(2, "hello world".wordCount())

    @Test
    @Disabled("TODO: implement wordCount() to make these pass")
    fun `wordCount ignores extra whitespace`() = assertEquals(2, "  hi  there  ".wordCount())

    @Test
    @Disabled("TODO: implement wordCount() to make these pass")
    fun `wordCount of single word is 1`() = assertEquals(1, "kotlin".wordCount())
}
