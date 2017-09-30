package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.ast.expression.FluentExpression
import at.hschroedl.fluentast.if_
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.IfStatement

/**
 * Used to construct an [IfStatement] with a condition and a then-statement,
 * but without a else-statement.
 *
 * For examples and usage see [if_].
 *
 */
class FluentIfStatement internal constructor(private val condition: FluentExpression,
                                             private val body: FluentStatement) : FluentStatement() {


    override fun build(ast: AST): IfStatement {
        val ifStatement = ast.newIfStatement()
        ifStatement.expression = condition.build(ast)
        ifStatement.thenStatement = body.build(ast)
        return ifStatement
    }

    /**
     * Creates a new [FluentIfElseStatement].
     *
     * @param statement statement in the else-part of the if-statement.
     *
     * @return FluentIfElseStatement with a condition, a then body and an else body.
     */
    fun else_(statement: FluentStatement): FluentIfElseStatement {
        return FluentIfElseStatement(condition, body, statement)
    }
}

/**
 * Used to construct an [IfStatement] with a condition, a then statement and an
 * else-statement.
 *
 * For examples and usage see [if_].
 */
class FluentIfElseStatement internal constructor(private val condition: FluentExpression,
                                                 private val body: FluentStatement,
                                                 private val elseBody: FluentStatement? = null) : FluentStatement() {

    override fun build(ast: AST): IfStatement {
        val ifStatement = ast.newIfStatement()
        ifStatement.expression = condition.build(ast)
        ifStatement.thenStatement = body.build(ast)
        ifStatement.elseStatement = elseBody?.build(ast)
        return ifStatement
    }

}

/**
 * Represents an [IfStatement] where a condition has
 * been set, but a then-statement or else-statement have yet to be added.
 *
 * For examples and usage see [if_].
 */
class IfPartial internal constructor(private val condition: FluentExpression) {

    /**
     * Create a [FluentIfStatement].
     *
     * @param statement the statement in the then-part of the [IfStatement].
     * @return the FluentIfStatement with the given statement as then-body.
     */
    fun then(statement: FluentStatement): FluentIfStatement {
        return FluentIfStatement(this.condition, statement)
    }
}



