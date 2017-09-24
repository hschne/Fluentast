package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.null_
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.NullLiteral
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class NullLiteralTest {

    @Test
    internal fun nullLiteral_shouldCreateNullLiteral() {
        val nulz = null_().build() as NullLiteral

        assertEquals("null", nulz.toInlineString())
    }
}