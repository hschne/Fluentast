---
title: FluentAnnotation - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast.ast.expression](index.html) / [FluentAnnotation](.)

# FluentAnnotation

`abstract class FluentAnnotation : `[`FluentExpression`](-fluent-expression/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/ast/expression/NormalAnnotation.kt#L7)

### Inherited Functions

| [build](-fluent-expression/build.html) | `abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)<br>`open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](-fluent-expression/field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](-fluent-field-access/index.html) |
| [index](-fluent-expression/--index--.html) | `fun index(expression: `[`FluentExpression`](-fluent-expression/index.html)`): `[`FluentArrayAccess`](-fluent-array-access/index.html) |

### Inheritors

| [FluentMarkerAnnotation](-fluent-marker-annotation/index.html) | `class FluentMarkerAnnotation : FluentAnnotation` |
| [FluentNormalAnnotation](-fluent-normal-annotation/index.html) | `class FluentNormalAnnotation : FluentAnnotation` |
| [FluentSingleMemberAnnotation](-fluent-single-member-annotation/index.html) | `class FluentSingleMemberAnnotation : FluentAnnotation` |

