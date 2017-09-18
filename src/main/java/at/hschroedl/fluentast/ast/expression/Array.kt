package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentArrayType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ArrayCreation
import org.eclipse.jdt.core.dom.ArrayInitializer
import org.eclipse.jdt.core.dom.Expression


class FluentArrayAccess internal constructor(private val array: FluentExpression,
                                             private val index: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newArrayAccess()
        exp.array = array.build(ast)
        exp.index = index.build(ast)
        return exp
    }
}

fun arrayIndex(array: FluentExpression, index: FluentExpression): FluentArrayAccess {
    return FluentArrayAccess(array, index)
}

class FluentArrayCreation internal constructor(private val type: FluentArrayType,
                                               private val initializer: FluentArrayInitializer?) : FluentExpression() {
    override fun build(ast: AST): ArrayCreation {
        val exp = ast.newArrayCreation()
        exp.type = type.build(ast)
        exp.initializer = initializer?.build(ast)
        return exp
    }

}

fun newArray(type: FluentArrayType, initializer: FluentArrayInitializer?): FluentArrayCreation {
    return FluentArrayCreation(type, initializer)
}

fun newArray(type: FluentArrayType): FluentArrayCreation {
    return FluentArrayCreation(type, null)
}


class FluentArrayInitializer internal constructor(
        private vararg val expressions: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): ArrayInitializer {
        val exp = ast.newArrayInitializer()
        expressions
                .map { it.build(ast) }
                .forEach { exp.expressions().add(it) }
        return exp
    }
}


fun arrayInit(vararg expression: FluentExpression): FluentArrayInitializer {
    return FluentArrayInitializer(*expression)
}


