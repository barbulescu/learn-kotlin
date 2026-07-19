/*
 * Exercise 04 — Data Classes
 * ============================
 *
 * KEY CONCEPTS:
 *   `data class` auto-generates equals(), hashCode(), toString(), and copy().
 *   Properties declared in the constructor are the "component" properties.
 *   `copy()` creates a modified clone: `p.copy(age = 31)` keeps all fields except age.
 *   Destructuring: `val (name, age) = person` unpacks in declaration order.
 *
 * JAVA ANALOGY:
 *   // Java (pre-16): ~20 lines of boilerplate
 *   public class Person { ... equals, hashCode, toString, getters ... }
 *
 *   // Java 16+ record (closest equivalent):
 *   record Person(String name, int age) {}
 *
 *   // Kotlin:
 *   data class Person(val name: String, val age: Int)
 *   person.copy(age = 31)    // immutable update — no Java equivalent without builders
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/data-classes.html
 *   https://kotlinlang.org/docs/destructuring-declarations.html
 */
package ex04

data class Person(val name: String, val age: Int)

// Return the younger of the two people. If ages are equal, return `a`.
fun younger(a: Person, b: Person): Person = if (a.age <= b.age) a else b

// Return a new Person with age incremented by 1. Use `.copy()`.
fun birthday(p: Person): Person = p.copy(age = p.age + 1)

// Return "<name> is <age> years old".
fun describe(p: Person): String = "${p.name} is ${p.age} years old"
