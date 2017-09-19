package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.ExpressionStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ExpressionStatementTest {

    @Test
    fun assert_withoutMessage_shouldReturnAssertStatement() {
        val statement = stmnt(dummyExpression("expression")).build() as ExpressionStatement

        assertEquals("expression;", statement.toInlineString())
    }


}