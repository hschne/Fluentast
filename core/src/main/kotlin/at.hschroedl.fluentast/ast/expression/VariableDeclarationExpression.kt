package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.FluentVariableDeclarationFragment
import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.VariableDeclarationExpression

class FluentVariableDeclarationExpression internal constructor(private val type: FluentType,
                                                               private vararg val fragments: FluentVariableDeclarationFragment) : FluentExpression() {


    override fun build(ast: AST): VariableDeclarationExpression {
        val fragment = fragments.first().build(ast)
        val ret = ast.newVariableDeclarationExpression(fragment)
        fragments.drop(1).forEach {
            ret.fragments().add(it.build(ast))
        }
        ret.type = type.build(ast)

        return ret
    }

}

