/*
 * Exercise 02 — String Templates
 * ================================
 *
 * KEY CONCEPTS:
 *   Embed variables directly with `$variable`.
 *   Embed expressions with `${expression}`.
 *   No concatenation or String.format() needed.
 *   Triple-quoted strings `"""..."""` are like Java 15+ text blocks.
 *
 * JAVA ANALOGY:
 *   "Hello, " + name + "!"           →  "Hello, $name!"
 *   String.format("Age: %d", age)    →  "Age: $age"
 *   "Sum: " + (a + b)                →  "Sum: ${a + b}"
 *   name.length()                    →  name.length   (property, no parentheses)
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/strings.html#string-templates
 *   https://kotlinlang.org/docs/strings.html
 */
package ex02

// Return "Hello, <name>! You are <age> years old."
fun formatGreeting(name: String, age: Int): String = "Hello, $name! You are $age years old."

// Return "Full name: <first> <last> (<n> characters)"
// e.g. formatFullName("John", "Doe") → "Full name: John Doe (8 characters)"
fun formatFullName(first: String, last: String): String {
    val full = "$first $last"
    return "Full name: $full (${full.length} characters)"
}

// Return "<a> + <b> = <sum>"
// e.g. showArithmetic(3, 4) → "3 + 4 = 7"
fun showArithmetic(a: Int, b: Int): String = "$a + $b = ${a + b}"
