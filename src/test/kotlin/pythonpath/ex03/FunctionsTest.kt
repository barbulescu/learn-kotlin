package pythonpath.ex03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FunctionsTest {

    @Test
    @Disabled("TODO: implement createTag() to make these pass")
    fun `createTag with defaults`() =
        assertEquals("<div>Hi</div>", createTag("Hi"))

    @Test
    @Disabled("TODO: implement createTag() to make these pass")
    fun `createTag with custom tag`() =
        assertEquals("<h1>Title</h1>", createTag("Title", tag = "h1"))

    @Test
    @Disabled("TODO: implement createTag() to make these pass")
    fun `createTag with tag and class`() =
        assertEquals("""<p class="intro">Text</p>""", createTag("Text", tag = "p", cls = "intro"))

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
