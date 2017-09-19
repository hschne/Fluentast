package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.dummyType
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.InstanceofExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InstanceOfExpressionTest {

    @Test
    internal fun instanceOfExpression_withExpressionsAndTypes_returnInstanceOfExpression() {
        val expression = instanceof(dummyExpression("a"),
                dummyType("Integer")).build() as InstanceofExpression

        assertEquals("a instanceof Integer", expression.toInlineString())
    }

}