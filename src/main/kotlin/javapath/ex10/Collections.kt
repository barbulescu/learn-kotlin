/*
 * Exercise 10 — Collections: map, filter, fold
 * ==============================================
 * PATH: Java developers
 *
 * KEY CONCEPTS:
 *   Kotlin collections have map/filter/fold built in — no .stream()/.collect() needed.
 *   `map { }` transforms each element.
 *   `filter { }` keeps elements matching a predicate.
 *   `fold(initial) { acc, el -> }` accumulates a result (like reduce with a seed).
 *   `maxByOrNull { }` returns the max element or null on an empty list.
 *
 * JAVA ANALOGY:
 *   list.stream().map(x -> x*2).collect(toList())     →  list.map { it * 2 }
 *   list.stream().filter(x -> x%2==0).collect(...)    →  list.filter { it % 2 == 0 }
 *   list.stream().reduce(0, Integer::sum)              →  list.fold(0) { acc, n -> acc + n }
 *   list.stream().max(Comparator.comparingInt(...))    →  list.maxByOrNull { it.length }
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/collection-transformations.html
 *   https://kotlinlang.org/docs/collection-filtering.html
 *   https://kotlinlang.org/docs/collection-aggregate.html
 *   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/
 */
package javapath.ex10

// Return a new list where every element is doubled.
fun doubleAll(numbers: List<Int>): List<Int> = TODO()

// Return only the even numbers.
fun onlyEven(numbers: List<Int>): List<Int> = TODO()

// Return the sum of all numbers using `fold`.
fun sumAll(numbers: List<Int>): Int = TODO()

// Return the longest word, or null if the list is empty.
fun longestWord(words: List<String>): String? = TODO()
