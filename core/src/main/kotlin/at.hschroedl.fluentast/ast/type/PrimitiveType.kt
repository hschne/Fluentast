package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.PrimitiveType

// TODO: Use static import parameters INT, BOOL etc.
class FluentPrimitiveType internal constructor(private val primitiveType: String) : FluentType() {
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
            else -> throw FluentArgumentException(
                    "Invalid primitive type '$primitiveType'")
        }
    }
}

