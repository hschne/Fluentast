package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.i
import at.hschroedl.fluentast.s
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.VariableDeclaration
import org.eclipse.jdt.core.dom.VariableDeclarationFragment

abstract class FluentVariableDeclaration : FluentChildNode<VariableDeclaration>


/**
 * A wrapper class for [VariableDeclarationFragment]. Fragements are used to declare or initialize values.
 *
 *  * Java Code:
 * ~~~ java
 * i = 1
 * ~~~
 *
 * Using JDT:
 * ~~~ java
 * VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
 * fragment.setName(ast.newSimpleName("i"));
 * fragment.setInitializer(ast.newNumberLiteral("1"));
 * ~~~
 *
 * Using Fluentast:
 * ~~~ java
 * VariableDeclarationFragment fragment = fragment("i", i(1))).build(ast);
 * ~~~
 *
 * @constructor takes a string representing the name and a [FluentExpression] as initializer.
 *
 * @see [VariableDeclarationFragment]
 */
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


    fun init(value: String): FluentVariableDeclarationFragmentImpl {
        return FluentVariableDeclarationFragmentImpl(name, s(value))
    }

    fun init(value: Int): FluentVariableDeclarationFragmentImpl {
        return FluentVariableDeclarationFragmentImpl(name, i(value))
    }

    fun init(value: FluentExpression): FluentVariableDeclarationFragmentImpl {
        return FluentVariableDeclarationFragmentImpl(name, value)
    }

}