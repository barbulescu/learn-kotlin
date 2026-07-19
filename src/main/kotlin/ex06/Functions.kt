/*
 * Exercise 06 — Default Parameters and Named Arguments
 * ======================================================
 *
 * KEY CONCEPTS:
 *   Parameters can have default values — eliminates the need for overloaded methods.
 *   Callers can name arguments to skip or reorder them.
 *   Single-expression functions use `=` instead of `{ return ... }`.
 *
 * JAVA ANALOGY:
 *   // Java needs three overloads:
 *   String tag(String c)                         { return tag(c, "div", ""); }
 *   String tag(String c, String t)               { return tag(c, t, ""); }
 *   String tag(String c, String t, String cls)   { ... }
 *
 *   // Kotlin: one function covers all cases:
 *   fun tag(c: String, t: String = "div", cls: String = "") = ...
 *   tag("Hi", cls = "btn")   // skip `t`, provide `cls` by name — Java can't do this
 *
 *   // Java Builder (common for config objects — Lombok @Builder or manual):
 *   new EmailRequest.Builder()
 *       .to("alice@example.com")
 *       .subject("Hi")
 *       .priority(1)
 *       .html(true)
 *       .build()
 *
 *   // Kotlin named + default params replace the builder entirely:
 *   sendEmail("alice@example.com", "Hi", priority = 1, html = true)
 *   // `cc` is omitted — the default ("") applies automatically.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/functions.html#default-arguments
 *   https://kotlinlang.org/docs/functions.html#named-arguments
 *   https://kotlinlang.org/docs/functions.html#single-expression-functions
 */
package ex06

// Format an email summary string. `cc` defaults to empty, `priority` to 3, `html` to false.
// sendEmail("alice@example.com", "Hi")
//   → "To: alice@example.com | Sub: Hi | CC:  | Pri: 3 | HTML: false"
// sendEmail("b@x.com", "Hey", cc = "c@x.com", priority = 1, html = true)
//   → "To: b@x.com | Sub: Hey | CC: c@x.com | Pri: 1 | HTML: true"
fun sendEmail(to: String, subject: String, cc: String = "", priority: Int = 3, html: Boolean = false): String = TODO()

// Repeat a string `times` times, joined by `separator`. Examples:
//   repeatStr("ha", 3)         → "hahaha"
//   repeatStr("ha", 3, "-")    → "ha-ha-ha"
fun repeatStr(s: String, times: Int, separator: String = ""): String = TODO()

// Now be the caller: implement this with a SINGLE call to sendEmail, using a named
// argument to set priority = 1 and letting every other optional parameter use its default.
// Don't build the string yourself.
// urgentEmail("a@x.com", "Server down") → "To: a@x.com | Sub: Server down | CC:  | Pri: 1 | HTML: false"
fun urgentEmail(to: String, subject: String): String = TODO()
