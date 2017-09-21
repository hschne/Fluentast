package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import at.hschroedl.fluentast.ast.type.p
import at.hschroedl.fluentast.ast.type.t
import at.hschroedl.fluentast.b
import at.hschroedl.fluentast.c
import at.hschroedl.fluentast.i
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.VariableDeclarationExpression

class FluentVariableDeclarationExpression internal constructor(private val type: FluentType,
                                                               private vararg val values: Pair<String, FluentExpression?>) : FluentExpression() {



    override fun build(ast: AST): VariableDeclarationExpression {

        val fragment = ast.newVariableDeclarationFragment()
        val ret = ast.newVariableDeclarationExpression(fragment)
        fragment.name = ast.newSimpleName(values.first().first)
        fragment.initializer = values.first().second?.build(ast)
        values.drop(1).forEach {
            val frag = ast.newVariableDeclarationFragment()
            frag.name = ast.newSimpleName(it.first)
            frag.initializer = it.second?.build(ast)
            ret.fragments().add(frag)
        }
        ret.type = type.build(ast)

        return ret
    }
}


// TODO: Rework this, too cumbersome
fun vars(type: String, vararg values: Pair<String, FluentExpression>): FluentExpression {
    return FluentVariableDeclarationExpression(t(type), *values)
}


