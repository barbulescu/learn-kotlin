/*
 * Exercise 08 — Lambdas and Higher-Order Functions
 * ==================================================
 *
 * KEY CONCEPTS:
 *   A function type like `(Int) -> Int` describes a function taking an Int and returning an Int.
 *   Lambdas are written as `{ x -> x * 2 }` or just `{ it * 2 }` when there's one parameter.
 *   When a lambda is the last argument, it can be moved outside the parentheses (trailing lambda).
 *   Higher-order functions take or return other functions.
 *
 * JAVA ANALOGY:
 *   Function<Integer, Integer> f   →  val f: (Int) -> Int
 *   x -> x * 2                     →  { x -> x * 2 }  or  { it * 2 }
 *   Predicate<Integer> p            →  val p: (Int) -> Boolean
 *   applyTwice(3, x -> x + 1)       →  applyTwice(3) { it + 1 }  (trailing lambda)
 *
 *   Kotlin lambdas are lighter: no @FunctionalInterface, no SAM boilerplate.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/lambdas.html
 *   https://kotlinlang.org/docs/lambdas.html#higher-order-functions
 *   https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
 */
package ex08

// Apply f to x, then apply f to the result.
// applyTwice(3) { it + 1 } → 5
fun applyTwice(x: Int, f: (Int) -> Int): Int = f(f(x))

// Return a new list containing only elements for which predicate returns true.
// Build it by hand with a loop and a mutableListOf — you are implementing `filter` yourself
// to see how a function parameter is called. (`list.filter` would pass the test but defeat
// the point; you'll meet the real thing in ex09.)
// keepIf(listOf(1,2,3,4)) { it % 2 == 0 } → [2, 4]
fun <T> keepIf(list: List<T>, predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (element in list) {
        if (predicate(element)) result.add(element)
    }
    return result
}

// Apply f to every element and return the resulting list.
// Again by hand with a loop — this is `map` built yourself; the stdlib version arrives in ex09.
// transformAll(listOf("hi", "bye")) { it.uppercase() } → ["HI", "BYE"]
fun <T, R> transformAll(list: List<T>, f: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (element in list) {
        result.add(f(element))
    }
    return result
}
