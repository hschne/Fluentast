package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression
import org.eclipse.jdt.core.dom.InfixExpression

class FluentInfixExpression internal constructor(private val left: FluentExpression, private val operator: String,
                                                 private vararg val right: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newInfixExpression()
        exp.leftOperand = left.build(ast)
        exp.operator = infixOperator(operator)
        if (right.isEmpty()) {
            throw FluentArgumentException("Infix must have at least one right-hand-side expression.")
        }
        exp.rightOperand = right.first().build(ast)
        exp.extendedOperands().addAll(right.drop(1).map { it.build(ast) })
        return exp
    }

    private fun infixOperator(operator: String): InfixExpression.Operator {
        return when (operator) {
            "*" -> InfixExpression.Operator.TIMES
            "/" -> InfixExpression.Operator.DIVIDE
            "%" -> InfixExpression.Operator.REMAINDER
            "+" -> InfixExpression.Operator.PLUS
            "-" -> InfixExpression.Operator.MINUS
            "<<" -> InfixExpression.Operator.LEFT_SHIFT
            ">>" -> InfixExpression.Operator.RIGHT_SHIFT_SIGNED
            ">>>" -> InfixExpression.Operator.RIGHT_SHIFT_UNSIGNED
            "<" -> InfixExpression.Operator.LESS
            ">" -> InfixExpression.Operator.GREATER
            "<=" -> InfixExpression.Operator.LESS_EQUALS
            ">=" -> InfixExpression.Operator.GREATER_EQUALS
            "==" -> InfixExpression.Operator.EQUALS
            "!=" -> InfixExpression.Operator.NOT_EQUALS
            "^" -> InfixExpression.Operator.XOR
            "&" -> InfixExpression.Operator.AND
            "|" -> InfixExpression.Operator.OR
            "&&" -> InfixExpression.Operator.CONDITIONAL_AND
            "||" -> InfixExpression.Operator.CONDITIONAL_OR
            else -> throw FluentArgumentException("Invalid infix operator '$operator.'")
        }
    }
}

fun infix(left: FluentExpression, operator: String, vararg right: FluentExpression): FluentInfixExpression {
    return FluentInfixExpression(left, operator, *right)
}
