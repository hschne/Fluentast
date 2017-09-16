package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.internal.compiler.ast.CharLiteral

abstract class FluentExpression : FluentASTNode(), FluentChildNode {

}

class FluentThisExpression : FluentExpression() {

    override fun build(ast: AST): ASTNode {
        return ast.newThisExpression()
    }
}

class FluentEmptyExpression : FluentExpression() {
    override fun build(ast: AST): ASTNode? {
        return null
    }
}


class FluentNumberLiteral(private val literal: Int) : FluentExpression() {
    override fun build(ast: AST): ASTNode {
        return ast.newNumberLiteral(literal.toString())
    }
}


class FluentBooleanLiteral(private val literal: Boolean) : FluentExpression() {
    override fun build(ast: AST): ASTNode {
        return ast.newBooleanLiteral(literal)
    }
}

class FluentCharLiteral(private val literal: Char) : FluentExpression() {
    override fun build(ast: AST): ASTNode {
        val charLiteral = ast.newCharacterLiteral()
        charLiteral.setCharValue(literal)
        return charLiteral
    }
}


fun exp(): FluentExpression {
    return FluentThisExpression()
}

