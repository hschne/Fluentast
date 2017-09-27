package at.hschroedl.fluentast.test

import at.hschroedl.fluentast.ast.FluentVariableDeclarationFragment
import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.ast.expression.FluentLiteral
import at.hschroedl.fluentast.ast.statement.FluentStatement
import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.*

class DummyLiteral(private val value: Int) : FluentLiteral() {
    override fun build(ast: AST): NumberLiteral {
        return ast.newNumberLiteral(value.toString())
    }
}

class DummyExpression(private val value: String) : FluentExpression() {
    override fun build(ast: AST): SimpleName {
        return ast.newSimpleName(value)
    }
}

class DummyType(private val value: String) : FluentType() {
    override fun build(ast: AST): SimpleType {
        return ast.newSimpleType(DummyExpression(value).build(ast))
    }
}

class DummyStatement(private val value: String) : FluentStatement() {

    override fun build(ast: AST): Statement {
        return ast.newExpressionStatement(DummyExpression(value).build(ast))
    }
}

class DummyVariableFragment(private val name: String,
                            private val value: Int?) : FluentVariableDeclarationFragment(name,
                                                                                         null) {

    override fun build(ast: AST): VariableDeclarationFragment {
        val fragment = ast.newVariableDeclarationFragment()
        fragment.name = ast.newSimpleName(name)
        if (value != null) {
            fragment.initializer = ast.newNumberLiteral(value.toString(10))
        }
        return fragment
    }

}

fun dummyLiteral(value: Int): DummyLiteral {
    return DummyLiteral(value)
}

fun dummyExpression(value: String): DummyExpression {
    return DummyExpression(value)
}

fun dummyType(value: String): DummyType {
    return DummyType(value)
}

fun dummyStatement(value: String): DummyStatement {
    return DummyStatement(value)
}

fun dummyVariableFragment(name: String, value: Int? = null): DummyVariableFragment {
    return DummyVariableFragment(name, value)
}