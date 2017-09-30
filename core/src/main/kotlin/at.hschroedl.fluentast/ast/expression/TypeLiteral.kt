package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.TypeLiteral

class FluentTypeLiteral internal constructor(private val type: FluentType) : FluentExpression() {
    override fun build(ast: AST): TypeLiteral {
        val typeLiteral = ast.newTypeLiteral()
        typeLiteral.type = type.build(ast)
        return typeLiteral
    }
}
