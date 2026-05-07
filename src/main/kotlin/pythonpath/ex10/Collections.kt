/*
 * Exercise 10 — Collections: map, filter, fold
 * ==============================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   Kotlin collections have map/filter/fold as methods — no `map()` / `filter()` builtins needed.
 *   `map { }` transforms each element — like `[f(x) for x in lst]` or `map(f, lst)`.
 *   `filter { }` keeps matching elements — like `[x for x in lst if pred(x)]`.
 *   `fold(initial) { acc, el -> }` accumulates — like `functools.reduce(f, lst, initial)`.
 *   `maxByOrNull { }` returns the max by a key, or null for an empty list.
 *
 * PYTHON ANALOGY:
 *   [x * 2 for x in lst]                    →  lst.map { it * 2 }
 *   [x for x in lst if x % 2 == 0]          →  lst.filter { it % 2 == 0 }
 *   functools.reduce(lambda a,b: a+b, lst, 0) →  lst.fold(0) { acc, n -> acc + n }
 *   max(lst, key=len)                        →  lst.maxByOrNull { it.length }
 *
 *   Key difference: Kotlin's methods return new lists — just like Python list comprehensions.
 *   The result of `map` is a `List`, not a lazy iterator (unlike Python's `map()`).
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/collection-transformations.html
 *   https://kotlinlang.org/docs/collection-filtering.html
 *   https://kotlinlang.org/docs/collection-aggregate.html
 *   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/
 */
package pythonpath.ex10

// Return a new list where every element is doubled.
fun doubleAll(numbers: List<Int>): List<Int> = TODO()

// Return only the even numbers.
fun onlyEven(numbers: List<Int>): List<Int> = TODO()

// Return the sum of all numbers using `fold`.
fun sumAll(numbers: List<Int>): Int = TODO()

// Return the longest word, or null if the list is empty.
fun longestWord(words: List<String>): String? = TODO()
