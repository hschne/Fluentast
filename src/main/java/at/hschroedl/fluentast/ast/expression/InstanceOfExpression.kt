package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression

class FluentInstanceOfExpression(private val left: FluentExpression,
                                 private val right: FluentType) : FluentExpression() {
    override fun build(ast: AST): Expression {
        val exp = ast.newInstanceofExpression()
        exp.leftOperand = left.build(ast)
        exp.rightOperand = right.build(ast)
        return exp
    }
}

fun instanceof(left: FluentExpression, right: FluentType): FluentInstanceOfExpression {
    return FluentInstanceOfExpression(left, right)
}