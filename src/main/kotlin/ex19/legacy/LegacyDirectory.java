package ex19.legacy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * LEGACY: a member directory that answers "is it there?" in four different dialects —
 * throw, Optional, null, and a -1 sentinel — because Java never picked one.
 * Port target: ex19/Absence.kt, where the convention is a naming rule:
 * name() throws, nameOrNull() returns null.
 */
public final class LegacyDirectory {

    private LegacyDirectory() {}

    // POJO trimmed to the minimum — ex16 already made this point at full length.
    public static final class Member {
        private final String name;
        private final String email;   // may be null! (says this comment, and nothing else)

        public Member(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
    }

    // Dialect 1 — THROW: absent member → NoSuchElementException.
    public static Member findMember(List<Member> members, String name) {
        for (Member m : members) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        throw new NoSuchElementException("no member named " + name);
    }

    // Dialect 2 — OPTIONAL: the same query, wrapped. CLUTTER: every caller now pays
    // the .map/.orElse toll — and half of them end in .orElse(null), quietly
    // converting dialect 2 back into dialect 3.
    public static Optional<Member> findMemberMaybe(List<Member> members, String name) {
        for (Member m : members) {
            if (m.getName().equals(name)) {
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }

    // Dialect 3 — NULL, reached via exception-as-control-flow. DANGER: an exception
    // is constructed, thrown, caught, and discarded on every bad input — as a way of
    // saying "no".
    public static Integer tryParseAge(String raw) {
        try {
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Dialect 4 — SENTINEL: indexOf answers "not found" with -1, and DANGER: nothing
    // makes the caller check. No '@' → indexOf returns -1 → substring(-1 + 1) = the
    // whole string. Garbage out, no error — LegacyJavaTest documents it in green.
    public static String domainOf(String email) {
        return email.substring(email.indexOf('@') + 1);
    }

    // The dialects compound: a missing member AND a missing email AND a default,
    // spelled out as a null-check pyramid.
    public static String emailOrPlaceholder(List<Member> members, String name) {
        Optional<Member> member = findMemberMaybe(members, name);
        if (member.isPresent()) {
            String email = member.get().getEmail();
            if (email != null) {
                return email;
            }
        }
        return "n/a";
    }
}
