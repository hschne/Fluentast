package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.FluentVariableDeclarationFragment
import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.VariableDeclarationStatement

class FluentVariableDeclarationStatement internal constructor(private val type: FluentType,
                                                              private vararg val fragments: FluentVariableDeclarationFragment) : FluentStatement() {
    override fun build(ast: AST): VariableDeclarationStatement {
        throw NotImplementedError()
    }
}
