package pythonpath.ex11

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.PI

class SealedClassesTest {

    @Test fun `area of Circle radius 2`() = assertEquals(PI * 4.0, area(Circle(2.0)), 1e-9)
    @Test fun `area of Circle radius 1`() = assertEquals(PI, area(Circle(1.0)), 1e-9)

    @Test fun `area of Rectangle 3x5`() = assertEquals(15.0, area(Rectangle(3.0, 5.0)), 1e-9)
    @Test fun `area of Rectangle 4x4`() = assertEquals(16.0, area(Rectangle(4.0, 4.0)), 1e-9)

    @Test fun `area of Triangle base 5 height 3`() = assertEquals(7.5, area(Triangle(5.0, 3.0)), 1e-9)
    @Test fun `area of Triangle base 6 height 4`() = assertEquals(12.0, area(Triangle(6.0, 4.0)), 1e-9)

    @Test fun `describe Circle`() = assertEquals("Circle with radius 2.0", describe(Circle(2.0)))
    @Test fun `describe Rectangle`() = assertEquals("Rectangle 3.0 x 5.0", describe(Rectangle(3.0, 5.0)))
    @Test fun `describe Triangle`() = assertEquals("Triangle with base 5.0 and height 3.0", describe(Triangle(5.0, 3.0)))
}
