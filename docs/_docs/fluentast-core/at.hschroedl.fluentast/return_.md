---
title: return_ - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast](index.html) / [return_](.)

# return_

`fun return_(): `[`FluentStatement`](../at.hschroedl.fluentast.ast.statement/-fluent-statement/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/Fluentast.kt#L118)
`fun return_(expression: `[`FluentExpression`](../at.hschroedl.fluentast.ast.expression/-fluent-expression/index.html)`): `[`FluentReturnStatement`](../at.hschroedl.fluentast.ast.statement/-fluent-return-statement/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/Fluentast.kt#L151)

Creates a [ReturnStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/ReturnStatement.html) using [FluentReturnStatement](../at.hschroedl.fluentast.ast.statement/-fluent-return-statement/index.html).

## Comparison of Fluentast and JDT:

### Fluentast:

``` java
return_(expression).build()
```

### JDT:

``` java
ReturnStatement returnStatement = ast.newReturnStatement();
returnStatement.setExpression(expression)
```

### Result:

``` java
return expression;
```

For more examples see the [Demo Project](https://github.com/hschroedl/FluentAST/tree/master/demo).

**See Also**

[FluentReturnStatement](../at.hschroedl.fluentast.ast.statement/-fluent-return-statement/index.html)

