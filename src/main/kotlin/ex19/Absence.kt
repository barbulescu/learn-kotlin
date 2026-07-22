/*
 * Exercise 19 — Signaling Absence: the OrNull Convention
 * =======================================================
 *
 * REFACTOR EXERCISE: the legacy program is ex19/legacy/LegacyDirectory.java — a
 * directory that says "not there" four different ways: throw, Optional, null, and a
 * -1 sentinel. LegacyJavaTest passes from the start (green tests = bug reports).
 * Port it below and make AbsenceTest pass.
 *
 * KEY CONCEPTS:
 *   Kotlin's convention is one sentence long: THE PLAIN NAME THROWS, THE OrNull NAME
 *   RETURNS NULL — first/firstOrNull, single/singleOrNull, toInt/toIntOrNull,
 *   elementAt/elementAtOrNull, max/maxOrNull... You never memorize per API; you read
 *   the name. (Compare ex17's sorted/sort rule: same idea, applied to mutation.)
 *   The OrNull half is only ergonomic because ex03 exists: `?.` chains through the
 *   null, `?:` supplies the default, and `T?` in a signature makes the compiler force
 *   every caller to look.
 *   Optional<T> has no seat at this table: a nullable type does everything Optional
 *   does with no wrapper object, no .map/.orElse dialect, and compiler enforcement
 *   instead of good intentions.
 *
 * JAVA ANALOGY:
 *   list.get(i) throws / map.get(k) nulls /
 *     queue.remove() throws / queue.poll() nulls →  the NAME tells you: x() / xOrNull()
 *   Optional<Member> + .orElse(null)             →  Member?  (?: for defaults, ?.let to map)
 *   try { parseInt(s) } catch { return null; }   →  s.toIntOrNull()
 *   indexOf(...) with an unchecked -1            →  return null — absence you cannot miss
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/null-safety.html
 *   https://kotlinlang.org/docs/java-to-kotlin-nullability-guide.html
 *   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/first-or-null.html
 *   https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/to-int-or-null.html
 */
package ex19

// The Kotlin data model: `String?` IS the absence type — no Optional field, no
// load-bearing comment [ex03, ex04].
data class Member(val name: String, val email: String?)

// Port of dialect 1 — and half of the naming pair: the PLAIN name throws
// (NoSuchElementException on an unknown name). Hint: members.first { }
fun findMember(members: List<Member>, name: String): Member = TODO()

// Port of dialect 2 — the other half: the OrNull name returns null, and the return
// type Member? advertises it to the compiler, not just the reader [ex03].
// Hint: firstOrNull { }
fun findMemberOrNull(members: List<Member>, name: String): Member? = TODO()

// Port of dialect 3 — the try/catch that said "no" with an exception becomes the
// stdlib's own OrNull variant. Hint: raw.trim().toIntOrNull()
fun ageOrNull(raw: String): Int? = TODO()

// Port of dialect 4 — the -1 sentinel becomes a null, and the garbage output becomes
// unrepresentable: "a@b.com" → "b.com"; "no-at-sign" → null (the legacy version
// returns "no-at-sign" — run LegacyJavaTest).
// Hint: `if ('@' in email) email.substringAfter('@') else null`
fun domainOrNull(email: String): String? = TODO()

// Port of emailOrPlaceholder — the null-check pyramid becomes one expression:
// two ?. hops and one ?: [ex03, ex13].
// Member missing → "n/a"; member present but email null → "n/a".
fun emailOrPlaceholder(members: List<Member>, name: String): String = TODO()
