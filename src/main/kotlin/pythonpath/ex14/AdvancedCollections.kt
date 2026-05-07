/*
 * Exercise 14 — Advanced Collections
 * ======================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `groupBy { key }` — splits a list into a Map<K, List<V>> based on a key function.
 *   `partition { predicate }` — splits a list into two lists: Pair(matching, notMatching).
 *   `flatMap { list }` — maps each element to a list, then flattens all into one.
 *   `zip(other)` — pairs elements from two lists by index into a List<Pair<A, B>>.
 *
 * PYTHON ANALOGY:
 *   {k: list(v) for k,v in groupby(...)}    →  list.groupBy { ... }
 *   evens = [x for x in lst if x%2==0]      →  val (evens, odds) = lst.partition { it%2==0 }
 *   [w for s in sentences for w in s.split()] →  sentences.flatMap { it.split(" ") }
 *   list(zip(a, b))                          →  a.zip(b)
 *
 *   Key difference: `partition` returns both halves at once as a `Pair` — destructure it:
 *   `val (evens, odds) = numbers.partition { it % 2 == 0 }`
 *   Python's `zip()` returns an iterator of tuples; Kotlin's returns a `List<Pair>` directly.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/collection-grouping.html
 *   https://kotlinlang.org/docs/collection-transformations.html#zip
 *   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/flat-map.html
 */
package pythonpath.ex14

// Group words by their length.
// groupByLength(["hi", "bye", "ok", "hello"]) → {2: ["hi", "ok"], 3: ["bye"], 5: ["hello"]}
fun groupByLength(words: List<String>): Map<Int, List<String>> = TODO()

// Split numbers into (evens, odds). First element of the Pair is the evens.
// partitionEvenOdd([1,2,3,4,5]) → Pair([2,4], [1,3,5])
fun partitionEvenOdd(numbers: List<Int>): Pair<List<Int>, List<Int>> = TODO()

// Split each sentence by spaces and return all words in a single flat list.
// allWords(["hello world", "foo bar"]) → ["hello", "world", "foo", "bar"]
fun allWords(sentences: List<String>): List<String> = TODO()

// Pair up elements from two lists by index.
// zipPairs(["a","b","c"], [1,2,3]) → [("a",1), ("b",2), ("c",3)]
fun zipPairs(keys: List<String>, values: List<Int>): List<Pair<String, Int>> = TODO()
