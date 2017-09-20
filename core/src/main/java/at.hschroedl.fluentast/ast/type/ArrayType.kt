package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayType

class FluentArrayType(private val type: FluentType,
                      private val dimensions: Int = 1) : FluentType() {


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

fun arr(type: FluentType): FluentArrayType {
    return FluentArrayType(type)
}

fun arr(type: FluentType, dimensions: Int): FluentArrayType {
    return FluentArrayType(type, dimensions)
}