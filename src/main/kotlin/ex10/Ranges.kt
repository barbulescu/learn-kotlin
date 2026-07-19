/*
 * Exercise 10 — Ranges and for Loops
 * =====================================
 *
 * KEY CONCEPTS:
 *   `1..10` is a closed range (1 to 10 inclusive) — use in for loops or `in` checks.
 *   `1 until 10` is a half-open range (1 to 9).
 *   `10 downTo 1` counts backwards.
 *   `1..10 step 3` iterates with a custom step.
 *   Ranges also work for Char: `'a'..'z'`.
 *
 * JAVA ANALOGY:
 *   for (int i = 1; i <= 10; i++)        →  for (i in 1..10)
 *   for (int i = 0; i < 10; i++)         →  for (i in 0 until 10)
 *   for (int i = 10; i >= 1; i--)        →  for (i in 10 downTo 1)
 *   for (int i = 1; i <= 10; i += 3)     →  for (i in 1..10 step 3)
 *   n >= 1 && n <= 10                    →  n in 1..10
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/ranges.html
 *   https://kotlinlang.org/docs/control-flow.html#for-loops
 */
package ex10

// Sum all integers from `from` to `to` inclusive using a for loop and a range.
fun sumRange(from: Int, to: Int): Int {
    var sum = 0
    for (i in from..to) sum += i
    return sum
}

// Return a list counting down from `n` to 1 (inclusive) using `downTo`.
// countdown(5) → [5, 4, 3, 2, 1]
fun countdown(n: Int): List<Int> = (n downTo 1).toList()

// Return a list of integers from `from` to `to` (inclusive), advancing by `interval` each
// time — the infix `step` function is what you're practicing here. `interval` is always >= 1;
// if it overshoots `to`, the range simply ends earlier.
// everyNth(1, 10, 3) → [1, 4, 7, 10]
fun everyNth(from: Int, to: Int, interval: Int): List<Int> = (from..to step interval).toList()
