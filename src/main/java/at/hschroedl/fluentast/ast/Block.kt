package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentParseException
import at.hschroedl.fluentast.FluentParsedNode
import org.eclipse.jdt.core.dom.*


abstract class FluentBlock : FluentStatement()

class FluentStatementBlock() : FluentBlock() {

    private val statements: MutableCollection<FluentStatement> = mutableListOf()

    constructor(statements: Array<FluentStatement>) : this() {
        this.statements.addAll(statements)
    }


    override fun build(ast: AST): Statement {
        val block: Block = ast.newBlock()
        statements
                .map { it.build(ast) }
                .forEach { block.statements().add(it) }
        return block
    }
}

class FluentParsedBlock(private val content: String) : FluentBlock() {

    override fun build(): Statement {

        val block = FluentParsedNode(content, ASTParser.K_STATEMENTS).build() as Block
        if (block.statements().isEmpty()) {
            throw FluentParseException(
                    "Failed to parse statements: '$content'. To create an empty block use 'block()'")
        }
        return block
    }

    override fun build(ast: AST): Statement {
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
    return FluentParsedBlock(content)
}

fun block(): FluentBlock {
    return FluentStatementBlock()
}

fun block(vararg statements: FluentStatement): FluentBlock {
    return FluentStatementBlock(arrayOf(*statements))
}