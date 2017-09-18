package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.*
import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.*

abstract class FluentExpression : FluentASTNode(), FluentChildNode<Expression>, FluentStandaloneNode<Expression> {

    abstract override fun build(ast: AST): Expression?

    override fun build(): Expression {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)!!
    }
}

internal class FluentParsedExpression internal constructor(private val content: String) : FluentExpression() {

    override fun build(): Expression {
        val result = FluentParsedNode(content, ASTParser.K_EXPRESSION).build()
        if (result is CompilationUnit) {
            // If we get a compilation unit as result that means parsing failed
            val error = result.problems[0]
            throw FluentArgumentException(
                    "Failed to parse expression '$content'. $error")
        }
        return result as Expression
    }


    override fun build(ast: AST): Expression {
        return ASTNode.copySubtree(ast, build()) as Expression
    }
}

fun exp(content: String): FluentExpression {
    return FluentParsedExpression(content)
}


class FluentClassInstanceCreation() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        throw NotImplementedError()
    }
}




class FluentName() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


class FluentParanethesizedExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentPostfixExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentPrefixExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


class FluentSuperFieldAccess() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentSuperMethodInvocation() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


class FluentAnnotationExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentThisExpression : FluentExpression() {
    override fun build(ast: AST): ThisExpression {
        return ast.newThisExpression()
    }
}

fun thiss(): FluentThisExpression {
    return FluentThisExpression()
}


