package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.NullLiteral

/**
 * Used to build a [NullLiteral].
 */
class FluentNullLiteral internal constructor(): FluentExpression() {
    override fun build(ast: AST): NullLiteral {
        return ast.newNullLiteral()
    }
}

