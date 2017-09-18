package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.type
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.MethodInvocation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MethodInvocationTest {

    @Test
    internal fun methodInvocation_withAllParameters_returnsMethodInvocation() {
        val expression = invocation(exp("expression"), listOf(type("Type")), "method", n(1),
                n(2)).build() as MethodInvocation

        assertEquals("expression.<Integer>method(1,2)", expression.toInlineString())
    }


}