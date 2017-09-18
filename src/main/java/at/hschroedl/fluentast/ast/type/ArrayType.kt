package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayType

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

