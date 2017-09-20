package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.body
import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.Statement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class FluentStatementTest {

    @Test
    fun statement_withString_shouldReturnStatement() {
        val statement = body("Integer i=15;").build() as Statement

        Assertions.assertEquals("{Integer i=15;}", statement.toInlineString())
    }

    @Test
    fun statement_withMultipleLines_shouldThrowException() {
        assertFailsWith(FluentArgumentException::class) {
            stmnt("int i;int j; int k;").build()
        }
    }

    @Test
    internal fun statement_withInvalidString_shouldThrowException() {
        assertFailsWith(FluentArgumentException::class) {
            stmnt("vargl di bargle!").build()
        }
    }

}