/*
 * Exercise 13 — Scope Functions
 * ================================
 *
 * KEY CONCEPTS:
 *   Scope functions run a block on an object and differ in: what `this`/`it` refers to, and what they return.
 *
 *   | Function | Receiver | Returns        | Typical use                          |
 *   |----------|----------|----------------|--------------------------------------|
 *   | let      | it       | lambda result  | Nullable checks, transformations     |
 *   | apply    | this     | the object     | Object configuration / builder style |
 *   | run      | this     | lambda result  | Compute a result using the receiver  |
 *   | also     | it       | the object     | Side effects in a chain (logging)    |
 *   | with     | this     | lambda result  | Operate on an object (non-extension) |
 *
 * NOTE: The tests only check return values — they cannot verify which scope function you
 * used. Each stub below names the one to practice; using it is the point of the exercise.
 *
 * JAVA ANALOGY:
 *   nullable?.let { transform(it) } ?: default   →  Optional.ofNullable(x).map(...).orElse(default)
 *   obj.apply { field = value }                  →  Builder pattern / fluent setters
 *   numbers.sum().also { log.add("sum=$it") }    →  result = compute(); log(result); return result;
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/scope-functions.html
 *   https://kotlinlang.org/docs/idioms.html#with
 */
package ex13

// Use `let` to safely process a nullable string: trim it and uppercase it,
// or return "NONE" if the input is null.
fun processInput(input: String?): String = TODO()

// Use `apply` to build and return a HashMap<String, String> containing:
// "host" → "localhost", "port" → "8080", "debug" → "true"
// Inside the block, prefer Kotlin's indexed assignment over put():
//   this["host"] = "localhost"
fun defaultConfig(): HashMap<String, String> = TODO()

// Use `also` to add a side effect: compute the sum of `numbers`, append "sum=<result>"
// to `log`, then return the sum.
fun sumWithLog(numbers: List<Int>, log: MutableList<String>): Int = TODO()

// Use `run` on the string to build a one-line summary from several of its members —
// inside the block, `this` is the string, so `length`, `first()`, and `last()` resolve directly.
// summarize("kotlin") → "kotlin has 6 chars, first k, last n"
fun summarize(s: String): String = TODO()
