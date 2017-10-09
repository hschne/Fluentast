---
title: FluentStatement.build - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.statement](../index.html) / [FluentStatement](index.html) / [build](.)

# build

`abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/ast/statement/Statement.kt#L23)

Overrides [FluentASTNode.build](../../at.hschroedl.fluentast.ast/-fluent-a-s-t-node/build.html)

Creates an [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) from the given [FluentStatement](index.html) using the given [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html).

### Parameters

`ast` - used for creating the [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)

**Return**
a new [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)

`open fun build(): `[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/ast/statement/Statement.kt#L30)

Overrides [FluentStandaloneNode.build](../../at.hschroedl.fluentast.ast/-fluent-standalone-node/build.html)

Creates a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) using a new [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html).

**Return**
a new [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)

