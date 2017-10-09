package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.name
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Expression
import org.eclipse.jdt.core.dom.SuperFieldAccess


class FluentSuperFieldAccess internal constructor(private val className: String?, private val field: String) : FluentExpression() {
    override fun build(ast: AST): SuperFieldAccess {
        val exp = ast.newSuperFieldAccess()
        exp.name = ast.newSimpleName(field)
        if (className != null) {
            exp.qualifier = name(className).build(ast)
        }
        return exp
    }
}

