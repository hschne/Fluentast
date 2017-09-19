package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.BooleanLiteral

class FluentBooleanLiteral internal constructor(private val literal: Boolean) : FluentLiteral() {
    override fun build(ast: AST): BooleanLiteral {
        return ast.newBooleanLiteral(literal)
    }
}

fun b(value: Boolean): FluentBooleanLiteral {
    return FluentBooleanLiteral(value)
}