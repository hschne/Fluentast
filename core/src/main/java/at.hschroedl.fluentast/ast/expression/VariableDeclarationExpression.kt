package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import at.hschroedl.fluentast.ast.type.p
import at.hschroedl.fluentast.ast.type.t
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


fun `var`(name: String, initializer: Int): FluentExpression {
    return FluentVariableDeclarationExpression(p("int"), Pair(name, i(initializer)))
}

fun `var`(name: String, initializer: Boolean): FluentExpression {
    return FluentVariableDeclarationExpression(p("boolean"), Pair(name, b(initializer)))
}

fun `var`(name: String, initializer: Char): FluentExpression {
    return FluentVariableDeclarationExpression(p("char"), Pair(name, c(initializer)))
}

fun `var`(type: String, name: String): FluentExpression {
    return FluentVariableDeclarationExpression(t(type), Pair(name, null))
}

fun `var`(type: String, name: String, expression: FluentExpression): FluentExpression {
    return FluentVariableDeclarationExpression(t(type), Pair(name, expression))
}

// TODO: Rework this, too cumbersome
fun vars(type: String, vararg values: Pair<String, FluentExpression>): FluentExpression {
    return FluentVariableDeclarationExpression(t(type), *values)
}


