---
title: FluentArrayAccess - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.expression](../index.html) / [FluentArrayAccess](.)

# FluentArrayAccess

`class FluentArrayAccess : `[`FluentExpression`](../-fluent-expression/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/ArrayAccess.kt#L26)

A wrapper class for [ArrayAccess](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ArrayAccess.html). Subclass of [FluentExpression](../-fluent-expression/index.html)

Using JDT:

``` java
val exp = ast.newArrayAccess()
exp.array = array.build(ast)
exp.index = index.build(ast)
```

Using Fluentast:

``` java
exp().build(ast);
```

### Functions

| [build](build.html) | `fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`ArrayAccess`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ArrayAccess.html) |

### Inherited Functions

| [build](../-fluent-expression/build.html) | `open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](../-fluent-expression/field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](../-fluent-field-access/index.html) |
| [index](../-fluent-expression/--index--.html) | `fun index(expression: `[`FluentExpression`](../-fluent-expression/index.html)`): FluentArrayAccess` |

