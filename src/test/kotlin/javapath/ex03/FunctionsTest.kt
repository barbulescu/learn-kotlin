package javapath.ex03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FunctionsTest {

    @Test fun `createTag with defaults`() =
        assertEquals("<div>Hi</div>", createTag("Hi"))

    @Test fun `createTag with custom tag`() =
        assertEquals("<h1>Title</h1>", createTag("Title", tag = "h1"))

    @Test fun `createTag with tag and class`() =
        assertEquals("""<p class="intro">Text</p>""", createTag("Text", tag = "p", cls = "intro"))

    @Test fun `repeatStr without separator`() =
        assertEquals("hahaha", repeatStr("ha", 3))

    @Test fun `repeatStr with separator`() =
        assertEquals("ha-ha-ha", repeatStr("ha", 3, "-"))

    @Test fun `repeatStr once`() =
        assertEquals("x", repeatStr("x", 1))
}
