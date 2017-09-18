package at.hschroedl.fluentast.ast.expression

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.Assignment
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class AssignmentTest {

    @Test
    internal fun assignment_withDefaultAssignment_returnsAssignment() {
        val expression = assignment(exp("a"), "=", n(1)).build() as Assignment

        assertEquals("a=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withPlus_returnsAssignment() {
        val expression = assignment(exp("a"), "+=", n(1)).build() as Assignment

        assertEquals("a+=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withMinus_returnsAssignment() {
        val expression = assignment(exp("a"), "-=", n(1)).build() as Assignment

        assertEquals("a-=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withTimes_returnsAssignment() {
        val expression = assignment(exp("a"), "*=", n(1)).build() as Assignment

        assertEquals("a*=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withDivide_returnsAssignment() {
        val expression = assignment(exp("a"), "/=", n(1)).build() as Assignment

        assertEquals("a/=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withBitAnd_returnsAssignment() {
        val expression = assignment(exp("a"), "&=", n(1)).build() as Assignment

        assertEquals("a&=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withBitOr_returnsAssignment() {
        val expression = assignment(exp("a"), "|=", n(1)).build() as Assignment

        assertEquals("a|=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withBitXOR_returnsAssignment() {
        val expression = assignment(exp("a"), "^=", n(1)).build() as Assignment

        assertEquals("a^=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withRemainder_returnsAssignment() {
        val expression = assignment(exp("a"), "%=", n(1)).build() as Assignment

        assertEquals("a%=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withLeftShift_returnsAssignment() {
        val expression = assignment(exp("a"), "<<=", n(1)).build() as Assignment

        assertEquals("a<<=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withRightShiftSigned_returnsAssignment() {
        val expression = assignment(exp("a"), ">>=", n(1)).build() as Assignment

        assertEquals("a>>=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_withRightShiftUnsigned_returnsAssignment() {
        val expression = assignment(exp("a"), ">>>=", n(1)).build() as Assignment

        assertEquals("a>>>=1", expression.toInlineString())
    }

    @Test
    internal fun assignment_invalidOperator_returnsAssignment() {
        assertFailsWith(FluentArgumentException::class) {
            assignment(exp("a"), "test", n(1)).build() as Assignment
        }

    }

}