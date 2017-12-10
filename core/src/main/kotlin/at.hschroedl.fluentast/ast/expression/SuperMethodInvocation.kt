package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.SuperMethodInvocation


/**
 * Used to build a [SuperMethodInvocation].
 *
 * Java:
 * ~~~ java
 * super.someMethod();
 * ~~~
 *
 * JDT:
 * ~~~ java
 * SuperMethodInvocation methodInvocation = ast.newSuperMethodInvocation();
 * methodInvocation.setName(ast.newSimpleName("myMethod"));
 * ~~~
 *
 * Fluentast:
 * ~~~ java
 * SuperMethodInvocation methodInvocation = superMethod("myMethod").build(ast);
 * ~~~
 *
 * @constructor takes a qualifier, an optional list of type parameters, and an optional list of expressions. And of course the name of the method.
 *
 * @see [SuperMethodInvocation]
 *
 */
class FluentSuperMethodInvocation internal constructor(private val qualifier: String? = null,
                                  private val typeParameter: List<FluentType>? = null,
                                  private val name: String,
                                  private vararg val arguments: FluentExpression) : FluentExpression() {

    // TODO: Make this more fluent
    override fun build(ast: AST): SuperMethodInvocation {
        val exp = ast.newSuperMethodInvocation()
        if (qualifier != null) {
            exp.qualifier = FluentName(qualifier).build(ast)
        }
        if (typeParameter != null) {
            exp.typeArguments().addAll(typeParameter.map { it.build(ast) })
        }
        exp.name = ast.newSimpleName(name)
        if (!arguments.isEmpty()) {
            exp.arguments().addAll(arguments.map { it.build(ast) })
        }
        return exp
    }
}
