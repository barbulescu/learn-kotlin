/*
 * Exercise 12 — object Declarations and companion object
 * ========================================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `object` declares a singleton — one instance, like a Python module-level state.
 *   `companion object` provides class-level members — like Python's `@classmethod` or `@staticmethod`.
 *   Members of a companion are accessed as `ClassName.member()` — no instance needed.
 *
 * PYTHON ANALOGY:
 *   # Python module as singleton:
 *   # math_utils.py → factorial(n), is_prime(n)
 *   import math_utils; math_utils.factorial(5)
 *
 *   # Kotlin object:
 *   object MathUtils { fun factorial(n: Int): Long }
 *   MathUtils.factorial(5)
 *
 *   # Python classmethod factory:
 *   @classmethod
 *   def from_fahrenheit(cls, f): return cls((f - 32) * 5 / 9)
 *
 *   # Kotlin companion object factory:
 *   companion object { fun fromFahrenheit(f: Double) = Temperature((f - 32) * 5 / 9) }
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/object-declarations.html
 *   https://kotlinlang.org/docs/object-declarations.html#companion-objects
 */
package pythonpath.ex12

object MathUtils {
    // Return n! (factorial). Assume n >= 0. factorial(0) = 1.
    fun factorial(n: Int): Long = TODO()

    // Return true if n is a prime number. Assume n >= 0.
    fun isPrime(n: Int): Boolean = TODO()
}

class Temperature(val celsius: Double) {
    companion object {
        // Create a Temperature from a Fahrenheit value. Formula: (f - 32) * 5 / 9
        fun fromFahrenheit(f: Double): Temperature = TODO()

        // Return the boiling point of water (100°C).
        fun boiling(): Temperature = TODO()
    }

    // Convert this temperature to Fahrenheit. Formula: celsius * 9 / 5 + 32
    fun toFahrenheit(): Double = TODO()
}
