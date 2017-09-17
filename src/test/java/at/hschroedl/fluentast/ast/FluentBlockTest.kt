package at.hschroedl.fluentast.ast

import at.hschroedl.fluentast.FluentArgumentException
import at.hschroedl.fluentast.test.toInlineString
import org.eclipse.jdt.core.dom.Block
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith


internal class FluentBlockTest {

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