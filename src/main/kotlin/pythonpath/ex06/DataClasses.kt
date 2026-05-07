/*
 * Exercise 06 — Data Classes
 * ============================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `data class` auto-generates __eq__, __hash__, __repr__, and copy().
 *   Properties declared in the constructor are the data fields.
 *   `copy()` creates a modified clone: `p.copy(age = 31)` — like dataclasses.replace().
 *   Destructuring: `val (name, age) = person` unpacks in declaration order.
 *
 * PYTHON ANALOGY:
 *   @dataclass                         →  data class Person(
 *   class Person:                      →      val name: String,
 *       name: str                      →      val age: Int
 *       age: int                       →  )
 *
 *   dataclasses.replace(p, age=31)     →  p.copy(age = 31)
 *   str(p)  # uses __repr__            →  p.toString()  # auto-generated
 *   p1 == p2  # uses __eq__            →  p1 == p2  # auto-generated, compares fields
 *
 *   Key difference: Kotlin data classes are immutable by default (val fields).
 *   Use `var` only when you explicitly need mutability.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/data-classes.html
 *   https://kotlinlang.org/docs/destructuring-declarations.html
 */
package pythonpath.ex06

data class Person(val name: String, val age: Int)

// Return the younger of the two people. If ages are equal, return `a`.
fun younger(a: Person, b: Person): Person = TODO()

// Return a new Person with age incremented by 1. Use `.copy()`.
fun birthday(p: Person): Person = TODO()

// Return "<name> is <age> years old".
fun describe(p: Person): String = TODO()
