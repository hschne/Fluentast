package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.PrimitiveType

abstract class FluentType : FluentASTNode(), FluentChildNode {

    abstract override fun build(ast: AST): ASTNode
}

class FluentStringType(private val name: String) : FluentType() {
    override fun build(ast: AST): ASTNode {
        return ast.newSimpleType(ast.newSimpleName(name))
    }
}

class FluentPrimitiveType(private val primitiveType: FluentPrimitive) : FluentType() {
    override fun build(ast: AST): ASTNode {
        return when (primitiveType) {
            FluentPrimitive.INT -> ast.newPrimitiveType(PrimitiveType.INT)
            FluentPrimitive.CHAR -> ast.newPrimitiveType(PrimitiveType.CHAR)
            FluentPrimitive.BOOL -> ast.newPrimitiveType(PrimitiveType.BOOLEAN)
        }
    }
}


enum class FluentPrimitive {
    INT, CHAR, BOOL
}
