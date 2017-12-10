package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.name
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.SuperFieldAccess


/**
 * Used to build a [SuperFieldAccess].
 *
 * Java:
 * ~~~ java
 * super.myField
 * ~~~
 *
 * JDT:
 * ~~~ java
 *  SuperFieldAccess fieldAccess = ast.newSuperFieldAccess();
 *  fieldAccess.setName(ast.newSimpleName("myField"));
 * ~~~
 *
 * Fluentast:
 * ~~~ java
 * SuperFieldAccess fieldAccess  = superField("myField").build(ast);
 * ~~~
 *
 * @constructor takes an optional class name and the name of the field.
 *
 * @see [SuperFieldAccess]
 *
 */
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

