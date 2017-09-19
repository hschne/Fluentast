package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.dummyLiteral
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.ConditionalExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ConditionalExpressionTest {

    @Test
    internal fun conditionalExpression_withTypes_returnsConditionalExpression() {
        val expression = ternary(dummyExpression("dummy"),
                dummyLiteral(1), dummyLiteral(2)).build() as ConditionalExpression

        assertEquals("dummy ? 1 : 2", expression.toInlineString())
    }
}