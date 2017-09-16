package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.*


abstract class FluentPrimitiveVariableDeclaration(private val type: PrimitiveType.Code,
                                                  private val name: String,
                                                  private val expression: FluentExpression) : FluentStatement() {

    override fun build(ast: AST): ASTNode {
        val fragment = ast.newVariableDeclarationFragment()
        val ret = ast.newVariableDeclarationStatement(fragment)
        fragment.name = ast.newSimpleName(name)
        val expr = expression.build(ast)
        if (expr != null) {
            fragment.initializer = expr as Expression
        }
        ret.type = ast.newPrimitiveType(type)
        return ret
    }
}

class FluentIntDeclarationStatement(name: String, expression: FluentExpression) :
        FluentPrimitiveVariableDeclaration(
                type = PrimitiveType.INT, name = name, expression = expression) {

    constructor(name: String) : this(name = name, expression = FluentEmptyExpression())
    constructor(name: String, initializer: Int) : this(name = name,
            expression = FluentNumberLiteral(initializer))

}


class FluentBoolDeclarationStatement(name: String, expression: FluentExpression) :
        FluentPrimitiveVariableDeclaration(
                type = PrimitiveType.BOOLEAN, name = name, expression = expression) {
    constructor(name: String) : this(name, expression = FluentEmptyExpression())
    constructor(name: String, initializer: Boolean) : this(name, expression = FluentBooleanLiteral(initializer))


}


class FluentCharDeclarationStatement(name: String, expression: FluentExpression) :
        FluentPrimitiveVariableDeclaration(
                type = PrimitiveType.CHAR, name = name, expression = expression) {
    constructor(name: String) : this(name, expression = FluentEmptyExpression())
    constructor(name: String, initializer: Char) : this(name, expression = FluentCharLiteral(initializer))

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


