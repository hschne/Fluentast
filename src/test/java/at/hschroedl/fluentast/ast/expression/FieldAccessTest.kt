package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.FieldAccess
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FieldAccessTest {

    @Test
    internal fun fieldAccess_withDefaultParameters_returnsFieldAccess() {
        val fieldAccess = fieldAccess(dummyExpression("dummy"), "field").build() as FieldAccess

        assertEquals("dummy.field", fieldAccess.toInlineString())
    }
}