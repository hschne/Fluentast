package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.paranthesis
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.ParenthesizedExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ParenthesizedExpressionTest {

    @Test
    internal fun parenthesizedExpression_withExpression_returnsParenthesizedExpression() {
        val expression = paranthesis(dummyExpression("expression")).build() as ParenthesizedExpression

        assertEquals("(expression)", expression.toInlineString())
    }
}