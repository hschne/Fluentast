package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.ThisExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ThisExpressionTest {

    @Test
    internal fun thisExpression_withName_returnsThis() {
        val expression = thiss("item").build() as ThisExpression

        assertEquals("item.this", expression.toInlineString())
    }

       @Test
    internal fun thisExpression_withOutName_returnsThis() {
        val expression = thiss().build() as ThisExpression

        assertEquals("this", expression.toInlineString())
    }
}