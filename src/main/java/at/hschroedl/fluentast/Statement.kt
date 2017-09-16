package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.*


abstract class FluentStatement : FluentASTNode(), FluentRootNode, FluentChildNode {

    abstract override fun build(ast: AST): ASTNode

    override fun build(): ASTNode {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)
    }
}

class FluentParsedStatement(private val content: String) : FluentStatement() {

    override fun build(): ASTNode {
        val parser = ASTParser.newParser(AST.JLS8)
        parser.setSource(content.toCharArray())
        parser.setResolveBindings(false)
        parser.setKind(ASTParser.K_STATEMENTS)
        val block = parser.createAST(null) as Block
        if (block.statements().isEmpty()) {
            throw FluentParseException(
                    "Failed to parse statements: $content. To create an empty statement use 'empty()'")
        }
        return block
    }

    override fun build(ast: AST): ASTNode {
        val copyTree = ASTNode.copySubtree(ast, build())
        return copyTree as Block
    }
}

class FluentEmptyStatement : FluentStatement() {
    override fun build(ast: AST): ASTNode {
        return ast.newEmptyStatement()
    }
}

class FluentReturnStatement : FluentStatement {

    private var expression: FluentExpression? = null

    constructor()

    constructor(expression: FluentExpression) : this() {
        this.expression = expression
    }

    override fun build(ast: AST): ASTNode {
        val ret = ast.newReturnStatement()
        if (expression != null) {
            ret.expression = expression?.build(ast) as Expression?
        }
        return ret
    }
}

class FluentBreakStatement : FluentStatement() {
    override fun build(ast: AST): ASTNode {
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
    return FluentReturnStatement()
}

fun ret(expression: FluentExpression): FluentReturnStatement {
    return FluentReturnStatement(expression)
}

fun empty(): FluentStatement {
    return FluentEmptyStatement()
}



