---
title: at.hschroedl.fluentast.ast.statement - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast.ast.statement](.)

## Package at.hschroedl.fluentast.ast.statement

Useful stuff in another package.

### Types

| [FluentAssertStatement](-fluent-assert-statement/index.html) | `class FluentAssertStatement : `[`FluentStatement`](-fluent-statement/index.html)<br>Used to build an [AssertStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AssertStatement.html) on the given expression with an optional message. |
| [FluentBlock](-fluent-block/index.html) | `abstract class FluentBlock : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentBreakStatement](-fluent-break-statement/index.html) | `class FluentBreakStatement : `[`FluentStatement`](-fluent-statement/index.html)<br>Used to build a [BreakStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/BreakStatement.html). |
| [FluentConstructorInvocation](-fluent-constructor-invocation/index.html) | `class FluentConstructorInvocation : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentContinueStatement](-fluent-continue-statement/index.html) | `class FluentContinueStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentDoStatement](-fluent-do-statement/index.html) | `class FluentDoStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentEmptyStatement](-fluent-empty-statement/index.html) | `class FluentEmptyStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentEnhancedForStatement](-fluent-enhanced-for-statement/index.html) | `class FluentEnhancedForStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentExpressionStatement](-fluent-expression-statement/index.html) | `class FluentExpressionStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentForStatement](-fluent-for-statement/index.html) | `class FluentForStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentIfElseStatement](-fluent-if-else-statement/index.html) | `class FluentIfElseStatement : `[`FluentStatement`](-fluent-statement/index.html)<br>Used to construct an [IfStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html) with a condition, a then statement and an else-statement. This class is a terminal expression, as not more than one else-statement can be added. |
| [FluentIfPartial](-fluent-if-partial/index.html) | `class FluentIfPartial`<br>Used to build an [IfStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html) where a condition has been set, but a then-statement or else-statement have yet to be added. |
| [FluentIfStatement](-fluent-if-statement/index.html) | `class FluentIfStatement : `[`FluentStatement`](-fluent-statement/index.html)<br>Used to build an [IfStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html) with a condition and a then-statement, but without a else-statement. |
| [FluentLabeledStatement](-fluent-labeled-statement/index.html) | `class FluentLabeledStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentParsedBlock](-fluent-parsed-block/index.html) | `class FluentParsedBlock : `[`FluentBlock`](-fluent-block/index.html) |
| [FluentParsedStatement](-fluent-parsed-statement/index.html) | `class FluentParsedStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentReturnStatement](-fluent-return-statement/index.html) | `class FluentReturnStatement : `[`FluentStatement`](-fluent-statement/index.html)<br>Used to construct a [ReturnStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ReturnStatement.html) with a given expression. |
| [FluentStatement](-fluent-statement/index.html) | `abstract class FluentStatement : `[`FluentASTNode`](../at.hschroedl.fluentast.ast/-fluent-a-s-t-node/index.html)`, `[`FluentStandaloneNode`](../at.hschroedl.fluentast.ast/-fluent-standalone-node/index.html)`<`[`Statement`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html)`>`<br>Used to create a [Statement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Statement.html). |
| [FluentStatementBlock](-fluent-statement-block/index.html) | `class FluentStatementBlock : `[`FluentBlock`](-fluent-block/index.html) |
| [FluentSuperConstructorInvocation](-fluent-super-constructor-invocation/index.html) | `class FluentSuperConstructorInvocation : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentSwitchCase](-fluent-switch-case/index.html) | `class FluentSwitchCase : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentSwitchStatement](-fluent-switch-statement/index.html) | `class FluentSwitchStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentSynchronizedStatement](-fluent-synchronized-statement/index.html) | `class FluentSynchronizedStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentThrowStatement](-fluent-throw-statement/index.html) | `class FluentThrowStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentTryStatement](-fluent-try-statement/index.html) | `class FluentTryStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentTypeDeclarationStatement](-fluent-type-declaration-statement/index.html) | `class FluentTypeDeclarationStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentVariableDeclarationStatement](-fluent-variable-declaration-statement/index.html) | `class FluentVariableDeclarationStatement : `[`FluentStatement`](-fluent-statement/index.html) |
| [FluentWhileStatement](-fluent-while-statement/index.html) | `class FluentWhileStatement : `[`FluentStatement`](-fluent-statement/index.html) |

