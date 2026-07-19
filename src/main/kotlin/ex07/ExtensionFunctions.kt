/*
 * Exercise 07 — Extension Functions
 * ====================================
 *
 * KEY CONCEPTS:
 *   Extension functions add methods to existing types without subclassing or wrapping.
 *   Inside the function, `this` refers to the receiver (the object before the dot).
 *   They are resolved statically — useful for utility methods, replaces helper classes.
 *   The standard library is full of them: String.trim(), List.first(), Int.coerceIn()...
 *
 * JAVA ANALOGY:
 *   // Java: utility class (StringUtils, etc.)
 *   public class StringUtils {
 *       public static boolean isPalindrome(String s) { ... }
 *   }
 *   StringUtils.isPalindrome("racecar");
 *
 *   // Kotlin: extension function called like a method
 *   fun String.isPalindrome(): Boolean { ... }
 *   "racecar".isPalindrome()
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/extensions.html
 *   https://kotlinlang.org/docs/idioms.html#extension-functions
 */
package ex07

// Return true if the string reads the same forwards and backwards (case-sensitive).
// "racecar".isPalindrome() → true,  "hello".isPalindrome() → false
fun String.isPalindrome(): Boolean = TODO()

// Return true if the integer is even.
fun Int.isEven(): Boolean = TODO()

// Return the number of words (split by one or more whitespace characters).
// The input always contains at least one word — no need to handle empty or blank strings.
// Hint: split(Regex("""\s+""")) — Regex is Kotlin's regex class, and triple quotes make a
// raw string, so the backslash needs no escaping (Java would need "\\s+").
// "hello world".wordCount() → 2,  "  hi  there  ".wordCount() → 2
fun String.wordCount(): Int = TODO()
