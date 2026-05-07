# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Kotlin exercises for developers coming from Java or Python. Two learning paths cover the same concepts but use different analogies and comments. Each exercise is a `TODO()` stub; the learner makes the pre-written tests pass.

## Setup

Requires JDK 21 and Gradle. Generate the wrapper once:
```bash
gradle wrapper
```

## Build & Test

```bash
./gradlew test                              # run all tests
./gradlew test --tests "javapath.*"         # Java path only
./gradlew test --tests "pythonpath.*"       # Python path only
./gradlew test --tests "*.ex03.*"           # one exercise, both paths
./gradlew test --tests "javapath.ex03.*"    # one exercise, one path
```

## Structure

```
src/
  main/kotlin/
    javapath/exNN/    # stubs with Java analogies and docs
    pythonpath/exNN/  # same stubs, Python analogies and docs
  test/kotlin/
    javapath/exNN/    # tests import from javapath
    pythonpath/exNN/  # identical tests, import from pythonpath
```

Tests are identical between paths — only the package import differs.

## Adding an Exercise

1. Create `src/main/kotlin/javapath/exNN/Topic.kt` with `TODO()` stubs and a header comment block (theory, analogy, doc links).
2. Copy to `src/main/kotlin/pythonpath/exNN/Topic.kt` and swap the analogy section.
3. Create `src/test/kotlin/javapath/exNN/TopicTest.kt`.
4. Copy to `src/test/kotlin/pythonpath/exNN/TopicTest.kt` and change only the package line.

## Curriculum

| Exercise | Week | Concept |
|----------|------|---------|
| ex01 | 1 | `val`/`var`, type inference |
| ex02 | 1 | String templates |
| ex03 | 1 | Default parameters, named arguments |
| ex04 | 1 | Null safety (`?`, `?.`, `?:`) |
| ex05 | 1 | `when` as expression |
| ex06 | 2 | Data classes (`copy`, destructuring, structural equality) |
| ex07 | 2 | Ranges and `for` loops (`..`, `downTo`, `step`, `until`) |
| ex08 | 2 | Extension functions |
| ex09 | 2 | Lambdas and higher-order functions (`it`, trailing lambda) |
| ex10 | 2 | Collections: `map`, `filter`, `fold`, `maxByOrNull` |
| ex11 | 3 | Sealed classes + exhaustive `when` |
| ex12 | 3 | `object` singletons and `companion object` factories |
| ex13 | 3 | Scope functions: `let`, `apply`, `also`, `run` |
| ex14 | 3 | Advanced collections: `groupBy`, `partition`, `flatMap`, `zip` |
| ex15 | 3 | Coroutines: `suspend`, `async`/`await`, `delay`, `coroutineScope` |
