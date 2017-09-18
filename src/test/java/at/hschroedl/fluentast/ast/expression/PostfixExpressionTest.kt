package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.PostfixExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class PostfixExpressionTest {

    @Test
    internal fun postfixExpression_withIncrement_returnsParenthesizedExpression() {
        val expression = postfix(name("expression"), "++").build() as PostfixExpression

        assertEquals("expression++", expression.toInlineString())
    }

    @Test
    internal fun postfixExpression_withDecrement_returnsParenthesizedExpression() {
        val expression = postfix(name("expression"), "--").build() as PostfixExpression

        assertEquals("expression--", expression.toInlineString())
    }

    @Test
    internal fun postfixExpression_withInvalidPostFix_throwsException() {
        assertFailsWith(FluentArgumentException::class) {
            postfix(name("expression"), "invalid").build()
        }
    }

}