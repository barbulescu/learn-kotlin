/*
 * Exercise 22 — Value Classes: Types for Free
 * ============================================
 *
 * REFACTOR EXERCISE: the legacy program is ex22/legacy/LegacyBilling.java —
 * primitive obsession: every ID is a String, and LegacyJavaTest documents (in
 * green) the invoice that billed customer "P-7" for 3 units of "C-42". Port it
 * below and make ValueClassesTest pass.
 *
 * KEY CONCEPTS:
 *   `@JvmInline value class CustomerId(val raw: String)` is a compile-time-only
 *   wrapper: in the bytecode it IS the underlying String (no allocation, no
 *   indirection), but in the type system it is its own type. Passing a ProductId
 *   where a CustomerId is expected no longer compiles. equals/hashCode/toString
 *   come free, value-style, like a data class.
 *   The main lesson carries its own caveat: the win is at COMPILE time, so the
 *   tests here are thinner than usual — they check behavior, but the swapped-
 *   argument call they CANNOT CONTAIN is the actual point.
 *   Pair it with ex19: parse, don't validate — a factory returning CustomerId?
 *   means invalid input never becomes an ID at all.
 *
 * JAVA ANALOGY:
 *   String customerId, String productId      →  CustomerId, ProductId — distinct types
 *   wrapper class + equals/hashCode
 *     (~30 lines, one heap object per ID)    →  @JvmInline value class (1 line, 0 objects)
 *   boolean looksLikeCustomerId(String)      →  fun customerIdOrNull(String): CustomerId?
 *   Project Valhalla (coming since 2014)     →  shipped in Kotlin 1.5 (2021)
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/inline-classes.html
 */
package ex22

// These two lines are most of the exercise — read them slowly. Everything the legacy
// file enforces by comment, they enforce by type.
@JvmInline value class CustomerId(val raw: String)
@JvmInline value class ProductId(val raw: String)

// Port of invoiceLine — same output, but the argument-swap bug from LegacyJavaTest
// is now UNWRITABLE: invoiceLine(product, customer, 3) does not compile. The types
// carry the proof; the body is ordinary string work (`.raw` unwraps) [ex02].
//   invoiceLine(CustomerId("C-42"), ProductId("P-7"), 3) → "Invoice C-42: 3 x P-7"
fun invoiceLine(customer: CustomerId, product: ProductId, quantity: Int): String = TODO()

// Port of looksLikeCustomerId — but "looks like" becomes "is or isn't": parse, don't
// validate. Valid input becomes a real CustomerId; invalid input never becomes one.
// The name follows ex19's convention — OrNull says how absence is signalled.
//   "C-42" → CustomerId("C-42");  "42", "P-7" → null
fun customerIdOrNull(raw: String): CustomerId? = TODO()

//   "P-7" → ProductId("P-7");  otherwise null
fun productIdOrNull(raw: String): ProductId? = TODO()
