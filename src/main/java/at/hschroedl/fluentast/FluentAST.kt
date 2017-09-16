package at.hschroedl.fluentast

import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.ASTNode


interface FluentRootNode {

    fun build(): ASTNode
}

interface FluentChildNode {

    fun build(ast: AST): ASTNode?
}

abstract class FluentASTNode

