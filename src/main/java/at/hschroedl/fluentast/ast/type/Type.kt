package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.FluentASTNode
import at.hschroedl.fluentast.FluentChildNode
import org.eclipse.jdt.core.dom.*

abstract class FluentType : FluentASTNode(), FluentChildNode<Type> {

    abstract override fun build(ast: AST): Type
}

class FluentParsedType(private val name: String) : FluentType() {
    override fun build(ast: AST): Type {
        return ast.newSimpleType(ast.newSimpleName(name))
    }
}

class FluentPrimitiveType(private val primitiveType: FluentPrimitive) : FluentType() {
    override fun build(ast: AST): Type {
        return when (primitiveType) {
            FluentPrimitive.INT -> ast.newPrimitiveType(PrimitiveType.INT)
            FluentPrimitive.CHAR -> ast.newPrimitiveType(PrimitiveType.CHAR)
            FluentPrimitive.BOOL -> ast.newPrimitiveType(PrimitiveType.BOOLEAN)
        }
    }
}

class FluentArrayType(private val type: FluentType,
                      private vararg val dimensions: NumberLiteral) : FluentType() {

    override fun build(ast: AST): Type {
        val type = ast.newArrayType(type.build(ast))
        dimensions
                .forEach { type.dimensions().add(it) }
        return type as ArrayType
    }
}

fun type(name: String): FluentType {
    return FluentParsedType(name)
}

enum class FluentPrimitive {
    INT, CHAR, BOOL
}
