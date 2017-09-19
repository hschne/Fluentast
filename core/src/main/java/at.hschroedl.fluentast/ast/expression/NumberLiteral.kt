package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.NumberLiteral

class FluentNumberLiteral internal constructor(private val literal: Int) : FluentLiteral() {
    override fun build(ast: AST): NumberLiteral {
        return ast.newNumberLiteral(literal.toString())
    }
}

fun i(value: Int): FluentNumberLiteral {
    return FluentNumberLiteral(value)
}