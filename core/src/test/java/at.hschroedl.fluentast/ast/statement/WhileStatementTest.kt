package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.dummyStatement
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.WhileStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class WhileStatementTest {

    @Test
    fun whileStatement_withCondition_shouldReturnIfStatement() {
        val statement = whilez(dummyExpression("condition"), dummyStatement("statement")).build() as WhileStatement

        assertEquals("while (condition) statement;", statement.toInlineString())
    }
}