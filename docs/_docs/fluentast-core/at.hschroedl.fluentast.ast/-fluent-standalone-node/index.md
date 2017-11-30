---
title: FluentStandaloneNode - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast](../index.html) / [FluentStandaloneNode](.)

# FluentStandaloneNode

`interface FluentStandaloneNode<out T : `[`ASTNode`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ASTNode.html)`>` [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/ASTNode.kt#L16)

### Functions

| [build](build.html) | `abstract fun build(): T` |

### Inheritors

| [FluentExpression](../../at.hschroedl.fluentast.ast.expression/-fluent-expression/index.html) | `abstract class FluentExpression : `[`FluentASTNode`](../-fluent-a-s-t-node/index.html)`, FluentStandaloneNode<`[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)`>` |
| [FluentParsedNode](../-fluent-parsed-node/index.html) | `class FluentParsedNode : FluentStandaloneNode<`[`ASTNode`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ASTNode.html)`>` |
| [FluentStatement](../../at.hschroedl.fluentast.ast.statement/-fluent-statement/index.html) | `abstract class FluentStatement : `[`FluentASTNode`](../-fluent-a-s-t-node/index.html)`, FluentStandaloneNode<`[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)`>`<br>Used to create a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html). |

