package ex16.legacy;

/**
 * CLUTTER: a hand-rolled singleton — private constructor + static INSTANCE ritual.
 * Kotlin: `object Pending : Payment()` (ex12).
 */
public final class Pending extends Payment {

    public static final Pending INSTANCE = new Pending();

    private Pending() {
    }
}
