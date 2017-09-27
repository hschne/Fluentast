package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.annotation
import at.hschroedl.fluentast.ast.pair
import at.hschroedl.fluentast.i
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.NormalAnnotation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Test
    internal fun annotation_withMoreParameters_returnsAnnotation() {
        val expression = annotation("Test", pair("param1", i(1)),
                                    pair("param2", i(2))).build() as NormalAnnotation

    Assertions.assertEquals("@Test(param1=1,param2=2)", expression.toInlineString())
    }