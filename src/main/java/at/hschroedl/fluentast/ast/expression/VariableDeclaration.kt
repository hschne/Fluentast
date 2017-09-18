package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.FluentStatement
import at.hschroedl.fluentast.ast.type.FluentType
import at.hschroedl.fluentast.ast.type.p
import at.hschroedl.fluentast.ast.type.t
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Statement

//TODO: Type hierarchy is possibly wrong, VarDecl are not statements! Use VaribleDeclarationStatement!
open class FluentVariableDeclaration(private val type: FluentType, private val name: String,
                                     private val expression: FluentExpression?) : FluentStatement() {


    override fun build(ast: AST): Statement {
        // TODO: Multiple varible fragments, e.g. int a = 3, b =4, c=5;
        val fragment = ast.newVariableDeclarationFragment()
        val ret = ast.newVariableDeclarationStatement(fragment)
        fragment.name = ast.newSimpleName(name)
        fragment.initializer = expression?.build(ast)
        ret.type = type.build(ast)
        return ret
    }
}


fun `var`(name: String, initializer: Int): FluentStatement {
    return FluentVariableDeclaration(p("int"), name, n(initializer))
}

fun `var`(name: String, initializer: Boolean): FluentStatement {
    return FluentVariableDeclaration(p("boolean"), name, b(initializer))
}

fun `var`(name: String, initializer: Char): FluentStatement {
    return FluentVariableDeclaration(p("char"), name, c(initializer))
}

fun `var`(type: String, name: String): FluentStatement {
    return FluentVariableDeclaration(t(type), name, null)
}

fun `var`(type: String, name: String, expression: FluentExpression): FluentStatement {
    return FluentVariableDeclaration(t(type), name, expression)
}


