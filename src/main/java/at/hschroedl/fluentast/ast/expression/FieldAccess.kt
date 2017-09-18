package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.FieldAccess

class FluentFieldAccess internal constructor(private val expression: FluentExpression,
                                             private val fieldName: String) : FluentExpression() {
    override fun build(ast: AST): FieldAccess {
        val exp = ast.newFieldAccess()
        exp.expression = expression.build(ast)
        exp.name = ast.newSimpleName(fieldName)
        return exp
    }
}

fun fieldAccess(expression: FluentExpression, fieldName: String): FluentFieldAccess {
    return FluentFieldAccess(expression, fieldName)
}
