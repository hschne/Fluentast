---
title: FluentInfixOperatorPartial - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.expression](../index.html) / [FluentInfixOperatorPartial](.)

# FluentInfixOperatorPartial

`class FluentInfixOperatorPartial` [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/InfixExpression.kt#L94)

Used to build an [InfixExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/InfixExpression.html). This partial represents an intermediate
representation where the operator has been set
but a right-hand side and left-hand-side operand are missing.

### Functions

| [left](left.html) | `fun left(expression: `[`FluentExpression`](../-fluent-expression/index.html)`): `[`FluentInfixLeftPartial`](../-fluent-infix-left-partial/index.html)<br>Creates a [FluentInfixLeftPartial](../-fluent-infix-left-partial/index.html) by adding a left-hand-side operand to the infix. |

