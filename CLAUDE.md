# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Kotlin exercises for developers coming from Java. Each exercise is a `TODO()` stub; the learner makes the pre-written tests pass.

## Setup

The Gradle wrapper is committed and the Foojay toolchain resolver (settings.gradle.kts) auto-provisions JDK 21 — use `./gradlew` directly; no local Gradle or JDK 21 install is needed.

## Build & Test

```bash
./gradlew test                      # run all tests
./gradlew test --tests "ex03.*"     # one exercise
```

## Structure

```
src/
  main/kotlin/exNN/         # stubs with Java analogies and docs
  main/kotlin/ex16/legacy/  # working, annotated legacy Java program (.java) that ex16 refactors to Kotlin
  test/kotlin/exNN/         # pre-written tests
```

The Java files live inside the Kotlin source tree on purpose (legacy sits next to its port); build.gradle.kts adds `src/main/kotlin` to the Java source set to compile them.

## Adding an Exercise

1. Create `src/main/kotlin/exNN/Topic.kt` with `TODO()` stubs and a header comment block (theory, Java analogy, doc links).
2. Create `src/test/kotlin/exNN/TopicTest.kt`.

The `JAVA ANALOGY` header blocks are the core teaching device, not decoration — for the stretch/advanced exercises the code is a one-liner once you know the right function exists, so the analogy (`Collectors.groupingBy` → `groupBy`) carries the entire lesson. Never trim or summarize them.

## Curriculum

Exercises are ordered by "convince factor" for a 2-hour dojo: core (ex01–ex06) makes the case for Kotlin, stretch (ex07–ex10) fills the second hour, advanced (ex11–ex15) is homework, and the capstone (ex16) is a refactoring exercise: a working Java program in `src/main/kotlin/ex16/legacy/` (annotated in place with DANGER/CLUTTER comments, money as `BigDecimal`) that the learner ports to Kotlin. Its `LegacyJavaTest` passes from the start by design — the green tests document the Java bugs (NPE, in-place mutation, leaked mutable list); don't "fix" the Java code they test.

ex17 (bonus tier) inverts the house format: its stub is complete-but-buggy code, not `TODO()`s — every function silently drops a return value (`trim`, `sortedDescending`, `plus`), and the tests fail until the learner uses the values. The `-Xreturn-value-checker=check` flag in build.gradle.kts makes the compiler warnings point at exactly the buggy lines; the warnings are the exercise's hint system, so don't "fix" the stub's bugs, and keep the rest of the codebase warning-clean under the checker.

| Exercise | Tier | Concept |
|----------|------|---------|
| ex01 | core | `val`/`var`, type inference |
| ex02 | core | String templates |
| ex03 | core | Null safety (`?`, `?.`, `?:`) |
| ex04 | core | Data classes (`copy`, destructuring, structural equality) |
| ex05 | core | `when` as expression |
| ex06 | core | Default parameters, named arguments |
| ex07 | stretch | Extension functions |
| ex08 | stretch | Lambdas and higher-order functions (`it`, trailing lambda) |
| ex09 | stretch | Collections: `map`, `filter`, `fold`, `maxByOrNull` |
| ex10 | stretch | Ranges and `for` loops (`..`, `downTo`, `step`, `until`) |
| ex11 | advanced | Sealed classes + exhaustive `when` |
| ex12 | advanced | `object` singletons and `companion object` factories |
| ex13 | advanced | Scope functions: `let`, `apply`, `also`, `run` |
| ex14 | advanced | Advanced collections: `groupBy`, `partition`, `flatMap`, `zip` |
| ex15 | advanced | Coroutines: `suspend`, `async`/`await`, `delay`, `coroutineScope` |
| ex16 | capstone | Everything combined — refactor a working, annotated legacy Java program to Kotlin |
| ex17 | bonus | Unused return value checker; immutability naming convention (`sorted` vs `sort`) |
