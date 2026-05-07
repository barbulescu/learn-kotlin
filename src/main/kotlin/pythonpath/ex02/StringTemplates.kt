/*
 * Exercise 02 — String Templates
 * ================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   Embed variables with `$variable` — almost identical to Python f-strings.
 *   Embed expressions with `${expression}` — like `{expression}` in f-strings.
 *   `str.length` is a property (no parentheses), like Python's `len(str)`.
 *
 * PYTHON ANALOGY:
 *   f"Hello, {name}!"     →  "Hello, $name!"
 *   f"Age: {age}"         →  "Age: $age"
 *   f"Sum: {a + b}"       →  "Sum: ${a + b}"
 *   f"{len(s)}"           →  "${s.length}"   (Kotlin uses .length property, not len())
 *
 *   Key difference: Kotlin uses `$` for simple names and `${}` for expressions.
 *   Python uses `{}` for both. No `f` prefix needed in Kotlin.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/strings.html#string-templates
 *   https://kotlinlang.org/docs/strings.html
 */
package pythonpath.ex02

// Return "Hello, <name>! You are <age> years old."
fun formatGreeting(name: String, age: Int): String = TODO()

// Return "Full name: <first> <last> (<n> characters)"
// e.g. formatFullName("John", "Doe") → "Full name: John Doe (8 characters)"
fun formatFullName(first: String, last: String): String = TODO()

// Return "<a> + <b> = <sum>"
// e.g. showArithmetic(3, 4) → "3 + 4 = 7"
fun showArithmetic(a: Int, b: Int): String = TODO()
