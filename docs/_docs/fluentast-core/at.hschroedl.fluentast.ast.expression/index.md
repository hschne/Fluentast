---
title: at.hschroedl.fluentast.ast.expression - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast.ast.expression](.)

## Package at.hschroedl.fluentast.ast.expression

Contains Expressions.

## Level 2 heading

Text after this heading is also part of documentation for `org.jetbrains.kotlin.demo`

### Types

| [FluentAnnotation](-fluent-annotation/index.html) | `abstract class FluentAnnotation : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentArrayAccess](-fluent-array-access/index.html) | `class FluentArrayAccess : `[`FluentExpression`](-fluent-expression/index.html)<br>A wrapper class for [ArrayAccess](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ArrayAccess.html). Subclass of [FluentExpression](-fluent-expression/index.html) |
| [FluentArrayCreation](-fluent-array-creation/index.html) | `class FluentArrayCreation : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentArrayInitializer](-fluent-array-initializer/index.html) | `class FluentArrayInitializer : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentAssignment](-fluent-assignment/index.html) | `class FluentAssignment : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentBooleanLiteral](-fluent-boolean-literal/index.html) | `class FluentBooleanLiteral : `[`FluentLiteral`](-fluent-literal/index.html) |
| [FluentCastExpression](-fluent-cast-expression/index.html) | `class FluentCastExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentCharacterLiteral](-fluent-character-literal/index.html) | `class FluentCharacterLiteral : `[`FluentLiteral`](-fluent-literal/index.html) |
| [FluentClassInstanceCreation](-fluent-class-instance-creation/index.html) | `class FluentClassInstanceCreation : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentConditionalExpression](-fluent-conditional-expression/index.html) | `class FluentConditionalExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentExpression](-fluent-expression/index.html) | `abstract class FluentExpression : `[`FluentASTNode`](../at.hschroedl.fluentast.ast/-fluent-a-s-t-node/index.html)`, `[`FluentStandaloneNode`](../at.hschroedl.fluentast.ast/-fluent-standalone-node/index.html)`<`[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)`>` |
| [FluentFieldAccess](-fluent-field-access/index.html) | `class FluentFieldAccess : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentInfixExpression](-fluent-infix-expression/index.html) | `open class FluentInfixExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentInstanceOfExpression](-fluent-instance-of-expression/index.html) | `class FluentInstanceOfExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentLiteral](-fluent-literal/index.html) | `abstract class FluentLiteral : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentMarkerAnnotation](-fluent-marker-annotation/index.html) | `class FluentMarkerAnnotation : `[`FluentAnnotation`](-fluent-annotation/index.html) |
| [FluentMethodInvocation](-fluent-method-invocation/index.html) | `class FluentMethodInvocation : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentName](-fluent-name/index.html) | `class FluentName : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentNormalAnnotation](-fluent-normal-annotation/index.html) | `class FluentNormalAnnotation : `[`FluentAnnotation`](-fluent-annotation/index.html) |
| [FluentNullLiteral](-fluent-null-literal/index.html) | `class FluentNullLiteral : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentNumberLiteral](-fluent-number-literal/index.html) | `class FluentNumberLiteral : `[`FluentLiteral`](-fluent-literal/index.html) |
| [FluentParenthesizedExpression](-fluent-parenthesized-expression/index.html) | `class FluentParenthesizedExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentPostfixExpression](-fluent-postfix-expression/index.html) | `class FluentPostfixExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentPrefixExpression](-fluent-prefix-expression/index.html) | `class FluentPrefixExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentSingleMemberAnnotation](-fluent-single-member-annotation/index.html) | `class FluentSingleMemberAnnotation : `[`FluentAnnotation`](-fluent-annotation/index.html) |
| [FluentStringLiteral](-fluent-string-literal/index.html) | `class FluentStringLiteral : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentSuperFieldAccess](-fluent-super-field-access/index.html) | `class FluentSuperFieldAccess : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentSuperMethodInvocation](-fluent-super-method-invocation/index.html) | `class FluentSuperMethodInvocation : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentThisExpression](-fluent-this-expression/index.html) | `class FluentThisExpression : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentTypeLiteral](-fluent-type-literal/index.html) | `class FluentTypeLiteral : `[`FluentExpression`](-fluent-expression/index.html) |
| [FluentVariableDeclarationExpression](-fluent-variable-declaration-expression/index.html) | `class FluentVariableDeclarationExpression : `[`FluentExpression`](-fluent-expression/index.html) |

### Functions

| [prefix](prefix.html) | `fun prefix(operator: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, expression: `[`FluentExpression`](-fluent-expression/index.html)`): `[`FluentPrefixExpression`](-fluent-prefix-expression/index.html) |

