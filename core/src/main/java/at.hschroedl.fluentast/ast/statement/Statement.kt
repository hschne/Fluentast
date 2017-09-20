package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.ast.FluentASTNode
import at.hschroedl.fluentast.ast.FluentParsedNode
import at.hschroedl.fluentast.ast.FluentStandaloneNode
import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.*


abstract class FluentStatement internal constructor() : FluentASTNode(), FluentStandaloneNode<Statement> {

    abstract override fun build(ast: AST): Statement

    override fun build(): Statement {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)
    }
}

class FluentParsedStatement(private val content: String) : FluentStatement() {

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

class FluentConstructorInvocation : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
    }
}

class FluentContinueStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
    }
}

class FluentDoStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
    }
}

class FluentEmptyStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEmptyStatement()
    }
}


class FluentEnhancedForStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentForStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentLabeledStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSuperConstructorInvocation : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSwitchCase : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSwitchStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentSynchronizedStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentThrowStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentTryStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentTypeDeclarationStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}




