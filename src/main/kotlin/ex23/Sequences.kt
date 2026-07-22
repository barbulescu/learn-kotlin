/*
 * Exercise 23 — Sequences: Laziness on Demand
 * ============================================
 *
 * REFACTOR EXERCISE: the legacy program is ex23/legacy/LegacyPipeline.java — the
 * eager way to find one word: full passes, intermediate lists, all paid for even
 * when the answer is item three. LegacyJavaTest counts the waste, in green.
 * Port it below — and note that SequencesTest counts YOUR visits too: laziness is
 * enforced by the tests, not suggested by the comments.
 *
 * KEY CONCEPTS:
 *   Kotlin's collection operators [ex09] are EAGER: each step builds a real list.
 *   For small data consumed whole, that is the right default — simple, debuggable.
 *   `.asSequence()` switches the SAME pipeline to lazy: elements flow through the
 *   whole chain one at a time, nothing runs until a terminal operator asks, and
 *   first/firstOrNull stops the line at the first hit.
 *   Sequences can be INFINITE: `generateSequence(seed) { next }` + `first { }` is
 *   the "search an unbounded space" idiom.
 *   Rule of thumb: large input, long chain, or early exit → sequence.
 *   Small list, consumed whole → plain list operators.
 *
 * JAVA ANALOGY:
 *   list.stream().map(...).filter(...)
 *       .findFirst().orElse(null)          →  list.asSequence().map { }.firstOrNull { }
 *   Stream.iterate(1, x -> x * 2)          →  generateSequence(1) { it * 2 }
 *   .collect(Collectors.toList())          →  .toList() — only when you leave the sequence
 *   (Java made Stream the ONLY fluent collections API, so every caller pays the
 *   .stream()/.collect() toll even for three elements; Kotlin defaults to eager
 *   and lets you opt into laziness per pipeline.)
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/sequences.html
 */
package ex23

// Port of LegacyPipeline.firstLongUpper — as a SEQUENCE: uppercase, keep words
// longer than 5 chars, return the FIRST or null; visit each element AT MOST ONCE,
// and NOTHING after the first hit. The test counts: for [ok, hi, gigantic, nope,
// never] it expects exactly three visits — the legacy version pays five.
// Hint: words.asSequence().onEach(onVisit).map { it.uppercase() }.firstOrNull { ... }
fun firstLongUpper(words: List<String>, onVisit: (String) -> Unit): String? = TODO()

// Sequences can be infinite, because nothing runs until asked:
// generateSequence(1) { it * 2 } is EVERY power of two. Return the first one
// strictly greater than `floor`.
//   firstPowerOfTwoAbove(100) → 128;  firstPowerOfTwoAbove(128) → 256
fun firstPowerOfTwoAbove(floor: Int): Int = TODO()

// The counterpoint, so the lesson doesn't overcorrect: a small list consumed WHOLE
// wants plain eager operators — no sequence, no ceremony [ex09].
fun totalLength(words: List<String>): Int = TODO()
