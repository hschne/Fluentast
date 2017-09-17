package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression


abstract class FluentLiteral : FluentExpression()

internal class FluentNumberLiteral(private val literal: Int) : FluentLiteral() {
    override fun build(ast: AST): Expression {
        return ast.newNumberLiteral(literal.toString())
    }
}

internal class FluentBooleanLiteral(private val literal: Boolean) : FluentLiteral() {
    override fun build(ast: AST): Expression {
        return ast.newBooleanLiteral(literal)
    }
}

internal class FluentCharLiteral(private val literal: Char) : FluentLiteral() {
    override fun build(ast: AST): Expression {
        val charLiteral = ast.newCharacterLiteral()
        charLiteral.setCharValue(literal)
        return charLiteral
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