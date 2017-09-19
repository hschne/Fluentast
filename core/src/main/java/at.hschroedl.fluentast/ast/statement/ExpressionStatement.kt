package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ExpressionStatement
import org.eclipse.jdt.core.dom.PrefixExpression
import org.eclipse.jdt.core.dom.Statement

class FluentExpressionStatement(private val expression: FluentExpression) : FluentStatement() {
    override fun build(ast: AST): ExpressionStatement {
        return ast.newExpressionStatement(expression.build(ast))
    }
}

fun stmnt(expression: FluentExpression): FluentExpressionStatement {
    return FluentExpressionStatement(expression)
}