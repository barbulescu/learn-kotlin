package ex06

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FunctionsTest {

    @Test
    fun `sendEmail with all defaults`() =
        assertEquals("To: a@x.com | Sub: Hi | CC:  | Pri: 3 | HTML: false", sendEmail("a@x.com", "Hi"))

    @Test
    fun `sendEmail with custom priority`() =
        assertEquals("To: a@x.com | Sub: Hi | CC:  | Pri: 1 | HTML: false", sendEmail("a@x.com", "Hi", priority = 1))

    @Test
    fun `sendEmail with cc and html`() =
        assertEquals("To: a@x.com | Sub: Hi | CC: b@x.com | Pri: 3 | HTML: true", sendEmail("a@x.com", "Hi", cc = "b@x.com", html = true))

    @Test
    fun `sendEmail all explicit`() =
        assertEquals("To: a@x.com | Sub: Hi | CC: b@x.com | Pri: 1 | HTML: true", sendEmail("a@x.com", "Hi", cc = "b@x.com", priority = 1, html = true))

    @Test
    fun `repeatStr without separator`() =
        assertEquals("hahaha", repeatStr("ha", 3))

    @Test
    fun `repeatStr with separator`() =
        assertEquals("ha-ha-ha", repeatStr("ha", 3, "-"))

    @Test
    fun `repeatStr once`() =
        assertEquals("x", repeatStr("x", 1))
}
