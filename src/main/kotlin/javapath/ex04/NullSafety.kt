/*
 * Exercise 04 — Null Safety
 * ==========================
 * PATH: Java developers
 *
 * KEY CONCEPTS:
 *   `String` can never be null. `String?` can be null. The compiler enforces this.
 *   `?.` safe-call: evaluates the right side only if the receiver is non-null.
 *   `?:` Elvis operator: returns the right side if the left side is null.
 *   No more NullPointerException surprises — nullability is part of the type system.
 *
 * JAVA ANALOGY:
 *   @Nullable String s  →  val s: String?
 *   Optional.ofNullable(s).map(String::length).orElse(0)  →  s?.length ?: 0
 *   s != null ? s : "default"                             →  s ?: "default"
 *   Objects.requireNonNull(s)  →  not needed; just declare `s: String` (non-null)
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/null-safety.html
 *   https://kotlinlang.org/docs/java-to-kotlin-nullability-guide.html
 *   https://kotlinlang.org/docs/idioms.html#if-not-null-shorthand
 */
package javapath.ex04

// Return the length of s, or 0 if s is null.
fun safeLength(s: String?): Int = TODO()

// Return "Hello, <name>!" or "Hello, stranger!" if name is null.
fun greetNullable(name: String?): String = TODO()

// Return the first element of the list, or null if the list is empty.
fun firstOrNull(list: List<Int>): Int? = TODO()
