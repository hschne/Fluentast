package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.ast.FluentASTNode
import at.hschroedl.fluentast.ast.FluentParsedNode
import at.hschroedl.fluentast.ast.FluentStandaloneNode
import org.eclipse.jdt.core.dom.*

abstract class FluentExpression : FluentASTNode(), FluentStandaloneNode<Expression> {

    abstract override fun build(ast: AST): Expression

    override fun build(): Expression {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)
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


// TODO: Implement class instance creation when method stuff is done
class FluentClassInstanceCreation() : FluentExpression() {
    override fun build(ast: AST): Expression {
        throw NotImplementedError()
    }
}



