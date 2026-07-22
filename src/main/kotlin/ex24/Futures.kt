/*
 * Exercise 24 — From CompletableFuture to Coroutines
 * ===================================================
 *
 * REFACTOR EXERCISE, and the track's closer: the legacy program is
 * ex24/legacy/LegacyFutures.java — async composition via thenCompose/thenCombine,
 * with the blocking, checked-exception-wrapped .get() at the exit. LegacyJavaTest
 * passes from the start. Port it below; FuturesTest runs on a VIRTUAL clock
 * (kotlinx-coroutines-test) and proves the concurrency by reading the time.
 *
 * KEY CONCEPTS:
 *   ex15 taught the primitives; this is the refactor. Sequential async code is just
 *   sequential code: call a suspend function, use the value on the next line — the
 *   compiler performs the thenCompose transformation for you. Parallel composition
 *   is `async { }` twice + `.await()` twice inside `coroutineScope { }` — and that
 *   scope is structured concurrency: if either branch fails, the other is cancelled
 *   (futures just leak).
 *   No combinator vocabulary (thenApply / thenCompose / thenCombine / handle /
 *   whenComplete), and no wrapper in signatures: `suspend fun f(): String`, not
 *   `CompletableFuture<String> f()`.
 *
 * JAVA ANALOGY:
 *   f().thenApply(x -> g(x))               →  g(f())
 *   f().thenCompose(x -> gAsync(x))        →  val x = f(); g(x)   — plain lines
 *   a().thenCombine(b(), (x, y) -> ...)    →  coroutineScope {
 *                                                val x = async { a() }
 *                                                val y = async { b() }
 *                                                ... x.await(), y.await() ... }
 *   future.get() + 2 checked exceptions    →  runBlocking { f() } — at the very edge only
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/composing-suspending-functions.html
 *   https://kotlinlang.org/docs/coroutines-basics.html
 */
package ex24

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

// The pretend-remote calls, already ported. Each suspends for 100 virtual
// milliseconds — the tests use this to PROVE sequential vs concurrent [ex15].
suspend fun fetchName(userId: Int): String {
    delay(100)
    return "user$userId"
}

suspend fun fetchScore(userId: Int): Int {
    delay(100)
    return userId * 6
}

// Port of LegacyFutures.greetingFor — thenCompose disappears: call fetchName, use
// the value on the next line. Sequential async code is just sequential code [ex15].
//   greetingFor(7) → "Hello, user7!"
suspend fun greetingFor(userId: Int): String = TODO()

// Port of LegacyFutures.scoreLine — thenCombine becomes two `async` blocks and two
// .await()s inside coroutineScope { }. The fetches run CONCURRENTLY: the test reads
// the virtual clock and expects 100ms, not 200 [ex15].
//   scoreLine(7) → "user7: 42"
suspend fun scoreLine(userId: Int): String = TODO()
