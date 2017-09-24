package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.Statement

class FluentForStatement internal constructor(
        private val initFragments: Collection<FluentExpression>,
        private val end: FluentExpression?,
        private val updateFragments: Collection<FluentExpression>,
        private val body: FluentStatement) : FluentStatement() {
    override fun build(ast: AST): Statement {
        val forStatement = ast.newForStatement()
        forStatement.initializers().addAll(initFragments.map { it.build(ast) })
        forStatement.expression = end?.build(ast)
        forStatement.updaters().addAll(updateFragments.map { it.build(ast) })
        forStatement.body = body.build(ast)
        return forStatement
    }

    class ForPartial(
            private val initFragments: MutableCollection<FluentExpression>,
            private var end: FluentExpression?,
            private val updateFragments: MutableCollection<FluentExpression>) {


        fun init(initExpression: FluentExpression): ForPartial {
            initFragments.add(initExpression)
            return this
        }

        fun end(expression: FluentExpression): ForPartial {
            this.end = expression
            return this
        }

        fun update(updateExpression: FluentExpression): ForPartial {
            updateFragments.add(updateExpression)
            return this
        }

        fun body(statement: FluentStatement): FluentForStatement {
            return FluentForStatement(initFragments, end, updateFragments, statement)
        }

    }
}