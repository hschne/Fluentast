package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.InfixExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFailsWith

internal class InfixExpressionTest {


    @ParameterizedTest(name = "Create infix with {arguments}")
    @ValueSource(
            strings = arrayOf(
                    "*", "/", "%", "+", "-", "<<", ">>", ">>>",
                    "<", ">", "<=", ">=", "==", "!=",
                    "^", "&", "|", "&&", "||"))
    internal fun infixExpression_withOperator_returnsPrefixExpression(operator: String) {
        val expression = infix(dummyExpression("a"), operator, dummyLiteral(1)).build() as InfixExpression

        assertEquals("a $operator 1", expression.toInlineString())
    }


    @Test
    internal fun infixExpression_invalidOperator_returnsInfixExpression() {
        assertFailsWith(FluentArgumentException::class) {
            infix(dummyExpression("a"), "test", dummyLiteral(1)).build() as InfixExpression
        }

    }

    @Test
    internal fun infixExpression_withExtendedOperands_returnInfixExpression() {
        val expression = infix(dummyExpression("a"), "||", dummyLiteral(1),
                dummyLiteral(2), dummyLiteral(3)).build() as InfixExpression

        assertEquals("a || 1 || 2|| 3", expression.toInlineString())
    }

}