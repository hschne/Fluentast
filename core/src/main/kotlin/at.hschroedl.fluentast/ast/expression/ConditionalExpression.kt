package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ConditionalExpression

class FluentConditionalExpression internal constructor(private val condition: FluentExpression,
                                                       private val then: FluentExpression,
                                                       private val `else`: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): ConditionalExpression {
        val exp = ast.newConditionalExpression()
        exp.expression = condition.build(ast)
        exp.thenExpression = then.build(ast)
        exp.elseExpression = `else`.build(ast)
        return exp
    }
}

