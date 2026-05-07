/*
 * Exercise 03 — Default Parameters and Named Arguments
 * ======================================================
 * PATH: Java developers
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
 * DOCS & READING:
 *   https://kotlinlang.org/docs/functions.html#default-arguments
 *   https://kotlinlang.org/docs/functions.html#named-arguments
 *   https://kotlinlang.org/docs/functions.html#single-expression-functions
 */
package javapath.ex03

// Build an HTML opening/closing tag pair. Examples:
//   createTag("Hi")                         → "<div>Hi</div>"
//   createTag("Hi", tag = "h1")             → "<h1>Hi</h1>"
//   createTag("Hi", tag = "p", cls = "x")   → "<p class=\"x\">Hi</p>"
fun createTag(content: String, tag: String = "div", cls: String = ""): String = TODO()

// Repeat a string `times` times, joined by `separator`. Examples:
//   repeatStr("ha", 3)         → "hahaha"
//   repeatStr("ha", 3, "-")    → "ha-ha-ha"
fun repeatStr(s: String, times: Int, separator: String = ""): String = TODO()
