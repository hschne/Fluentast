package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.Block


abstract class FluentBlock : FluentStatement() {


}

class FluentStatementBlock() : FluentBlock() {

    private val statements: MutableCollection<FluentStatement> = mutableListOf()

    constructor(statements: Array<FluentStatement>) : this() {
        this.statements.addAll(statements)
    }


    override fun build(ast: AST): ASTNode {
        val block: Block = ast.newBlock()
        statements
                .map { it.build(ast) }
                .forEach { block.statements().add(it) }
        return block
    }
}

class FluentStringBlock() : FluentBlock() {


    var content = ""

    constructor(content: String) : this() {
        this.content = content
    }

    override fun build(): ASTNode {
        val parser = ASTParser.newParser(AST.JLS8)
        parser.setSource(content.toCharArray())
        parser.setResolveBindings(false)
        parser.setKind(ASTParser.K_STATEMENTS)
        return parser.createAST(null) as Block
    }

    override fun build(ast: AST): ASTNode {
        val convertedAstNodeWithMethodBody = ASTNode.copySubtree(ast, build())
        return convertedAstNodeWithMethodBody as Block
    }
}

fun body(): FluentBlock {
    return FluentStatementBlock()
}

fun body(vararg statements: FluentStatement): FluentBlock {
    return FluentStatementBlock(arrayOf(*statements))
}

fun body(content: String): FluentBlock {
    return FluentStringBlock(content)
}

fun block(vararg statements: FluentStatement): FluentBlock {
    return FluentStatementBlock(arrayOf(*statements))
}