package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.InfixExpression

// TODO: Use static import parameters GEQ, LEQ etc.
/**
 * Used to build an [InfixExpression] with a left operand, an operator and a right operand.
 */
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

    /**
     * Adds a [FluentExpression] to the list of extended operands on the right hand side
     * of the operator.
     *
     * @param anotherExpression expression on the right side of operator.
     * @return this [FluentInfixExpression] with another right hand side operand.
     */
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

}

/**
 * Used to build an [InfixExpression]. This partial represents an intermediate
 * representation where an operator and left-hand-side operand has been set
 * but a right-hand side operand is missing.
 */
class FluentInfixLeftPartial internal constructor(private val operator: String,
                                                  private val leftExpression: FluentExpression) {

    /**
     * Creates a [FluentInfixExpression] by adding an expression to the right-hand side
     * of this partial.
     *
     * @param rightExpression expression on the right-hand side.
     * @return a new [FluentInfixExpression].
     */
    fun right(rightExpression: FluentExpression): FluentInfixExpression {
        return FluentInfixExpression(operator, leftExpression,
                                     mutableListOf(rightExpression))
    }

}

/**
 * Used to build an [InfixExpression]. This partial represents an intermediate
 * representation where the operator has been set
 * but a right-hand side and left-hand-side operand are missing.
 */
class FluentInfixOperatorPartial internal constructor(private val operator: String) {

    /**
     * Creates a [FluentInfixLeftPartial] by adding a left-hand-side operand to the infix.
     *
     * @param expression expression on the left-hand side.
     * @return a new [FluentInfixLeftPartial].
     */
    fun left(expression: FluentExpression): FluentInfixLeftPartial {
        return FluentInfixLeftPartial(operator, expression)

    }
}


