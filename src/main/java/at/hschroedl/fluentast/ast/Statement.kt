package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.*
import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.*


abstract class FluentStatement : FluentASTNode(), FluentStandaloneNode<Statement>, FluentChildNode<Statement> {

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

class FluentAssertStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newAssertStatement()
    }
}

class FluentBreakStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newBreakStatement()
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

class FluentExpressionStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentForStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentIfStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentLabeledStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentReturnStatement(private val expression: FluentExpression?) : FluentStatement() {

    override fun build(ast: AST): Statement {
        val ret = ast.newReturnStatement()
        ret.expression = expression?.build(ast)
        return ret
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

class FluenVariableDeclarationStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

class FluentWhileStatement : FluentStatement() {
    override fun build(ast: AST): Statement {
        return ast.newEnhancedForStatement()
    }
}

fun stmnt(content: String): FluentStatement {
    return FluentParsedStatement(content)
}

fun br(): FluentStatement {
    return FluentBreakStatement()
}

fun ret(): FluentStatement {
    return FluentReturnStatement(null)
}

fun ret(expression: FluentExpression): FluentReturnStatement {
    return FluentReturnStatement(expression)
}

fun empty(): FluentStatement {
    return FluentEmptyStatement()
}



