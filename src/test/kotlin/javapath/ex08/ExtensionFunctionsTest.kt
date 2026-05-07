package javapath.ex08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ExtensionFunctionsTest {

    @Test fun `racecar is a palindrome`() = assertTrue("racecar".isPalindrome())
    @Test fun `madam is a palindrome`() = assertTrue("madam".isPalindrome())
    @Test fun `hello is not a palindrome`() = assertFalse("hello".isPalindrome())
    @Test fun `single char is a palindrome`() = assertTrue("a".isPalindrome())

    @Test fun `4 is even`() = assertTrue(4.isEven())
    @Test fun `7 is not even`() = assertFalse(7.isEven())
    @Test fun `0 is even`() = assertTrue(0.isEven())

    @Test fun `wordCount of hello world is 2`() = assertEquals(2, "hello world".wordCount())
    @Test fun `wordCount ignores extra whitespace`() = assertEquals(2, "  hi  there  ".wordCount())
    @Test fun `wordCount of single word is 1`() = assertEquals(1, "kotlin".wordCount())
}
