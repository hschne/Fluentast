package at.hschroedl.fluentast

import at.hschroedl.fluentast.test.toInlineString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FluentPrimitiveVariableDeclarationTest {

    @Test
    internal fun intDecl_withInitializer_shouldReturnIntDeclaration() {
        val varDecl = `var`("a", 1).build()

        assertEquals("int a=1;", varDecl.toInlineString())
    }


    @Test
    internal fun intDecl_withoutValue_shouldReturnIntDeclaration() {
        val varDecl = intVar("a").build()

        assertEquals("int a;", varDecl.toInlineString())
    }

    @Test
    internal fun intDecl_withoutExpression_shouldReturnIntDeclaration() {
        val varDecl = intVar("a", exp()).build()

        assertEquals("int a=this;", varDecl.toInlineString())
    }

    @Test
    internal fun boolDecl_withName_shouldReturnBooleanDeclaration() {
        val varDecl = `var`("a", true).build()

        assertEquals("boolean a=true;", varDecl.toInlineString())
    }

    @Test
    internal fun boolDecl_withOutValue_shouldReturnBooleanDeclaration() {
        val varDecl = `var`("a", true).build()

        assertEquals("boolean a;", varDecl.toInlineString())
    }
}