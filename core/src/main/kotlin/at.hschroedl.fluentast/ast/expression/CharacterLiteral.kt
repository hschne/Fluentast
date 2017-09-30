package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.BooleanLiteral
import org.eclipse.jdt.core.dom.CharacterLiteral

/**
 * Used to build a [CharacterLiteral] with a given character value.
 */
class FluentCharacterLiteral internal constructor(private val literal: Char) : FluentLiteral() {
    override fun build(ast: AST): CharacterLiteral {
        val char = ast.newCharacterLiteral()
        char.setCharValue(literal)
        return char
    }
}

