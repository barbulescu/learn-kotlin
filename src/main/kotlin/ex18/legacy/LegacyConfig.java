package ex18.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * LEGACY: loads "one port per line" config text. Working, tested — and every method
 * is shaped by checked exceptions. Port target: ex18/Exceptions.kt.
 */
public final class LegacyConfig {

    private LegacyConfig() {}   // CLUTTER: ritual to stop instantiation of a non-class

    // A strict parser. The checked exception is the API: every caller of parsePort,
    // however deep in the stack, must either try/catch or re-declare `throws`.
    public static int parsePort(String raw) throws ParseException {
        try {
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            throw new ParseException("not a port: " + raw, 0);
        }
    }

    // DANGER: this wants to be lines.stream().map(LegacyConfig::parsePort) — but that
    // DOES NOT COMPILE: a checked exception cannot cross a lambda boundary, because
    // Function.apply() declares none. So the code catches inside the loop... and this
    // author, like so many before, chose to swallow: a typo'd line silently vanishes
    // from the result. ["80", "oops", "443"] → [80, 443] and nobody is ever told.
    public static List<Integer> parsePorts(List<String> lines) {
        List<Integer> ports = new ArrayList<>();
        for (String line : lines) {
            try {
                ports.add(parsePort(line));
            } catch (ParseException e) {
                // swallowed — see DANGER above
            }
        }
        return ports;
    }

    // CLUTTER: the fallback dance, five lines and a catch block, at every call site
    // that wants a default instead of an exception.
    public static int portOrDefault(String raw, int fallback) {
        try {
            return parsePort(raw);
        } catch (ParseException e) {
            return fallback;
        }
    }

    // CLUTTER: try-with-resources — better than finally { close(); }, but still
    // ceremony, and the checked IOException still tunnels through every signature
    // above this one.
    public static List<Integer> readPorts(Reader source) throws IOException {
        try (BufferedReader reader = new BufferedReader(source)) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return parsePorts(lines);   // DANGER: swallows bad lines, see above
        }
    }
}
