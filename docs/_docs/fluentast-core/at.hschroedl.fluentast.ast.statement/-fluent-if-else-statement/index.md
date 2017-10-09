---
title: FluentIfElseStatement - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.statement](../index.html) / [FluentIfElseStatement](.)

# FluentIfElseStatement

`class FluentIfElseStatement : `[`FluentStatement`](../-fluent-statement/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/ast/statement/IfStatement.kt#L39)

Used to construct an [IfStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html) with a condition, a then statement and an
else-statement. This class is a terminal expression, as not more than one
else-statement can be added.

### Functions

| [build](build.html) | `fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`IfStatement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html)<br>Creates an [Statement](#) from the given [FluentStatement](../-fluent-statement/index.html) using the given [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html). |

### Inherited Functions

| [build](../-fluent-statement/build.html) | `open fun build(): `[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)<br>Creates a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) using a new [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html). |

