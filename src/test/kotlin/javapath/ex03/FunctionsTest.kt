package javapath.ex03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FunctionsTest {

    @Test
    @Disabled("TODO: implement sendEmail() to make these pass")
    fun `sendEmail with all defaults`() =
        assertEquals("To: a@x.com | Sub: Hi | CC:  | Pri: 3 | HTML: false", sendEmail("a@x.com", "Hi"))

    @Test
    @Disabled("TODO: implement sendEmail() to make these pass")
    fun `sendEmail with custom priority`() =
        assertEquals("To: a@x.com | Sub: Hi | CC:  | Pri: 1 | HTML: false", sendEmail("a@x.com", "Hi", priority = 1))

    @Test
    @Disabled("TODO: implement sendEmail() to make these pass")
    fun `sendEmail with cc and html`() =
        assertEquals("To: a@x.com | Sub: Hi | CC: b@x.com | Pri: 3 | HTML: true", sendEmail("a@x.com", "Hi", cc = "b@x.com", html = true))

    @Test
    @Disabled("TODO: implement sendEmail() to make these pass")
    fun `sendEmail all explicit`() =
        assertEquals("To: a@x.com | Sub: Hi | CC: b@x.com | Pri: 1 | HTML: true", sendEmail("a@x.com", "Hi", cc = "b@x.com", priority = 1, html = true))

    @Test
    @Disabled("TODO: implement repeatStr() to make these pass")
    fun `repeatStr without separator`() =
        assertEquals("hahaha", repeatStr("ha", 3))

    @Test
    @Disabled("TODO: implement repeatStr() to make these pass")
    fun `repeatStr with separator`() =
        assertEquals("ha-ha-ha", repeatStr("ha", 3, "-"))

    @Test
    @Disabled("TODO: implement repeatStr() to make these pass")
    fun `repeatStr once`() =
        assertEquals("x", repeatStr("x", 1))
}
