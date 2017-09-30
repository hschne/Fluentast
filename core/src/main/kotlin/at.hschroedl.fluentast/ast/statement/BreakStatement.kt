package at.hschroedl.fluentast.ast.statement

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.BreakStatement

/**
 * Used to build a [BreakStatement].
 */
class FluentBreakStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): BreakStatement {
        return ast.newBreakStatement()
    }
}