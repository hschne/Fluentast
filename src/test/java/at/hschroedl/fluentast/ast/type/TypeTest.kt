package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.SimpleType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TypeTest {

    private lateinit var ast: AST

    @BeforeEach
    internal fun setUp() {
        ast = AST.newAST(AST.JLS8)
    }

    @Test
    internal fun type_withString_shouldReturnTypeWithName() {
        val result = t("test1.Typename").build(ast) as SimpleType

        assertEquals("test1.Typename", result.toInlineString())
    }


}

