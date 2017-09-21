package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.dummyStatement
import at.hschroedl.fluentast.test.toInlineString
import at.hschroedl.fluentast.while_
import org.eclipse.jdt.core.dom.WhileStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WhileStatementTest {

    @Test
    fun whileStatement_withCondition_shouldReturnIfStatement() {
        val statement = while_(dummyExpression("condition"), dummyStatement("statement")).build() as WhileStatement

        assertEquals("while (condition) statement;", statement.toInlineString())
    }
}