package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode

abstract class FluentStatement {

    abstract fun build(parent: FluentBlock): ASTNode
}

class FluentEmptyStatement : FluentStatement() {
    override fun build(parent: FluentBlock): ASTNode {
        return parent.ast.newEmptyStatement()
    }
}

class FluentReturnStatement : FluentStatement() {
    override fun build(parent: FluentBlock): ASTNode {
        return parent.ast.newReturnStatement();
    }

}

class FluentBreakStatement : FluentStatement() {
    override fun build(parent: FluentBlock): ASTNode {
        return parent.ast.newBreakStatement()
    }
}

fun b(): FluentStatement {
    return FluentBreakStatement()
}

fun r(): FluentStatement {
    return FluentReturnStatement()
}

fun e(): FluentStatement {
    return FluentEmptyStatement()
}

