package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.break_
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.BreakStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BreakStatementTest {
    @Test
    fun breakStatement_justBreak_shouldReturnBreakStatement() {
        val statement = break_().build() as BreakStatement

        assertEquals("break;", statement.toInlineString())
    }
}