package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.InfixExpression
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class FluentInfixExpressionTest {


    @Test
    internal fun infixExpression_withTimes_returnInfixExpression() {
        val expression = infix(exp("a"), "*", n(1)).build() as InfixExpression

        assertEquals("a * 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withDivide_returnInfixExpression() {
        val expression = infix(exp("a"), "/", n(1)).build() as InfixExpression

        assertEquals("a / 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withRemainder_returnInfixExpression() {
        val expression = infix(exp("a"), "%", n(1)).build() as InfixExpression

        assertEquals("a % 1", expression.toInlineString())
    }


    @Test
    internal fun infixExpression_withPlus_returnInfixExpression() {
        val expression = infix(exp("a"), "+", n(1)).build() as InfixExpression

        assertEquals("a + 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withMinus_returnInfixExpression() {
        val expression = infix(exp("a"), "-", n(1)).build() as InfixExpression

        assertEquals("a - 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withLeftShift_returnInfixExpression() {
        val expression = infix(exp("a"), "<<", n(1)).build() as InfixExpression

        assertEquals("a << 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withRightShift_returnInfixExpression() {
        val expression = infix(exp("a"), ">>", n(1)).build() as InfixExpression

        assertEquals("a >> 1", expression.toInlineString())
    }


    @Test
    internal fun infixExpression_withRightShiftUnsigned_returnInfixExpression() {
        val expression = infix(exp("a"), ">>>", n(1)).build() as InfixExpression

        assertEquals("a >>> 1", expression.toInlineString())
    }


    @Test
    internal fun infixExpression_withLess_returnInfixExpression() {
        val expression = infix(exp("a"), "<", n(1)).build() as InfixExpression

        assertEquals("a < 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withGreater_returnInfixExpression() {
        val expression = infix(exp("a"), ">", n(1)).build() as InfixExpression

        assertEquals("a > 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withLessEquals_returnInfixExpression() {
        val expression = infix(exp("a"), "<=", n(1)).build() as InfixExpression

        assertEquals("a <= 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withGreaterEquals_returnInfixExpression() {
        val expression = infix(exp("a"), ">=", n(1)).build() as InfixExpression

        assertEquals("a >= 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withEquals_returnInfixExpression() {
        val expression = infix(exp("a"), "==", n(1)).build() as InfixExpression

        assertEquals("a == 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withNotEquals_returnInfixExpression() {
        val expression = infix(exp("a"), "!=", n(1)).build() as InfixExpression

        assertEquals("a != 1", expression.toInlineString())
    }


    @Test
    internal fun infixExpression_withXOR_returnInfixExpression() {
        val expression = infix(exp("a"), "^", n(1)).build() as InfixExpression

        assertEquals("a ^ 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withAnd_returnInfixExpression() {
        val expression = infix(exp("a"), "&", n(1)).build() as InfixExpression

        assertEquals("a & 1", expression.toInlineString())
    }


    @Test
    internal fun infixExpression_withOr_returnInfixExpression() {
        val expression = infix(exp("a"), "|", n(1)).build() as InfixExpression

        assertEquals("a | 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withConditionalAnd_returnInfixExpression() {
        val expression = infix(exp("a"), "&&", n(1)).build() as InfixExpression

        assertEquals("a && 1", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withConditionalOr_returnInfixExpression() {
        val expression = infix(exp("a"), "||", n(1)).build() as InfixExpression

        assertEquals("a || 1", expression.toInlineString())
    }


    @Test
    internal fun infixExpression_invalidOperator_returnsInfixExpression() {
        assertFailsWith(FluentArgumentException::class) {
            infix(exp("a"), "test", n(1)).build() as InfixExpression
        }

    }

    @Test
    internal fun infixExpression_withExtendedOperands_returnInfixExpression() {
        val expression = infix(exp("a"), "||", n(1), n(2), n(3)).build() as InfixExpression

        assertEquals("a || 1 || 2|| 3", expression.toInlineString())
    }


}