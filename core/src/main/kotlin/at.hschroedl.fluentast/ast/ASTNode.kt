package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.MemberValuePair

abstract class FluentASTNode internal constructor(): FluentChildNode<ASTNode> {

    abstract override fun build(ast: AST): ASTNode

}

interface FluentStandaloneNode<out T : ASTNode> {

    fun build(): T
}

interface FluentChildNode<out T : ASTNode> {

    fun build(ast: AST): T?
}


class FluentParsedNode internal constructor(private val content: String, private val kind: Int) : FluentStandaloneNode<ASTNode> {

    override fun build(): ASTNode {
        val parser = ASTParser.newParser(AST.JLS8)
        parser.setSource(content.toCharArray())
        parser.setResolveBindings(false)
        parser.setKind(kind)
        val result = parser.createAST(null)
        if (result.flags == ASTNode.MALFORMED) {
            throw FluentArgumentException(
                    "Failed to parse '$content'. Use 's(..) to create a statement.'")
        }
        return result
    }
}

class FluentAnonymousClassDeclaration internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentBodyDeclaration internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentCatchClause internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentComment internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentCompilationUnit internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentImportDeclaration internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMemberRef internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMemberValuePair internal constructor(private val name: String, private val value: FluentExpression) : FluentASTNode() {
    override fun build(ast: AST): MemberValuePair {
        val memberPair = ast.newMemberValuePair()
        memberPair.name = ast.newSimpleName(name)
        memberPair.value = value.build(ast)
        return memberPair
    }
}

class FluentMethodRef internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMethodRefParameter internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentPackageDeclaration internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentTagElement internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentTextElement internal constructor() : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentTypeParameter internal constructor() : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentModifier internal constructor(): FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}







