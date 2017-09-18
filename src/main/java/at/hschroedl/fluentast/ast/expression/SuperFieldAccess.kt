package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression
import org.eclipse.jdt.core.dom.SuperFieldAccess


class FluentSuperFieldAccess(private val className: String?, private val field: String) : FluentExpression() {
    override fun build(ast: AST): SuperFieldAccess {
        val exp = ast.newSuperFieldAccess()
        exp.name = ast.newSimpleName(field)
        if (className != null) {
            exp.qualifier = name(className).build(ast)
        }
        return exp
    }
}

fun superr(field: String): FluentSuperFieldAccess {
    return FluentSuperFieldAccess(null, field)
}

fun superr(className: String, field: String): FluentSuperFieldAccess {
    return FluentSuperFieldAccess(className, field)
}