package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.NumberLiteral
import org.eclipse.jdt.core.dom.SimpleName
import org.eclipse.jdt.core.dom.SimpleType

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

fun dummyLiteral(value: Int): DummyLiteral {
    return DummyLiteral(value)
}

fun dummyExpression(value: String): DummyExpression {
    return DummyExpression(value)
}

fun dummyType(value: String): DummyType {
    return DummyType(value)
}