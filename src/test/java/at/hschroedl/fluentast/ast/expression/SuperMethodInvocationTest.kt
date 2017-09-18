package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.t
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
        val expression = superMethod("mypackage.Class", listOf(t("Integer")), "method",
                n(1), n(2)).build() as SuperMethodInvocation

        assertEquals("mypackage.Class.super.<Integer>method(1,2)", expression.toInlineString())
    }
}