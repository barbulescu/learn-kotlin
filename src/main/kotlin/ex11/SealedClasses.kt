/*
 * Exercise 11 — Sealed Classes
 * ==============================
 *
 * KEY CONCEPTS:
 *   A `sealed class` restricts which classes can extend it — all subclasses must be in the same file.
 *   When used with `when`, the compiler enforces exhaustiveness: no missing branches, no `else` needed.
 *   Subclasses are usually `data class` (with state) or `object` (singleton, no state).
 *
 *   SMART CASTS: after an `is` type check, the compiler automatically narrows the type.
 *   No explicit cast needed — just check once, then use the subclass properties directly.
 *     when (shape) {
 *         is Circle -> shape.radius   // `shape` is smart-cast to Circle here
 *     }
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
 *   // Java requires explicit cast even after instanceof:
 *   if (shape instanceof Circle c) { ... c.getRadius() ... }  // Java 16+ pattern variable
 *   // Kotlin: just use `is` and the compiler handles the rest — no cast needed.
 *
 *   Key benefit over Java enums: each subclass can carry different data.
 *   Key benefit over abstract classes: `when` exhaustiveness is compiler-checked.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/sealed-classes.html
 *   https://kotlinlang.org/docs/control-flow.html#when-expression
 *   https://kotlinlang.org/docs/typecasts.html#smart-casts
 */
package ex11

sealed class Shape
data class Circle(val radius: Double) : Shape()
data class Rectangle(val width: Double, val height: Double) : Shape()
data class Triangle(val base: Double, val height: Double) : Shape()

// Return the area of the shape. Use `when` — the compiler will warn if a branch is missing.
// Circle: π * r²  |  Rectangle: w * h  |  Triangle: (base * height) / 2
// For π use `kotlin.math.PI` — yes, Kotlin lets you import a bare top-level constant
// (`import kotlin.math.PI`), no wrapper class like Java's Math needed.
fun area(shape: Shape): Double = TODO()

// Return a human-readable description.
// Circle(2.0) → "Circle with radius 2.0"
// Rectangle(3.0, 5.0) → "Rectangle 3.0 x 5.0"
// Triangle(5.0, 3.0) → "Triangle with base 5.0 and height 3.0"
fun describe(shape: Shape): String = TODO()

// Scale the shape by the given factor and return a new Shape.
// Only Circle and Rectangle can be scaled — multiply their size properties by `factor`.
// A Triangle is returned unchanged (scaling both base and height by the same factor changes area
// quadratically, so we leave it as a deliberate asymmetry to discuss in class).
//   scaleUp(Circle(2.0), 3.0)        → Circle(6.0)
//   scaleUp(Rectangle(3.0, 5.0), 2.0) → Rectangle(6.0, 10.0)
//   scaleUp(Triangle(5.0, 3.0), 2.0)  → Triangle(5.0, 3.0)
// Hint: use `is Circle` — the compiler smart-casts `shape` so you can access `shape.radius`
// directly inside that branch without any explicit cast.
fun scaleUp(shape: Shape, factor: Double): Shape = TODO()
