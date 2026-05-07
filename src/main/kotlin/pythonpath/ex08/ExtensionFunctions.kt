/*
 * Exercise 08 — Extension Functions
 * ====================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   Extension functions add methods to existing types you don't own.
 *   Inside the function, `this` refers to the receiver (the object before the dot).
 *   Unlike Python monkey-patching, extensions are resolved statically — safe, no runtime surprises.
 *   The standard library is full of them: String.trim(), List.first(), Int.coerceIn()...
 *
 * PYTHON ANALOGY:
 *   # Python: monkey-patching (works but fragile, not idiomatic):
 *   str.is_palindrome = lambda self: self == self[::-1]
 *   "racecar".is_palindrome()
 *
 *   # Kotlin extension function (clean and safe):
 *   fun String.isPalindrome(): Boolean = this == this.reversed()
 *   "racecar".isPalindrome()
 *
 *   Key difference: Kotlin extensions don't modify the class — they're syntactic sugar
 *   for a static function call. No global state, no risk of breaking existing code.
 *
 *   Also note: `this` in Kotlin == `self` in Python (but implicit, not a parameter).
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/extensions.html
 *   https://kotlinlang.org/docs/idioms.html#extension-functions
 */
package pythonpath.ex08

// Return true if the string reads the same forwards and backwards (case-sensitive).
// "racecar".isPalindrome() → true,  "hello".isPalindrome() → false
fun String.isPalindrome(): Boolean = TODO()

// Return true if the integer is even.
fun Int.isEven(): Boolean = TODO()

// Return the number of words (split by one or more whitespace characters).
// "hello world".wordCount() → 2,  "  hi  there  ".wordCount() → 2
fun String.wordCount(): Int = TODO()
