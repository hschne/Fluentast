package at.hschroedl.fluentast.ast.type

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.PrimitiveType

class FluentPrimitiveType(private val primitiveType: FluentPrimitive) : FluentType() {
    override fun build(ast: AST): PrimitiveType {
        return when (primitiveType) {
            FluentPrimitive.INT -> ast.newPrimitiveType(
                    PrimitiveType.INT)
            FluentPrimitive.CHAR -> ast.newPrimitiveType(
                    PrimitiveType.CHAR)
            FluentPrimitive.BOOL -> ast.newPrimitiveType(
                    PrimitiveType.BOOLEAN)
        }
    }
}

enum class FluentPrimitive {
    INT, CHAR, BOOL
}


//TODO: Add proper accessor here, possibly use string instead of some enum