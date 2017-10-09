---
title: FluentASTNode - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast](../index.html) / [FluentASTNode](.)

# FluentASTNode

`abstract class FluentASTNode : `[`FluentChildNode`](../-fluent-child-node/index.html)`<`[`ASTNode`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ASTNode.html)`>` [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/ast/ASTNode.kt#L10)

### Functions

| [build](build.html) | `abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`ASTNode`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ASTNode.html) |

### Inheritors

| [FluentAnonymousClassDeclaration](../-fluent-anonymous-class-declaration/index.html) | `class FluentAnonymousClassDeclaration : FluentASTNode` |
| [FluentBodyDeclaration](../-fluent-body-declaration/index.html) | `class FluentBodyDeclaration : FluentASTNode` |
| [FluentCatchClause](../-fluent-catch-clause/index.html) | `class FluentCatchClause : FluentASTNode` |
| [FluentComment](../-fluent-comment/index.html) | `class FluentComment : FluentASTNode` |
| [FluentCompilationUnit](../-fluent-compilation-unit/index.html) | `class FluentCompilationUnit : FluentASTNode` |
| [FluentExpression](../../at.hschroedl.fluentast.ast.expression/-fluent-expression/index.html) | `abstract class FluentExpression : FluentASTNode, `[`FluentStandaloneNode`](../-fluent-standalone-node/index.html)`<`[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html)`>` |
| [FluentImportDeclaration](../-fluent-import-declaration/index.html) | `class FluentImportDeclaration : FluentASTNode` |
| [FluentMemberRef](../-fluent-member-ref/index.html) | `class FluentMemberRef : FluentASTNode` |
| [FluentMemberValuePair](../-fluent-member-value-pair/index.html) | `class FluentMemberValuePair : FluentASTNode` |
| [FluentMethodRef](../-fluent-method-ref/index.html) | `class FluentMethodRef : FluentASTNode` |
| [FluentMethodRefParameter](../-fluent-method-ref-parameter/index.html) | `class FluentMethodRefParameter : FluentASTNode` |
| [FluentModifier](../-fluent-modifier/index.html) | `class FluentModifier : FluentASTNode` |
| [FluentPackageDeclaration](../-fluent-package-declaration/index.html) | `class FluentPackageDeclaration : FluentASTNode` |
| [FluentStatement](../../at.hschroedl.fluentast.ast.statement/-fluent-statement/index.html) | `abstract class FluentStatement : FluentASTNode, `[`FluentStandaloneNode`](../-fluent-standalone-node/index.html)`<`[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)`>`<br>Used to create a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html). |
| [FluentTagElement](../-fluent-tag-element/index.html) | `class FluentTagElement : FluentASTNode` |
| [FluentTextElement](../-fluent-text-element/index.html) | `class FluentTextElement : FluentASTNode` |
| [FluentType](../../at.hschroedl.fluentast.ast.type/-fluent-type/index.html) | `abstract class FluentType : FluentASTNode` |
| [FluentTypeParameter](../-fluent-type-parameter/index.html) | `class FluentTypeParameter : FluentASTNode` |

