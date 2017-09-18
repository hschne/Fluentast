package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.TypeLiteral
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class TypeLiteralTest {

    @Test
    internal fun typeLiteral_withName_returnsTypeLiteral() {
        val expression = clazz(dummyType("myType")).build() as TypeLiteral

        Assertions.assertEquals("myType.class", expression.toInlineString())
    }
}