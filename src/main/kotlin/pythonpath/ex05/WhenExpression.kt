/*
 * Exercise 05 — when Expression
 * ================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `when` replaces if/elif chains and returns a value (it's an expression).
 *   Similar to Python 3.10+ `match`, but more flexible — supports ranges and arbitrary conditions.
 *   No `break`, no fall-through.
 *
 * PYTHON ANALOGY:
 *   # Python 3.10+ match:        # Kotlin when:
 *   match n:                     when (n) {
 *     case 0: ...                  0 -> ...
 *     case _: ...                  else -> ...
 *   }                            }
 *
 *   # Python if/elif chain:      # Kotlin when without argument:
 *   if n < 0: ...                when {
 *   elif n == 0: ...               n < 0 -> ...
 *   else: ...                      n == 0 -> ...
 *                                  else -> ...
 *                                }
 *
 *   # Range matching (no direct Python match equivalent):
 *   1..9 -> "small"   # Kotlin IntRange — Python would need: case n if 1 <= n <= 9
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/control-flow.html#when-expression
 *   https://kotlinlang.org/docs/kotlin-tour-control-flow.html
 */
package pythonpath.ex05

// Classify an integer: "negative", "zero", "small" (1..9), or "large" (>= 10).
fun classify(n: Int): String = TODO()

// Map day number (1 = Monday .. 7 = Sunday) to "weekday" or "weekend".
fun dayType(day: Int): String = TODO()

// Classic FizzBuzz: return "Fizz" (÷3), "Buzz" (÷5), "FizzBuzz" (÷both), or the number as a string.
fun fizzBuzz(n: Int): String = TODO()
