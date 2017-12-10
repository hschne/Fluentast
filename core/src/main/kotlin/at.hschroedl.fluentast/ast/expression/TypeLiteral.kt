package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.BooleanLiteral
import org.eclipse.jdt.core.dom.TypeLiteral

/**
 * Used to build a [TypeLiteral] from a [FluentType].
 *
 * Java:
 * ~~~ java
 * MyType.class
 * ~~~
 *
 * JDT:
 * ~~~ java
 * TypeLiteral literal = ast.newTypeLiteral();
 * literal.setType(ast.newSimpleType(ast.newSimpleName("MyType")));
 * ~~~
 *
 * Fluentast:
 * ~~~ java
 * TypeLiteral literal = clazz(t("MyType")).build(ast);
 * ~~~
 *
 * @constructor takes the [FluentType] of this literal expression.
 *
 * @see [TypeLiteral]
 */
class FluentTypeLiteral internal constructor(private val type: FluentType) : FluentExpression() {
    override fun build(ast: AST): TypeLiteral {
        val typeLiteral = ast.newTypeLiteral()
        typeLiteral.type = type.build(ast)
        return typeLiteral
    }
}
