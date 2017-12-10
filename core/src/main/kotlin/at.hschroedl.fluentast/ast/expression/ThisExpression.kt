package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ThisExpression

/**
 * Used to build a [ThisExpression].
 *
 * Java:
 * ~~~ java
 * this
 * ~~~
 *
 * JDT:
 * ~~~ java
 * ThisExpression exp = ast.newThisExpression();
 * ~~~
 *
 * Fluentast:
 * ~~~ java
 * ThisExpression exp = this_().build(ast);
 * ~~~
 *
 * @constructor takes an optional qualifier for the this expression.
 *
 * @see [ThisExpression]
 *
 */
class FluentThisExpression internal constructor(private val qualifier: String? = null) : FluentExpression() {
    override fun build(ast: AST): ThisExpression {
        val exp = ast.newThisExpression()
        if (qualifier != null) {
            exp.qualifier = FluentName(qualifier).build(ast)
        }
        return exp
    }
}

