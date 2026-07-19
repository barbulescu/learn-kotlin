/*
 * Exercise 15 — Coroutines Intro
 * ================================
 *
 * KEY CONCEPTS:
 *   `suspend` marks a function that can pause without blocking a thread.
 *   `runBlocking { }` bridges regular code and coroutines (use in tests/main, not production).
 *   `async { }` starts a coroutine and returns a `Deferred<T>` — call `.await()` to get the result.
 *   Multiple `async` blocks run concurrently; `await()` suspends until each one completes.
 *   `delay(ms)` is a non-blocking sleep — the thread is free to do other work while waiting.
 *
 * JAVA ANALOGY:
 *   suspend fun                  →  CompletableFuture / Virtual Thread (Java 21)
 *   async { } + await()         →  CompletableFuture.supplyAsync(...).thenCombine(...)
 *   delay(100)                  →  Thread.sleep(100)  (but non-blocking — no thread is held)
 *   runBlocking { }             →  CompletableFuture.get()  (blocks the calling thread)
 *
 *   Coroutines are cheaper than threads: you can launch millions without exhausting the JVM.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/coroutines-overview.html
 *   https://kotlinlang.org/docs/coroutines-basics.html
 *   https://kotlinlang.org/docs/async-programming.html
 */
package ex15

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

// Suspend function: wait 50ms, then return "Hello, <name>!".
suspend fun fetchGreeting(name: String): String {
    delay(50.milliseconds)
    return "Hello, $name!"
}

// Launch two fetchGreeting calls concurrently using `async`/`await` inside `coroutineScope`.
// Return both results as a Pair — they should run in parallel, not sequentially.
suspend fun fetchBoth(first: String, second: String): Pair<String, String> = coroutineScope {
    val a = async { fetchGreeting(first) }
    val b = async { fetchGreeting(second) }
    a.await() to b.await()
}
