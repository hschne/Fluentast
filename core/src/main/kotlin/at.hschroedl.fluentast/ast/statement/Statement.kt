package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.ast.FluentASTNode
import at.hschroedl.fluentast.ast.FluentParsedNode
import at.hschroedl.fluentast.ast.FluentStandaloneNode
import org.eclipse.jdt.core.dom.*


/**
 * Used to create a [Statement].
 *
 */
abstract class FluentStatement internal constructor() : FluentASTNode(), FluentStandaloneNode<Statement> {

    /**
     * Creates an [Statement] from the given [FluentStatement] using the given [AST].
     *
     * @param ast used for creating the [Statement]
     * @return a new [Statement]
     *
     */
    abstract override fun build(ast: AST): Statement

    /**
     * Creates a [Statement] using a new [AST].
     *
     * @return a new [Statement]
     */
    override fun build(): Statement {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)
    }
}

class FluentParsedStatement internal constructor(private val content: String) : FluentStatement() {

    override fun build(): Statement {
        val block = FluentParsedNode(content, ASTParser.K_STATEMENTS).build() as Block
        if (block.statements().size != 1) {
            throw FluentArgumentException(
                    "Failed to parse statement: '$content'. Use 'block(..) to create multiple statements.'")
        }
        return block.statements()[0] as Statement
    }

    override fun build(ast: AST): Statement {
        return ASTNode.copySubtree(ast, build()) as Statement
    }
}

class FluentConstructorInvocation internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
    }
}

class FluentContinueStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
    }
}

class FluentDoStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
    }
}

class FluentEmptyStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEmptyStatement()
    }
}


class FluentEnhancedForStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentLabeledStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSuperConstructorInvocation internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSwitchCase internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSwitchStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSynchronizedStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentThrowStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentTryStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentTypeDeclarationStatement internal constructor() : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}




