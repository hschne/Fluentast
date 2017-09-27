package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.exception.FluentArgumentException
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode
import org.eclipse.jdt.core.dom.ASTParser
import org.eclipse.jdt.core.dom.MemberValuePair

abstract class FluentASTNode : FluentChildNode<ASTNode> {

    abstract override fun build(ast: AST): ASTNode

}

interface FluentStandaloneNode<out T : ASTNode> {

    fun build(): T
}

interface FluentChildNode<out T : ASTNode> {

    fun build(ast: AST): T?
}


class FluentParsedNode(private val content: String, private val kind: Int) : FluentStandaloneNode<ASTNode> {

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

class FluentAnonymousClassDeclaration : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentBodyDeclaration : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentCatchClause : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentComment : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentCompilationUnit : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentImportDeclaration : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMemberRef : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMemberValuePair(private val name: String, private val value: FluentExpression) : FluentASTNode() {
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

class FluentMethodRef : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentMethodRefParameter : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentPackageDeclaration : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}

class FluentTagElement : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentTextElement : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentTypeParameter : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}


class FluentModifier : FluentASTNode() {
    override fun build(ast: AST): ASTNode {
        throw NotImplementedError()
    }
}







