package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.IfStatement

open class FluentIfStatement internal constructor(protected val condition: FluentExpression,
                                                  protected val body: FluentStatement,
                                                  private val elseBody: FluentStatement? = null) : FluentStatement() {


    override fun build(ast: AST): IfStatement {
        val statement = ast.newIfStatement()
        statement.expression = condition.build(ast)
        statement.thenStatement = body.build(ast)
        statement.elseStatement = elseBody?.build(ast)
        return statement
    }

    fun elsez(statement: FluentStatement): FluentIfStatement {
        return FluentIfStatement(condition, body, statement)
    }


    class IfPartial internal constructor(private val condition: FluentExpression) {

        fun then(statement: FluentStatement): FluentIfStatement {
            return FluentIfStatement(condition, statement)
        }
    }

}
