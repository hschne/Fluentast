package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.superField
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.SuperFieldAccess
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SuperFieldAccessTest {

    @Test
    internal fun superFieldAccess_withName_returnsSuperFieldAccess() {
        val expression = superField("field").build() as SuperFieldAccess

        assertEquals("super.field", expression.toInlineString())
    }

    @Test
    internal fun superFieldAccess_withQualfiedName_returnsSuperFieldAccess() {
        val expression = superField("mypackage.Class", "field").build() as SuperFieldAccess

        assertEquals("mypackage.Class.super.field", expression.toInlineString())
    }

}