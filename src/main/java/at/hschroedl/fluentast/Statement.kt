package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.Expression

abstract class FluentStatement {

    var ast = AST.newAST(AST.JLS8)

    abstract fun build(parent: FluentBlock): ASTNode
}

class FluentEmptyStatement : FluentStatement() {
    override fun build(parent: FluentBlock): ASTNode {
        ast = parent.ast;
        return parent.ast.newEmptyStatement()
    }
}

class FluentReturnStatement : FluentStatement {

    private var expression: FluentExpression? = null

    constructor()

    constructor(expression: FluentExpression) : this() {
        this.expression = expression
    }

    override fun build(parent: FluentBlock): ASTNode {
        ast = parent.ast
        val ret = ast.newReturnStatement()
        if (expression != null) {
            ret.expression = expression?.build(this) as Expression?
        }
        return ret
    }


}

class FluentBreakStatement : FluentStatement() {
    override fun build(parent: FluentBlock): ASTNode {
        ast = parent.ast;
        return parent.ast.newBreakStatement()
    }
}


fun br(): FluentStatement {
    return FluentBreakStatement()
}

fun ret(): FluentStatement {
    return FluentReturnStatement()
}

fun ret(expression: FluentExpression): FluentReturnStatement {
    return FluentReturnStatement(expression)
}

fun empty(): FluentStatement {
    return FluentEmptyStatement()
}

