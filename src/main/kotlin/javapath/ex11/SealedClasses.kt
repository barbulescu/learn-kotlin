/*
 * Exercise 11 — Sealed Classes
 * ==============================
 * PATH: Java developers
 *
 * KEY CONCEPTS:
 *   A `sealed class` restricts which classes can extend it — all subclasses must be in the same file.
 *   When used with `when`, the compiler enforces exhaustiveness: no missing branches, no `else` needed.
 *   Subclasses are usually `data class` (with state) or `object` (singleton, no state).
 *
 * JAVA ANALOGY:
 *   // Java 17+ sealed class (closest equivalent):
 *   sealed interface Shape permits Circle, Rectangle, Triangle {}
 *   record Circle(double radius) implements Shape {}
 *
 *   // Kotlin:
 *   sealed class Shape
 *   data class Circle(val radius: Double) : Shape()
 *
 *   Key benefit over Java enums: each subclass can carry different data.
 *   Key benefit over abstract classes: `when` exhaustiveness is compiler-checked.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/sealed-classes.html
 *   https://kotlinlang.org/docs/control-flow.html#when-expression
 */
package javapath.ex11

sealed class Shape
data class Circle(val radius: Double) : Shape()
data class Rectangle(val width: Double, val height: Double) : Shape()
data class Triangle(val base: Double, val height: Double) : Shape()

// Return the area of the shape. Use `when` — the compiler will warn if a branch is missing.
// Circle: π * r²  |  Rectangle: w * h  |  Triangle: (base * height) / 2
fun area(shape: Shape): Double = TODO()

// Return a human-readable description.
// Circle(2.0) → "Circle with radius 2.0"
// Rectangle(3.0, 5.0) → "Rectangle 3.0 x 5.0"
// Triangle(5.0, 3.0) → "Triangle with base 5.0 and height 3.0"
fun describe(shape: Shape): String = TODO()
