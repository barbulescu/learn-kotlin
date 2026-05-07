/*
 * Exercise 11 — Sealed Classes
 * ==============================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   A `sealed class` restricts which classes can extend it — all subclasses must be in the same file.
 *   When used with `when`, the compiler enforces exhaustiveness: no missing branch compiles silently.
 *   Subclasses are usually `data class` (with state) or `object` (no state, singleton).
 *
 * PYTHON ANALOGY:
 *   # Python: Union type + isinstance checks (not enforced at compile time)
 *   Shape = Circle | Rectangle | Triangle
 *   if isinstance(shape, Circle): ...
 *   elif isinstance(shape, Rectangle): ...
 *   # Python won't warn if you forget Triangle
 *
 *   # Kotlin: sealed class + when (exhaustiveness is a compile error)
 *   when (shape) {
 *       is Circle -> ...
 *       is Rectangle -> ...
 *       is Triangle -> ...    // missing this → compile error
 *   }
 *
 *   Python 3.10+ `match` with structural patterns is the closest equivalent,
 *   but still not compiler-enforced for exhaustiveness.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/sealed-classes.html
 *   https://kotlinlang.org/docs/control-flow.html#when-expression
 */
package pythonpath.ex11

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
