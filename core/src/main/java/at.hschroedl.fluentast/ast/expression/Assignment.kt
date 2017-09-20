package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Assignment

class FluentAssignment internal constructor(private val left: FluentExpression, private val operator: String,
                                            private val right: FluentExpression) : FluentExpression() {

    override fun build(ast: AST): Assignment {
        val exp = ast.newAssignment()
        exp.leftHandSide = left.build(ast)
        exp.operator = assignmentOperator(operator)
        exp.rightHandSide = right.build(ast)
        return exp
    }

    private fun assignmentOperator(operator: String): Assignment.Operator {
        return when (operator) {
            "=" -> Assignment.Operator.ASSIGN
            "+=" -> Assignment.Operator.PLUS_ASSIGN
            "-=" -> Assignment.Operator.MINUS_ASSIGN
            "*=" -> Assignment.Operator.TIMES_ASSIGN
            "/=" -> Assignment.Operator.DIVIDE_ASSIGN
            "&=" -> Assignment.Operator.BIT_AND_ASSIGN
            "|=" -> Assignment.Operator.BIT_OR_ASSIGN
            "^=" -> Assignment.Operator.BIT_XOR_ASSIGN
            "%=" -> Assignment.Operator.REMAINDER_ASSIGN
            "<<=" -> Assignment.Operator.LEFT_SHIFT_ASSIGN
            ">>=" -> Assignment.Operator.RIGHT_SHIFT_SIGNED_ASSIGN
            ">>>=" -> Assignment.Operator.RIGHT_SHIFT_UNSIGNED_ASSIGN
            else -> throw FluentArgumentException(
                    "Invalid assignment operator '$operator.'")
        }
    }
}

