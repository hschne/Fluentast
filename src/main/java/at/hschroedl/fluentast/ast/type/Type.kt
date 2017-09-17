package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.FluentASTNode
import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.FluentChildNode
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayType
import org.eclipse.jdt.core.dom.PrimitiveType
import org.eclipse.jdt.core.dom.Type

abstract class FluentType : FluentASTNode(), FluentChildNode<Type> {

    abstract override fun build(ast: AST): Type
}

class FluentParsedType(private val name: String) : FluentType() {
    override fun build(ast: AST): Type {
        return ast.newSimpleType(ast.newSimpleName(name))
    }
}

class FluentPrimitiveType(private val primitiveType: FluentPrimitive) : FluentType() {
    override fun build(ast: AST): PrimitiveType {
        return when (primitiveType) {
            FluentPrimitive.INT -> ast.newPrimitiveType(PrimitiveType.INT)
            FluentPrimitive.CHAR -> ast.newPrimitiveType(PrimitiveType.CHAR)
            FluentPrimitive.BOOL -> ast.newPrimitiveType(PrimitiveType.BOOLEAN)
        }
    }
}

class FluentArrayType(private val type: FluentType,
                      private val dimensions: Int) : FluentType() {

    constructor(type: FluentType) : this(type, 1)

    override fun build(ast: AST): ArrayType {
        val type = ast.newArrayType(type.build(ast))
        if (dimensions < 1) {
            throw FluentArgumentException(
                    "Can not create an array type with $dimensions dimensions. Number must be greater than 0.")
        }
        for (i in 1 until dimensions) {
            type.dimensions().add(ast.newDimension())
        }
        return type as ArrayType
    }
}

class FluentQualifiedType() : FluentType() {
    override fun build(ast: AST): Type {
        throw NotImplementedError()
    }
}

class FluentWildcardType() : FluentType() {
    override fun build(ast: AST): Type {
        throw NotImplementedError()
    }
}


fun type(name: String): FluentType {
    return FluentParsedType(name)
}

enum class FluentPrimitive {
    INT, CHAR, BOOL
}
