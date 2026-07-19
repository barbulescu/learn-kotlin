# learn-kotlin

Kotlin exercises for developers coming from Java. Each exercise is a file of `TODO()` stubs; your job is to make the pre-written tests pass.

## Setup

No prerequisites beyond a JDK on your PATH to bootstrap Gradle — the wrapper is included, and the [Foojay toolchain resolver](https://github.com/gradle/foojay-toolchains) auto-downloads JDK 21 if you don't have it:

```bash
./gradlew test
```

## Running Tests

```bash
./gradlew test                      # all exercises
./gradlew test --tests "ex03.*"     # one exercise
```

A fresh clone starts **red**: every stub is `TODO()`, so its tests fail with `NotImplementedError` until you implement the function. Work one exercise at a time and re-run its tests until they pass.

Two stub shapes: `fun f() = TODO()` wants a single expression (`fun f() = "result"`), while `fun f() { TODO() }` gives you a block body for statements like loops (replace `TODO()` with your code and `return` the result). You can convert between them freely — the block form is pre-set where a loop is the intended solution.

## Suggested Route (2-hour dojo)

Exercises are ordered by how strongly they make the case for Kotlin, so just work through them in sequence. Budget **~10 minutes per exercise** including reading the header. The tiers below set expectations:

- **Core (ex01–ex06)** — the "convince me" exercises. Null safety (ex03) and data classes (ex04) are the strongest arguments for Kotlin; everyone should reach them. Core fills the first hour.
- **Stretch (ex07–ex10)** — idioms that make everyday code shorter. Do as many as time allows in the second hour.
- **Advanced (ex11–ex15)** — take these home; they're the reward for finishing, not part of the 2-hour session.

---

## Core — the "convince me" exercises (ex01–ex06)

### ex01 · `val`, `var`, and Type Inference

Kotlin replaces Java's `final` with `val` (read-only) and keeps `var` for mutation. The compiler infers the type from the right-hand side so you rarely write it explicitly — `val x = 42` is an `Int`. Under the hood, `Int` and `String` map to JVM primitives and `java.lang.String`, so interop is seamless. In this exercise you implement `sumUpTo` (loop with a `var` accumulator) and `initials` (string slicing) to get comfortable with both declaration keywords and Kotlin's basic types.

- [Variables](https://kotlinlang.org/docs/basic-syntax.html#variables)
- [Basic types](https://kotlinlang.org/docs/basic-types.html)
- [Kotlin Playground](https://play.kotlinlang.org) — try snippets in the browser

---

### ex02 · String Templates

Instead of concatenation or `String.format()`, Kotlin lets you embed values directly inside a string literal: `"Hello, $name!"` or `"Sum: ${a + b}"` for expressions. Triple-quoted strings (`"""..."""`) serve the same purpose as Java 15+ text blocks. This exercise has three small functions — `formatGreeting`, `formatFullName`, and `showArithmetic` — each requiring a different template form. Pay attention to `name.length` (a property, no parentheses) vs. Java's `name.length()`.

- [String templates](https://kotlinlang.org/docs/strings.html#string-templates)
- [Strings overview](https://kotlinlang.org/docs/strings.html)

---

### ex03 · Null Safety

Nullable types are part of Kotlin's type system: `String` can never be `null`, but `String?` can. The compiler refuses to compile code that dereferences a nullable without a check, eliminating the NullPointerException surprises that plague Java code. The safe-call operator `?.` short-circuits the chain to `null` at the first missing value; the Elvis operator `?:` supplies a fallback. You will chain these together in `cityOf` — a single expression that navigates `User → Address → city` and uppercases the result, all without a single `if`.

- [Null safety](https://kotlinlang.org/docs/null-safety.html)
- [Java-to-Kotlin nullability guide](https://kotlinlang.org/docs/java-to-kotlin-nullability-guide.html)
- [Idioms: if-not-null shorthand](https://kotlinlang.org/docs/idioms.html#if-not-null-shorthand)

---

### ex04 · Data Classes

`data class` gives you `equals()`, `hashCode()`, `toString()`, and `copy()` for free, based on the properties declared in the constructor. It is the Kotlin equivalent of Java 16+ records, but with one killer feature Java lacks: `copy()`, which creates an immutable clone with specific fields changed — `person.copy(age = 31)`. Destructuring (`val (name, age) = person`) unpacks properties in declaration order. The exercise covers all three patterns: comparison, `copy`, and string formatting.

- [Data classes](https://kotlinlang.org/docs/data-classes.html)
- [Destructuring declarations](https://kotlinlang.org/docs/destructuring-declarations.html)

---

### ex05 · `when` as an Expression

`when` is Kotlin's supercharged replacement for `switch`. Unlike Java's `switch`, it has no fall-through, needs no `break`, and — crucially — returns a value, making it usable anywhere an expression is expected. Branches can match exact values, multiple values (`6, 7 ->`), ranges (`1..9 ->`), or arbitrary conditions (`when { n < 0 -> ... }`). The classic FizzBuzz exercise here is an ideal `when` workout: multiple overlapping conditions, each mapping cleanly to a branch.

- [when expression](https://kotlinlang.org/docs/control-flow.html#when-expression)
- [Kotlin tour: control flow](https://kotlinlang.org/docs/kotlin-tour-control-flow.html)

---

### ex06 · Default Parameters and Named Arguments

Kotlin functions can declare default values for any parameter, eliminating the clusters of overloaded methods that Java requires for optional arguments. Callers can also pass arguments by name — `sendEmail("alice@example.com", "Hi", priority = 1)` — allowing them to skip parameters in the middle or reorder for clarity. This is the idiomatic replacement for the Builder pattern. The exercise also introduces single-expression functions (`fun f() = ...`), the preferred style for one-liners.

- [Default arguments](https://kotlinlang.org/docs/functions.html#default-arguments)
- [Named arguments](https://kotlinlang.org/docs/functions.html#named-arguments)
- [Single-expression functions](https://kotlinlang.org/docs/functions.html#single-expression-functions)

---

## Stretch — everyday idioms (ex07–ex10)

### ex07 · Extension Functions

Extension functions let you add new methods to an existing type — even one from the standard library or a third-party jar — without subclassing or wrapping it. Inside the function, `this` refers to the receiver (the value before the dot). This makes `"racecar".isPalindrome()` possible even though `String` never declared that method. Extension functions are resolved statically, so they are a drop-in replacement for Java utility classes (`StringUtils`, `CollectionUtils`, etc.) with a much nicer call site.

- [Extensions](https://kotlinlang.org/docs/extensions.html)
- [Idioms: extension functions](https://kotlinlang.org/docs/idioms.html#extension-functions)

---

### ex08 · Lambdas and Higher-Order Functions

A lambda in Kotlin is written as `{ x -> x * 2 }`, or `{ it * 2 }` when there is exactly one parameter (`it` is the implicit name). Higher-order functions accept or return other functions — their parameter type is written like `(Int) -> Int`. When the last argument to a function is a lambda, it can be moved outside the parentheses (trailing lambda syntax), which is why `applyTwice(3) { it + 1 }` reads naturally. There is no `@FunctionalInterface` boilerplate; any function type works directly.

- [Lambdas](https://kotlinlang.org/docs/lambdas.html)
- [Higher-order functions](https://kotlinlang.org/docs/lambdas.html#higher-order-functions)
- [Implicit `it` parameter](https://kotlinlang.org/docs/lambdas.html#it-implicit-name-of-a-single-parameter)

---

### ex09 · Collections: `map`, `filter`, `fold`, `maxByOrNull`

Kotlin's collection API is built from extension functions, so `map`, `filter`, and `fold` call directly on a `List` — no `.stream()`, no `.collect()`. `map { }` transforms each element; `filter { }` keeps elements matching a predicate; `fold(initial) { acc, el -> }` accumulates a value from left to right (equivalent to Java's `reduce` with a seed); `maxByOrNull { }` returns the largest element by a key, or `null` for an empty list. Getting fluent with these four operations covers the vast majority of everyday collection processing.

- [Collection transformations](https://kotlinlang.org/docs/collection-transformations.html)
- [Collection filtering](https://kotlinlang.org/docs/collection-filtering.html)
- [Aggregate operations](https://kotlinlang.org/docs/collection-aggregate.html)
- [stdlib collections API](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/)

---

### ex10 · Ranges and `for` Loops

Kotlin replaces the verbose `for (int i = 0; i < n; i++)` with concise range expressions: `1..10` (inclusive), `0 until 10` (exclusive), `10 downTo 1` (reversed), and `1..10 step 3` (custom stride). Ranges also work with `in` for membership checks: `n in 1..10`. The same range objects are reusable in `for` loops, `when` branches, and collection operations. The three functions here — `sumRange`, `countdown`, and `everyNth` — exercise all four range forms.

- [Ranges](https://kotlinlang.org/docs/ranges.html)
- [for loops](https://kotlinlang.org/docs/control-flow.html#for-loops)

---

## Advanced — after the session (ex11–ex15)

### ex11 · Sealed Classes and Exhaustive `when`

A `sealed class` limits which subclasses can exist — all must be declared in the same file. The payoff comes when you use `when` on a sealed type: the compiler verifies that every subclass is handled, so a missing branch is a compile error, not a runtime surprise. Subclasses are typically `data class` (carrying fields) or `object` (singleton, no fields). Kotlin's **smart casts** mean that after `is Circle`, the compiler already knows the type — you access `shape.radius` directly, no explicit cast needed. This pattern replaces Java's `instanceof` chains and is more powerful than enums because each variant can hold different data.

- [Sealed classes](https://kotlinlang.org/docs/sealed-classes.html)
- [when expression](https://kotlinlang.org/docs/control-flow.html#when-expression)
- [Smart casts](https://kotlinlang.org/docs/typecasts.html#smart-casts)

---

### ex12 · `object` Singletons and `companion object` Factories

Kotlin has no `static` keyword. Instead, `object` declares a singleton: one lazily-created instance, globally accessible by name. `companion object` is a special object nested inside a class that provides class-level members — the idiomatic home for factory methods like `Temperature.fromFahrenheit(212.0)`. The call site looks identical to a Java static method, but the implementation is a regular object with all the flexibility that brings (interfaces, extension functions, etc.). `MathUtils` in this exercise is a top-level `object`; `Temperature` shows the companion pattern.

- [Object declarations](https://kotlinlang.org/docs/object-declarations.html)
- [Companion objects](https://kotlinlang.org/docs/object-declarations.html#companion-objects)

---

### ex13 · Scope Functions: `let`, `apply`, `also`, `run`

Scope functions run a lambda block on an object and differ along two axes: whether the object is exposed as `this` (allowing direct property access) or as `it` (explicit parameter), and whether the block returns the object itself or the lambda result. `let` (→ result, `it`) is the standard nullable-safe transformer: `input?.let { it.trim().uppercase() } ?: "NONE"`. `apply` (→ object, `this`) is builder-style configuration. `also` (→ object, `it`) injects side effects (logging, assertions) into a chain without breaking it. `run` (→ result, `this`) computes a value using the receiver's members. Choosing the right one is a matter of intent — if it returns the object, it's for building/side-effects; if it returns the result, it's for transformation.

- [Scope functions](https://kotlinlang.org/docs/scope-functions.html)
- [Idioms: with](https://kotlinlang.org/docs/idioms.html#with)

---

### ex14 · Advanced Collections: `groupBy`, `partition`, `flatMap`, `zip`

These four operations handle the collection patterns that require more than a simple transform or filter. `groupBy { key }` produces a `Map<K, List<V>>` by categorizing elements — the Kotlin equivalent of Java's `Collectors.groupingBy`. `partition { predicate }` splits a list into a `Pair` of (matching, non-matching) in a single pass. `flatMap { list }` maps each element to a sub-list and flattens everything into one list — essential for tokenizing sentences, expanding trees, or unnesting nested collections. `zip(other)` pairs two lists by index into `List<Pair<A, B>>`, with no built-in Java equivalent before streams workarounds.

- [Grouping](https://kotlinlang.org/docs/collection-grouping.html)
- [zip](https://kotlinlang.org/docs/collection-transformations.html#zip)
- [flatMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/flat-map.html)

---

### ex15 · Coroutines: `suspend`, `async`/`await`, `delay`

A `suspend` function can pause its execution without blocking the underlying thread — the runtime saves its state and resumes it later. This is cheaper than Java threads by orders of magnitude: millions of coroutines can coexist on a handful of threads. `delay(ms)` is the non-blocking equivalent of `Thread.sleep`. `async { }` starts a coroutine that runs concurrently and returns a `Deferred<T>`; calling `.await()` suspends until the result is ready. `coroutineScope { }` scopes a group of `async` blocks so that if one fails, the rest are cancelled automatically. The exercise has you implement `fetchGreeting` (a single suspend function with a delay) and `fetchBoth` (two concurrent `async` calls that run in parallel and return a `Pair`).

- [Coroutines overview](https://kotlinlang.org/docs/coroutines-overview.html)
- [Coroutines basics](https://kotlinlang.org/docs/coroutines-basics.html)
- [Async programming](https://kotlinlang.org/docs/async-programming.html)
