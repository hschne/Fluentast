---
title: infix - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast](index.html) / [infix](.)

# infix

`fun infix(operator: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentInfixOperatorPartial`](../at.hschroedl.fluentast.ast.expression/-fluent-infix-operator-partial/index.html) [(source)](https://github.com/hschroedl/FluentAST/tree/master/core/src/main/kotlin//at.hschroedl.fluentast/Fluentast.kt#L256)

Creates an [FluentInfixOperatorPartial](../at.hschroedl.fluentast.ast.expression/-fluent-infix-operator-partial/index.html), which is used for building an [InfixExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/InfixExpression.html).

### Parameters

`operator` - operator used in [InfixExpression](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/InfixExpression.html). See [InfixExpression.Operator](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/InfixExpression/Operator.html).

**Return**
a new [FluentInfixOperatorPartial](../at.hschroedl.fluentast.ast.expression/-fluent-infix-operator-partial/index.html).

**See Also**

[FluentInfixOperatorPartial](../at.hschroedl.fluentast.ast.expression/-fluent-infix-operator-partial/index.html)

[FluentInfixLeftPartial](../at.hschroedl.fluentast.ast.expression/-fluent-infix-left-partial/index.html)

[FluentInfixExpression](../at.hschroedl.fluentast.ast.expression/-fluent-infix-expression/index.html)

