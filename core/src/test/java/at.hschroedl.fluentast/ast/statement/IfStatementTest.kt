package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.iff
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.dummyStatement
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.IfStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class IfStatementTest {

    @Test
    fun ifStatement_withElse_shouldReturnIfStatement() {
        val statement = iff(dummyExpression("condition"))
                .then(dummyStatement("statement"))
                .elsez(dummyStatement("statement")).build()

        assertEquals("if (condition) statement;else statement;", statement.toInlineString())
    }

    @Test
    fun ifStatement_withoutElse_shouldReturnIfStatement() {
        val statement = iff(dummyExpression("condition"))
                .then(dummyStatement("statement"))
                .build() as IfStatement

        assertEquals("if (condition) statement;", statement.toInlineString())

    }
}