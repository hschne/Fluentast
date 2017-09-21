package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Name

class FluentName(private val name: String) : FluentExpression() {
    override fun build(ast: AST): Name {
        return ast.newName(name.split(".").toTypedArray())
    }

}
