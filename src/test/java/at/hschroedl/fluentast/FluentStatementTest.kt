package at.hschroedl.fluentast

import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.Block
import org.eclipse.jdt.core.dom.Statement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class FluentStatementTest {

    @Test
    fun statement_withString_shouldReturnStatement() {
        val statement = body("int i;int j;int k;").build() as Statement

        Assertions.assertEquals("{int i;int j;int k;}", statement.toInlineString())
    }

    @Test
    internal fun statement_withInvalidString_shouldThrowException() {
        assertFailsWith(FluentParseException::class) {
            s("vargl di bargle!").build()
        }
    }

}