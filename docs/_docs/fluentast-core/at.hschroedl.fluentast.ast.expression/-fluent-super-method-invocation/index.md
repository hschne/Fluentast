---
title: FluentSuperMethodInvocation - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.expression](../index.html) / [FluentSuperMethodInvocation](.)

# FluentSuperMethodInvocation

`class FluentSuperMethodInvocation : `[`FluentExpression`](../-fluent-expression/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/SuperMethodInvocation.kt#L32)

Used to build a [SuperMethodInvocation](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/SuperMethodInvocation.html).

Java:

``` java
super.someMethod();
```

JDT:

``` java
SuperMethodInvocation methodInvocation = ast.newSuperMethodInvocation();
methodInvocation.setName(ast.newSimpleName("myMethod"));
```

Fluentast:

``` java
SuperMethodInvocation methodInvocation = superMethod("myMethod").build(ast);
```

### Functions

| [build](build.html) | `fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`SuperMethodInvocation`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/SuperMethodInvocation.html) |

### Inherited Functions

| [build](../-fluent-expression/build.html) | `open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](../-fluent-expression/field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](../-fluent-field-access/index.html) |
| [index](../-fluent-expression/--index--.html) | `fun index(expression: `[`FluentExpression`](../-fluent-expression/index.html)`): `[`FluentArrayAccess`](../-fluent-array-access/index.html) |

