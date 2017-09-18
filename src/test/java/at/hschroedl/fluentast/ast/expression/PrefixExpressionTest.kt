package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.PrefixExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class PrefixExpressionTest {

    @Test
    internal fun prefixExpression_withIncrement_returnsPrefixExpression() {
        val expression = prefix("++", name("expression")).build() as PrefixExpression

        assertEquals("++expression", expression.toInlineString())
    }

    @Test
    internal fun prefixExpression_withDecrement_returnsPrefixExpression() {
        val expression = prefix("--", name("expression")).build() as PrefixExpression

        assertEquals("--expression", expression.toInlineString())
    }

    @Test
    internal fun prefixExpression_withPlus_returnsPrefixExpression() {
        val expression = prefix("+", name("expression")).build() as PrefixExpression

        assertEquals("+expression", expression.toInlineString())
    }

    @Test
    internal fun prefixExpression_withMinus_returnsPrefixExpression() {
        val expression = prefix("-", name("expression")).build() as PrefixExpression

        assertEquals("-expression", expression.toInlineString())
    }

    @Test
    internal fun prefixExpression_withComplement_returnsPrefixExpression() {
        val expression = prefix("~", name("expression")).build() as PrefixExpression

        assertEquals("~expression", expression.toInlineString())
    }

    @Test
    internal fun prefixExpression_withNot_returnsPrefixExpression() {
        val expression = prefix("!", name("expression")).build() as PrefixExpression

        assertEquals("!expression", expression.toInlineString())
    }


    @Test
    internal fun prefixExpression_withInvalidPostFix_throwsException() {
        assertFailsWith(FluentArgumentException::class) {
            prefix(",invalid", name("expression")).build()
        }
    }
}