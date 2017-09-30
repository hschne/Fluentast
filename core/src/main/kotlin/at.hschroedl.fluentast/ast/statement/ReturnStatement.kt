package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.if_
import at.hschroedl.fluentast.return_
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.IfStatement
import org.eclipse.jdt.core.dom.ReturnStatement
import org.eclipse.jdt.core.dom.Statement

/**
 * Used to construct a [ReturnStatement] with a given expression.
 *
 * For examples and usage see [return_].
 *
 */
class FluentReturnStatement internal constructor(
        private val expression: FluentExpression?) : FluentStatement() {

    override fun build(ast: AST): ReturnStatement {
        val ret = ast.newReturnStatement()
        ret.expression = expression?.build(ast)
        return ret
    }
}