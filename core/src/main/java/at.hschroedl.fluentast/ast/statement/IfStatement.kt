package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.IfStatement

class FluentIfStatement internal constructor(private val condition: FluentExpression, private val body: FluentStatement,
                                             private val elseBody: FluentStatement?) : FluentStatement() {
    override fun build(ast: AST): IfStatement {
        val statement = ast.newIfStatement()
        statement.expression = condition.build(ast)
        statement.thenStatement = body.build(ast)
        statement.elseStatement = elseBody?.build(ast)
        return statement
    }
}

