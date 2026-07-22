package ex23.legacy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * LEGACY: find the first long word, uppercased — computed the eager way: full passes
 * and intermediate lists, all paid for even when the answer sits at index 2.
 * Port target: ex23/Sequences.kt.
 * (The onVisit hook exists so the tests can COUNT the wasted work.)
 */
public final class LegacyPipeline {

    private LegacyPipeline() {}

    // CLUTTER: two full passes and two intermediate lists for one result.
    // DANGER: with 10_000 words and the match at index 2, this still visits and
    // uppercases all 10_000 — LegacyJavaTest counts it. (Java's own fix is Stream —
    // genuinely lazy, but at the price of .stream()/.collect() at every boundary.
    // Kotlin's collections stay eager and simple; you opt into laziness per
    // pipeline with .asSequence().)
    public static String firstLongUpper(List<String> words, Consumer<String> onVisit) {
        List<String> upper = new ArrayList<>();
        for (String word : words) {            // pass 1: uppercase EVERYTHING
            onVisit.accept(word);
            upper.add(word.toUpperCase());
        }
        List<String> longOnes = new ArrayList<>();
        for (String word : upper) {            // pass 2: filter EVERYTHING
            if (word.length() > 5) {
                longOnes.add(word);
            }
        }
        return longOnes.isEmpty() ? null : longOnes.get(0);
    }
}
