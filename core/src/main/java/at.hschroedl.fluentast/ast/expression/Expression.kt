package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.FluentASTNode
import at.hschroedl.fluentast.ast.FluentStandaloneNode
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression

abstract class FluentExpression : FluentASTNode(), FluentStandaloneNode<Expression> {

    abstract override fun build(ast: AST): Expression

    override fun build(): Expression {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)
    }

    fun field(fieldName: String): FluentFieldAccess {
        return FluentFieldAccess(this, fieldName)
    }

    fun index(expression: FluentExpression): FluentArrayAccess {
        return FluentArrayAccess(this, expression)
    }
}


// TODO: Implement class instance creation when method stuff is done
class FluentClassInstanceCreation() : FluentExpression() {
    override fun build(ast: AST): Expression {
        throw NotImplementedError()
    }
}