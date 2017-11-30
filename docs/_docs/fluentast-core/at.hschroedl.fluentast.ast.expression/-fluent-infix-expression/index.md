---
title: FluentInfixExpression - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.expression](../index.html) / [FluentInfixExpression](.)

# FluentInfixExpression

`open class FluentInfixExpression : `[`FluentExpression`](../-fluent-expression/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/InfixExpression.kt#L11)

Used to build an [InfixExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/InfixExpression.html) with a left operand, an operator and a right operand.

### Properties

| [operator](operator.html) | `val operator: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [build](build.html) | `open fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`InfixExpression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/InfixExpression.html) |
| [right](right.html) | `fun right(anotherExpression: `[`FluentExpression`](../-fluent-expression/index.html)`): FluentInfixExpression`<br>Adds a [FluentExpression](../-fluent-expression/index.html) to the list of extended operands on the right hand side of the operator. |

### Inherited Functions

| [build](../-fluent-expression/build.html) | `open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](../-fluent-expression/field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](../-fluent-field-access/index.html) |
| [index](../-fluent-expression/--index--.html) | `fun index(expression: `[`FluentExpression`](../-fluent-expression/index.html)`): `[`FluentArrayAccess`](../-fluent-array-access/index.html) |

