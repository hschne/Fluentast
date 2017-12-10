---
title: FluentVariableDeclarationFragment - fluentast-core
---

[fluentast-core](../../index.html) / [at.hschroedl.fluentast.ast](../index.html) / [FluentVariableDeclarationFragment](.)

# FluentVariableDeclarationFragment

`abstract class FluentVariableDeclarationFragment : `[`FluentVariableDeclaration`](../-fluent-variable-declaration/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/ast/VariableDeclarationFragment.kt#L37)

A wrapper class for [VariableDeclarationFragment](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/VariableDeclarationFragment.html). Fragements are used to declare or initialize values.

* Java Code:

``` java
i = 1
```

Using JDT:

``` java
VariableDeclarationFragment fragment = ast.newVariableDeclarationFragment();
fragment.setName(ast.newSimpleName("i"));
fragment.setInitializer(ast.newNumberLiteral("1"));
```

Using Fluentast:

``` java
VariableDeclarationFragment fragment = fragment("i", i(1))).build(ast);
```

### Constructors

| [&lt;init&gt;](-init-.html) | `FluentVariableDeclarationFragment(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, initializer: `[`FluentExpression`](../../at.hschroedl.fluentast.ast.expression/-fluent-expression/index.html)`? = null)`<br>takes a string representing the name and a [FluentExpression](../../at.hschroedl.fluentast.ast.expression/-fluent-expression/index.html) as initializer. |

### Functions

| [build](build.html) | `open fun build(ast: `[`AST`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/AST.html)`): `[`VariableDeclarationFragment`](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/VariableDeclarationFragment.html) |

### Inheritors

| [FluentVariableDeclarationFragmentImpl](../-fluent-variable-declaration-fragment-impl/index.html) | `class FluentVariableDeclarationFragmentImpl : FluentVariableDeclarationFragment` |

