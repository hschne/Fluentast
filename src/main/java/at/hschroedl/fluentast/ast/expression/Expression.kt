package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.*
import at.hschroedl.fluentast.ast.type.FluentArrayType
import at.hschroedl.fluentast.ast.type.FluentType

import org.eclipse.jdt.core.dom.*

abstract class FluentExpression : FluentASTNode(), FluentChildNode<Expression>, FluentStandaloneNode<Expression> {

    abstract override fun build(ast: AST): Expression?

    override fun build(): Expression {
        val ast: AST = AST.newAST(AST.JLS8)
        return build(ast)!!
    }
}

internal class FluentParsedExpression(private val content: String) : FluentExpression() {

    override fun build(): Expression {
        val result = FluentParsedNode(content, ASTParser.K_EXPRESSION).build()
        if (result is CompilationUnit) {
            // If we get a compilation unit as result that means parsing failed
            val error = result.problems[0]
            throw FluentArgumentException(
                    "Failed to parse expression '$content'. $error")
        }
        return result as Expression
    }


    override fun build(ast: AST): Expression {
        return ASTNode.copySubtree(ast, build()) as Expression
    }
}

class FluentArrayAccess internal constructor(private val array: FluentExpression,
                                             private val index: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newArrayAccess()
        exp.array = array.build(ast)
        exp.index = index.build(ast)
        return exp
    }
}

fun arrayIndex(array: FluentExpression, index: FluentExpression): FluentArrayAccess {
    return FluentArrayAccess(array, index)
}

class FluentArrayCreation internal constructor(private val type: FluentArrayType,
                                               private val initializer: FluentArrayInitializer?) : FluentExpression() {
    override fun build(ast: AST): ArrayCreation {
        val exp = ast.newArrayCreation()
        exp.type = type.build(ast)
        exp.initializer = initializer?.build(ast)
        return exp
    }

}

fun newArray(type: FluentArrayType, initializer: FluentArrayInitializer?): FluentArrayCreation {
    return FluentArrayCreation(type, initializer)
}

fun newArray(type: FluentArrayType): FluentArrayCreation {
    return FluentArrayCreation(type, null)
}

class FluentArrayInitializer internal constructor(
        private vararg val expressions: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): ArrayInitializer {
        val exp = ast.newArrayInitializer()
        expressions
                .map { it.build(ast) }
                .forEach { exp.expressions().add(it) }
        return exp
    }
}

fun arrayInit(vararg expression: FluentExpression): FluentArrayInitializer {
    return FluentArrayInitializer(*expression)
}

class FluentAssignment internal constructor(private val left: FluentExpression, private val operator: String,
                                            private val right: FluentExpression) : FluentExpression() {


    override fun build(ast: AST): Assignment {
        val exp = ast.newAssignment()
        exp.leftHandSide = left.build(ast)
        exp.operator = assignmentOperator(operator)
        exp.rightHandSide = right.build(ast)
        return exp
    }

    private fun assignmentOperator(operator: String): Assignment.Operator {
        when (operator) {
            "=" -> return Assignment.Operator.ASSIGN
            "+=" -> return Assignment.Operator.PLUS_ASSIGN
            "-=" -> return Assignment.Operator.MINUS_ASSIGN
            "*=" -> return Assignment.Operator.TIMES_ASSIGN
            "/=" -> return Assignment.Operator.DIVIDE_ASSIGN
            "&=" -> return Assignment.Operator.BIT_AND_ASSIGN
            "|=" -> return Assignment.Operator.BIT_OR_ASSIGN
            "^=" -> return Assignment.Operator.BIT_XOR_ASSIGN
            "%=" -> return Assignment.Operator.REMAINDER_ASSIGN
            "<<=" -> return Assignment.Operator.LEFT_SHIFT_ASSIGN
            ">>=" -> return Assignment.Operator.RIGHT_SHIFT_SIGNED_ASSIGN
            ">>>=" -> return Assignment.Operator.RIGHT_SHIFT_UNSIGNED_ASSIGN
            else -> throw FluentArgumentException("Invalid assignment operator '$operator.'")
        }
    }
}


fun assignment(left: FluentExpression, operator: String, right: FluentExpression): FluentAssignment {
    return FluentAssignment(left, operator, right)
}

class FluentCastExpression internal constructor(private val type: FluentType?,
                                                private val expression: FluentExpression) : FluentExpression() {

    internal constructor(type: FluentExpression) : this(null, type)

    override fun build(ast: AST): CastExpression {
        val exp = ast.newCastExpression()
        exp.type = type?.build(ast)
        exp.expression = expression.build(ast)
        return exp
    }
}

fun cast(type: FluentType, expression: FluentExpression): FluentCastExpression {
    return FluentCastExpression(type, expression)
}

class FluentClassInstanceCreation() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        throw NotImplementedError()
    }
}


class FluentConditionalExpression(private val condition: FluentExpression, private val then: FluentExpression,
                                  private val `else`: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newConditionalExpression()
        exp.expression = condition.build(ast)
        exp.thenExpression = then.build(ast)
        exp.elseExpression = `else`.build(ast)
        return exp
    }
}

fun tern(condition: FluentExpression, then: FluentExpression, `else`: FluentExpression): FluentConditionalExpression {
    return FluentConditionalExpression(condition, then, `else`)
}

class FluentFieldAccess() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


class FluentInfixExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentInstanceOfExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentMethodInvocation() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentName() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


class FluentParanethesizedExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentPostfixExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentPrefixExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


class FluentSuperFieldAccess() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentSuperMethodInvocation() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}


class FluentAnnotationExpression() : FluentExpression() {
    override fun build(ast: AST): Expression? {
        return null
    }
}

class FluentThisExpression : FluentExpression() {
    override fun build(ast: AST): Expression {
        return ast.newThisExpression()
    }
}


fun exp(): FluentExpression {
    return FluentThisExpression()
}

fun exp(content: String): FluentExpression {
    return FluentParsedExpression(content)
}

