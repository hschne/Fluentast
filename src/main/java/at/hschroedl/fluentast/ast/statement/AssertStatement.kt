package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.AssertStatement

class FluentAssertStatement internal constructor(private val expression: FluentExpression,
                                                 private val message: FluentExpression? = null) : FluentStatement() {
    override fun build(ast: AST): AssertStatement {
        val assert = ast.newAssertStatement()
        assert.expression = expression.build(ast)
        assert.message = message?.build(ast)
        return assert
    }
}

fun assert(expression: FluentExpression): FluentAssertStatement {
    return FluentAssertStatement(expression)
}

fun assert(expression: FluentExpression, message: FluentExpression): FluentAssertStatement {
    return FluentAssertStatement(expression, message)
}