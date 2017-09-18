package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression

class FluentNullLiteral() : FluentExpression() {
    override fun build(ast: AST): Expression {
        return ast.newNullLiteral()
    }
}

fun nullz(): FluentNullLiteral {
    return FluentNullLiteral()
}