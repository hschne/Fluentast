---
title: FluentVariableDeclarationExpression - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast.expression](../index.html) / [FluentVariableDeclarationExpression](.)

# FluentVariableDeclarationExpression

`class FluentVariableDeclarationExpression : `[`FluentExpression`](../-fluent-expression/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/expression/VariableDeclarationExpression.kt#L38)

A wrapper class for [VariableDeclarationExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/VariableDeclarationExpression.html).

Use convenience methods from [at.hschroedl.fluentast](../../at.hschroedl.fluentast/index.html) to create instances of this class.

Java Code:

``` java
boolean i = true
```

Using JDT:

``` java
VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
fragment.setName(ast.newSimpleName("i"));
fragment.setInitializer(ast.newBooleanLiteral(true));
VariableDeclarationExpression statement = ast.newVariableDeclarationExpression(fragment);
statement.setType(ast.newPrimitiveType(PrimitiveType.BOOLEAN));
```

Using Fluentast:

``` java
VariableDeclarationExpression exp = decl("i", true).build(ast);
```

### Functions

| [build](build.html) | `fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`VariableDeclarationExpression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/VariableDeclarationExpression.html) |

### Inherited Functions

| [build](../-fluent-expression/build.html) | `open fun build(): `[`Expression`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/Expression.html) |
| [field](../-fluent-expression/field.html) | `fun field(fieldName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentFieldAccess`](../-fluent-field-access/index.html) |
| [index](../-fluent-expression/--index--.html) | `fun index(expression: `[`FluentExpression`](../-fluent-expression/index.html)`): `[`FluentArrayAccess`](../-fluent-array-access/index.html) |

