package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression

class FluentNullLiteral internal constructor(): FluentExpression() {
    override fun build(ast: AST): Expression {
        return ast.newNullLiteral()
    }
}

