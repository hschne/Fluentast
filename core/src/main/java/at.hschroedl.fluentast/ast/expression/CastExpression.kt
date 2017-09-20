package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.CastExpression

class FluentCastExpression internal constructor(private val type: FluentType?,
                                                private val expression: FluentExpression) : FluentExpression() {

    override fun build(ast: AST): CastExpression {
        val exp = ast.newCastExpression()
        exp.type = type?.build(ast)
        exp.expression = expression.build(ast)
        return exp
    }
}

