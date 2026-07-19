/*
 * Exercise 01 — val, var, and Type Inference
 * ============================================
 *
 * KEY CONCEPTS:
 *   `val` declares a read-only variable (assigned once, like `final`).
 *   `var` declares a mutable variable.
 *   Kotlin infers types — you rarely need to write them explicitly.
 *   `Int`, `String`, `Boolean` are Kotlin types; the compiler maps them to JVM primitives.
 *
 * JAVA ANALOGY:
 *   val name: String = "Alice"  →  final String name = "Alice";
 *   val x = 42                  →  final int x = 42;      // type inferred
 *   var count = 0               →  var count = 0;         // Java 10+
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/basic-syntax.html#variables
 *   https://kotlinlang.org/docs/basic-types.html
 *   https://play.kotlinlang.org  (try snippets in the browser)
 */
package ex01

// Sum all integers from 1 to n (inclusive). Use a `var` accumulator inside a loop.
fun sumUpTo(n: Int): Int {
    TODO()
}

// Return initials like "J.D." given firstName = "John" and lastName = "Doe".
fun initials(firstName: String, lastName: String): String = TODO()
