/*
 * Exercise 15 — Coroutines Intro
 * ================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `suspend` marks a function that can pause without blocking a thread — like Python's `async def`.
 *   `runBlocking { }` bridges regular code and coroutines — like `asyncio.run()`.
 *   `async { }` starts a coroutine and returns a `Deferred<T>` — like `asyncio.create_task()`.
 *   `.await()` suspends until the result is ready — like Python's `await`.
 *   `delay(ms)` is a non-blocking sleep — like `asyncio.sleep(seconds)`.
 *
 * PYTHON ANALOGY:
 *   async def fetch(name):          →  suspend fun fetch(name: String): String
 *       await asyncio.sleep(0.05)   →      delay(50)
 *       return f"Hello, {name}!"    →      return "Hello, $name!"
 *
 *   asyncio.run(fetch("Alice"))     →  runBlocking { fetch("Alice") }
 *
 *   task = asyncio.create_task(f()) →  val d = async { f() }
 *   result = await task             →  val result = d.await()
 *
 *   Key difference: Kotlin coroutines are not tied to a single event loop like asyncio.
 *   They use a dispatcher (thread pool) and can run across multiple threads.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/coroutines-overview.html
 *   https://kotlinlang.org/docs/coroutines-basics.html
 *   https://kotlinlang.org/docs/async-programming.html
 */
package pythonpath.ex15

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

// Suspend function: wait 50ms, then return "Hello, <name>!".
suspend fun fetchGreeting(name: String): String = TODO()

// Launch two fetchGreeting calls concurrently using `async`/`await` inside `coroutineScope`.
// Return both results as a Pair — they should run in parallel, not sequentially.
suspend fun fetchBoth(first: String, second: String): Pair<String, String> = TODO()
