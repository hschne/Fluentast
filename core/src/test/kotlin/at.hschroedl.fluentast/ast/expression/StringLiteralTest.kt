package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.s
import org.eclipse.jdt.core.dom.StringLiteral
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class StringLiteralTest {

    @Test
    internal fun boolean_withBoolean_returnsBooleanLiteral() {
        val expression = s("s").build() as StringLiteral

        assertEquals("s", expression.literalValue)
    }
}