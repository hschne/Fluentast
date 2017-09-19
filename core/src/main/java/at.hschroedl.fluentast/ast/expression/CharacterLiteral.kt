package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.CharacterLiteral

class FluentCharacterLiteral internal constructor(private val literal: Char) : FluentLiteral() {
    override fun build(ast: AST): CharacterLiteral {
        val char = ast.newCharacterLiteral()
        char.setCharValue(literal)
        return char
    }
}

fun c(value: Char): FluentCharacterLiteral {
    return FluentCharacterLiteral(value)
}