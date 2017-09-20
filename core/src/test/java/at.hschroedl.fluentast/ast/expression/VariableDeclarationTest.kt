package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.`var`
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.VariableDeclarationExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class VariableDeclarationTest {

    @Test
    internal fun intVar_withInitializer_shouldReturnIntDeclaration() {
        val varDecl = `var`("a", 1).build() as VariableDeclarationExpression

        assertEquals("int a=1", varDecl.toInlineString())
    }

    @Test
    internal fun boolVar_withInitializer_shouldReturnBooleanDeclaration() {
        val varDecl = `var`("a", true).build() as VariableDeclarationExpression

        assertEquals("boolean a=true", varDecl.toInlineString())
    }

    @Test
    internal fun charVar_withInitializer_shouldReturnCharDeclaration() {
        val varDecl = `var`("a", 'c').build() as VariableDeclarationExpression

        assertEquals("char a='c'", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withType_shouldReturnVariableDeclaration() {
        val varDecl = `var`("Integer", "a").build() as VariableDeclarationExpression

        assertEquals("Integer a", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withTypeAndExpression_shouldReturnVariableDeclaration() {
        val varDecl = `var`("Integer", "a", dummyExpression("expression")).build() as VariableDeclarationExpression

        assertEquals("Integer a=expression", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withMultipleFragments_shouldReturnVariableDeclaration() {
        val varDecl = vars("Integer", Pair("a", dummyExpression("expression")),
                Pair("b", dummyExpression("expression"))).build() as VariableDeclarationExpression

        assertEquals("Integer a=expression, b=expression", varDecl.toInlineString())
    }
}