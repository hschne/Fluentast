package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser


interface FluentStandaloneNode {

    fun build(): ASTNode?
}

interface FluentChildNode {

    fun build(ast: AST): ASTNode?
}

abstract class FluentASTNode

class FluentParsedNode(private val content: String, private val kind: Int) : FluentStandaloneNode {

    override fun build(): ASTNode? {
        val parser = ASTParser.newParser(AST.JLS8)
        parser.setSource(content.toCharArray())
        parser.setResolveBindings(false)
        parser.setKind(kind)
        val result = parser.createAST(null)
        if (result.flags == ASTNode.MALFORMED) {
            throw FluentParseException(
                    "Failed to parse statement '$content'. Use 's(..) to create a statement.'")
        }
        return result
    }

}

