package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayAccess

/**
 * Used to build an [ArrayAccess] on a given expression and a index. Both are a
 * [FluentExpression].
 */
class FluentArrayAccess internal constructor(private val array: FluentExpression,
                                             private val index: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): ArrayAccess {
        val exp = ast.newArrayAccess()
        exp.array = array.build(ast)
        exp.index = index.build(ast)
        return exp
    }
}

