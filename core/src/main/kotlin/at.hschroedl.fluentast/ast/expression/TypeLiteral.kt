package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.BooleanLiteral
import org.eclipse.jdt.core.dom.TypeLiteral

/**
 * Used to build a [TypeLiteral] from a [FluentType].
 */
class FluentTypeLiteral internal constructor(private val type: FluentType) : FluentExpression() {
    override fun build(ast: AST): TypeLiteral {
        val typeLiteral = ast.newTypeLiteral()
        typeLiteral.type = type.build(ast)
        return typeLiteral
    }
}
