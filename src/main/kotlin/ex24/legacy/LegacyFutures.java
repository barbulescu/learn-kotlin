package ex24.legacy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * LEGACY: async composition, CompletableFuture-style. Working — and every step is a
 * callback threaded through a then-something combinator. Port target: ex24/Futures.kt.
 */
public final class LegacyFutures {

    private LegacyFutures() {}

    // Pretend-remote calls (no sleeps — the SHAPE is the point, not the latency).
    public static CompletableFuture<String> fetchName(int userId) {
        return CompletableFuture.supplyAsync(() -> "user" + userId);
    }

    public static CompletableFuture<Integer> fetchScore(int userId) {
        return CompletableFuture.supplyAsync(() -> userId * 6);
    }

    // CLUTTER: sequential composition means thenCompose (flatMap by another name) —
    // control flow turns inside-out: each step is a lambda handed to the previous
    // one, and the wrapper type infects every signature on the way up.
    public static CompletableFuture<String> greetingFor(int userId) {
        return fetchName(userId)
                .thenCompose(name ->
                        CompletableFuture.supplyAsync(() -> "Hello, " + name + "!"));
    }

    // CLUTTER: parallel composition is a different combinator again — thenCombine.
    // (And plain mapping is a third, thenApply. The reader must know which of three
    // merge words applies; in the Kotlin port all three are just... syntax.)
    public static CompletableFuture<String> scoreLine(int userId) {
        return fetchName(userId)
                .thenCombine(fetchScore(userId), (name, score) -> name + ": " + score);
    }

    // DANGER: leaving future-land costs .get(), which blocks a real platform thread
    // AND throws two checked exceptions — so the escape hatch arrives wrapped in the
    // very ceremony the futures were meant to abstract away.
    public static String scoreLineNow(int userId) {
        try {
            return scoreLine(userId).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e.getCause());
        }
    }
}
