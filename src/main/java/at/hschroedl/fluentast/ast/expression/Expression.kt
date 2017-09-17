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

internal class FluentParsedExpression internal constructor(private val content: String) : FluentExpression() {

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

fun exp(content: String): FluentExpression {
    return FluentParsedExpression(content)
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
        return when (operator) {
            "=" -> Assignment.Operator.ASSIGN
            "+=" -> Assignment.Operator.PLUS_ASSIGN
            "-=" -> Assignment.Operator.MINUS_ASSIGN
            "*=" -> Assignment.Operator.TIMES_ASSIGN
            "/=" -> Assignment.Operator.DIVIDE_ASSIGN
            "&=" -> Assignment.Operator.BIT_AND_ASSIGN
            "|=" -> Assignment.Operator.BIT_OR_ASSIGN
            "^=" -> Assignment.Operator.BIT_XOR_ASSIGN
            "%=" -> Assignment.Operator.REMAINDER_ASSIGN
            "<<=" -> Assignment.Operator.LEFT_SHIFT_ASSIGN
            ">>=" -> Assignment.Operator.RIGHT_SHIFT_SIGNED_ASSIGN
            ">>>=" -> Assignment.Operator.RIGHT_SHIFT_UNSIGNED_ASSIGN
            else -> throw FluentArgumentException("Invalid assignment operator '$operator.'")
        }
    }
}


fun assignment(left: FluentExpression, operator: String, right: FluentExpression): FluentAssignment {
    return FluentAssignment(left, operator, right)
}

class FluentCastExpression internal constructor(private val type: FluentType?,
                                                private val expression: FluentExpression) : FluentExpression() {

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

class FluentConditionalExpression internal constructor(private val condition: FluentExpression,
                                                       private val then: FluentExpression,
                                                       private val `else`: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): ConditionalExpression {
        val exp = ast.newConditionalExpression()
        exp.expression = condition.build(ast)
        exp.thenExpression = then.build(ast)
        exp.elseExpression = `else`.build(ast)
        return exp
    }
}

fun ternary(condition: FluentExpression, then: FluentExpression,
            `else`: FluentExpression): FluentConditionalExpression {
    return FluentConditionalExpression(condition, then, `else`)
}

class FluentFieldAccess internal constructor(private val expression: FluentExpression,
                                             private val fieldName: String) : FluentExpression() {
    override fun build(ast: AST): FieldAccess {
        val exp = ast.newFieldAccess()
        exp.expression = expression.build(ast)
        exp.name = ast.newSimpleName(fieldName)
        return exp
    }
}

fun fieldAccess(expression: FluentExpression, fieldName: String): FluentFieldAccess {
    return FluentFieldAccess(expression, fieldName)
}


class FluentInfixExpression internal constructor(private val left: FluentExpression, private val operator: String,
                                                 private vararg val right: FluentExpression) : FluentExpression() {
    override fun build(ast: AST): Expression? {
        val exp = ast.newInfixExpression()
        exp.leftOperand = left.build(ast)
        exp.operator = infixOperator(operator)
        if (right.isEmpty()) {
            throw FluentArgumentException("Infix must have at least one right-hand-side expression.")
        }
        exp.rightOperand = right[0].build(ast)
        // TODO: fix this hot garbage
        if (right.size > 1) {
            for (i in 2 until right.size) {
                exp.extendedOperands().add(right[i])
            }
        }
        return exp
    }

    private fun infixOperator(operator: String): InfixExpression.Operator {
        return when (operator) {
            "*" -> InfixExpression.Operator.TIMES
            "/" -> InfixExpression.Operator.DIVIDE
            "%" -> InfixExpression.Operator.REMAINDER
            "+" -> InfixExpression.Operator.PLUS
            "-" -> InfixExpression.Operator.MINUS
            "<<" -> InfixExpression.Operator.LEFT_SHIFT
            ">>" -> InfixExpression.Operator.RIGHT_SHIFT_SIGNED
            ">>>" -> InfixExpression.Operator.RIGHT_SHIFT_UNSIGNED
            "<" -> InfixExpression.Operator.LESS
            ">" -> InfixExpression.Operator.GREATER
            "<=" -> InfixExpression.Operator.LESS_EQUALS
            ">=" -> InfixExpression.Operator.GREATER_EQUALS
            "==" -> InfixExpression.Operator.EQUALS
            "!=" -> InfixExpression.Operator.NOT_EQUALS
            "^" -> InfixExpression.Operator.XOR
            "&" -> InfixExpression.Operator.AND
            "|" -> InfixExpression.Operator.OR
            "&&" -> InfixExpression.Operator.CONDITIONAL_AND
            "||" -> InfixExpression.Operator.CONDITIONAL_OR
            else -> throw FluentArgumentException("Invalid infix operator '$operator.'")
        }
    }
}

fun infix(left: FluentExpression, operator: String, vararg right: FluentExpression): FluentInfixExpression {
    return FluentInfixExpression(left, operator, *right)
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
    override fun build(ast: AST): ThisExpression {
        return ast.newThisExpression()
    }
}

fun thiss(): FluentThisExpression {
    return FluentThisExpression()
}


