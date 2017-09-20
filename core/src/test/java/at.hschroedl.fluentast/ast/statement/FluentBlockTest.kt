package at.hschroedl.fluentast.ast.statement

import at.hschroedl.fluentast.block
import at.hschroedl.fluentast.body
import at.hschroedl.fluentast.empty
import at.hschroedl.fluentast.exception.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.Block
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith


internal class FluentBlockTest {

    //TODO: Refactor bad unit tests
    @Test
    fun body_emptyBlock_shouldReturnEmptyBlock() {
        val block = body().build() as Block

        assertTrue(block.statements().isEmpty())
    }

    @Test
    fun body_withStatements_shouldReturnBlockWithStatements() {
        val block = body(empty(),
                empty(), empty())
                .build() as Block

        assertEquals(3, block.statements().size)
    }

    @Test
    fun body_withString_shouldReturnBlockWithStatements() {
        val block = body("int i; i += 3; return;").build() as Block

        assertEquals(3, block.statements().size)
    }

    @Test
    fun body_withInvalidString_shouldThrowException() {
        assertFailsWith(FluentArgumentException::class) {
            body("vargl di bargle!").build()
        }
    }

    @Test
    fun block_withEmptyBlock_shouldReturnEmptyBlock() {
        val block = body().build() as Block

        assertTrue(block.statements().isEmpty())
    }

    @Test
    fun block_nestedBlocks_shouldReturnNestedBlocks() {
        val block = body(
                block(block())).build() as Block

        val expected = "{{{}}}"
        assertEquals(expected, block.toInlineString())
    }
}