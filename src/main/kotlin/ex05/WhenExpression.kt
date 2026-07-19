/*
 * Exercise 05 — when Expression
 * ================================
 *
 * KEY CONCEPTS:
 *   `when` replaces switch/if-else chains and returns a value (it's an expression, not a statement).
 *   No fall-through, no `break` needed.
 *   Branches can match ranges (`1..9`), multiple values (`6, 7`), or arbitrary conditions.
 *   When used without an argument: `when { condition -> ... }` replaces if/else chains.
 *
 * JAVA ANALOGY:
 *   // Java 14+ switch expression (closest equivalent):
 *   return switch (n) { case 0 -> "zero"; default -> "other"; };
 *
 *   // Kotlin when expression:
 *   return when (n) { 0 -> "zero"; else -> "other" }
 *
 *   // Kotlin range match (no Java equivalent):
 *   1..9 -> "small"
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/control-flow.html#when-expression
 *   https://kotlinlang.org/docs/kotlin-tour-control-flow.html
 */
package ex05

// Classify an integer: "negative", "zero", "small" (1..9), or "large" (>= 10).
fun classify(n: Int): String = TODO()

// Map day number (1 = Monday .. 7 = Sunday) to "weekday" or "weekend".
// `day` is always in 1..7 — no need to handle other values.
fun dayType(day: Int): String = TODO()

// Classic FizzBuzz: return "Fizz" (÷3), "Buzz" (÷5), "FizzBuzz" (÷both), or the number as a string.
fun fizzBuzz(n: Int): String = TODO()
