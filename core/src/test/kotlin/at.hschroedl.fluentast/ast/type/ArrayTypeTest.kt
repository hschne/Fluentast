package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.t
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class ArrayTypeTest {

    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }


    @Test
    internal fun arrayType_withSingleDimension_returnsArrayType() {
        val result = FluentArrayType(t("MyType")).build(ast) as ArrayType

        assertEquals("MyType[]", result.toInlineString())
    }


    @Test
    internal fun arrayType_withExtraDimensions_returnsArrayType() {
        val result = FluentArrayType(t("MyType"), 3).build(ast) as ArrayType

        assertEquals("MyType[][][]", result.toInlineString())
    }

    @Test
    internal fun arrayType_withNegativeDimension_throwsException() {
        assertFailsWith(FluentArgumentException::class) {
            FluentArrayType(t("MyType"), -3).build(ast)
        }
    }
}