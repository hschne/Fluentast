package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.*


abstract class FluentLiteral : FluentExpression()

internal class FluentNumberLiteral(private val literal: Int) : FluentLiteral() {
    override fun build(ast: AST): NumberLiteral {
        return ast.newNumberLiteral(literal.toString())
    }
}

internal class FluentBooleanLiteral(private val literal: Boolean) : FluentLiteral() {
    override fun build(ast: AST): BooleanLiteral {
        return ast.newBooleanLiteral(literal)
    }
}

internal class FluentCharLiteral(private val literal: Char) : FluentLiteral() {
    override fun build(ast: AST): CharacterLiteral {
        val charLiteral = ast.newCharacterLiteral()
        charLiteral.setCharValue(literal)
        return charLiteral
    }
}

class FluentNullLiteral() : FluentExpression() {
    override fun build(ast: AST): Expression {
        return ast.newNullLiteral()
    }
}

class FluentStringLiteral(private val literalValue: String) : FluentExpression() {
    override fun build(ast: AST): StringLiteral {
        val stringLiteral = ast.newStringLiteral()
        stringLiteral.literalValue = literalValue
        return stringLiteral
    }
}

class FluentTypeLiteral(private val type: FluentType) : FluentExpression() {
    override fun build(ast: AST): TypeLiteral {
        val typeLiteral = ast.newTypeLiteral()
        typeLiteral.type = type.build(ast)
        return typeLiteral
    }
}

fun n(number: Int): FluentLiteral {
    return FluentNumberLiteral(number)
}

fun b(boolean: Boolean): FluentLiteral {
    return FluentBooleanLiteral(boolean)
}

fun c(char: Char): FluentLiteral {
    return FluentCharLiteral(char)
}