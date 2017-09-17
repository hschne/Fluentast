package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentASTNode
import at.hschroedl.fluentast.FluentChildNode
import at.hschroedl.fluentast.FluentStandaloneNode
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode

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

class FluentMemberValuePair : FluentASTNodeImpl() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
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







