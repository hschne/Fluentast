package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.superMethod
import at.hschroedl.fluentast.test.dummyLiteral
import at.hschroedl.fluentast.test.dummyType
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.SuperMethodInvocation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SuperMethodInvocationTest {
    @Test
    internal fun superMethodInvocation_withName_returnsSuperMethodInvocation() {
        val expression = superMethod("method").build() as SuperMethodInvocation

        assertEquals("super.method()", expression.toInlineString())
    }

    @Test
    internal fun superFieldAccess_withQualfiedName_returnsSuperFieldAccess() {
        val expression = superMethod("mypackage.Class", listOf(dummyType("Integer")), "method",
                dummyLiteral(1), dummyLiteral(2)).build() as SuperMethodInvocation

        assertEquals("mypackage.Class.super.<Integer>method(1,2)", expression.toInlineString())
    }
}