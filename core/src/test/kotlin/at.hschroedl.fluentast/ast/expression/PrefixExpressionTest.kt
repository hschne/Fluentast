package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.prefix
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.PrefixExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFailsWith

internal class PrefixExpressionTest {

    @ParameterizedTest(name = "Create prefix with {arguments}")
    @ValueSource(strings = arrayOf("++", "--", "+", "-", "~", "!"))
    internal fun prefixExpression_withOperator_returnsPrefixExpression(operator: String) {
        val expression = prefix(operator, dummyExpression("expression")).build() as PrefixExpression

        assertEquals("${operator}expression", expression.toInlineString())
    }

    @Test
    internal fun prefixExpression_withInvalidPostFix_throwsException() {
        assertFailsWith(FluentArgumentException::class) {
            prefix(",invalid", dummyExpression("expression")).build()
        }
    }
}