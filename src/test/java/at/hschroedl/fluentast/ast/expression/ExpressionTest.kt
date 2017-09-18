package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.ast.type.FluentArrayType
import at.hschroedl.fluentast.ast.type.type
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class ExpressionTest {


    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }

    @Test
    internal fun parse_withString_shouldReturnExpression() {
        val expression = exp("new Integer()").build()

        assertEquals("new Integer()", expression.toInlineString())
    }

    @Test
    internal fun parse_withMalformedString_shouldThrowException() {
        assertFailsWith(FluentArgumentException::class) {
            exp("new Invalid!").build()
        }
    }


    @Test
    internal fun cast_withType_returnsTypeCast() {
        val expression = cast(type("Integer"), n(1)).build() as CastExpression

        assertEquals("(Integer)1", expression.toInlineString())
    }

    @Test
    internal fun conditionalExpression_withTypes_returnsConditionalExpression() {
        val expression = ternary(b(true), n(1), n(2)).build() as ConditionalExpression

        assertEquals("true ? 1 : 2", expression.toInlineString())
    }

    @Test
    internal fun fieldAccess_withExpression_returnsConditionalExpression() {
        val expression = fieldAccess(exp("Integer"), "myField").build() as FieldAccess

        assertEquals("Integer.myField", expression.toInlineString())
    }

    @Test
    internal fun infixExpression_withExpression_returnsConditionalExpression() {
        val expression = infix(exp("i"), "==", thiss()).build() as InfixExpression

        assertEquals("i == this", expression.toInlineString())
    }

    //TODO: Add rest of infix tests
}