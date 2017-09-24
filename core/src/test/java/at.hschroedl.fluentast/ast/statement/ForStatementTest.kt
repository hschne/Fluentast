package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.for_
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.dummyStatement
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.ForStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ForStatementTest {
    @Test
    fun forStatement_withoutHeader_shouldReturnForStatement() {
        val statement = for_().body(dummyStatement("statement"))
                .build() as ForStatement

        assertEquals("for (; ; ) statement;", statement.toInlineString())

    }

    @Test
    fun forStatement_withSimpleHeader_shouldReturnForStatement() {
        val statement = for_(dummyExpression("init"), dummyExpression("expression"),
                             dummyExpression("update")).body(dummyStatement("statement"))
                .build() as ForStatement

        assertEquals("for (init; expression; update) statement;", statement.toInlineString())
    }

    @Test
    fun forStatement_withManyExpessions_shouldReturnForStatement() {
        val statement = for_().init(dummyExpression("init1")).init(dummyExpression("init2")).end(
                dummyExpression("expression")).update(dummyExpression("update1")).update(
                dummyExpression("update2")).body(dummyStatement("statement"))
                .build() as ForStatement

        assertEquals("for (init1, init2; expression; update1, update2) statement;",
                     statement.toInlineString())
    }
}