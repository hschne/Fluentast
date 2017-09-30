package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.StringLiteral

/**
 * Used to build a [StringLiteral] with a given value.
 */
class FluentStringLiteral internal constructor(private val literalValue: String) : FluentExpression() {
    override fun build(ast: AST): StringLiteral {
        val stringLiteral = ast.newStringLiteral()
        stringLiteral.literalValue = literalValue
        return stringLiteral
    }
}

