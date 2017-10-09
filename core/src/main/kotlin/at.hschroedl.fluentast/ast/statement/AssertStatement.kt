package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.AssertStatement

/**
 * Used to build an [AssertStatement] on the given expression with an optional message.
 */
class FluentAssertStatement internal constructor(private val expression: FluentExpression,
                                                 private val message: FluentExpression? = null) : FluentStatement() {
    override fun build(ast: AST): AssertStatement {
        val assert = ast.newAssertStatement()
        assert.expression = expression.build(ast)
        assert.message = message?.build(ast)
        return assert
    }
}
