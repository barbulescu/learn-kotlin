/*
 * Exercise 12 — object Declarations and companion object
 * ========================================================
 *
 * KEY CONCEPTS:
 *   `object` declares a singleton — one instance, created lazily on first use.
 *   `companion object` lives inside a class and provides class-level members (like factory methods).
 *   Members of a companion are accessed as `ClassName.member()` — no instance needed.
 *
 * JAVA ANALOGY:
 *   object MathUtils { ... }           →  class MathUtils { private MathUtils(){} static ... }
 *   MathUtils.factorial(5)             →  MathUtils.factorial(5)   (same call site)
 *
 *   companion object { fun of(...) }   →  static factory method
 *   Temperature.fromFahrenheit(212.0)  →  Temperature.fromFahrenheit(212.0)  (same)
 *
 *   There are no `static` members in Kotlin — `companion object` is the idiomatic replacement.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/object-declarations.html
 *   https://kotlinlang.org/docs/object-declarations.html#companion-objects
 */
package ex12

object MathUtils {
    // Return n! (factorial). Assume n >= 0. factorial(0) = 1.
    fun factorial(n: Int): Long {
        var result = 1L
        for (i in 1..n) result *= i
        return result
    }

    // Return true if n is a prime number. Assume n >= 0.
    fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        var i = 2
        while (i * i <= n) {
            if (n % i == 0) return false
            i++
        }
        return true
    }
}

class Temperature(val celsius: Double) {
    companion object {
        // Create a Temperature from a Fahrenheit value. Formula: (f - 32) * 5 / 9
        fun fromFahrenheit(f: Double): Temperature = Temperature((f - 32) * 5 / 9)

        // Return the boiling point of water (100°C).
        fun boiling(): Temperature = Temperature(100.0)
    }

    // Convert this temperature to Fahrenheit. Formula: celsius * 9 / 5 + 32
    fun toFahrenheit(): Double = celsius * 9 / 5 + 32
}
