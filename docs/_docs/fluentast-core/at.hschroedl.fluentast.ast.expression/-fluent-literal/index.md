---
title: FluentLiteral - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.expression](../index.html) / [FluentLiteral](.)

# FluentLiteral

`abstract class FluentLiteral : `[`FluentExpression`](../-fluent-expression/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/LiteralExpression.kt#L4)

### Constructors

| [&lt;init&gt;](-init-.html) | `FluentLiteral()` |

### Inherited Functions

| [build](../-fluent-expression/build.html) | `abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)<br>`open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](../-fluent-expression/field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](../-fluent-field-access/index.html) |
| [index](../-fluent-expression/--index--.html) | `fun index(expression: `[`FluentExpression`](../-fluent-expression/index.html)`): `[`FluentArrayAccess`](../-fluent-array-access/index.html) |

### Inheritors

| [FluentBooleanLiteral](../-fluent-boolean-literal/index.html) | `class FluentBooleanLiteral : FluentLiteral` |
| [FluentCharacterLiteral](../-fluent-character-literal/index.html) | `class FluentCharacterLiteral : FluentLiteral` |
| [FluentNumberLiteral](../-fluent-number-literal/index.html) | `class FluentNumberLiteral : FluentLiteral` |

