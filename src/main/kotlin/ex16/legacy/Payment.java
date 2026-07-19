package ex16.legacy;

/**
 * DANGER: a plain abstract class — anyone, in any package, can add a subclass, so the
 * compiler can never know an instanceof chain over payments is complete (see
 * OrderUtils.paymentMessage). Java 17 added `sealed ... permits`, but pre-17 codebases
 * (and this one, faithfully) have no way to say "these three are all there is".
 *
 * Kotlin: sealed class Payment — subclasses restricted to the same file, and `when`
 * over it is compiler-checked exhaustive (ex11).
 */
public abstract class Payment {
}
