package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentParseException
import jdk.nashorn.internal.runtime.regexp.joni.constants.NodeType
import org.eclipse.jdt.core.Flags
import org.eclipse.jdt.core.dom.*


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

class FluentStringBlock(private val content: String) : FluentBlock() {

    override fun build(): ASTNode {
        val parser = ASTParser.newParser(AST.JLS8)
        parser.setSource(content.toCharArray())
        parser.setResolveBindings(false)
        parser.setKind(ASTParser.K_STATEMENTS)
        val block = parser.createAST(null) as Block
        if (block.flags == ASTNode.MALFORMED) {
            throw FluentParseException(
                    "Failed to parse statements: '$content'. To create an empty block use 'block()'")
        }
        return block
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

fun block(): FluentBlock {
    return FluentStatementBlock()
}

fun block(vararg statements: FluentStatement): FluentBlock {
    return FluentStatementBlock(arrayOf(*statements))
}