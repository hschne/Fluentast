package at.hschroedl.fluentast.ast.type

import at.hschroedl.fluentast.ast.FluentASTNode
import at.hschroedl.fluentast.name
import org.eclipse.jdt.core.dom.*

abstract class FluentType : FluentASTNode() {

    abstract override fun build(ast: AST): Type
}

class FluentSimpleType internal constructor(private val type: String) : FluentType() {
    override fun build(ast: AST): SimpleType {
        return ast.newSimpleType(name(type).build(ast))
    }
}

class FluentQualifiedType internal constructor() : FluentType() {
    override fun build(ast: AST): QualifiedType {
        throw NotImplementedError()
    }
}

class FluentNameQualifiedType internal constructor(): FluentType() {
    override fun build(ast: AST): NameQualifiedType {
        throw NotImplementedError()
    }
}


class FluentWildcardType internal constructor() : FluentType() {
    override fun build(ast: AST): WildcardType {
        throw NotImplementedError()
    }
}

class FluentParameterizedType internal constructor() : FluentType() {
    override fun build(ast: AST): ParameterizedType {
        throw NotImplementedError()
    }
}


class FluentUnionType internal constructor() : FluentType() {
    override fun build(ast: AST): Type {
        throw NotImplementedError()
    }
}

class FluentIntersectionType internal constructor() : FluentType() {
    override fun build(ast: AST): Type {
        throw NotImplementedError()
    }
}


