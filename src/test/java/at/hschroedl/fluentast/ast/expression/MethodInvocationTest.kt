package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.MethodInvocation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MethodInvocationTest {

    @Test
    internal fun methodInvocation_withName_returnsMethodInvocation() {
        val expression = invocation("method").build() as MethodInvocation

        assertEquals("method()", expression.toInlineString())
    }


    @Test
    internal fun methodInvocation_withAllParameters_returnsMethodInvocation() {
        val expression = invocation(dummyExpression("expression"), listOf(dummyType("Type")), "method",
                dummyLiteral(1),
                dummyLiteral(2)).build() as MethodInvocation

        assertEquals("expression.<Type>method(1,2)", expression.toInlineString())
    }


}