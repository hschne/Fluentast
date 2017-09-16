package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentParseException
import at.hschroedl.fluentast.test.toInlineString
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.beans.Expression
import kotlin.test.assertFailsWith

internal class FluentExpressionTest {

    @Test
    internal fun expression_withString_shouldReturnExpression() {
        var expression = exp("new Integer()").build()

        assertEquals("new Integer()", expression.toInlineString())
    }

    @Test
    internal fun expression_withMalformedString_shouldThrowException() {
        assertFailsWith(FluentParseException::class) {
            exp("new Invalid!").build()
        }
    }
}