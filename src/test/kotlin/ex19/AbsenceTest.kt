package ex19

import java.util.NoSuchElementException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AbsenceTest {

    private val members = listOf(
        Member("Alice", "alice@example.com"),
        Member("Bob", null),
    )

    @Test
    fun `findMember returns the member`() = assertEquals(members[0], findMember(members, "Alice"))

    @Test
    fun `findMember throws on an unknown name - the plain name throws`() {
        assertThrows<NoSuchElementException> { findMember(members, "Zed") }
    }

    @Test
    fun `findMemberOrNull returns the member`() =
        assertEquals(members[1], findMemberOrNull(members, "Bob"))

    @Test
    fun `findMemberOrNull returns null on an unknown name`() = assertNull(findMemberOrNull(members, "Zed"))

    @Test
    fun `ageOrNull parses a trimmed int`() = assertEquals(42, ageOrNull(" 42 "))

    @Test
    fun `ageOrNull returns null on garbage - no exception spent`() = assertNull(ageOrNull("forty-two"))

    @Test
    fun `domainOrNull extracts the domain`() = assertEquals("example.com", domainOrNull("alice@example.com"))

    @Test
    fun `domainOrNull returns null without an at sign - never garbage`() = assertNull(domainOrNull("no-at-sign"))

    @Test
    fun `emailOrPlaceholder finds the email`() = assertEquals("alice@example.com", emailOrPlaceholder(members, "Alice"))

    @Test
    fun `emailOrPlaceholder when the member has no email`() = assertEquals("n/a", emailOrPlaceholder(members, "Bob"))

    @Test
    fun `emailOrPlaceholder when there is no such member`() = assertEquals("n/a", emailOrPlaceholder(members, "Zed"))
}
