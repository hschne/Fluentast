package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.i
import at.hschroedl.fluentast.s
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.VariableDeclarationFragment

class FluentVariableDeclarationFragment internal constructor(private val name: String,
                                                             private val initializer: FluentExpression? = null,
                                                             private val dimensions: Array<out FluentExpression>? = null) : FluentChildNode<VariableDeclarationFragment> {

    override fun build(ast: AST): VariableDeclarationFragment {
        val fragment = ast.newVariableDeclarationFragment()
        fragment.name = ast.newSimpleName(name)
        fragment.initializer = initializer?.build(ast)
        return fragment
    }

    fun `is`(value: String): FluentVariableDeclarationFragment {
        return FluentVariableDeclarationFragment(name, s(value))
    }

    fun `is`(value: Int): FluentVariableDeclarationFragment {
        return FluentVariableDeclarationFragment(name, i(value))
    }

    fun `is`(value: FluentExpression): FluentVariableDeclarationFragment {
        return FluentVariableDeclarationFragment(name, value)
    }

    fun at(vararg dimensions: FluentExpression): FluentVariableDeclarationFragment {
        return FluentVariableDeclarationFragment(name, initializer, dimensions)
    }


}