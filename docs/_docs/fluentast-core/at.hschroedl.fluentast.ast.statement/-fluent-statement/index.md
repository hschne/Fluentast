---
title: FluentStatement - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.statement](../index.html) / [FluentStatement](.)

# FluentStatement

`abstract class FluentStatement : `[`FluentASTNode`](../../at.hschroedl.fluentast.ast/-fluent-a-s-t-node/index.html)`, `[`FluentStandaloneNode`](../../at.hschroedl.fluentast.ast/-fluent-standalone-node/index.html)`<`[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)`>` [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/ast/statement/Statement.kt#L14)

Used to create a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html).

### Functions

| [build](build.html) | `abstract fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)<br>Creates an [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) from the given FluentStatement using the given [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html).`open fun build(): `[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)<br>Creates a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html) using a new [AST](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html). |

### Inheritors

| [FluentAssertStatement](../-fluent-assert-statement/index.html) | `class FluentAssertStatement : FluentStatement` |
| [FluentBlock](../-fluent-block/index.html) | `abstract class FluentBlock : FluentStatement` |
| [FluentBreakStatement](../-fluent-break-statement/index.html) | `class FluentBreakStatement : FluentStatement` |
| [FluentConstructorInvocation](../-fluent-constructor-invocation/index.html) | `class FluentConstructorInvocation : FluentStatement` |
| [FluentContinueStatement](../-fluent-continue-statement/index.html) | `class FluentContinueStatement : FluentStatement` |
| [FluentDoStatement](../-fluent-do-statement/index.html) | `class FluentDoStatement : FluentStatement` |
| [FluentEmptyStatement](../-fluent-empty-statement/index.html) | `class FluentEmptyStatement : FluentStatement` |
| [FluentEnhancedForStatement](../-fluent-enhanced-for-statement/index.html) | `class FluentEnhancedForStatement : FluentStatement` |
| [FluentExpressionStatement](../-fluent-expression-statement/index.html) | `class FluentExpressionStatement : FluentStatement` |
| [FluentForStatement](../-fluent-for-statement/index.html) | `class FluentForStatement : FluentStatement` |
| [FluentIfElseStatement](../-fluent-if-else-statement/index.html) | `class FluentIfElseStatement : FluentStatement`<br>Used to construct an [IfStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html) with a condition, a then statement and an else-statement. |
| [FluentIfStatement](../-fluent-if-statement/index.html) | `class FluentIfStatement : FluentStatement`<br>Used to construct an [IfStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html) with a condition and a then-statement, but without a else-statement. |
| [FluentLabeledStatement](../-fluent-labeled-statement/index.html) | `class FluentLabeledStatement : FluentStatement` |
| [FluentParsedStatement](../-fluent-parsed-statement/index.html) | `class FluentParsedStatement : FluentStatement` |
| [FluentReturnStatement](../-fluent-return-statement/index.html) | `class FluentReturnStatement : FluentStatement`<br>Used to construct a [ReturnStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ReturnStatement.html) with a given expression. |
| [FluentSuperConstructorInvocation](../-fluent-super-constructor-invocation/index.html) | `class FluentSuperConstructorInvocation : FluentStatement` |
| [FluentSwitchCase](../-fluent-switch-case/index.html) | `class FluentSwitchCase : FluentStatement` |
| [FluentSwitchStatement](../-fluent-switch-statement/index.html) | `class FluentSwitchStatement : FluentStatement` |
| [FluentSynchronizedStatement](../-fluent-synchronized-statement/index.html) | `class FluentSynchronizedStatement : FluentStatement` |
| [FluentThrowStatement](../-fluent-throw-statement/index.html) | `class FluentThrowStatement : FluentStatement` |
| [FluentTryStatement](../-fluent-try-statement/index.html) | `class FluentTryStatement : FluentStatement` |
| [FluentTypeDeclarationStatement](../-fluent-type-declaration-statement/index.html) | `class FluentTypeDeclarationStatement : FluentStatement` |
| [FluentVariableDeclarationStatement](../-fluent-variable-declaration-statement/index.html) | `class FluentVariableDeclarationStatement : FluentStatement` |
| [FluentWhileStatement](../-fluent-while-statement/index.html) | `class FluentWhileStatement : FluentStatement` |

