package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.Assignment
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertFailsWith

internal class AssignmentTest {

    @ParameterizedTest(name = "Create assignment with {arguments}")
    @ValueSource(strings = arrayOf("=", "+=", "-=", "/=", "&=", "|=", "^=", "%=", "<<=", ">>=", ">>>="))
    internal fun assignment_withDefaultAssignment_returnsAssignment(operator: String) {
        val expression = assignment(dummyExpression("a"), operator,
                dummyLiteral(1)).build() as Assignment

        assertEquals("a${operator}1", expression.toInlineString())
    }


    @Test
    internal fun assignment_invalidOperator_returnsAssignment() {
        assertFailsWith(FluentArgumentException::class) {
            assignment(dummyExpression("a"), "test",
                    dummyLiteral(1)).build() as Assignment
        }

    }

}