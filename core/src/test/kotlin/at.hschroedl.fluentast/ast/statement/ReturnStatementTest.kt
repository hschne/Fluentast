package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.return_
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.ReturnStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ReturnStatementTest {

    @Test
    fun returnStatement_withExpression_shouldReturnReturnStatement() {
        val statement = return_(dummyExpression("expression")).build() as ReturnStatement

        assertEquals("return expression;", statement.toInlineString())
    }

    @Test
    fun returnStatement_withoutExpression_shouldReturnReturnStatement() {
        val statement = return_().build() as ReturnStatement

        assertEquals("return;", statement.toInlineString())
    }

}