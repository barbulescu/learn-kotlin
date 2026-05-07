/*
 * Exercise 07 — Ranges and for Loops
 * =====================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `1..10` is a closed range (1 to 10 inclusive) — Python's `range(1, 11)`.
 *   `1 until 10` is half-open (1 to 9) — Python's `range(1, 10)`.
 *   `10 downTo 1` counts backwards — Python's `range(10, 0, -1)`.
 *   `1..10 step 3` uses a custom step — Python's `range(1, 11, 3)`.
 *   `n in 1..10` membership check — Python's `1 <= n <= 10` or `n in range(1, 11)`.
 *
 * PYTHON ANALOGY:
 *   for i in range(1, 11):       →  for (i in 1..10)
 *   for i in range(1, 10):       →  for (i in 1 until 10)
 *   for i in range(10, 0, -1):   →  for (i in 10 downTo 1)
 *   for i in range(1, 11, 3):    →  for (i in 1..10 step 3)
 *
 *   Note: Kotlin's `for` loop only iterates — no index by default.
 *   Use `list.indices` or `list.withIndex()` when you need the index.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/ranges.html
 *   https://kotlinlang.org/docs/control-flow.html#for-loops
 */
package pythonpath.ex07

// Sum all integers from `from` to `to` inclusive using a for loop and a range.
fun sumRange(from: Int, to: Int): Int = TODO()

// Return a list counting down from `n` to 1 (inclusive) using `downTo`.
// countdown(5) → [5, 4, 3, 2, 1]
fun countdown(n: Int): List<Int> = TODO()

// Return a list of integers from `from` to `to` (inclusive) at every `step` interval.
// everyNth(1, 10, 3) → [1, 4, 7, 10]
fun everyNth(from: Int, to: Int, step: Int): List<Int> = TODO()
