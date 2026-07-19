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
  main/kotlin/exNN/   # stubs with Java analogies and docs
  test/kotlin/exNN/   # pre-written tests
```

## Adding an Exercise

1. Create `src/main/kotlin/exNN/Topic.kt` with `TODO()` stubs and a header comment block (theory, Java analogy, doc links).
2. Create `src/test/kotlin/exNN/TopicTest.kt`.

## Curriculum

Exercises are ordered by "convince factor" for a 2-hour dojo: core (ex01–ex06) makes the case for Kotlin, stretch (ex07–ex10) fills the second hour, advanced (ex11–ex15) is homework.

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
