package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.WhileStatement

class FluentWhileStatement internal constructor(private val condition: FluentExpression,
                                                private val body: FluentStatement) : FluentStatement() {
    override fun build(ast: AST): WhileStatement {
        val statement = ast.newWhileStatement()
        statement.expression = condition.build(ast)
        statement.body = body.build(ast)
        return statement
    }
}

fun whilez(condition: FluentExpression, body: FluentStatement): FluentWhileStatement {
    return FluentWhileStatement(condition, body)
}