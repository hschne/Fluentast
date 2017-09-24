package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.i
import at.hschroedl.fluentast.s
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.VariableDeclaration
import org.eclipse.jdt.core.dom.VariableDeclarationFragment

abstract class FluentVariableDeclaration : FluentChildNode<VariableDeclaration>


abstract class FluentVariableDeclarationFragment(private val name: String,
                                                 private val initializer: FluentExpression? = null) : FluentVariableDeclaration() {

    override fun build(ast: AST): VariableDeclarationFragment {
        val fragment = ast.newVariableDeclarationFragment()
        fragment.name = ast.newSimpleName(name)
        fragment.initializer = initializer?.build(ast)
        return fragment
    }

}

class FluentVariableDeclarationFragmentImpl(private val name: String,
                                            initializer: FluentExpression? = null) : FluentVariableDeclarationFragment(
        name, initializer) {


    fun `is`(value: String): FluentVariableDeclarationFragmentImpl {
        return FluentVariableDeclarationFragmentImpl(name, s(value))
    }

    fun `is`(value: Int): FluentVariableDeclarationFragmentImpl {
        return FluentVariableDeclarationFragmentImpl(name, i(value))
    }

    fun init(value: FluentExpression): FluentVariableDeclarationFragmentImpl {
        return FluentVariableDeclarationFragmentImpl(name, value)
    }

}