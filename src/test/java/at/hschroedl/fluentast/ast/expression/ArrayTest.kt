package at.hschroedl.fluentast.ast.expression


import at.hschroedl.fluentast.ast.type.FluentArrayType
import at.hschroedl.fluentast.ast.type.t
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.ArrayAccess
import org.eclipse.jdt.core.dom.ArrayCreation
import org.eclipse.jdt.core.dom.ArrayInitializer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ArrayTest {

    @Test
    internal fun arrayAccess_withExpressions_returnsArrayAccessWithExpressions() {
        val expression = arrayIndex(exp("test"), n(1)).build() as ArrayAccess

        assertEquals("test[1]", expression.toInlineString())
    }

    @Test
    internal fun arrayInitializer_withNumbers_returnsArrayInitializerWithNumbers() {
        val expression = arrayInit(n(1),
                n(2), n(3)).build() as ArrayInitializer

        assertEquals("{1,2,3}", expression.toInlineString())
    }

    @Test
    internal fun arrayInitializer_withNestedInitializers_returnsArrayInitializerWithNumbers() {
        val expression = arrayInit(n(1), FluentArrayInitializer(
                n(2), n(3))).build() as ArrayInitializer

        assertEquals("{1,{2,3}}", expression.toInlineString())
    }

    @Test
    internal fun arrayCreation_withType_returnsArrayCreation() {
        val expression = newArray(FluentArrayType(t("Integer"), 3)).build() as ArrayCreation

        assertEquals("new Integer[][][]", expression.toInlineString())
    }


    @Test
    internal fun arrayCreation_withInitializer_returnsArrayCreation() {
        val expression = newArray(FluentArrayType(t("Integer"), 3), arrayInit(
                n(1), n(2))).build() as ArrayCreation

        assertEquals("new Integer[][][]{1,2}", expression.toInlineString())
    }
}