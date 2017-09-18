package at.hschroedl.fluentast.ast.type

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.PrimitiveType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PrimitiveTypeTest {
    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }

    @Test
    internal fun primitiveType_withInt_shouldReturnInt() {
        val result = FluentPrimitiveType(
                FluentPrimitive.INT).build(ast)

        assertEquals(PrimitiveType.INT, result.primitiveTypeCode)
    }

    @Test
    internal fun primitiveType_withChar_shouldReturnChar() {
        val result = FluentPrimitiveType(
                FluentPrimitive.CHAR).build(ast)

        assertEquals(PrimitiveType.CHAR, result.primitiveTypeCode)
    }

    @Test
    internal fun primitiveType_withBool_shouldReturnBoolean() {
        val result = FluentPrimitiveType(
                FluentPrimitive.BOOL).build(ast)

        assertEquals(PrimitiveType.BOOLEAN, result.primitiveTypeCode)
    }
}