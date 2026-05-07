/*
 * Exercise 04 — Null Safety
 * ==========================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   `String` can never be null. `String?` can be null. The compiler enforces this.
 *   `?.` safe-call: like `x.something if x is not None else None` in one operator.
 *   `?:` Elvis operator: like Python's `x or default`, but only for None (not all falsy values).
 *   Forgetting to handle null is a compile error, not a runtime AttributeError.
 *
 * PYTHON ANALOGY:
 *   len(s) if s is not None else 0         →  s?.length ?: 0
 *   name if name is not None else "stranger"  →  name ?: "stranger"
 *   s.upper() if s else None               →  s?.uppercase()
 *   Optional[str] type hint (not enforced) →  String? (compiler enforced)
 *
 *   Key difference: Python's `x or default` triggers on ANY falsy value ("", 0, []).
 *   Kotlin's `x ?: default` triggers ONLY on null.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/null-safety.html
 *   https://kotlinlang.org/docs/idioms.html#if-not-null-shorthand
 */
package pythonpath.ex04

// Return the length of s, or 0 if s is null.
fun safeLength(s: String?): Int = TODO()

// Return "Hello, <name>!" or "Hello, stranger!" if name is null.
fun greetNullable(name: String?): String = TODO()

// Return the first element of the list, or null if the list is empty.
fun firstOrNull(list: List<Int>): Int? = TODO()
