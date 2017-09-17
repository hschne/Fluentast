package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentASTNode
import at.hschroedl.fluentast.FluentChildNode
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.PrimitiveType
import org.eclipse.jdt.core.dom.QualifiedType


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

class FluentQualifiedType() : FluentType() {
    override fun build(ast: AST): ASTNode {
        return ast.newSimpleName("");
    }
}

class FluentWildcardType() : FluentType() {
    override fun build(ast: AST): ASTNode {
        return ast.newSimpleName("");
    }
}


enum class FluentPrimitive {
    INT, CHAR, BOOL
}
