---
title: FluentExpression - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.expression](../index.html) / [FluentExpression](.)

# FluentExpression

`abstract class FluentExpression : `[`FluentASTNode`](../../at.hschroedl.fluentast.ast/-fluent-a-s-t-node/index.html)`, `[`FluentStandaloneNode`](../../at.hschroedl.fluentast.ast/-fluent-standalone-node/index.html)`<`[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)`>` [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/Expression.kt#L8)

### Functions

| [build](build.html) | `abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)<br>`open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](../-fluent-field-access/index.html) |
| [index](--index--.html) | `fun index(expression: FluentExpression): `[`FluentArrayAccess`](../-fluent-array-access/index.html) |

### Inheritors

| [FluentAnnotation](../-fluent-annotation.html) | `abstract class FluentAnnotation : FluentExpression` |
| [FluentArrayAccess](../-fluent-array-access/index.html) | `class FluentArrayAccess : FluentExpression`<br>A wrapper class for [ArrayAccess](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ArrayAccess.html). Subclass of FluentExpression |
| [FluentArrayCreation](../-fluent-array-creation/index.html) | `class FluentArrayCreation : FluentExpression`<br>Used to create an [ArrayCreation](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ArrayCreation.html) with the given [FluentArrayType](../../at.hschroedl.fluentast.ast.type/-fluent-array-type/index.html) and a [FluentArrayInitializer](../-fluent-array-initializer/index.html). |
| [FluentArrayInitializer](../-fluent-array-initializer/index.html) | `class FluentArrayInitializer : FluentExpression` |
| [FluentAssignment](../-fluent-assignment/index.html) | `class FluentAssignment : FluentExpression` |
| [FluentCastExpression](../-fluent-cast-expression/index.html) | `class FluentCastExpression : FluentExpression` |
| [FluentClassInstanceCreation](../-fluent-class-instance-creation/index.html) | `class FluentClassInstanceCreation : FluentExpression` |
| [FluentConditionalExpression](../-fluent-conditional-expression/index.html) | `class FluentConditionalExpression : FluentExpression` |
| [FluentFieldAccess](../-fluent-field-access/index.html) | `class FluentFieldAccess : FluentExpression` |
| [FluentInfixExpression](../-fluent-infix-expression/index.html) | `open class FluentInfixExpression : FluentExpression`<br>Used to build an [InfixExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/InfixExpression.html) with a left operand, an operator and a right operand. |
| [FluentInstanceOfExpression](../-fluent-instance-of-expression/index.html) | `class FluentInstanceOfExpression : FluentExpression` |
| [FluentLiteral](../-fluent-literal.html) | `abstract class FluentLiteral : FluentExpression`<br>Base class for other literals. See [NumberLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/NumberLiteral.html),[StringLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/StringLiteral.html),[BooleanLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/BooleanLiteral.html)... |
| [FluentMethodInvocation](../-fluent-method-invocation/index.html) | `class FluentMethodInvocation : FluentExpression` |
| [FluentName](../-fluent-name/index.html) | `class FluentName : FluentExpression` |
| [FluentNullLiteral](../-fluent-null-literal/index.html) | `class FluentNullLiteral : FluentExpression`<br>Used to build a [NullLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/NullLiteral.html). |
| [FluentParenthesizedExpression](../-fluent-parenthesized-expression/index.html) | `class FluentParenthesizedExpression : FluentExpression` |
| [FluentPostfixExpression](../-fluent-postfix-expression/index.html) | `class FluentPostfixExpression : FluentExpression` |
| [FluentPrefixExpression](../-fluent-prefix-expression/index.html) | `class FluentPrefixExpression : FluentExpression` |
| [FluentStringLiteral](../-fluent-string-literal/index.html) | `class FluentStringLiteral : FluentExpression`<br>Used to build a [StringLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/StringLiteral.html) with a given value. |
| [FluentSuperFieldAccess](../-fluent-super-field-access/index.html) | `class FluentSuperFieldAccess : FluentExpression` |
| [FluentSuperMethodInvocation](../-fluent-super-method-invocation/index.html) | `class FluentSuperMethodInvocation : FluentExpression`<br>Used to build a [SuperMethodInvocation](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/SuperMethodInvocation.html). |
| [FluentThisExpression](../-fluent-this-expression/index.html) | `class FluentThisExpression : FluentExpression`<br>Used to build a [ThisExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ThisExpression.html). |
| [FluentTypeLiteral](../-fluent-type-literal/index.html) | `class FluentTypeLiteral : FluentExpression`<br>Used to build a [TypeLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/TypeLiteral.html) from a [FluentType](../../at.hschroedl.fluentast.ast.type/-fluent-type/index.html). |
| [FluentVariableDeclarationExpression](../-fluent-variable-declaration-expression/index.html) | `class FluentVariableDeclarationExpression : FluentExpression`<br>A wrapper class for [VariableDeclarationExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/VariableDeclarationExpression.html). |

