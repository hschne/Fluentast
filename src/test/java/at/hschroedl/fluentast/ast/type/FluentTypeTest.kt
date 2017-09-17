package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.ast.expression.n
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayType
import org.eclipse.jdt.core.dom.PrimitiveType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class FluentTypeTest {

    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }

    @Test
    internal fun build_intType_shouldReturnInt() {
        val result = FluentPrimitiveType(
                FluentPrimitive.INT).build(ast) as PrimitiveType

        assertEquals(PrimitiveType.INT, result.primitiveTypeCode)
    }

    @Test
    internal fun build_charType_shouldReturnInt() {
        val result = FluentPrimitiveType(
                FluentPrimitive.CHAR).build(ast) as PrimitiveType

        assertEquals(PrimitiveType.CHAR, result.primitiveTypeCode)
    }

    @Test
    internal fun build_primitiveInt_shouldReturnInt() {
        val result = FluentPrimitiveType(
                FluentPrimitive.BOOL).build(ast) as PrimitiveType

        assertEquals(PrimitiveType.BOOLEAN, result.primitiveTypeCode)
    }

    @Test
    internal fun arrayType_withParameters_returnsArrayType() {
        val result = FluentArrayType(type("MyType"),1,2,3).build(ast) as ArrayType

        assertEquals("test[1][2][3]", result.toInlineString())
    }
}

