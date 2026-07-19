/*
 * Exercise 03 — Null Safety
 * ==========================
 *
 * KEY CONCEPTS:
 *   `String` can never be null. `String?` can be null. The compiler enforces this.
 *   `?.` safe-call: evaluates the right side only if the receiver is non-null.
 *   `?:` Elvis operator: returns the right side if the left side is null.
 *   Safe-calls can be chained: `a?.b?.c` — the whole chain short-circuits to null at the first null.
 *   No more NullPointerException surprises — nullability is part of the type system.
 *
 * JAVA ANALOGY:
 *   @Nullable String s  →  val s: String?
 *   Optional.ofNullable(s).map(String::length).orElse(0)  →  s?.length ?: 0
 *   s != null ? s : "default"                             →  s ?: "default"
 *   Objects.requireNonNull(s)  →  not needed; just declare `s: String` (non-null)
 *
 *   // Chained null checks (the NPE minefield in Java):
 *   String city = null;
 *   if (user != null && user.getAddress() != null) city = user.getAddress().getCity();
 *   // Kotlin: one expression, compiler-checked at every step:
 *   val city: String? = user?.address?.city
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/null-safety.html
 *   https://kotlinlang.org/docs/java-to-kotlin-nullability-guide.html
 *   https://kotlinlang.org/docs/idioms.html#if-not-null-shorthand
 */
package ex03

// Return the length of s, or 0 if s is null.
fun safeLength(s: String?): Int = TODO()

// Return "Hello, <name>!" or "Hello, stranger!" if name is null.
fun greetNullable(name: String?): String = TODO()

// Return the first element of the list, or null if the list is empty.
fun firstOrNull(list: List<Int>): Int? = TODO()

data class Address(val city: String?)
data class User(val name: String, val address: Address?)

// Return the city of the user's address uppercased, or "UNKNOWN" if the user has no address
// or the address has no city. Use a single safe-call chain with `?.` and `?:`.
//   cityOf(User("Alice", Address("Berlin")))  → "BERLIN"
//   cityOf(User("Bob", Address(null)))        → "UNKNOWN"
//   cityOf(User("Eve", null))                 → "UNKNOWN"
fun cityOf(user: User): String = TODO()
