package at.hschroedl.fluentast.ast.expression.test

import at.hschroedl.fluentast.ast.expression.FluentLiteral
import org.eclipse.jdt.core.dom.AST
import org.eclipse.jdt.core.dom.StringLiteral

class Dummy(private val value: String) : FluentLiteral() {
    override fun build(ast: AST): StringLiteral {
        val dummy = ast.newStringLiteral()
        dummy.literalValue = value
        return dummy
    }
}

fun dummy(value: String): Dummy {
    return Dummy(value)
}
