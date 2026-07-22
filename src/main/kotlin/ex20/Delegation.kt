/*
 * Exercise 20 — Delegation: the `by` Keyword
 * ===========================================
 *
 * REFACTOR EXERCISE: the legacy program is ex20/legacy/LegacyDelegation.java — a
 * decorator that hand-forwards an interface, and lazy init via double-checked
 * locking. LegacyJavaTest passes from the start. Port both classes below and make
 * DelegationTest pass.
 *
 * KEY CONCEPTS:
 *   CLASS DELEGATION: `class C(inner: Store) : Store by inner` — the compiler
 *   generates every forwarding member; you override only what you change. The
 *   decorator pattern shrinks to its one interesting method. This solution is
 *   measured in DELETED lines: the stub compiles with four overrides, the solution
 *   keeps one.
 *   PROPERTY DELEGATION: `val x by lazy { ... }` — computed on first read, cached,
 *   thread-safe by default (LazyThreadSafetyMode.SYNCHRONIZED). `lazy` is one of a
 *   family (Delegates.observable, vetoable, map delegates), the `by` syntax is the
 *   same for all, and you can write your own (getValue/setValue operators).
 *
 * JAVA ANALOGY:
 *   decorator: N forwarding methods + 1 real one   →  `: Store by inner` + 1 override
 *   Lombok @Delegate (annotation-processor patch)  →  a language keyword
 *   double-checked locking + volatile (11 lines)   →  by lazy { }  (1 word)
 *   PropertyChangeSupport listener boilerplate     →  Delegates.observable { ... }
 *
 * DOCS & READING:
 *   https://kotlinlang.org/docs/delegation.html
 *   https://kotlinlang.org/docs/delegated-properties.html
 */
package ex20

// The same Store contract, Kotlin spelling: size is a val, get returns String? —
// the map might not have the key, and the type says so [ex19].
interface Store {
    fun put(key: String, value: String)
    fun get(key: String): String?
    val size: Int
    fun contains(key: String): Boolean
}

// Scaffolding, already ported — the exercise is the two classes below it.
class MemoryStore : Store {
    private val map = mutableMapOf<String, String>()

    override fun put(key: String, value: String) { map[key] = value }
    override fun get(key: String): String? = map[key]
    override val size: Int get() = map.size
    override fun contains(key: String): Boolean = key in map
}

// Port of CountingStore. Declare it `: Store by inner` and the compiler writes every
// forwarding member for you; then implement ONLY put (count, then forward to inner).
// The correct solution DELETES three of the four overrides below — `by` is the
// feature, deletion is the proof.
class CountingStore(private val inner: Store) : Store {
    var puts = 0
        private set

    override fun put(key: String, value: String): Unit = TODO()
    override fun get(key: String): String? = TODO("delete this override — `by inner` forwards it")
    override val size: Int get() = TODO("delete this override — `by inner` forwards it")
    override fun contains(key: String): Boolean = TODO("delete this override — `by inner` forwards it")
}

// Port of LazyConfig — all eleven lines of double-checked locking become one
// delegated property. Replace the failing getter with:
//   val config: Map<String, String> by lazy { loader() }
class LazyConfig(private val loader: () -> Map<String, String>) {
    val config: Map<String, String>
        get() = TODO("replace this getter with `by lazy { loader() }`")
}
