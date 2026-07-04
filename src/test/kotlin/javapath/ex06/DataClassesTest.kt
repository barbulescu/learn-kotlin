package javapath.ex06

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class DataClassesTest {

    private val alice = Person("Alice", 30)
    private val bob = Person("Bob", 25)

    @Test
    @Disabled("TODO: implement younger() to make these pass")
    fun `younger returns the younger person`() = assertEquals(bob, younger(alice, bob))

    @Test
    @Disabled("TODO: implement younger() to make these pass")
    fun `younger returns a when ages are equal`() = assertEquals(alice, younger(alice, Person("Twin", 30)))

    @Test
    @Disabled("TODO: implement birthday() to make these pass")
    fun `birthday increments age by 1`() = assertEquals(Person("Alice", 31), birthday(alice))

    @Test
    @Disabled("TODO: implement birthday() to make these pass")
    fun `birthday preserves name`() = assertEquals("Alice", birthday(alice).name)

    @Test
    @Disabled("TODO: implement describe() to make these pass")
    fun `describe formats correctly`() = assertEquals("Alice is 30 years old", describe(alice))

    @Test
    @Disabled("TODO: these verify data class behaviour — no implementation needed beyond the data class")
    fun `data class equality compares fields`() = assertEquals(Person("Alice", 30), Person("Alice", 30))

    @Test
    @Disabled("TODO: these verify data class behaviour — no implementation needed beyond the data class")
    fun `copy produces independent instance`() {
        val older = alice.copy(age = 31)
        assertEquals(30, alice.age)
        assertEquals(31, older.age)
    }
}
