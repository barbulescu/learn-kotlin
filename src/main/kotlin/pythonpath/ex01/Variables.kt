/*
 * Exercise 01 — val, var, and Type Inference
 * ============================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `val` declares a read-only variable — like a Python constant by convention (ALL_CAPS).
 *   `var` declares a mutable variable — like a regular Python variable.
 *   Kotlin infers types like Python does, but checks them at compile time.
 *   Reassigning a `val` is a compile error, not a runtime one.
 *
 * PYTHON ANALOGY:
 *   val name = "Alice"    →  name = "Alice"   # (by convention, never reassign)
 *   var count = 0         →  count = 0
 *   val x: Int = 42       →  x: int = 42      # Python 3.6+ type hint (not enforced by Python)
 *   Unlike Python, `val x = 1; x = 2` is a compile error in Kotlin.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/basic-syntax.html#variables
 *   https://kotlinlang.org/docs/basic-types.html
 *   https://play.kotlinlang.org  (try snippets in the browser)
 */
package pythonpath.ex01

// Sum all integers from 1 to n (inclusive). Use a `var` accumulator inside a loop.
fun sumUpTo(n: Int): Int = TODO()

// Return initials like "J.D." given firstName = "John" and lastName = "Doe".
fun initials(firstName: String, lastName: String): String = TODO()
