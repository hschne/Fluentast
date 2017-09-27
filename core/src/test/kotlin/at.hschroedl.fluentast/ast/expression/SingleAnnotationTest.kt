package at.hschroedl.fluentast.ast.expression


import at.hschroedl.fluentast.annotation
import at.hschroedl.fluentast.test.dummyLiteral
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.MarkerAnnotation
import org.eclipse.jdt.core.dom.SingleMemberAnnotation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SingleAnnotationTest {

    @Test
    internal fun annotation_withQualfiedName_returnsAnnotation() {
        val expression = annotation("test.test1.Test2").build() as MarkerAnnotation

        assertEquals("@test.test1.Test2", expression.toInlineString())
    }


    @Test
    internal fun annotation_withParameter_returnsAnnotation() {
        val expression = annotation("Test", dummyLiteral(1)).build() as SingleMemberAnnotation

        assertEquals("@Test(1)", expression.toInlineString())
    }

}