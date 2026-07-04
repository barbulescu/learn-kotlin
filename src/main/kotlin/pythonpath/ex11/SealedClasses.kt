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
 *   SMART CASTS: after an `is` type check, the compiler automatically narrows the type.
 *   No explicit cast needed — just check once, then use the subclass properties directly.
 *     when (shape) {
 *         is Circle -> shape.radius   // `shape` is smart-cast to Circle here
 *     }
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
 *       is Circle -> ...        // `shape` is smart-cast to Circle — access shape.radius freely
 *       is Rectangle -> ...
 *       is Triangle -> ...      // missing this → compile error
 *   }
 *
 *   Smart cast ≈ Python's isinstance() check, but the cast happens implicitly.
 *   In Python you'd still write `shape.radius` after `isinstance(shape, Circle)` — same idea,
 *   but Kotlin enforces it at compile time and needs no explicit cast().
 *
 *   Python 3.10+ `match` with structural patterns is the closest equivalent,
 *   but still not compiler-enforced for exhaustiveness.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/sealed-classes.html
 *   https://kotlinlang.org/docs/control-flow.html#when-expression
 *   https://kotlinlang.org/docs/typecasts.html#smart-casts
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

// Scale the shape by the given factor and return a new Shape.
// Only Circle and Rectangle can be scaled — multiply their size properties by `factor`.
// A Triangle is returned unchanged (scaling both base and height by the same factor changes area
// quadratically, so we leave it as a deliberate asymmetry to discuss in class).
//   scaleUp(Circle(2.0), 3.0)         → Circle(6.0)
//   scaleUp(Rectangle(3.0, 5.0), 2.0) → Rectangle(6.0, 10.0)
//   scaleUp(Triangle(5.0, 3.0), 2.0)  → Triangle(5.0, 3.0)
// Hint: use `is Circle` — the compiler smart-casts `shape` so you can access `shape.radius`
// directly inside that branch without any explicit cast (like isinstance() but with free casting).
fun scaleUp(shape: Shape, factor: Double): Shape = TODO()
