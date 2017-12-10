package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.FluentVariableDeclarationFragment
import at.hschroedl.fluentast.ast.type.FluentType
import at.hschroedl.fluentast.decl
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.VariableDeclarationExpression

/**
 * A wrapper class for [VariableDeclarationExpression].
 *
 * Use convenience methods from [at.hschroedl.fluentast] to create instances of this class.
 *
 * Java Code:
 * ~~~ java
 * boolean i = true
 * ~~~
 *
 * Using JDT:
 * ~~~ java
 * VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
 * fragment.setName(ast.newSimpleName("i"));
 * fragment.setInitializer(ast.newBooleanLiteral(true));
 * VariableDeclarationExpression statement = ast.newVariableDeclarationExpression(fragment);
 * statement.setType(ast.newPrimitiveType(PrimitiveType.BOOLEAN));
 * ~~~
 *
 * Using Fluentast:
 * ~~~ java
 * VariableDeclarationExpression exp = decl("i", true).build(ast);
 * ~~~
 *
 * @constructor takes a [FluentType] and a list of [FluentVariableDeclarationFragment] to be initialized.
 *
 * @see [VariableDeclarationExpression]
 *
 * */
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

