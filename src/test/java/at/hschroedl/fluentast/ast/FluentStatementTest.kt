package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentParseException
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
         assertFailsWith(FluentParseException::class) {
            s("int i;int j; int k;").build()
        }
    }

    @Test
    internal fun statement_withInvalidString_shouldThrowException() {
        assertFailsWith(FluentParseException::class) {
            s("vargl di bargle!").build()
        }
    }

}