package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Statement

class FluentReturnStatement(private val expression: FluentExpression?) : FluentStatement() {

    override fun build(ast: AST): Statement {
        val ret = ast.newReturnStatement()
        ret.expression = expression?.build(ast)
        return ret
    }
}