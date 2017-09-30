package at.hschroedl.fluentast

import at.hschroedl.fluentast.ast.FluentMemberValuePair
import at.hschroedl.fluentast.ast.FluentVariableDeclarationFragment
import at.hschroedl.fluentast.ast.FluentVariableDeclarationFragmentImpl
import at.hschroedl.fluentast.ast.expression.*
import at.hschroedl.fluentast.ast.statement.*
import at.hschroedl.fluentast.ast.type.FluentArrayType
import at.hschroedl.fluentast.ast.type.FluentPrimitiveType
import at.hschroedl.fluentast.ast.type.FluentType
import org.eclipse.jdt.core.dom.IfStatement
import org.eclipse.jdt.core.dom.ReturnStatement


fun annotation(name: String): FluentMarkerAnnotation {
    return FluentMarkerAnnotation(name)
}

fun annotation(name: String, expression: FluentExpression): FluentSingleMemberAnnotation {
    return FluentSingleMemberAnnotation(name,
                                        expression)
}

fun annotation(name: String, vararg members: FluentMemberValuePair): FluentNormalAnnotation {
    return FluentNormalAnnotation(name, *members)
}

fun b(value: Boolean): FluentBooleanLiteral {
    return FluentBooleanLiteral(value)
}

fun c(value: Char): FluentCharacterLiteral {
    return FluentCharacterLiteral(value)
}

fun ternary(condition: FluentExpression, then: FluentExpression,
            `else`: FluentExpression): FluentConditionalExpression {
    return FluentConditionalExpression(condition, then, `else`)
}

fun instanceof(left: FluentExpression, right: FluentType): FluentInstanceOfExpression {
    return FluentInstanceOfExpression(left, right)
}

fun invocation(name: String): FluentMethodInvocation {
    return FluentMethodInvocation(name = name)
}

fun invocation(expression: FluentExpression,
               typeParameter: List<FluentType>,
               name: String,
               vararg arguments: FluentExpression): FluentMethodInvocation {
    return FluentMethodInvocation(expression, typeParameter, name, *arguments)
}

fun n(name: String): FluentName {
    return FluentName(name)
}

fun fragment(name: String): FluentVariableDeclarationFragmentImpl {
    return FluentVariableDeclarationFragmentImpl(name)
}

fun p(type: String): FluentPrimitiveType {
    return FluentPrimitiveType(type)
}

fun name(name: String): FluentName {
    return FluentName(name)
}

fun null_(): FluentNullLiteral {
    return FluentNullLiteral()
}

fun i(value: Int): FluentNumberLiteral {
    return FluentNumberLiteral(value)
}

fun stmnt(content: String): FluentStatement {
    return FluentParsedStatement(content)
}


fun break_(): FluentStatement {
    return FluentBreakStatement()
}

/**
 * Creates a [ReturnStatement] using [FluentReturnStatement].
 *
 * ## Comparison of Fluentast and JDT:
 *
 * ### Fluentast:
 *
 * ~~~ java
 * return_(expression).build()
 * ~~~
 *
 * ### JDT:
 *
 * ~~~ java
 * ReturnStatement returnStatement = ast.newReturnStatement();
 * returnStatement.setExpression(expression)
 * ~~~
 *
 * ### Result:
 *
 * ~~~ java
 * return expression;
 * ~~~
 *
 * For more examples see the [Demo Project](https://github.com/hschroedl/FluentAST/tree/master/demo).
 *
 * @see [FluentReturnStatement]
 *
 */
fun return_(): FluentStatement {
    return FluentReturnStatement(null)
}

/**
 * Creates a [ReturnStatement] using [FluentReturnStatement].
 *
 * ## Comparison of Fluentast and JDT:
 *
 * ### Fluentast:
 *
 * ~~~ java
 * return_(expression).build()
 * ~~~
 *
 * ### JDT:
 *
 * ~~~ java
 * ReturnStatement returnStatement = ast.newReturnStatement();
 * returnStatement.setExpression(expression)
 * ~~~
 *
 * ### Result:
 *
 * ~~~ java
 * return expression;
 * ~~~
 *
 * For more examples see the [Demo Project](https://github.com/hschroedl/FluentAST/tree/master/demo).
 *
 * @see [FluentReturnStatement]
 *
 */
fun return_(expression: FluentExpression): FluentReturnStatement {
    return FluentReturnStatement(expression)
}

fun empty(): FluentStatement {
    return FluentEmptyStatement()
}


fun exp(content: String): FluentExpression {
    return FluentParsedExpression(content)
}

fun paranthesis(expression: FluentExpression): FluentParenthesizedExpression {
    return FluentParenthesizedExpression(expression)
}

fun s(literal: String): FluentStringLiteral {
    return FluentStringLiteral(literal)
}

fun superField(field: String): FluentSuperFieldAccess {
    return FluentSuperFieldAccess(null, field)
}

fun superField(className: String, field: String): FluentSuperFieldAccess {
    return FluentSuperFieldAccess(className, field)
}


fun superMethod(name: String): FluentSuperMethodInvocation {
    return FluentSuperMethodInvocation(name = name)
}

fun superMethod(qualifier: String,
                typeParameter: List<FluentType>,
                name: String,
                vararg arguments: FluentExpression): FluentSuperMethodInvocation {
    return FluentSuperMethodInvocation(qualifier, typeParameter, name, *arguments)
}


fun decl(name: String, initializer: Int): FluentExpression {
    return FluentVariableDeclarationExpression(p("int"),
                                               FluentVariableDeclarationFragmentImpl(
                                                       name, initializer =
                                               i(initializer)))
}

fun decl(type: FluentType,
         vararg fragment: FluentVariableDeclarationFragment): FluentVariableDeclarationExpression {
    return FluentVariableDeclarationExpression(type, *fragment)
}

fun decl(name: String, initializer: Boolean): FluentVariableDeclarationExpression {
    return FluentVariableDeclarationExpression(p("boolean"),
                                               FluentVariableDeclarationFragmentImpl(
                                                       name,
                                                       initializer = b(initializer)))
}

fun decl(name: String, initializer: Char): FluentVariableDeclarationExpression {
    return FluentVariableDeclarationExpression(p("char"),
                                               FluentVariableDeclarationFragmentImpl(
                                                       name,
                                                       initializer = c(initializer)))
}

fun decl(type: FluentType, name: String): FluentExpression {
    return FluentVariableDeclarationExpression(type,
                                               FluentVariableDeclarationFragmentImpl(
                                                       name, initializer = null))
}

fun infix(operator: String): FluentInfixExpression.OperatorPartial {
    return FluentInfixExpression.OperatorPartial(operator)
}


fun this_(): FluentThisExpression {
    return FluentThisExpression()
}

fun this_(qualifier: String): FluentThisExpression {
    return FluentThisExpression(qualifier)
}

fun clazz(type: FluentType): FluentTypeLiteral {
    return FluentTypeLiteral(type)
}

fun newArray(type: FluentArrayType, initializer: FluentArrayInitializer?): FluentArrayCreation {
    return FluentArrayCreation(type, initializer)
}

fun newArray(type: FluentArrayType): FluentArrayCreation {
    return FluentArrayCreation(type, null)
}

fun arrayInit(vararg expression: FluentExpression): FluentArrayInitializer {
    return FluentArrayInitializer(*expression)
}

fun assignment(left: FluentExpression, operator: String,
               right: FluentExpression): FluentAssignment {
    return FluentAssignment(left, operator, right)
}

fun assert(expression: FluentExpression): FluentAssertStatement {
    return FluentAssertStatement(expression)
}

fun assert(expression: FluentExpression, message: FluentExpression): FluentAssertStatement {
    return FluentAssertStatement(expression, message)
}

fun body(): FluentBlock {
    return FluentStatementBlock()
}

fun body(vararg statements: FluentStatement): FluentBlock {
    return FluentStatementBlock(arrayOf(*statements))
}

fun body(content: String): FluentBlock {
    return FluentParsedBlock(content)
}

fun block(): FluentBlock {
    return FluentStatementBlock()
}

fun block(vararg statements: FluentStatement): FluentBlock {
    return FluentStatementBlock(arrayOf(*statements))
}

fun stmnt(expression: FluentExpression): FluentExpressionStatement {
    return FluentExpressionStatement(expression)
}


/**
 * Creates an [IfStatement] using [FluentIfStatement] or [FluentIfElseStatement].
 *
 * ## Usage and Result:
 *
 * ### Fluentast:
 *
 * ~~~ java
 * if_(condition)
 *    .then(thenStatement)
 *    .else_(elseStatement)
 *    .build();
 * ~~~
 *
 * ### JDT:
 *
 * ~~~ java
 * IfStatement ifStatement = ast.newIfStatement();
 * ifStatement.setExpression(condition);
 * ifStatement.setThenStatement(thenStatement);
 * ifStatement.setElseStatement(elseStatement);
 * ~~~
 *
 * ### Result:
 *
 * ~~~ java
 * if(condition)
 *   thenStatement
 * else
 *   elseStatement
 * ~~~
 *
 * For more examples see the [Demo Project](https://github.com/hschroedl/FluentAST/tree/master/demo).
 *
 * @see [IfPartial]
 * @see [FluentIfStatement]
 * @see [FluentIfElseStatement]
 *
 */
fun if_(condition: FluentExpression): IfPartial {
    return IfPartial(condition)
}

fun for_(): FluentForStatement.ForPartial {
    return FluentForStatement.ForPartial(mutableListOf(), null, mutableListOf())
}

fun for_(init: FluentExpression, expression: FluentExpression?,
         update: FluentExpression): FluentForStatement.ForPartial {
    return FluentForStatement.ForPartial(mutableListOf(init), expression, mutableListOf(update))
}

fun while_(condition: FluentExpression): FluentWhileStatement.DoPartial {
    return FluentWhileStatement.DoPartial(condition)
}

fun cast(type: FluentType, expression: FluentExpression): FluentCastExpression {
    return FluentCastExpression(type, expression)
}

fun postfix(operator: String): FluentPostfixExpression.PostfixPartial {
    return FluentPostfixExpression.PostfixPartial(operator)
}

fun prefix(operator: String, expression: FluentExpression): FluentPrefixExpression {
    return FluentPrefixExpression(operator, expression)
}