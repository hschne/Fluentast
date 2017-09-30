package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.NumberLiteral

/**
 * Used to build a [NumberLiteral] with a given integer value.
 */
class FluentNumberLiteral internal constructor(private val literal: Int) : FluentLiteral() {
    override fun build(ast: AST): NumberLiteral {
        return ast.newNumberLiteral(literal.toString())
    }
}

