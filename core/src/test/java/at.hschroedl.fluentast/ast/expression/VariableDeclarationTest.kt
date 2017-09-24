package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.decl
import at.hschroedl.fluentast.test.dummyExpression
import at.hschroedl.fluentast.test.dummyVariableFragment
import at.hschroedl.fluentast.test.toInlineString
import at.hschroedl.fluentast.fragment
import org.eclipse.jdt.core.dom.VariableDeclarationExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class VariableDeclarationTest {

    @Test
    internal fun intVar_withInitializer_shouldReturnIntDeclaration() {
        val varDecl = decl("a", 1).build() as VariableDeclarationExpression

        assertEquals("int a=1", varDecl.toInlineString())
    }

    @Test
    internal fun boolVar_withInitializer_shouldReturnBooleanDeclaration() {
        val varDecl = decl("a", true).build() as VariableDeclarationExpression

        assertEquals("boolean a=true", varDecl.toInlineString())
    }

    @Test
    internal fun charVar_withInitializer_shouldReturnCharDeclaration() {
        val varDecl = decl("a", 'c').build() as VariableDeclarationExpression

        assertEquals("char a='c'", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withType_shouldReturnVariableDeclaration() {
        val varDecl = decl("Integer", "a").build() as VariableDeclarationExpression

        assertEquals("Integer a", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withTypeAndExpression_shouldReturnVariableDeclaration() {
        val varDecl = decl("Integer", fragment("a").init(
                dummyExpression("expression"))).build() as VariableDeclarationExpression

        assertEquals("Integer a=expression", varDecl.toInlineString())
    }

    @Test
    internal fun variable_withMultipleFragments_shouldReturnVariableDeclaration() {
        val varDecl = decl("Integer", dummyVariableFragment("a", 1),
                           dummyVariableFragment("b", 2),
                           dummyVariableFragment("c")).build() as VariableDeclarationExpression

        assertEquals("Integer a=1, b=2, c", varDecl.toInlineString())
    }


}