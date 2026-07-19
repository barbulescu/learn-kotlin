/*
 * Exercise 17 — Unused Return Values & the Immutability Convention
 * =================================================================
 *
 * A DIFFERENT KIND OF EXERCISE: nothing here is TODO(). The four functions below are
 * complete, they compile, and they look plausible — and every one is wrong in the
 * same way: it calls a function that RETURNS a new value and silently drops the
 * result. The tests fail until you use the values.
 *
 * You have a built-in hint system. build.gradle.kts enables the (experimental)
 * unused return value checker:
 *
 *     -Xreturn-value-checker=check
 *
 * so when this file compiles (`./gradlew test --tests "ex17.*"`), the compiler
 * prints a warning pointing at EXACTLY each broken line. Read the warnings, then
 * make the code use the values it computes.
 *
 * KEY CONCEPTS:
 *   Kotlin's everyday types are immutable: String, List, Map never change in place.
 *   trim(), replace(), sorted(), plus() all return a NEW value — the receiver keeps
 *   its old one, so calling them as bare statements does nothing at all.
 *
 *   Kotlin's naming convention tells you which is which — Java never had one:
 *     past participle — sorted(), reversed(), shuffled() — returns a new collection;
 *     imperative      — sort(),   reverse(),  shuffle()  — mutates in place, and
 *     therefore exists only on MutableList.
 *
 *   The checker (experimental since Kotlin 2.2.20, KEEP-0412): calls to functions
 *   marked @MustUseReturnValues — the whole stdlib already is — warn when the result
 *   is dropped. Deliberate drops opt out with @IgnorableReturnValue on the function,
 *   or `val _ = f()` at the call site.
 *
 * JAVA ANALOGY:
 *   This bug class is a Java classic precisely because Java has no convention:
 *     Collections.sort(list)   mutates in place (void)
 *     list.stream().sorted()   returns a new stream
 *     s.replace("a", "b")      returns a new String — famously dropped
 *     bigDecimal.add(x)        returns a new BigDecimal — ex16's worst DANGER
 *   Java's fix is a third-party build plugin; Kotlin builds it into the compiler:
 *     ErrorProne @CheckReturnValue      →  @MustUseReturnValues + -Xreturn-value-checker
 *     ErrorProne @CanIgnoreReturnValue  →  @IgnorableReturnValue
 *   (Interop is two-way: the Kotlin checker honors @CheckReturnValue on Java code.)
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/unused-return-value-checker.html
 *   https://github.com/Kotlin/KEEP/blob/main/proposals/KEEP-0412-unused-return-value-checker.md
 *   https://kotlinlang.org/docs/collection-ordering.html
 */
package ex17

import java.math.BigDecimal

// Normalize user input: surrounding whitespace trimmed, everything lowercased.
//   normalize("  Hello World  ") → "hello world"
fun normalize(raw: String): String {
    return raw.trim().lowercase()
}

// The three highest scores, best first.
//   topThree(listOf(7, 2, 9, 8, 5)) → [9, 8, 7]
fun topThree(scores: List<Int>): List<Int> {
    return scores.sortedDescending().take(3)
}

// The playlist with one track appended at the end. The original must not change —
// and cannot: List<String> has no add().
//   withTrack(listOf("Intro", "Verse"), "Outro") → [Intro, Verse, Outro]
fun withTrack(playlist: List<String>, track: String): List<String> {
    return playlist + track
}

// The sum of the line totals — ex16's grandTotal accumulator, and its worst DANGER
// (`total.add(...)` with the result dropped) reborn in Kotlin. This time the
// compiler has something to say about it.
//   grandTotal(listOf(BigDecimal("10.00"), BigDecimal("2.50"))) → 12.50
fun grandTotal(lineTotals: List<BigDecimal>): BigDecimal {
    var total = BigDecimal.ZERO
    for (line in lineTotals) {
        total += line
    }
    return total
}
