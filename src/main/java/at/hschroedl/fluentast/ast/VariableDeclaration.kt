package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.ast.expression.*
import at.hschroedl.fluentast.ast.type.FluentParsedType
import at.hschroedl.fluentast.ast.type.FluentPrimitive
import at.hschroedl.fluentast.ast.type.FluentPrimitiveType
import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.*

open class FluentVariableDeclaration(private val type: FluentType, private val name: String,
                                     private val expression: FluentExpression) : FluentStatement() {

    constructor(type: String, name: String, expression: FluentExpression) : this(
            FluentParsedType(type), name,
            expression)

    override fun build(ast: AST): Statement {
        val fragment = ast.newVariableDeclarationFragment()
        val ret = ast.newVariableDeclarationStatement(fragment)
        fragment.name = ast.newSimpleName(name)
        fragment.initializer = expression.build(ast) as? Expression
        ret.type = type.build(ast) as? Type
        return ret
    }
}


class FluentIntDeclarationStatement(name: String, expression: FluentExpression) :
        FluentVariableDeclaration(
                type = FluentPrimitiveType(
                        FluentPrimitive.INT), name = name, expression = expression) {

    constructor(name: String) : this(name = name, expression = FluentEmptyExpression())
    constructor(name: String, initializer: Int) : this(name = name,
            expression = FluentNumberLiteral(initializer))
}


class FluentBoolDeclarationStatement(name: String, expression: FluentExpression) :
        FluentVariableDeclaration(
                type = FluentPrimitiveType(
                        FluentPrimitive.BOOL), name = name, expression = expression) {
    constructor(name: String) : this(name, expression = FluentEmptyExpression())
    constructor(name: String, initializer: Boolean) : this(name, expression = FluentBooleanLiteral(
            initializer))


}


class FluentCharDeclarationStatement(name: String, expression: FluentExpression) :
        FluentVariableDeclaration(
                type = FluentPrimitiveType(
                        FluentPrimitive.CHAR), name = name, expression = expression) {
    constructor(name: String) : this(name, expression = FluentEmptyExpression())
    constructor(name: String, initializer: Char) : this(name, expression = FluentCharLiteral(
            initializer))

}


fun intVar(name: String): FluentStatement {
    return FluentIntDeclarationStatement(name)
}

fun `var`(name: String, initializer: Int): FluentStatement {
    return FluentIntDeclarationStatement(name, initializer)
}

fun intVar(name: String, expression: FluentExpression): FluentStatement {
    return FluentIntDeclarationStatement(name, expression)
}

fun boolVar(name: String): FluentStatement {
    return FluentBoolDeclarationStatement(name)
}

fun `var`(name: String, initializer: Boolean): FluentStatement {
    return FluentBoolDeclarationStatement(name, initializer)
}

fun boolVar(name: String, expression: FluentExpression): FluentStatement {
    return FluentBoolDeclarationStatement(name, expression)
}

fun charVar(name: String): FluentStatement {
    return FluentCharDeclarationStatement(name)
}

fun `var`(name: String, initializer: Char): FluentStatement {
    return FluentCharDeclarationStatement(name, initializer)
}

fun charVar(name: String, expression: FluentExpression): FluentStatement {
    return FluentCharDeclarationStatement(name, expression)
}

fun `var`(type: String, name: String): FluentStatement {
    return FluentVariableDeclaration(type, name,
            FluentEmptyExpression())
}

fun `var`(type: String, name: String, expression: FluentExpression): FluentStatement {
    return FluentVariableDeclaration(type, name, expression)
}


