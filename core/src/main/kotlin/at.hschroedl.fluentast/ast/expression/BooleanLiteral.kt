package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayAccess
import org.eclipse.jdt.core.dom.BooleanLiteral

/**
 * Used to build a [BooleanLiteral] with a given value.
 */
class FluentBooleanLiteral internal constructor(private val literal: Boolean) : FluentLiteral() {
    override fun build(ast: AST): BooleanLiteral {
        return ast.newBooleanLiteral(literal)
    }
}

