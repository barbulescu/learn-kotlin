/*
 * Exercise 18 — Exceptions Without the Checking: `use`, `runCatching`
 * ====================================================================
 *
 * REFACTOR EXERCISE: the legacy program is ex18/legacy/LegacyConfig.java — read it
 * first, DANGER/CLUTTER comments and all. LegacyJavaTest passes from the start; its
 * green tests are the bug reports [the ex16 trick]. Port each method below and make
 * ExceptionsTest pass.
 *
 * KEY CONCEPTS:
 *   Kotlin has exceptions but NO checked exceptions: nothing is declared (`@Throws`
 *   exists only for Java callers), nothing is forced on callers, and — the payoff —
 *   lambdas can throw. The pipeline Java couldn't write (`map` over a throwing
 *   parser) is a one-liner, and errors PROPAGATE loudly instead of being swallowed
 *   at the exact point where the type system got in the way.
 *   `use { }` is try-with-resources as a stdlib function: closes on every exit path
 *   (normal or exception) and returns the lambda's value.
 *   `runCatching { }` turns a throwing call into a Result value — try/catch as an
 *   expression: .getOrDefault(x), .getOrNull(), .getOrElse { }.
 *
 * JAVA ANALOGY:
 *   throws ParseException on every signature      →  (nothing — not a concept here)
 *   try { f(x) } catch (E e) { return fallback; } →  runCatching { f(x) }.getOrDefault(fallback)
 *   try (var r = new BufferedReader(s)) { ... }   →  s.buffered().use { ... }
 *   .map(x -> { try {...} catch {...} })          →  .map { parsePort(it) } — lambdas may throw
 *
 *   The trade is honest: Java's checked exceptions FORCE acknowledgement but invite
 *   the silent-swallow anti-pattern the moment lambdas are involved; Kotlin trusts
 *   you and keeps errors loud by default. And when "absent" is an expected, everyday
 *   outcome, don't throw at all — return null and say so in the name: that story is
 *   ex19, next door.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/exceptions.html
 *   https://kotlinlang.org/docs/java-interop.html#checked-exceptions
 *   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/use.html
 *   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/run-catching.html
 */
package ex18

import java.io.Reader

// Port of LegacyConfig.parsePort. `toInt()` already throws NumberFormatException on
// bad input, and in Kotlin that's the whole story: nothing declared, nothing forced
// on callers. " 443 " → 443 (trim first); "oops" → NumberFormatException.
fun parsePort(raw: String): Int = TODO()

// Port of parsePorts — the pipeline the Java version COULDN'T write. Kotlin lambdas
// may throw, so this is a one-line map — and a bad line now FAILS LOUDLY instead of
// silently vanishing (run LegacyJavaTest for the bug report).
fun parsePorts(lines: List<String>): List<Int> = TODO()

// Port of portOrDefault — the five-line catch block becomes an expression:
//   runCatching { ... }.getOrDefault(fallback)
fun portOrDefault(raw: String, fallback: Int): Int = TODO()

// Port of readPorts — `use` is try-with-resources as a stdlib function: closes on
// the way out, exception or not, and returns the lambda's value.
// Hint: source.buffered().use { it.readLines() }, then parsePorts.
fun readPorts(source: Reader): List<Int> = TODO()
