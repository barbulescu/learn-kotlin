/*
 * Exercise 09 — Lambdas and Higher-Order Functions
 * ==================================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   A function type like `(Int) -> Int` is the type of a function taking an Int, returning an Int.
 *   Lambdas: `{ x -> x * 2 }` or `{ it * 2 }` when there's a single parameter (`it` is implicit).
 *   When a lambda is the last argument, it can be placed outside the parentheses (trailing lambda).
 *   Higher-order functions take or return other functions — just like Python.
 *
 * PYTHON ANALOGY:
 *   lambda x: x * 2               →  { x -> x * 2 }  or  { it * 2 }
 *   def apply_twice(x, f): ...     →  fun applyTwice(x: Int, f: (Int) -> Int): Int
 *   apply_twice(3, lambda x: x+1)  →  applyTwice(3) { it + 1 }  (trailing lambda syntax)
 *   filter(pred, lst)              →  keepIf(list, predicate)
 *   map(f, lst)                    →  transformAll(list, f)
 *
 *   Key difference: `it` is the implicit name for a single-parameter lambda.
 *   There's no Python equivalent — Python always requires naming the parameter.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/lambdas.html
 *   https://kotlinlang.org/docs/lambdas.html#higher-order-functions
 *   https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter
 */
package pythonpath.ex09

// Apply f to x, then apply f to the result.
// applyTwice(3) { it + 1 } → 5
fun applyTwice(x: Int, f: (Int) -> Int): Int = TODO()

// Return a new list containing only elements for which predicate returns true.
// keepIf(listOf(1,2,3,4)) { it % 2 == 0 } → [2, 4]
fun <T> keepIf(list: List<T>, predicate: (T) -> Boolean): List<T> = TODO()

// Apply f to every element and return the resulting list.
// transformAll(listOf("hi", "bye")) { it.uppercase() } → ["HI", "BYE"]
fun <T, R> transformAll(list: List<T>, f: (T) -> R): List<R> = TODO()
