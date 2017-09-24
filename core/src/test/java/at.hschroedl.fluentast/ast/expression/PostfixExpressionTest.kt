package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.postfix
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.PostfixExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFailsWith

internal class PostfixExpressionTest {

    @ParameterizedTest(name = "Create postfix with {arguments}")
    @ValueSource(strings = arrayOf("++", "--"))
    internal fun postfixExpression_withOperator_returnsPrefixExpression(operator: String) {
        val expression = postfix(operator).operand(
                dummyExpression("expression")).build() as PostfixExpression

        assertEquals("expression$operator", expression.toInlineString())
    }


    @Test
    internal fun postfixExpression_withInvalidPostFix_throwsException() {
        assertFailsWith(FluentArgumentException::class) {
            postfix("invalid").operand(dummyExpression("expression")).build()
        }
    }

}