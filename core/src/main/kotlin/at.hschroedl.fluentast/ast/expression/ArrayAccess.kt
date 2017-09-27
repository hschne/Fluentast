package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayAccess

/**
 * A wrapper class for [ArrayAccess]. Subclass of [FluentExpression]
 *
 *
 * Using JDT:
 * ~~~ java
 * val exp = ast.newArrayAccess()
 * exp.array = array.build(ast)
 * exp.index = index.build(ast)
 * ~~~
 *
 * Using Fluentast:
 * ~~~ java
 * exp().build(ast);
 * ~~~
 *
 * @constructor takes a [FluentExpression] as array and a [FluentExpression] as index
 *
 * @see ArrayAccess
 */
class FluentArrayAccess internal constructor(private val array: FluentExpression,
                                             private val index: FluentExpression) : FluentExpression() {


    override fun build(ast: AST): ArrayAccess {
        val exp = ast.newArrayAccess()
        exp.array = array.build(ast)
        exp.index = index.build(ast)
        return exp
    }
}

