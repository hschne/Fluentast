package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.*
import at.hschroedl.fluentast.ast.expression.FluentEmptyExpression
import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.*


abstract class FluentStatement : FluentASTNode(), FluentStandaloneNode<Statement>, FluentChildNode<Statement> {

    abstract override fun build(ast: AST): Statement

    override fun build(): Statement {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)
    }
}

class FluentParsedStatement(private val content: String) : FluentStatement() {

    override fun build(): Statement {
        val block = FluentParsedNode(content, ASTParser.K_STATEMENTS).build() as Block
        if (block.statements().size != 1) {
            throw FluentParseException(
                    "Failed to parse statement: '$content'. Use 'block(..) to create multiple statements.'")
        }
        return block.statements()[0] as Statement
    }

    override fun build(ast: AST): Statement {
        return ASTNode.copySubtree(ast, build()) as Statement
    }
}

class FluentEmptyStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEmptyStatement()
    }
}

class FluentReturnStatement(private val expression: FluentExpression) : FluentStatement() {

    override fun build(ast: AST): Statement {
        val ret = ast.newReturnStatement()
        ret.expression = expression.build(ast) as Expression?
        return ret
    }
}

class FluentBreakStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
    }
}

fun s(content: String): FluentStatement {
    return FluentParsedStatement(content)
}

fun br(): FluentStatement {
    return FluentBreakStatement()
}

fun ret(): FluentStatement {
    return FluentReturnStatement(FluentEmptyExpression())
}

fun ret(expression: FluentExpression): FluentReturnStatement {
    return FluentReturnStatement(expression)
}

fun empty(): FluentStatement {
    return FluentEmptyStatement()
}



