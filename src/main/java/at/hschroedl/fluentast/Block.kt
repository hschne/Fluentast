package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.Block

class FluentBlock() {

    var ast = AST.newAST(AST.JLS8)

    val statements: MutableCollection<FluentStatement> = mutableListOf()

    constructor(statements: Array<FluentStatement>) : this() {
        this.statements.addAll(statements)
    }


    fun build(): ASTNode {
        val block: Block = ast.newBlock()
        statements
                .map { it.build(this) }
                .forEach { block.statements().add(it) }
        return block
    }

}

fun body(): FluentBlock {
    return FluentBlock()
}

fun body(vararg statements: FluentStatement): FluentBlock {
    return FluentBlock(arrayOf(*statements))
}