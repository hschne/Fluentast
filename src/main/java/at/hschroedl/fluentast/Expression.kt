package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.ASTNode

abstract class FluentExpression : FluentASTNode {

    abstract fun build(parent: FluentStatement): ASTNode
}

class FluentSimpleExpression : FluentExpression() {


    override fun build(): ASTNode {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun build(parent: FluentStatement): ASTNode {
        val thisExpression = parent.ast.newThisExpression()
        return thisExpression
    }

}

fun ex(): FluentExpression {
    return FluentSimpleExpression()
}