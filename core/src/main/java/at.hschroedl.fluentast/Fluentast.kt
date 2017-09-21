package at.hschroedl.fluentast

import at.hschroedl.fluentast.ast.FluentMemberValuePair
import at.hschroedl.fluentast.ast.expression.*
import at.hschroedl.fluentast.ast.statement.*
import at.hschroedl.fluentast.ast.type.FluentArrayType
import at.hschroedl.fluentast.ast.type.FluentType
import at.hschroedl.fluentast.ast.type.p
import at.hschroedl.fluentast.ast.type.t


fun annotation(name: String): FluentMarkerAnnotation {
    return FluentMarkerAnnotation(name)
}

fun annotation(name: String, expression: FluentExpression): FluentSingleMemberAnnotation {
    return FluentSingleMemberAnnotation(name, expression)
}

fun annotation(name: String, vararg members: FluentMemberValuePair): FluentNormalAnnotation {
    return FluentNormalAnnotation(name, *members)
}

fun arrayIndex(array: FluentExpression, index: FluentExpression): FluentArrayAccess {
    return FluentArrayAccess(array, index)
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

fun fieldAccess(expression: FluentExpression, fieldName: String): FluentFieldAccess {
    return FluentFieldAccess(expression, fieldName)
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

fun `var`(name: String): FluentName {
    return FluentName(name);
}

fun name(name: String): FluentName {
    return FluentName(name)
}

fun nullz(): FluentNullLiteral {
    return FluentNullLiteral()
}

fun i(value: Int): FluentNumberLiteral {
    return FluentNumberLiteral(value)
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
    return FluentVariableDeclarationExpression(p("int"), Pair(name, i(initializer)))
}

fun decl(name: String, initializer: Boolean): FluentExpression {
    return FluentVariableDeclarationExpression(p("boolean"), Pair(name, b(initializer)))
}

fun decl(name: String, initializer: Char): FluentExpression {
    return FluentVariableDeclarationExpression(p("char"), Pair(name, c(initializer)))
}

fun decl(type: String, name: String): FluentExpression {
    return FluentVariableDeclarationExpression(t(type), Pair(name, null))
}

fun decl(type: String, name: String, expression: FluentExpression): FluentExpression {
    return FluentVariableDeclarationExpression(t(type), Pair(name, expression))
}

fun infix(left: FluentExpression, operator: String, vararg right: FluentExpression): FluentInfixExpression {
    return FluentInfixExpression(left, operator, *right)
}


fun thiss(): FluentThisExpression {
    return FluentThisExpression()
}

fun thiss(qualifier: String): FluentThisExpression {
    return FluentThisExpression(qualifier = qualifier)
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

fun assignment(left: FluentExpression, operator: String, right: FluentExpression): FluentAssignment {
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

fun iff(condition: FluentExpression): FluentIfStatement.IfPartial {
    return FluentIfStatement.IfPartial(condition)
}


fun whilez(condition: FluentExpression, body: FluentStatement): FluentWhileStatement {
    return FluentWhileStatement(condition, body)
}

fun cast(type: FluentType, expression: FluentExpression): FluentCastExpression {
    return FluentCastExpression(type, expression)
}