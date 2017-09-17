package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayType
import org.eclipse.jdt.core.dom.PrimitiveType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class FluentTypeTest {

    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }

    @Test
    internal fun primitiveType_withInt_shouldReturnInt() {
        val result = FluentPrimitiveType(
                FluentPrimitive.INT).build(ast) as PrimitiveType

        assertEquals(PrimitiveType.INT, result.primitiveTypeCode)
    }

    @Test
    internal fun primitiveType_withChar_shouldReturnChar() {
        val result = FluentPrimitiveType(
                FluentPrimitive.CHAR).build(ast) as PrimitiveType

        assertEquals(PrimitiveType.CHAR, result.primitiveTypeCode)
    }

    @Test
    internal fun primitiveType_withBool_shouldReturnBoolean() {
        val result = FluentPrimitiveType(
                FluentPrimitive.BOOL).build(ast) as PrimitiveType

        assertEquals(PrimitiveType.BOOLEAN, result.primitiveTypeCode)
    }

    @Test
    internal fun arrayType_withExtraDimensions_returnsArrayType() {
        val result = FluentArrayType(type("MyType"), 3).build(ast) as ArrayType

        assertEquals("MyType[][][]", result.toInlineString())
    }

    @Test
    internal fun arrayType_withSingleDimension_returnsArrayType() {
        val result = FluentArrayType(type("MyType")).build(ast) as ArrayType

        assertEquals("MyType[]", result.toInlineString())
    }

    @Test
    internal fun arrayType_withNegativeDimension_throwsException() {
        assertFailsWith(FluentArgumentException::class) {
            FluentArrayType(type("MyType"), -3).build(ast)
        }
    }

}

