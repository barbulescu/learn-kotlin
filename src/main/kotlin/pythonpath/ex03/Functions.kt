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
 *   # Python config objects often use @dataclass or **kwargs factories:
 *   @dataclass
 *   class EmailRequest:
 *       to: str; subject: str; cc: str = ""; priority: int = 3; html: bool = False
 *   send(EmailRequest(to="alice@example.com", subject="Hi", priority=1))
 *
 *   # Kotlin: no wrapper class needed — the function itself carries the defaults:
 *   sendEmail("alice@example.com", "Hi", priority = 1)
 *
 *   Differences from Python:
 *   - Parameter types are required: `to: String`, not just `to`.
 *   - Kotlin uses camelCase (`sendEmail`), Python uses snake_case (`send_email`).
 *   - `= TODO()` is a stub that throws at runtime — fill it in to make tests pass.
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/functions.html#default-arguments
 *   https://kotlinlang.org/docs/functions.html#named-arguments
 *   https://kotlinlang.org/docs/functions.html#single-expression-functions
 */
package pythonpath.ex03

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
