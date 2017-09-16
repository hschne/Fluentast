package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.ast.*
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.VariableDeclarationStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FluentPrimitiveVariableDeclarationTest {

    @Test
    internal fun intVar_withInitializer_shouldReturnIntDeclaration() {
        val varDecl = `var`("a", 1).build() as VariableDeclarationStatement

        assertEquals("int a=1;", varDecl.toInlineString())
    }


    @Test
    internal fun intVar_withoutInitializer_shouldReturnIntDeclaration() {
        val varDecl = intVar("a").build() as VariableDeclarationStatement

        assertEquals("int a;", varDecl.toInlineString())
    }

    @Test
    internal fun intVar_withExpression_shouldReturnIntDeclaration() {
        val varDecl = intVar("a", exp()).build() as VariableDeclarationStatement

        assertEquals("int a=this;", varDecl.toInlineString())
    }

    @Test
    internal fun boolVar_withInitializer_shouldReturnBooleanDeclaration() {
        val varDecl = `var`("a", true).build() as VariableDeclarationStatement

        assertEquals("boolean a=true;", varDecl.toInlineString())
    }

    @Test
    internal fun boolVar_withoutInitializer_shouldReturnBooleanDeclaration() {
        val varDecl = boolVar("a").build() as VariableDeclarationStatement

        assertEquals("boolean a;", varDecl.toInlineString())
    }

    @Test
    internal fun boolVar_withExpression_shouldReturnBooleanDeclaration() {
        val varDecl = boolVar("a", exp()).build() as VariableDeclarationStatement

        assertEquals("boolean a=this;", varDecl.toInlineString())
    }

    @Test
    internal fun charVar_withInitializer_shouldReturnCharDeclaration() {
        val varDecl = `var`("a", 'c').build() as VariableDeclarationStatement

        assertEquals("char a='c';", varDecl.toInlineString())
    }

    @Test
    internal fun charVar_withoutInitializer_shouldReturnCharDeclaration() {
        val varDecl = charVar("a").build() as VariableDeclarationStatement

        assertEquals("char a;", varDecl.toInlineString())
    }

    @Test
    internal fun charVar_withExpression_shouldReturnCharDeclaration() {
        val varDecl = charVar("a", exp()).build() as VariableDeclarationStatement

        assertEquals("char a=this;", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withType_shouldReturnVariableDeclaration() {
        val varDecl = `var`("Integer", "a").build() as VariableDeclarationStatement

        assertEquals("Integer a;", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withTypeAndExpression_shouldReturnVariableDeclaration() {
        val varDecl = `var`("Integer", "a", exp()).build() as VariableDeclarationStatement

        assertEquals("Integer a=this;", varDecl.toInlineString())
    }
}