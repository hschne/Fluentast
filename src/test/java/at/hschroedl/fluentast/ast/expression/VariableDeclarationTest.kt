package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.VariableDeclarationStatement
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class VariableDeclarationTest {

    @Test
    internal fun intVar_withInitializer_shouldReturnIntDeclaration() {
        val varDecl = `var`("a", 1).build() as VariableDeclarationStatement

        assertEquals("int a=1;", varDecl.toInlineString())
    }

    @Test
    internal fun boolVar_withInitializer_shouldReturnBooleanDeclaration() {
        val varDecl = `var`("a", true).build() as VariableDeclarationStatement

        assertEquals("boolean a=true;", varDecl.toInlineString())
    }

    @Test
    internal fun charVar_withInitializer_shouldReturnCharDeclaration() {
        val varDecl = `var`("a", 'c').build() as VariableDeclarationStatement

        assertEquals("char a='c';", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withType_shouldReturnVariableDeclaration() {
        val varDecl = `var`("Integer", "a").build() as VariableDeclarationStatement

        assertEquals("Integer a;", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withTypeAndExpression_shouldReturnVariableDeclaration() {
        val varDecl = `var`("Integer", "a", dummyExpression("expression")).build() as VariableDeclarationStatement

        assertEquals("Integer a=expression;", varDecl.toInlineString())
    }
}