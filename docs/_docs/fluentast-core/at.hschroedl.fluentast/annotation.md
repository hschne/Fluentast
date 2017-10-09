---
title: annotation - fluentast-core
---

[fluentast-core](../index.html) / [at.hschroedl.fluentast](index.html) / [annotation](.)

# annotation

`fun annotation(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`FluentMarkerAnnotation`](../at.hschroedl.fluentast.ast.expression/-fluent-marker-annotation/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/Fluentast.kt#L18)
`fun annotation(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, expression: `[`FluentExpression`](../at.hschroedl.fluentast.ast.expression/-fluent-expression/index.html)`): `[`FluentSingleMemberAnnotation`](../at.hschroedl.fluentast.ast.expression/-fluent-single-member-annotation/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/Fluentast.kt#L22)
`fun annotation(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, vararg members: `[`FluentMemberValuePair`](../at.hschroedl.fluentast.ast/-fluent-member-value-pair/index.html)`): `[`FluentNormalAnnotation`](../at.hschroedl.fluentast.ast.expression/-fluent-normal-annotation/index.html) [(source)](http://github.com/hschroedl/fluentast/tree/master/core/at.hschroedl.fluentast/Fluentast.kt#L27)