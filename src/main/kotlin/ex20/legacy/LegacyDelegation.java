package ex20.legacy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * LEGACY: two classic delegation chores, hand-rolled — a decorator that forwards an
 * interface method by method, and lazy initialization via double-checked locking.
 * Port target: ex20/Delegation.kt, where both collapse into the `by` keyword.
 */
public final class LegacyDelegation {

    private LegacyDelegation() {}

    public interface Store {
        void put(String key, String value);
        String get(String key);
        int size();
        boolean contains(String key);
    }

    public static final class MemoryStore implements Store {
        private final Map<String, String> map = new HashMap<>();

        @Override public void put(String key, String value) { map.put(key, value); }
        @Override public String get(String key) { return map.get(key); }
        @Override public int size() { return map.size(); }
        @Override public boolean contains(String key) { return map.containsKey(key); }
    }

    // CLUTTER: the decorator pattern, Java edition. ONE method gains behavior (put
    // counts writes); the other THREE are hand-written forwarding boilerplate.
    // DANGER: this scales with the interface, not with the feature — add a method to
    // Store and every decorator in the codebase needs another forwarding method.
    // Lombok's @Delegate is the bolt-on admission that the language is missing a word.
    public static final class CountingStore implements Store {
        private final Store inner;
        private int puts = 0;

        public CountingStore(Store inner) { this.inner = inner; }

        @Override public void put(String key, String value) {   // the ONE real method
            puts++;
            inner.put(key, value);
        }

        @Override public String get(String key) { return inner.get(key); }              // forwarding
        @Override public int size() { return inner.size(); }                            // forwarding
        @Override public boolean contains(String key) { return inner.contains(key); }   // forwarding

        public int getPuts() { return puts; }
    }

    // DANGER: double-checked locking — the famous "compute once, on first use" idiom
    // that took the Java memory model years to make correct (the field MUST be
    // volatile; many hand-rolled copies aren't). Eleven lines of concurrency lore to
    // express one word of intent.
    public static final class LazyConfig {
        private final Supplier<Map<String, String>> loader;
        private volatile Map<String, String> config;

        public LazyConfig(Supplier<Map<String, String>> loader) { this.loader = loader; }

        public Map<String, String> getConfig() {
            Map<String, String> local = config;
            if (local == null) {
                synchronized (this) {
                    local = config;
                    if (local == null) {
                        config = local = loader.get();
                    }
                }
            }
            return local;
        }
    }
}
