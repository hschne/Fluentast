package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.*
import org.eclipse.jdt.core.dom.*

abstract class FluentExpression : FluentASTNode(), FluentChildNode, FluentStandaloneNode {

    abstract override fun build(ast: AST): ASTNode?

    override fun build(): ASTNode {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)!!
    }
}

class FluentThisExpression : FluentExpression() {

    override fun build(ast: AST): ASTNode {
        return ast.newThisExpression()
    }
}


class FluentParsedExpression(private val content: String) : FluentExpression() {

    override fun build(): ASTNode {
        val result = FluentParsedNode(content, ASTParser.K_EXPRESSION).build()
        if (result is CompilationUnit) {
            // If we get a compilation unit as result that means parsing failed
            val error = result.problems[0]
            throw FluentParseException(
                    "Failed to parse expression '$content'. $error")
        }
        return result as Expression
    }


    override fun build(ast: AST): ASTNode {
        return ASTNode.copySubtree(ast, build())
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

fun exp(content: String): FluentExpression {
    return FluentParsedExpression(content)
}

