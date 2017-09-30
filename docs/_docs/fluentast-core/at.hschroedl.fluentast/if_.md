---
title: if_ - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast](index.html) / [if_](.)

# if_

`fun if_(condition: `[`FluentExpression`](../at.hschroedl.fluentast.ast.expression/-fluent-expression/index.html)`): `[`IfPartial`](../at.hschroedl.fluentast.ast.statement/-if-partial/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/Fluentast.kt#L331)

Creates an [IfStatement](https://help.eclipse.org/neon/topic/org.eclipse.jdt.doc.isv/reference/api/org/eclipse/jdt/core/dom/IfStatement.html) using [FluentIfStatement](../at.hschroedl.fluentast.ast.statement/-fluent-if-statement/index.html) or [FluentIfElseStatement](../at.hschroedl.fluentast.ast.statement/-fluent-if-else-statement/index.html).

## Usage and Result:

### Fluentast:

``` java
if_(condition)
   .then(thenStatement)
   .else_(elseStatement)
   .build();
```

### JDT:

``` java
IfStatement ifStatement = ast.newIfStatement();
ifStatement.setExpression(condition);
ifStatement.setThenStatement(thenStatement);
ifStatement.setElseStatement(elseStatement);
```

### Result:

``` java
if(condition)
  thenStatement
else
  elseStatement
```

For more examples see the [Demo Project](https://github.com/hschroedl/FluentAST/tree/master/demo).

**See Also**

[IfPartial](../at.hschroedl.fluentast.ast.statement/-if-partial/index.html)

[FluentIfStatement](../at.hschroedl.fluentast.ast.statement/-fluent-if-statement/index.html)

[FluentIfElseStatement](../at.hschroedl.fluentast.ast.statement/-fluent-if-else-statement/index.html)

