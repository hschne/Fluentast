package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode

abstract class FluentExpression : FluentASTNode(), FluentChildNode {

}

class FluentThisExpression : FluentExpression() {

    override fun build(ast: AST) : ASTNode{
        return ast.newThisExpression()
    }
}

fun exp(): FluentExpression {
    return FluentThisExpression()
}