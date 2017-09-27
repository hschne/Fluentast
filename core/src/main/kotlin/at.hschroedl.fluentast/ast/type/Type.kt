package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.ast.FluentASTNode
import at.hschroedl.fluentast.name
import org.eclipse.jdt.core.dom.*

abstract class FluentType : FluentASTNode() {

    abstract override fun build(ast: AST): Type
}

class FluentSimpleType(private val type: String) : FluentType() {
    override fun build(ast: AST): SimpleType {
        return ast.newSimpleType(name(type).build(ast))
    }
}

fun t(name: String): FluentType {
    return FluentSimpleType(name)
}


class FluentQualifiedType() : FluentType() {
    override fun build(ast: AST): QualifiedType {
        throw NotImplementedError()
    }
}

class FluentNameQualifiedType() : FluentType() {
    override fun build(ast: AST): NameQualifiedType {
        throw NotImplementedError()
    }
}


class FluentWildcardType() : FluentType() {
    override fun build(ast: AST): WildcardType {
        throw NotImplementedError()
    }
}

class FluentParameterizedType() : FluentType() {
    override fun build(ast: AST): ParameterizedType {
        throw NotImplementedError()
    }
}


class FluentUnionType() : FluentType() {
    override fun build(ast: AST): Type {
        throw NotImplementedError()
    }
}

class FluentIntersectionType() : FluentType() {
    override fun build(ast: AST): Type {
        throw NotImplementedError()
    }
}


