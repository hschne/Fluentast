package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.PostfixExpression

class FluentPostfixExpression internal constructor(private val expression: FluentExpression,
                                                   private val operator: String) : FluentExpression() {
    override fun build(ast: AST): PostfixExpression {
        val exp = ast.newPostfixExpression()
        exp.operand = expression.build(ast)
        exp.operator = postfixOperator(operator)
        return exp
    }

    private fun postfixOperator(operator: String): PostfixExpression.Operator {
        return when (operator) {
            "++" -> PostfixExpression.Operator.INCREMENT
            "--" -> PostfixExpression.Operator.DECREMENT
            else -> throw FluentArgumentException(
                    "Invalid postfix operator '$operator.'")
        }
    }

    class PostfixPartial(private val operator: String) {

        fun operand(expression: FluentExpression): FluentPostfixExpression {
            return FluentPostfixExpression(expression, operator)
        }
    }
}

