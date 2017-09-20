package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ParenthesizedExpression

class FluentParenthesizedExpression(private val expression: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): ParenthesizedExpression {
        val exp = ast.newParenthesizedExpression()
        exp.expression = expression.build(ast)
        return exp
    }
}

