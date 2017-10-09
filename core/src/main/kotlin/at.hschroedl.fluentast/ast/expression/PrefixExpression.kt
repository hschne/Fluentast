package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.PrefixExpression

class FluentPrefixExpression internal constructor(private val operator: String,
                             private val expression: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): PrefixExpression {
        val exp = ast.newPrefixExpression()
        exp.operand = expression.build(ast)
        exp.operator = prefixOperator(operator)
        return exp
    }

    private fun prefixOperator(operator: String): PrefixExpression.Operator {
        return when (operator) {
            "++" -> PrefixExpression.Operator.INCREMENT
            "--" -> PrefixExpression.Operator.DECREMENT
            "+" -> PrefixExpression.Operator.PLUS
            "-" -> PrefixExpression.Operator.MINUS
            "~" -> PrefixExpression.Operator.COMPLEMENT
            "!" -> PrefixExpression.Operator.NOT
            else -> throw FluentArgumentException(
                    "Invalid postfix operator '$operator.'")
        }
    }
}

