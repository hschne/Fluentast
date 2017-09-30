---
title: FluentBlock - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.statement](../index.html) / [FluentBlock](.)

# FluentBlock

`abstract class FluentBlock : `[`FluentStatement`](../-fluent-statement/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/ast/statement/Block.kt#L8)

### Constructors

| [&lt;init&gt;](-init-.html) | `FluentBlock()` |

### Inherited Functions

| [build](../-fluent-statement/build.html) | `abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)<br>Creates an [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) from the given [FluentStatement](../-fluent-statement/index.html) using the given [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html).`open fun build(): `[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)<br>Creates a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) using a new [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html). |

### Inheritors

| [FluentParsedBlock](../-fluent-parsed-block/index.html) | `class FluentParsedBlock : FluentBlock` |
| [FluentStatementBlock](../-fluent-statement-block/index.html) | `class FluentStatementBlock : FluentBlock` |

