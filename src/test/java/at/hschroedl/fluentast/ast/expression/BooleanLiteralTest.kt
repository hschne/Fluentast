package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.BooleanLiteral
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BooleanLiteralTest {

    @Test
    internal fun boolean_withBoolean_returnsBooleanLiteral() {
        val expression = b(true).build() as BooleanLiteral

        assertEquals(true, expression.booleanValue())
    }

}