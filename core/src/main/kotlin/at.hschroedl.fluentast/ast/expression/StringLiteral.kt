package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.StringLiteral

class FluentStringLiteral internal constructor(private val literalValue: String) : FluentExpression() {
    override fun build(ast: AST): StringLiteral {
        val stringLiteral = ast.newStringLiteral()
        stringLiteral.literalValue = literalValue
        return stringLiteral
    }
}

