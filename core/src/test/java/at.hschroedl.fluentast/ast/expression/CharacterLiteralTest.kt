package at.hschroedl.fluentast.ast.expression

import org.eclipse.jdt.core.dom.CharacterLiteral
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CharacterLiteralTest {

    @Test
    internal fun boolean_withBoolean_returnsBooleanLiteral() {
        val expression = c('c').build() as CharacterLiteral

        assertEquals('c', expression.charValue())
    }
}