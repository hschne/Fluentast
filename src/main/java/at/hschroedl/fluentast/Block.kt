package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.Block

interface FluentASTNode {

    fun build(): ASTNode
}

abstract class AbstractFluentBlock : FluentASTNode

class FluentBlock() : AbstractFluentBlock() {

    var ast = AST.newAST(AST.JLS8)

    val statements: MutableCollection<FluentStatement> = mutableListOf()

    constructor(statements: Array<FluentStatement>) : this() {
        this.statements.addAll(statements)
    }


    override fun build(): ASTNode {
        val block: Block = ast.newBlock()
        statements
                .map { it.build(this) }
                .forEach { block.statements().add(it) }
        return block
    }
}

class FluentStringBlock() : AbstractFluentBlock() {

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
}

fun body(): AbstractFluentBlock {
    return FluentBlock()
}

fun body(vararg statements: FluentStatement): AbstractFluentBlock {
    return FluentBlock(arrayOf(*statements))
}

fun body(content: String): AbstractFluentBlock {
    return FluentStringBlock(content)
}