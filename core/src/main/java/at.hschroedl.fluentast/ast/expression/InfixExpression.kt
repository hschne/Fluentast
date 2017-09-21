package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.InfixExpression

//TODO: Use static import parameters GEQ, LEQ etc.
open class FluentInfixExpression internal constructor(protected val operator: String,
                                                      private val left: FluentExpression,
                                                      private val right: MutableCollection<FluentExpression>) : FluentExpression() {
    override fun build(ast: AST): InfixExpression {
        val exp = ast.newInfixExpression()
        exp.leftOperand = left.build(ast)
        exp.operator = infixOperator(operator)
        if (right.isEmpty()) {
            throw FluentArgumentException(
                    "Infix must have at least one right-hand-side expression.")
        }
        exp.rightOperand = right.first().build(ast)
        exp.extendedOperands().addAll(right.drop(1).map { it.build(ast) })
        return exp
    }

    fun right(anotherExpression: FluentExpression): FluentInfixExpression {
        right.add(anotherExpression)
        return this
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
            else -> throw FluentArgumentException(
                    "Invalid infix operator '$operator.'")
        }
    }

    class OperatorPartial internal constructor(private val operator: String) {

        fun left(expression: FluentExpression): LeftPartial {
            return LeftPartial(operator, expression)

        }
    }

    class LeftPartial internal constructor(private val operator: String,
                                           private val leftExpression: FluentExpression) {

        fun right(rightExpression: FluentExpression): FluentInfixExpression {
            return FluentInfixExpression(operator, leftExpression,
                                         mutableListOf(rightExpression))
        }

    }


}


