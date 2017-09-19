package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.PrimitiveType

class FluentPrimitiveType(private val primitiveType: String) : FluentType() {
    override fun build(ast: AST): PrimitiveType {
        return when (primitiveType) {
            "byte" -> ast.newPrimitiveType(PrimitiveType.BYTE)
            "short" -> ast.newPrimitiveType(PrimitiveType.SHORT)
            "char" -> ast.newPrimitiveType(PrimitiveType.CHAR)
            "int" -> ast.newPrimitiveType(PrimitiveType.INT)
            "long" -> ast.newPrimitiveType(PrimitiveType.LONG)
            "float" -> ast.newPrimitiveType(PrimitiveType.FLOAT)
            "double" -> ast.newPrimitiveType(PrimitiveType.DOUBLE)
            "boolean" -> ast.newPrimitiveType(PrimitiveType.BOOLEAN)
            "void" -> ast.newPrimitiveType(PrimitiveType.VOID)
            else -> throw FluentArgumentException("Invalid primitive type '$primitiveType'")
        }
    }
}

fun p(type: String): FluentPrimitiveType {
    return FluentPrimitiveType(type)
}