/*
 * Exercise 21 — Deleting the Builder
 * ===================================
 *
 * REFACTOR EXERCISE: the legacy program is ex21/legacy/LegacyRequest.java — four
 * fields, ~40 lines of Builder. LegacyJavaTest passes from the start, including the
 * bug report: build() happily builds a request with no url. The port is the data
 * class below (already written — six lines, Builder included*) plus the functions
 * that use it. Make BuildersTest pass.
 *   (* there is no Builder. That's the point.)
 *
 * KEY CONCEPTS:
 *   ex04 + ex06 taught the mechanics (data class, defaults, named arguments); this
 *   exercise is the payoff at pattern scale. A required field is a parameter with no
 *   default — omitting it is a COMPILE error, where the Builder scheduled an NPE.
 *   Optional fields carry their defaults in the constructor. Call sites name what
 *   they set and skip the rest. copy() is the "with one change" helper the Builder
 *   made you hand-roll.
 *   `apply { }` [ex13] covers the leftover case: mutable, setter-style objects from
 *   Java libraries you don't own — configure in one block, get the object back.
 *
 * JAVA ANALOGY:
 *   new Builder().url(u).build()           →  Request(u)
 *   .method("POST").body(json)             →  Request(u, method = "POST", body = json)
 *   hand-rolled withTimeout(...) copier    →  request.copy(timeoutMillis = t)
 *   builder-style config objects           →  TheirClass().apply { host = h; port = p }
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/functions.html#default-arguments
 *   https://kotlinlang.org/docs/functions.html#named-arguments
 *   https://kotlinlang.org/docs/data-classes.html#copying
 *   https://kotlinlang.org/docs/scope-functions.html#apply
 */
package ex21

// The entire port of LegacyRequest.java, Builder and all. url has no default —
// leaving it out will not compile; the other three defaults replace the Builder's
// field initializers [ex04, ex06].
data class Request(
    val url: String,
    val method: String = "GET",
    val body: String? = null,
    val timeoutMillis: Int = 30_000,
)

// new Builder().url(u).build()  →  one constructor call; defaults fill the rest.
fun getRequest(url: String): Request = TODO()

// The builder chain becomes a constructor call with NAMED arguments — set method and
// body, skip the middle, read like prose [ex06].
fun jsonPost(url: String, json: String): Request = TODO()

// Port of LegacyRequest.withTimeout — the hand-rolled every-field copier is copy()
// with one named change; the original is untouched [ex04].
fun withTimeout(request: Request, millis: Int): Request = TODO()

// A stand-in for a builder-era library class you don't own: mutable, setter-style.
class ConnectionPool {
    var name: String = ""
    var maxConnections: Int = 16
    var retries: Int = 3
}

// Configure a pool for CI in one `apply { }` block: the given name, maxConnections
// 4, retries 0 — and the pool comes back out of the block [ex13].
fun ciPool(name: String): ConnectionPool = TODO()
