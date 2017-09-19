package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentASTNode
import at.hschroedl.fluentast.FluentChildNode
import at.hschroedl.fluentast.FluentStandaloneNode
import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.MemberValuePair

abstract class FluentASTNodeImpl : FluentASTNode(), FluentStandaloneNode<ASTNode>, FluentChildNode<ASTNode> {

    abstract override fun build(ast: AST): ASTNode

    override fun build(): ASTNode {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)
    }
}

class FluentAnonymousClassDeclaration : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentBodyDeclaration : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentCatchClause : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentComment : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentCompilationUnit : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentImportDeclaration : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMemberRef : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMemberValuePair(private val name: String, private val value: FluentExpression) : FluentASTNodeImpl() {
    override fun build(ast: AST): MemberValuePair {
        val memberPair = ast.newMemberValuePair()
        memberPair.name = ast.newSimpleName(name)
        memberPair.value = value.build(ast)
        return memberPair
    }
}

fun pair(name: String, value: FluentExpression): FluentMemberValuePair {
    return FluentMemberValuePair(name, value)
}

class FluentMethodRef : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMethodRefParameter : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentPackageDeclaration : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentTagElement : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentTextElement : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentTypeParameter : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentModifier : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}







