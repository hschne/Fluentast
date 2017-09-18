package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.Name
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NameTest {

    @Test
    internal fun name_qualifiedName_returnsName() {
        val expression = name("package1.subpackage.name").build() as Name

        assertEquals("package1.subpackage.name", expression.toInlineString())
    }

    @Test
    internal fun name_simpleName_returnsName() {
        val expression = name("name").build() as Name

        assertEquals("name", expression.toInlineString())
    }
}