package at.hschroedl.fluentast.ast.statement

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Statement

class FluenVariableDeclarationStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}