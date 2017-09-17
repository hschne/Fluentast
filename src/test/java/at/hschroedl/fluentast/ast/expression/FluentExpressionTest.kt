package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentParseException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayAccess
import org.eclipse.jdt.core.dom.ArrayInitializer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class FluentExpressionTest {


    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }

    @Test
    internal fun parse_withString_shouldReturnExpression() {
        var expression = exp("new Integer()").build()

        assertEquals("new Integer()", expression.toInlineString())
    }

    @Test
    internal fun parse_withMalformedString_shouldThrowException() {
        assertFailsWith(FluentParseException::class) {
            exp("new Invalid!").build()
        }
    }

    @Test
    internal fun arrayAccess_withExpressions_returnsArrayAccessWithExpressions() {
        val expression = FluentArrayAccessExpression(exp("test"), n(1)).build() as ArrayAccess

        assertEquals("test[1]", expression.toInlineString())
    }

    @Test
    internal fun arrayInitializer_withNumbers_returnsArrayInitializerWithNumbers() {
        val expression = FluentArrayInitializer(n(1), n(2), n(3)).build() as ArrayInitializer

        assertEquals("{1,2,3}", expression.toInlineString())
    }
}