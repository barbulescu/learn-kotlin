/*
 * Exercise 03 — Default Parameters and Named Arguments
 * ======================================================
 * PATH: Python developers
 *
 * KEY CONCEPTS:
 *   Default parameters work exactly like Python's default arguments.
 *   Named arguments work exactly like Python's keyword arguments.
 *   Single-expression functions use `=` — similar to a named lambda.
 *
 * PYTHON ANALOGY:
 *   def create_tag(content, tag="div", cls=""):   →  fun createTag(content: String, tag: String = "div", cls: String = ""): String
 *       ...
 *
 *   create_tag("Hi", cls="btn")   →   createTag("Hi", cls = "btn")
 *
 *   Differences from Python:
 *   - Parameter types are required: `tag: String`, not just `tag`.
 *   - Kotlin uses camelCase (`createTag`), Python uses snake_case (`create_tag`).
 *   - `= TODO()` is a stub that throws at runtime — fill it in to make tests pass.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/functions.html#default-arguments
 *   https://kotlinlang.org/docs/functions.html#named-arguments
 *   https://kotlinlang.org/docs/functions.html#single-expression-functions
 */
package pythonpath.ex03

// Build an HTML opening/closing tag pair. Examples:
//   createTag("Hi")                         → "<div>Hi</div>"
//   createTag("Hi", tag = "h1")             → "<h1>Hi</h1>"
//   createTag("Hi", tag = "p", cls = "x")   → "<p class=\"x\">Hi</p>"
fun createTag(content: String, tag: String = "div", cls: String = ""): String = TODO()

// Repeat a string `times` times, joined by `separator`. Examples:
//   repeatStr("ha", 3)         → "hahaha"
//   repeatStr("ha", 3, "-")    → "ha-ha-ha"
fun repeatStr(s: String, times: Int, separator: String = ""): String = TODO()
