package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.AST
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PrimitiveTypeTest {
    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }

    @ParameterizedTest(name = "Create primtive type '{0}")
    @ValueSource(strings = arrayOf("byte", "short", "char", "int", "long", "float", "double", "boolean", "void"))
    internal fun primitiveType_withInt_shouldReturnInt(type: String) {
        val result = FluentPrimitiveType(type).build(ast)

        assertEquals(type, result.toInlineString())
    }

}