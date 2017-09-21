package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.exp
import at.hschroedl.fluentast.test.toInlineString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class ParsedExpressionTest {

    @Test
    internal fun parse_withString_shouldReturnExpression() {
        val expression = exp("new Integer()").build()

        assertEquals("new Integer()", expression.toInlineString())
    }

    @Test
    internal fun parse_withMalformedString_shouldThrowException() {
        assertFailsWith(FluentArgumentException::class) {
            exp("new Invalid!").build()
        }
    }
}