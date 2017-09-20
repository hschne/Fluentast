package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.assert
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.AssertStatement
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class AssertStatementTest {


    @Test
    fun assert_withoutMessage_shouldReturnAssertStatement() {
        val statement = assert(dummyExpression("expression")).build() as AssertStatement

        assertEquals("assert expression;", statement.toInlineString())
    }

    @Test
    fun assert_withMessage_shouldReturnAssertStatement() {
        val statement = assert(dummyExpression("expression"), dummyExpression("message")).build() as AssertStatement

        assertEquals("assert expression : message;", statement.toInlineString())
    }


}