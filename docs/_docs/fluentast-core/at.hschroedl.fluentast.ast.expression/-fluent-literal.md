---
title: FluentLiteral - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast.ast.expression](index.html) / [FluentLiteral](.)

# FluentLiteral

`abstract class FluentLiteral : `[`FluentExpression`](-fluent-expression/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/LiteralExpression.kt#L10)

Base class for other literals. See [NumberLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/NumberLiteral.html),[StringLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/StringLiteral.html),[BooleanLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/BooleanLiteral.html)...

### Inherited Functions

| [build](-fluent-expression/build.html) | `abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)<br>`open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](-fluent-expression/field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](-fluent-field-access/index.html) |
| [index](-fluent-expression/--index--.html) | `fun index(expression: `[`FluentExpression`](-fluent-expression/index.html)`): `[`FluentArrayAccess`](-fluent-array-access/index.html) |

### Inheritors

| [FluentBooleanLiteral](-fluent-boolean-literal/index.html) | `class FluentBooleanLiteral : FluentLiteral`<br>Used to build a [BooleanLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/BooleanLiteral.html) with a given value. |
| [FluentCharacterLiteral](-fluent-character-literal/index.html) | `class FluentCharacterLiteral : FluentLiteral`<br>Used to build a [CharacterLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/CharacterLiteral.html) with a given character value. |
| [FluentNumberLiteral](-fluent-number-literal/index.html) | `class FluentNumberLiteral : FluentLiteral`<br>Used to build a [NumberLiteral](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/NumberLiteral.html) with a given integer value. |

