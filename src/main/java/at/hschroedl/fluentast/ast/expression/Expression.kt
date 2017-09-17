package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.*
import at.hschroedl.fluentast.ast.type.FluentArrayType
import org.eclipse.jdt.core.dom.*

abstract class FluentExpression : FluentASTNode(), FluentChildNode<Expression>, FluentStandaloneNode<Expression> {

    abstract override fun build(ast: AST): Expression?

    override fun build(): Expression {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)!!
    }
}

class FluentArrayAccessExpression(private val array: FluentExpression,
                                  private val index: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newArrayAccess()
        exp.array = array.build(ast)
        exp.index = index.build(ast)
        return exp
    }
}

class FluentArrayCreationExpression(private val initializer: FluentArrayInitializer, private val type: FluentArrayType,
                                    private vararg val dimensions: FluentASTNode) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newArrayCreation()
        return exp
    }

}

class FluentArrayInitializer(private vararg val expressions: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newArrayInitializer()
        expressions
                .map { it.build(ast) }
                .forEach { exp.expressions().add(it) }
        return exp
    }
}

class FluentThisExpression : FluentExpression() {

    override fun build(ast: AST): Expression {
        return ast.newThisExpression()
    }
}


class FluentParsedExpression(private val content: String) : FluentExpression() {

    override fun build(): Expression {
        val result = FluentParsedNode(content, ASTParser.K_EXPRESSION).build()
        if (result is CompilationUnit) {
            // If we get a compilation unit as result that means parsing failed
            val error = result.problems[0]
            throw FluentParseException(
                    "Failed to parse expression '$content'. $error")
        }
        return result as Expression
    }


    override fun build(ast: AST): Expression {
        return ASTNode.copySubtree(ast, build()) as Expression
    }


}

class FluentEmptyExpression : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


fun exp(): FluentExpression {
    return FluentThisExpression()
}

fun exp(content: String): FluentExpression {
    return FluentParsedExpression(content)
}

